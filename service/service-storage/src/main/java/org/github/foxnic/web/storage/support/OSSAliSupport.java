package org.github.foxnic.web.storage.support;

import com.aliyun.oss.*;
import com.aliyun.oss.model.GetObjectRequest;
import com.aliyun.oss.model.OSSObject;
import com.aliyun.oss.model.PutObjectRequest;
import com.aliyun.oss.model.PutObjectResult;
import com.github.foxnic.commons.io.StreamUtil;
import com.github.foxnic.commons.lang.DateUtil;
import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.commons.log.Logger;
import org.github.foxnic.web.domain.storage.File;
import org.github.foxnic.web.storage.exception.FileTransferException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Date;

/**
 * 实现参考
 * https://help.aliyun.com/document_detail/84781.htm?spm=a2c4g.11186623.0.0.3341227eYjkspC#concept-84781-zh
 * */

@Component
public class OSSAliSupport extends StorageSupport {

    private static OSS OSS_CLIENT;

    @Value("${foxnic.storage.oss-aliyun.end-point}")
    private String endpoint;

    @Value("${foxnic.storage.oss-aliyun.access-key-id}")
    private String accessKeyId;

    @Value("${foxnic.storage.oss-aliyun.access-secret}")
    private String accessSecret;

    // 公有桶
    @Value("${foxnic.storage.oss-aliyun.public-bucket}")
    private String publicBucket;
    // 私有桶
    @Value("${foxnic.storage.oss-aliyun.private-bucket}")
    private String privateBucket;

    @PostConstruct
    private void init() {
        String prefix="foxnic.storage";
        endpoint=this.decrypt(prefix,endpoint);
        accessKeyId=this.decrypt(prefix,accessKeyId);
        accessSecret=this.decrypt(prefix,accessSecret);
        publicBucket=this.decrypt(prefix,publicBucket);
        privateBucket=this.decrypt(prefix,privateBucket);
    }

    public OSSAliSupport() {
        super("oss-aliyun");
    }

    @Override
    public File write(File fileInfo, MultipartFile mf,String dir) {
        try {

            byte[] bytes=new byte[0];
            try {
                bytes = mf.getBytes();
            } catch (Exception e) {
                Logger.error("文件字节错误",e);
            }
            upload(fileInfo,fileInfo.getFileName(), bytes, dir, true);
            return fileInfo;
        } catch (Exception e) {
            Logger.exception(e);
            return fileInfo;
        }
    }

    @Override
    public byte[] read(File fileInfo) throws Exception {
        return this.download(fileInfo);
    }

    @Override
    public Boolean isFileExists(File fileInfo) {
        if(fileInfo!=null && !StringUtil.isBlank(fileInfo.getDownloadUrl())) {
            return true;
        } else {
            return true;
        }
    }


    /**
     *  上传文件
     * @param fileName                      上传的文件名
     * @param content                       上传文件内容的字节数组
     * @param dir                               上传文件到某个目录
     * @param returnAbsoluteUrl         是否返回绝对路径
     * @return                                      上传文件成功后，返回相对路径或绝对路径，绝对路径可直接访问上传的文件
     * @throws FileTransferException
     */
    private File upload(File fileInfo,String fileName, byte[] content, String dir, Boolean returnAbsoluteUrl) throws FileTransferException
    {
        String relativeUrl = "";
        try
        {
            validate(content,returnAbsoluteUrl);
            String date = DateUtil.format(new Date(),"yyyyMMdd");
            relativeUrl = StringUtil.joinUrl(dir , date , fileName);
            String bucket = returnAbsoluteUrl ? this.publicBucket : this.privateBucket;
            fileInfo.setLocation(bucket);
            PutObjectRequest putObjectRequest = new PutObjectRequest(bucket, relativeUrl, new ByteArrayInputStream(content));
            putObjectRequest.setProcess("true");
            PutObjectResult result = OSS_CLIENT.putObject(putObjectRequest);
            if (result == null || result.getResponse().getStatusCode()!=200) {
                throw new FileTransferException("putObject error!");
            }
            relativeUrl = result.getResponse().getUri();
            fileInfo.setDownloadUrl(relativeUrl);
            return fileInfo;

        } catch (OSSException e) {
            Logger.error("Accessing OSS failed!");
            throw new FileTransferException(e.getMessage());
        } catch (ClientException e) {
            Logger.error("Accessing OSS failed!");
            throw new FileTransferException(e.getMessage());
        } catch (FileTransferException e) {
            throw e;
        } catch (Exception e) {
            throw new FileTransferException(e.getMessage());
        }
    }

    private byte[] download(File fileInfo) {
        try {

            String url=fileInfo.getDownloadUrl();
            String objectName=null;
            if(StringUtil.isBlank(url)) {
                int i=url.indexOf("//");
                if(i<0) return null;
                i=url.indexOf("/",i+2);
                if(i<0) return null;
                objectName=url.substring(i);
            }
            // ossObject 包含文件所在的存储空间名称、文件名称、文件元信息以及一个输入流。
            OSSObject ossObject = OSS_CLIENT.getObject(fileInfo.getLocation(), objectName);
            InputStream inputStream=ossObject.getObjectContent();
            byte[] bytes=StreamUtil.input2bytes(inputStream);
            inputStream.close();
            return bytes;
        } catch (Exception oe) {
            Logger.exception(oe);
        } catch (Throwable ce) {
            Logger.exception(ce);
        }
        return null;
    }

    private void validate(Object resource,Boolean returnAbsoluteUrl) throws FileTransferException
    {

        initClient();

        if (resource == null)
        {
            throw new FileTransferException("No files!");
        }

        String bucket = returnAbsoluteUrl ? publicBucket : privateBucket;

        if (!OSS_CLIENT.doesBucketExist(bucket))
        {
            Logger.error("Bucket：{} 不存在！", bucket);
            throw new FileTransferException("Bucket：" + bucket + "不存在！");
        }

    }

    private void initClient() throws FileTransferException {
        if (OSS_CLIENT == null) {
            try {
                OSS_CLIENT =new OSSClientBuilder().build(endpoint, accessKeyId, accessSecret);
            } catch (Exception e) {
                throw new FileTransferException("OSS init failed!");
            }
        }
    }




}
