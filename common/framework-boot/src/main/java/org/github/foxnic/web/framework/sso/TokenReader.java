package org.github.foxnic.web.framework.sso;

import com.alibaba.fastjson.JSONObject;
import org.github.foxnic.web.language.Language;

import javax.servlet.http.HttpServletRequest;

public abstract class TokenReader {

    private static ThreadLocal<String> RENEW_JTI=new InheritableThreadLocal<>();

    private static ThreadLocal<JSONObject> KEEP_REFRESH_TOKEN=new InheritableThreadLocal<>();

    /**
     * 使 Token 在同一 JTI 续租
     * */
    public void setRenewJTI(String jti) {
        RENEW_JTI.set(jti);
    }

    public static String getRenewJTI() {
        return RENEW_JTI.get();
    }

    /**
     *  保持 RefreshToken 不变
     * */
    public void setKeepRefreshToken(JSONObject jwtJson) {
        KEEP_REFRESH_TOKEN.set(jwtJson);
    }

    public static JSONObject getKeepRefreshToken() {
        return KEEP_REFRESH_TOKEN.get();
    }


    public static class UserId {
        private String value;
        private boolean sso;

        private Language language;

        public UserId(String value, Language language ,boolean sso) {
            this.value = value;
            this.sso = sso;
            this.language=language;
        }

        public String value() {
            return value;
        }

        public boolean sso() {
            return sso;
        }

        public Language language() {
            return language;
        }
    }

    public abstract String readUserId(HttpServletRequest request);

    public abstract Language readLanguage(HttpServletRequest request);

}
