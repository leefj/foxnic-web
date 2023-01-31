package org.github.foxnic.web.oauth.jwt;

public enum TokenType {
    access("accessToken"),refresh("refreshToken");

    private String keyName;
    private TokenType(String keyName) {
        this.keyName=keyName;
    }

    public String keyName() {
        return keyName;
    }
}
