package com.itemis.conftrackmanagement;

import java.util.regex.Pattern;

/**
 *
 * @author Mouad Douieb
 */
public class TalkRegexParser {
    
    private String lightning;
    
    /**
     * Talk Regular expression
     */
    private final String regex = "(?<title>.*) +(?<duration>\\d+(?=min)|lightning)";

    /**
     * Talk pattern
     */
    final Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);

    /**
     * Get the value of lightning
     *
     * @return the value of lightning
     */
    public String getLightning() {
        return lightning;
    }

    /**
     * Set the value of lightning
     *
     * @param lightning new value of lightning
     */
    public void setLightning(String lightning) {
        this.lightning = lightning;
    }

}
