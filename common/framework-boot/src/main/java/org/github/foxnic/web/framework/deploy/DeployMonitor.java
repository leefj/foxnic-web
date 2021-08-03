package org.github.foxnic.web.framework.deploy;

import com.github.foxnic.commons.concurrent.task.SimpleTaskManager;
import com.github.foxnic.commons.io.FileUtil;
import com.github.foxnic.commons.lang.DateUtil;
import com.github.foxnic.commons.log.Logger;
import com.github.foxnic.commons.project.maven.MavenProject;
import com.github.foxnic.springboot.spring.SpringUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.io.File;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class DeployMonitor implements ApplicationListener<ApplicationStartedEvent> {

    private SimpleTaskManager tm=new SimpleTaskManager(2);

    private WatchService watcher = null;

    @Value("${develop.deploy.projects}")
    private String projects;

    @Value("${develop.deploy.enable}")
    private Boolean enable=false;


    private List<MavenProject> mps=null;

    private void regist() throws Exception {

        watcher = FileSystems.getDefault().newWatchService();

        mps=new ArrayList<>();
        //
        Class startupClass=SpringUtil.getStartupClass();
        MavenProject wrapper=new MavenProject(startupClass);
        mps.add(wrapper);
        //搜集监控项目
        String[] dirs=projects.split(",");
        for (String dir : dirs) {
            File d=FileUtil.resolveByPath(wrapper.getProjectDir().getParentFile(),dir.trim());
            d=new File(d.getCanonicalPath());
            MavenProject mp=new MavenProject(d);
            mps.add(mp);
        }
        //注册监控目录
        File dir=null;
        for (MavenProject mp : mps) {
            dir=FileUtil.resolveByPath(mp.getMainResourceDir(),"/public");
            if(dir.exists()) {
                register(dir);
            }
            dir=FileUtil.resolveByPath(mp.getMainResourceDir(),"/static");
            if(dir.exists()) {
                register(dir);
            }
        }

        Logger.info("deploy is ready on "+monitorDirCount+" dirs");

        //启动监控
        watching();
    }

    private int monitorDirCount=0;

    private void register(File dir) throws Exception {
        monitorDirCount++;
        //System.out.println("register\t"+dir.getAbsolutePath());
        Path mPath= Paths.get(dir.getAbsolutePath());
        mPath.register(watcher, StandardWatchEventKinds.ENTRY_CREATE,StandardWatchEventKinds.ENTRY_MODIFY,StandardWatchEventKinds.ENTRY_DELETE,StandardWatchEventKinds.OVERFLOW);
        File[] fs=dir.listFiles();
        for (File f : fs) {
           if(f.isDirectory()) {
               register(f);
           }
        }
    }

    private int taskId=-1;

    public void watching() {
        while (true) {

            WatchKey key = null;
            try {
                key = watcher.take();
            } catch (InterruptedException e) {
                Logger.error("watching metho eror",e);
            }
            for (WatchEvent<?> event : key.pollEvents()) {
                WatchEvent.Kind<?> kind = event.kind();
                final Path path = (Path) key.watchable();
                final Path filename = (Path) event.context();
                final String fullPath=String.format("%s\\%s%n", path.toString(), filename.toString()).trim();
                File target=new File(fullPath);
                if(target.isDirectory()) continue;
                if(filename.toString().trim().endsWith("~")) continue;
//                System.err.println(fullPath);
                tm.clearTask(taskId);
                taskId=tm.doDelayTask(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            deploy(target);
                        } catch (Exception e) {
                            Logger.error("watching method eror",e);
                        }
                    }
                }, 100);
            }
            // 重设WatchKey
            boolean valid = key.reset();
            // 如果重设失败，退出监听
            if (!valid) {
                Logger.info("Mapper 监控异常，退出监控...");
                break;
            }
        }
    }

    private void deploy(File file) {
        if(file.isDirectory()) return;
        MavenProject p=null;
        for (MavenProject mp : mps) {
            if(file.getAbsolutePath().startsWith(mp.getProjectDir().getAbsolutePath())) {
                p=mp;
                break;
            }
        }
        if(p==null) {
            throw new RuntimeException(file.getAbsolutePath()+" 所属项目未注册");
        }

        String suffix=file.getAbsolutePath().substring(p.getMainResourceDir().getAbsolutePath().length());
        File to=FileUtil.resolveByPath(p.getTargetClassesDir(),suffix);
        FileUtil.copyFile(file,to);
        System.err.println("["+ DateUtil.getCurrTime("HH:mm:ss") +"] deploy "+" "+p.getProjectDir().getName()+" "+suffix);
    }

    @Override
    public void onApplicationEvent(ApplicationStartedEvent event) {
        if(!enable) return;
        SimpleTaskManager.doParallelTask(new Runnable() {
            @Override
            public void run() {
                try {
                    regist();
                } catch (Exception e) {
                    Logger.error("启动Mapper监控失败",e);
                }
            }
        });
    }
}
