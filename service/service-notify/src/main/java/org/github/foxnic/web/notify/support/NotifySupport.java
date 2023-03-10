package org.github.foxnic.web.notify.support;

import com.github.foxnic.commons.lang.StringUtil;
import org.github.foxnic.web.framework.config.ConfigKeys;
import org.github.foxnic.web.framework.security.ConfigDecryptor;

public class NotifySupport {

    /**
     * 解密配置信息
     * */
    protected String decrypt(String data) {
        if(StringUtil.isBlank(data)) return data;
        Boolean enable= ConfigDecryptor.getBooleanProperty(ConfigKeys.FOXNIC_NOTIFY,ConfigKeys.ENCRYPT,null);
        if(enable==null || !enable) return data;
        return ConfigDecryptor.decrypt(data);
    }

}
