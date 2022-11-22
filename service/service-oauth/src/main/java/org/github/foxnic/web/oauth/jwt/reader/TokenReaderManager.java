package org.github.foxnic.web.oauth.jwt.reader;

import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.commons.reflect.ReflectUtil;
import com.github.foxnic.springboot.spring.SpringUtil;
import org.github.foxnic.web.framework.sso.TokenReader;
import org.github.foxnic.web.language.Language;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Component
public class TokenReaderManager {
    private List<TokenReader> READERS = null;

    private JwtTokenTokenReader jwtTokenTokenReader = null;

    public void initReaders() {
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


    public TokenReader.UserId getUserIdBySSOReader(HttpServletRequest request) {
        String userId = null;
        for (TokenReader reader : READERS) {
            userId = reader.readUserId(request);
            Language language=reader.readLanguage(request);
            if (userId != null) {
                return new TokenReader.UserId(userId,language,true);
            }
        }
        return null;
    }

    public TokenReader.UserId getUserIdByDefaultTokenReader(HttpServletRequest request) {
        String userId = jwtTokenTokenReader.readUserId(request);
        Language language = jwtTokenTokenReader.readLanguage(request);
        if (userId != null) return new TokenReader.UserId(userId, language, false);
        return null;
    }

}
