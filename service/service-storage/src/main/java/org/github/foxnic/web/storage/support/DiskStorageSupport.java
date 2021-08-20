package org.github.foxnic.web.storage.support;

import com.github.foxnic.commons.busi.id.IDGenerator;
import com.github.foxnic.commons.environment.OSType;
import com.github.foxnic.commons.io.FileUtil;
import com.github.foxnic.commons.lang.DateUtil;
import com.github.foxnic.commons.log.Logger;
import org.apache.commons.io.IOUtils;
import org.github.foxnic.web.domain.storage.File;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

@Component
public class DiskStorageSupport  extends  StorageSupport {

    @Value("${storage.disk.location.windows}")
    private String windowsDir="";

    @Value("${storage.disk.location.mac}")
    private String macDir="";

    @Value("${storage.disk.location.linux}")
    private String linuxDir="";

    private String getStorageDir() {
        if(OSType.isWindows()) return windowsDir;
        else if(OSType.isLinux()) return linuxDir;
        else if(OSType.isMac()) return macDir;
        else {
            throw new RuntimeException("不支持的操作系统");
        }
    }


    public DiskStorageSupport() {
        super("disk");
    }

    @Override
    public File write(File fileInfo, MultipartFile file) {
        String dir=this.getStorageDir();
        byte[] bytes=new byte[0];
        try {
            bytes = file.getBytes();
        } catch (Exception e) {
            Logger.error("文件字节错误",e);
        }
        String url=null;
        try {
            java.io.File f=FileUtil.resolveByPath(dir, DateUtil.format(new Date(), "yyyyMMdd"), IDGenerator.getSnowflakeId()+"."+fileInfo.getFileType());
            url=f.getAbsolutePath().substring(dir.length());
            fileInfo.setLocation(url);
            if(!f.getParentFile().exists()) {
                f.getParentFile().mkdirs();
            }
            FileOutputStream out=new FileOutputStream(f);
            fileInfo.setSize(new Long(bytes.length));
            IOUtils.write(bytes, out);
            out.close();

        } catch (Exception e) {
            Logger.error("文件写入错误",e);
        }
        return fileInfo;
    }

    /**
     *  文件下载
     * @param fileInfo 当前对象文件路径
     * @throws IOException
     */
    public byte[] read(File fileInfo) throws Exception  {
        byte[] bytes=null;
        String dir=this.getStorageDir();
        try {
            if(!isFileExists(fileInfo)) {
//                throw  new RuntimeException("FileId = "+fileInfo.getId()+" , file is not exists");
                return null;
            }
            FileInputStream in=new FileInputStream(getFile(fileInfo));
            bytes =IOUtils.readFully(in, in.available());
            return bytes;
        } catch (IOException e) {
//            throw  new RuntimeException("FileId = "+fileInfo.getId()+" , file download error",e);
            return null;
        }


    }

    private java.io.File getFile(File fileInfo) {
        if(fileInfo==null) return null;
        String dir=this.getStorageDir();
        if(!OSType.isWindows()){
            fileInfo.setLocation(fileInfo.getLocation().replace('\\','/'));
        }
        java.io.File f= FileUtil.resolveByPath(dir, fileInfo.getLocation());
        return f;
    }

    @Override
    public Boolean isFileExists(File fileInfo) {
        java.io.File f= getFile(fileInfo);
        if(f==null) return false;
        Logger.info(f.getAbsolutePath());
        return f.exists();
    }
}
