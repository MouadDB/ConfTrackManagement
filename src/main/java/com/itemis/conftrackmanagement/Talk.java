package com.itemis.conftrackmanagement;

/**
 *
 * @author Mouad Douieb
 */
public class Talk {
    
    /**
     * Talk Title
     */
    private String title;
    
    /**
     * Talk duration in minutes
     */
    private int duration;

    /**
     * Default Constructor
     */
    public Talk() {
        this.title = "";
        this.duration = 0;
    }

    /**
     * Talk parameterized constructor
     * 
     * @param title 
     * @param duration
     */
    public Talk(String title, int duration) {
        this.title = title;
        this.duration = duration;
    }

    /**
     * Get the value of title
     *
     * @return the value of title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Set the value of title
     *
     * @param title new value of title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Get the value of duration
     *
     * @return the value of duration
     */
    public int getDuration() {
        return duration;
    }

    /**
     * Set the value of duration
     *
     * @param duration new value of duration
     */
    public void setDuration(int duration) {
        this.duration = duration;
    }


    @Override
    public String toString() {
        return this.duration != 15 ? String.format("%s %dmin", this.title, this.duration) : String.format("%s lightning", this.title);
    }

}
