package org.github.foxnic.web.storage.support;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.OSSObject;
import com.aliyun.oss.model.PutObjectRequest;
import com.aliyun.oss.model.PutObjectResult;
import com.github.foxnic.commons.busi.id.IDGenerator;
import com.github.foxnic.commons.encrypt.MD5Util;
import com.github.foxnic.commons.io.FileUtil;
import com.github.foxnic.commons.io.StreamUtil;
import com.github.foxnic.commons.lang.DateUtil;
import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.commons.log.Logger;
import io.minio.*;
import io.minio.errors.*;
import org.github.foxnic.web.domain.storage.File;
import org.github.foxnic.web.storage.exception.FileTransferException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 实现参考
 * https://help.aliyun.com/document_detail/84781.htm?spm=a2c4g.11186623.0.0.3341227eYjkspC#concept-84781-zh
 * */

@Component
public class MinioStroageSupport extends StorageSupport {

    private static MinioClient client;


    @Value("${foxnic.storage.minio.endpoint}")
    private String endpoint;

    @Value("${foxnic.storage.minio.accessKey}")
    private String accessKey;

    @Value("${foxnic.storage.minio.secretKey}")
    private String secretKey;

    @Value("${foxnic.storage.minio.bucketAppData}")
    private String bucket;

    @Value("${foxnic.storage.mode}")
    private String storageMode;


    public MinioStroageSupport() {
        super("minio");
    }


    @PostConstruct
    private void init() {
        if(storageMode==null) return;
        if(!storageMode.equals(this.getConfigKey())) return;


        try {
            if(!StringUtil.isBlank(endpoint)
                    && !StringUtil.isBlank(accessKey)
                    && !StringUtil.isBlank(secretKey)
                    && !StringUtil.isBlank(bucket)
            ) {
                initClient();
            }
        } catch (FileTransferException e) {
            Logger.info("Minio 客户端初始化错误",e);
        }
    }



    private void initClient() throws FileTransferException {
        if (client == null) {
            try {
                client =MinioClient.builder().endpoint(endpoint).credentials(accessKey, secretKey).build();
            } catch (Exception e) {
                throw new FileTransferException("OSS init failed!");
            }
        }
    }


    private String getFileName(String filename){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        // 设置存储对象名称
        String dir = sdf.format(new Date());
        int idx = filename.lastIndexOf(".");
        if (idx >= 0) {
            String ext = filename.substring(idx+1);
            String name = System.currentTimeMillis() + filename.substring(0, idx);
            filename = MD5Util.encrypt32(name) + "." + ext;
        }else{
            String name = System.currentTimeMillis() + filename;
            filename = MD5Util.encrypt32(name) + ".block";
        }
        return dir + "/" +filename;
    }

    @Override
    public File write(File fileInfo, MultipartFile file,String dir) {
        try {
            String filename = getFileName(file.getOriginalFilename());
            Logger.info("originalFilename:"+  file.getOriginalFilename());
            Logger.info("oss filename:"+  filename);
            Logger.info("fileSize:"+  file.getSize());
            Logger.info("bucket:"+  bucket);
            Logger.info("contentType:"+  file.getContentType());
            fileInfo.setLocation(filename);
            if(!client.bucketExists(BucketExistsArgs.builder().bucket(bucket).build())){
                client.makeBucket(MakeBucketArgs.builder().bucket(bucket).build());
            }
            ObjectWriteResponse response = client.putObject(PutObjectArgs.builder()
                    .bucket(bucket)
                    .object(filename)
                    .contentType(file.getContentType())
                    .stream(file.getInputStream(), file.getSize(), ObjectWriteArgs.MIN_MULTIPART_SIZE).build());
        } catch (ErrorResponseException e) {
            e.printStackTrace();
        } catch (InsufficientDataException e) {
            e.printStackTrace();

        } catch (InternalException e) {
            e.printStackTrace();

        } catch (InvalidKeyException e) {
            e.printStackTrace();

        } catch (InvalidResponseException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();

        } catch (ServerException e) {
            e.printStackTrace();

        } catch (XmlParserException e) {
            e.printStackTrace();

        }
        return fileInfo;
    }


    public InputStream readStream(File fileInfo) {

        InputStream stream=null;
        Boolean isFileExists=isFileExists(fileInfo);
        if(!isFileExists){
            return null;
        }
        try {
            stream=client.getObject(GetObjectArgs.builder().bucket(bucket).object(fileInfo.getLocation()).build());
            ByteArrayOutputStream bos=new ByteArrayOutputStream();
        } catch (ErrorResponseException e) {
            e.printStackTrace();
        } catch (InsufficientDataException e) {
            e.printStackTrace();
        } catch (InternalException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (InvalidResponseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (XmlParserException e) {
            e.printStackTrace();
        }
        return stream;
    }


    @Override
    public byte[] read(File fileInfo) {
        byte[] bytes=null;
        InputStream stream=readStream(fileInfo);
        if(stream!=null){
            try {
                ByteArrayOutputStream bos=new ByteArrayOutputStream();
                byte[] b= new byte[1024];int len;
                while((len = stream.read(b))!=-1){
                    bos.write(b,0,len);
                }
                bytes = bos.toByteArray();
                bos.close();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        return bytes;

    }


    @Override
    public Boolean isFileExists(File fileInfo) {

        try {
            StatObjectResponse statObj=client.statObject(StatObjectArgs.builder().bucket(bucket).object(fileInfo.getLocation()).build());
            if(statObj!=null&&statObj.size()>0){
                return true;
            }else{
                return false;
            }
        } catch (ErrorResponseException e) {
            e.printStackTrace();
        } catch (InsufficientDataException e) {
            e.printStackTrace();
        } catch (InternalException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (InvalidResponseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (XmlParserException e) {
            e.printStackTrace();
        }
        return false;
    }




}
