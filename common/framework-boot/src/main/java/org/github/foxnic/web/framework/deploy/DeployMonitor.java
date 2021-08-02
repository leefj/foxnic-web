package org.github.foxnic.web.framework.deploy;

import com.github.foxnic.commons.concurrent.task.SimpleTaskManager;
import com.github.foxnic.commons.io.FileUtil;
import com.github.foxnic.commons.log.Logger;
import com.github.foxnic.commons.project.maven.MavenProject;
import com.github.foxnic.springboot.spring.SpringUtil;
import com.sun.nio.file.SensitivityWatchEventModifier;
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
            MavenProject mp=new MavenProject(d);
            mps.add(mp);
        }
        //注册监控目录
        File dir;
        Path mPath;
        for (MavenProject mp : mps) {
            dir=FileUtil.resolveByPath(mp.getMainResourceDir(),"/public");
            if(dir.exists()) {
                mPath = Paths.get(dir.getAbsolutePath());
                mPath.register(watcher, new WatchEvent.Kind[]{StandardWatchEventKinds.ENTRY_MODIFY}, SensitivityWatchEventModifier.HIGH);
            }
            dir=FileUtil.resolveByPath(mp.getMainResourceDir(),"/static");
            if(dir.exists()) {
                mPath = Paths.get(dir.getAbsolutePath());
                mPath.register(watcher, new WatchEvent.Kind[]{StandardWatchEventKinds.ENTRY_MODIFY}, SensitivityWatchEventModifier.HIGH);
            }
        }
        //启动监控
        watching();
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
                if(filename.toString().endsWith("~")) continue;
                final String fullPath=String.format("%s\\%s%n", path.toString(), filename.toString());
                tm.clearTask(taskId);
                taskId=tm.doDelayTask(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            refresh(new File(fullPath));
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

    private void refresh(File file) {
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

        System.out.println(System.currentTimeMillis()+" "+file.getAbsolutePath());
    }

    @Override
    public void onApplicationEvent(ApplicationStartedEvent event) {
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
