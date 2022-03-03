package org.github.foxnic.web.proxy.utils;

import com.alibaba.fastjson.JSON;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.encrypt.Base64Util;
import com.github.foxnic.commons.io.StreamUtil;
import com.github.foxnic.commons.log.Logger;
import org.github.foxnic.web.proxy.storage.FileServiceProxy;

import java.io.InputStream;

public class StorageProxyUtil {

    /**
     * 获得文件的 byte[] 数据
     * */
    public static byte[] getFileData(String id){
        Result<String> result = FileServiceProxy.api().getFileData(id);
        if(result.success()) {
            return Base64Util.decodeToBtyes(result.data());
        } else {
            Logger.info("Get File Error", JSON.toJSON(result));
            return null;
        }
    }

    /**
     * 获得文件的 InputStream
     * */
    public static InputStream getInputStream(String id){
        byte[] data=getFileData(id);
        if(data==null) return null;
        try {
            return StreamUtil.bytes2input(data);
        } catch (Exception e) {
            Logger.error("Get File Error",e);
            return null;
        }
    }

}
