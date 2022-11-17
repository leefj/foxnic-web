package org.github.foxnic.web.oauth.jwt.reader;

import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.commons.reflect.ReflectUtil;
import com.github.foxnic.springboot.spring.SpringUtil;
import org.github.foxnic.web.language.Language;
import org.github.foxnic.web.proxy.oauth.UserServiceProxy;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public abstract class TokenReader {

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

    private static List<TokenReader> READERS = null;

    private static JwtTokenTokenReader jwtTokenTokenReader = null;

    public static void initReaders() {
        if(READERS!=null) return;
        //
        jwtTokenTokenReader=SpringUtil.getBean(JwtTokenTokenReader.class);
        //
        READERS = new ArrayList<>();
        String readerNames=SpringUtil.getEnvProperty("security.token-readers");
        if(StringUtil.isBlank(readerNames)) return;
        String[] ns=readerNames.split(",");
        for (String n : ns) {
            Class type= ReflectUtil.forName(n.trim(),true);
            if(type==null) {
                throw new IllegalArgumentException( n+" 未定义");
            }
            try {
                TokenReader reader=(TokenReader)SpringUtil.getBean(type);
                READERS.add(reader);
            } catch (Exception e) {
                throw new IllegalArgumentException(n+" 无法初始化",e);
            }
        }
    }

    public static UserId getUserId(HttpServletRequest request,boolean sso) {
        String userId = null;
        // 任意页面可登录，但考虑到还有JS的内容需要设置，暂时 SSO 仅限于  SSO_LOGIN_URI
        if(UserServiceProxy.SSO_LOGIN_URI.equals(request.getRequestURI())) {
            for (TokenReader reader : READERS) {
                userId = reader.readUserId(request);
                Language language=reader.readLanguage(request);
                if (userId != null) {
                    return new UserId(userId,language,true);
                }
            }
        }
        //
        if(!sso) {
            userId = jwtTokenTokenReader.readUserId(request);
            Language language = jwtTokenTokenReader.readLanguage(request);
            if (userId != null) return new UserId(userId, language, false);
        }
        return null;
    }

    public abstract String readUserId(HttpServletRequest request);

    public abstract Language readLanguage(HttpServletRequest request);

}
