package com.csidigital.rh.shared.enumeration;

public enum Language {
    ARABIC("Arabic"),
    AZERBAIJANI("Azerbaijani"),
    BENGALI("Bengali"),
    CHINESE_CANTONESE("Cantonese"),
    CHINESE_MANDARIN("Mandarin Chinese"),
    ENGLISH("English"),
    FRENCH("French"),
    GERMAN("German"),
    GUJARATI("Gujarati"),
    HINDI("Hindi"),
    INDONESIAN("Indonesian"),
    ITALIAN("Italian"),
    JAPANESE("Japanese"),
    JAVANESE("Javanese"),
    KANNADA("Kannada"),
    KOREAN("Korean"),
    MALAY("Malay"),
    MARATHI("Marathi"),
    PERSIAN("Persian"),
    POLISH("Polish"),
    PORTUGUESE("Portuguese"),
    PUNJABI("Punjabi"),
    RUSSIAN("Russian"),
    SPANISH("Spanish"),
    TAMIL("Tamil"),
    TELUGU("Telugu"),
    TURKISH("Turkish"),
    URDU("Urdu"),
    VIETNAMESE("Vietnamese");
    private  String language;
    Language(String language) {
        this.language = language;
    }
    public String getLanguage() {
        return language;
    }
}
