package com.itemis.conftrackmanagement;

import java.util.regex.Matcher;
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

    public TalkRegexParser() {
    }


    /**
     * Talk pattern
     */
    final Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
    
    /**
     * Parse the talk
     * 
     * @param text
     * @return 
     */
    public Talk parse(String text) {
        Matcher result = pattern.matcher(text);
        
        while (result.find()) {
            int duration = result.group("duration").equals(this.lightning) ? 15 : Integer.parseInt(result.group("duration"));
            return new Talk(result.group("title").toString(), duration);
        }

        return null;
    }

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
