package org.github.foxnic.web.notify.support.sms;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.foxnic.commons.collection.CollectorUtil;
import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.commons.log.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.net.ssl.*;
import java.io.*;
import java.net.URL;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class SMSSupport4HuaWei extends SMSSupport {


    /**
     * 接口地址
     * */
    @Value("${foxnic.notify.sms.huawei.api-url}")
    private String url;
    /**
     * 账号
     * */
    @Value("${foxnic.notify.sms.huawei.account}")
    private String account;
    /**
     * 密码
     * */
    @Value("${foxnic.notify.sms.huawei.password}")
    private String password;

    /**
     * 签名
     * */
    @Value("${foxnic.notify.sms.huawei.signature}")
    private String signature;

    @PostConstruct
    private void init() {
        this.url=this.decrypt(this.url);
        this.account=this.decrypt(this.account);
        this.password=this.decrypt(this.password);
        this.signature=this.decrypt(this.signature);
    }


    /**
     * 设置不验证主机
     */
    private static final HostnameVerifier DO_NOT_VERIFY = new HostnameVerifier() {
        @Override
        public boolean verify(String hostname, SSLSession session) {
            return true;
        }
    };


    public void sendByPhoneNumbers(List<String> phoneNumbers, String smsTemplateId, Map<String, String> templateParams) {
        try {
            sendByPhoneNumbersInternal(phoneNumbers,smsTemplateId,templateParams);
        } catch (Exception e) {
            Logger.exception(e);
        }
    }

    /**
     * 发送短信接口
     * @param phoneNumbers 手机号清单
     * @param smsTemplateId 短信模板
     * @param templateParams hashmap参数
     * @return
     * @throws SMSException
     */
    private String sendByPhoneNumbersInternal(List<String> phoneNumbers, String smsTemplateId, Map<String, String> templateParams) throws SMSException {

        // 剔除无效的号码
        phoneNumbers=CollectorUtil.filter(phoneNumbers,p->{
           return StringUtil.hasContent(p);
        });

        if(phoneNumbers.isEmpty()) {
            throw new SMSException("缺少手机号码");
        }

        Map<String, Object> body = buildRequestBody(phoneNumbers, smsTemplateId, templateParams, account, password);
        if (null == body || body.isEmpty()) {
            throw new SMSException("body is null.");
        }

        HttpsURLConnection connection = null;
        InputStream is = null;
        BufferedReader br = null;
        try {
            trustAllHttpsCertificates();
            URL realUrl = new URL(url);
            connection = (HttpsURLConnection) realUrl.openConnection();
            connection.setHostnameVerifier(DO_NOT_VERIFY);
            connection.setDoInput(true); // 设置可输入
            connection.setDoOutput(true); // 设置该连接是可以输出的
            connection.setRequestMethod("POST"); // 设置请求方式
            connection.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
            // connection.connect();
            ObjectMapper objectMapper = new ObjectMapper();
            PrintWriter pw = new PrintWriter(new OutputStreamWriter(connection.getOutputStream(), "UTF-8"));
            pw.write(objectMapper.writeValueAsString(body));
            pw.flush();
            pw.close();

            br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));
            int status = connection.getResponseCode();
            if (200 == status) { // 200
                is = connection.getInputStream();
            } else { // 400/401
                is = connection.getErrorStream();
            }
            br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            String line = null;
            StringBuilder result = new StringBuilder();
            while ((line = br.readLine()) != null) { // 读取数据
                result.append(line + "\n");
            }
            connection.disconnect();
            Logger.info("华为云短信接口返回：" + result.toString());
            return result.toString();
        } catch (Exception e) {
            Logger.error("华为云短信接口调用异常: " + e.getMessage());
            throw new SMSException(e.getMessage());
        } finally {
            try {
                if (null != is) {
                    is.close();
                }
                if (null != br) {
                    br.close();
                }
            } catch (Exception e) {
                Logger.error("华为云短信接口，流关闭异常: " + e.getMessage());
                throw new SMSException(e.getMessage());
            }
        }
    }

    private static void trustAllHttpsCertificates() throws Exception {
        TrustManager[] trustAllCerts = new TrustManager[]{
                new X509TrustManager() {
                    @Override
                    public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                        return;
                    }

                    @Override
                    public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                        return;
                    }

                    @Override
                    public X509Certificate[] getAcceptedIssuers() {
                        return null;
                    }
                }
        };
        SSLContext sc = SSLContext.getInstance("SSL");
        sc.init(null, trustAllCerts, null);
        HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
    }


    private Map<String, Object> buildRequestBody(List<String> phoneNumbers, String smsTemplateId,
                                                       Map<String, String> paramValues, String accout, String passward) {
        if (null == phoneNumbers || null == smsTemplateId || null == accout || null == passward) {
            System.out.println(
                    "buildRequestBody(): mobiles, templateId or templateParas or account or password is null.");
            return null;
        }


        Map<String, Object> map = new HashMap<String, Object>();
        List<MtSmsMessage> requestLists = new ArrayList<MtSmsMessage>();
        MtSmsMessage mtSmsMessage = new MtSmsMessage();
        List<String> mobiles = new ArrayList<String>();
        for (String mobile : phoneNumbers) {
            mobiles.add(mobile);
        }
        mtSmsMessage.setMobiles(mobiles);
        mtSmsMessage.setTemplateId(smsTemplateId);
        mtSmsMessage.setTemplateParas(paramValues);
        mtSmsMessage.setSignature(signature);
        requestLists.add(mtSmsMessage);
        map.put("account", accout);
        map.put("password", passward);
        map.put("requestLists", requestLists);
        return map;
    }


    public static class MtSmsMessage {
        List<String> mobiles;

        String templateId;

        Map<String, String> templateParas;

        String signature;

        String messageId;

        String extCode;

        List<NamedPatameter> extendInfos;

        /**
         * 返回 mobiles
         *
         * @return mobiles值
         */
        public List<String> getMobiles() {
            return mobiles;
        }

        /**
         * 对mobiles进行赋值
         *
         * @param mobiles mobiles值
         */
        public void setMobiles(List<String> mobiles) {
            this.mobiles = mobiles;
        }

        /**
         * 返回 templateId
         *
         * @return templateId值
         */
        public String getTemplateId() {
            return templateId;
        }

        /**
         * 对templateId进行赋值
         *
         * @param templateId templateId值
         */
        public void setTemplateId(String templateId) {
            this.templateId = templateId;
        }

        /**
         * 返回 templateParas
         *
         * @return templateParas值
         */
        public Map<String, String> getTemplateParas() {
            return templateParas;
        }

        /**
         * 对templateParas进行赋值
         *
         * @param templateParas templateParas值
         */
        public void setTemplateParas(Map<String, String> templateParas) {
            this.templateParas = templateParas;
        }

        /**
         * 返回 signature
         *
         * @return signature值
         */
        public String getSignature() {
            return signature;
        }

        /**
         * 对signature进行赋值
         *
         * @param signature signature值
         */
        public void setSignature(String signature) {
            this.signature = signature;
        }

        /**
         * 返回 messageId
         *
         * @return messageId值
         */
        public String getMessageId() {
            return messageId;
        }

        /**
         * 对messageId进行赋值
         *
         * @param messageId messageId值
         */
        public void setMessageId(String messageId) {
            this.messageId = messageId;
        }

        /**
         * 返回 extCode
         *
         * @return extCode值
         */
        public String getExtCode() {
            return extCode;
        }

        /**
         * 对extCode进行赋值
         *
         * @param extCode extCode值
         */
        public void setExtCode(String extCode) {
            this.extCode = extCode;
        }

        /**
         * 返回 extendInfos
         *
         * @return extendInfos值
         */
        public List<NamedPatameter> getExtendInfos() {
            return extendInfos;
        }

        /**
         * 对extendInfos进行赋值
         *
         * @param extendInfos extendInfos值
         */
        public void setExtendInfos(List<NamedPatameter> extendInfos) {
            this.extendInfos = extendInfos;
        }

    }

    public class NamedPatameter {
        String key;

        String value;

        /**
         * 返回 key
         *
         * @return key值
         */
        public String getKey() {
            return key;
        }

        /**
         * 对key进行赋值
         *
         * @param key key值
         */
        public void setKey(String key) {
            this.key = key;
        }

        /**
         * 返回 value
         *
         * @return value值
         */
        public String getValue() {
            return value;
        }

        /**
         * 对value进行赋值
         *
         * @param value value值
         */
        public void setValue(String value) {
            this.value = value;
        }

    }


}
