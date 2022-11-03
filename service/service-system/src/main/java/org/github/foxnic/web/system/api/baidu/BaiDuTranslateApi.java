package org.github.foxnic.web.system.api.baidu;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.foxnic.commons.bean.BeanUtil;
import com.github.foxnic.commons.encrypt.MD5Util;
import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.commons.log.Logger;
import com.github.foxnic.commons.network.HttpClient;
import com.github.foxnic.dao.data.SaveMode;
import org.github.foxnic.web.domain.system.Lang;
import org.github.foxnic.web.language.Language;
import org.github.foxnic.web.system.api.TranslateApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BaiDuTranslateApi extends TranslateApi {
    // 对接的api为百度翻译
    private static final String TRANS_API_HOST = "https://fanyi-api.baidu.com/api/trans/vip/translate";

    @Value("${foxnic.language.translator.baidu.appId}")
    private String appId = null;

    @Value("${foxnic.language.translator.baidu.securityKey}")
    private String securityKey = null;

    private static HttpClient client = new HttpClient();

    // 发送查询
    private String getTranslateResult(String query, BaiDuLanguage from, BaiDuLanguage to) throws Exception {

        String appId=this.decrypt(this.appId);
        String securityKey=this.decrypt(this.securityKey);
        query=query.replace(" ","");
        query=query.replace("&nbsp;","");
        query=query.trim();
        List<String> params = new ArrayList<>();
        params.add("q=" + query);
        params.add("from=" + from.code());
        params.add("to=" + to.code());
        params.add("appid=" + appId);
        // 随机数
        String salt = String.valueOf(System.currentTimeMillis());
        params.add("salt=" + salt);
        // 签名
        String src = appId + query + salt + securityKey; // 加密前的原文
        params.add("sign=" + MD5Util.encrypt32(src).toLowerCase());
        String translateResult = client.get(TRANS_API_HOST + "?" + StringUtil.join(params, "&"));
        JSONObject jsonObject = JSONObject.parseObject(translateResult);
        String string = jsonObject.getJSONArray("trans_result").getJSONObject(0).getString("dst");
        return string;
    }


    @Override
    public void translate(String code) {
        Lang lang=langService.getById(code);
        for (BaiDuLanguage to : BaiDuLanguage.values()) {
            if(to==BaiDuLanguage.zh) continue;
            boolean doTrans=true;
            for (Language language : to.getLanguages()) {
                String value= BeanUtil.getFieldValue(lang,language.code(),String.class);
                if(!StringUtil.isBlank(value)) {
                    doTrans=false;
                }
            }
            if(!doTrans) continue;
            try {
                String result = getTranslateResult(lang.getDefaults(), BaiDuLanguage.zh, to);
                if(StringUtil.isBlank(result)) continue;
                for (Language language : to.getLanguages()) {
                    String value= BeanUtil.getFieldValue(lang,language.code(),String.class);
                    if(StringUtil.isBlank(value)) {
                        BeanUtil.setFieldValue(lang,language.code(),result);
                    }
                }
            } catch (Exception e) {
                Logger.exception(e);
            }
        }
        System.out.println(JSON.toJSON(lang));
        langService.update(lang, SaveMode.DIRTY_FIELDS);

    }
}
