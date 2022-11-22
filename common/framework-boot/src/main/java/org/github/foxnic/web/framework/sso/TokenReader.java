package org.github.foxnic.web.framework.sso;

import org.github.foxnic.web.language.Language;

import javax.servlet.http.HttpServletRequest;

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

    public abstract String readUserId(HttpServletRequest request);

    public abstract Language readLanguage(HttpServletRequest request);

}
