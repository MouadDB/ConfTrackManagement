package com.itemis.conftrackmanagement;

/**
 *
 * @author Mouad Douieb
 */
public class TrackDay {
    
    
    /**
     * Track day name
     */
    private String name;

    /**
     * Get the value of name
     *
     * @return the value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Set the value of name
     *
     * @param name new value of name
     */
    public void setName(String name) {
        this.name = name;
    }
    
    @Override
    public String toString() {
        return "Track " + name + "\n";
    }

}
