package org.github.foxnic.web.language;

public class LanguageServiceInstance {
    private static LanguageService INSTANCE;
    public static LanguageService get() {
        return INSTANCE;
    }
    public static void set(LanguageService instance) {
        LanguageServiceInstance.INSTANCE = instance;
    }
}
