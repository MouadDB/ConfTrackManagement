package com.itemis.conftrackmanagement;

/**
 *
 * @author Mouad Douieb
 */
public class Session {
    
    /**
     * Session total duration
     */
    private int totalDuration;
    
    /**
     * Session available minutes
     */
    private int availableMinutes;
    
    /**
     * Session available minutes extended
     */
    private int availableMinutesExtended;

    /**
     * Get the value of availableMinutesExtended
     *
     * @return the value of availableMinutesExtended
     */
    public int getAvailableMinutesExtended() {
        return availableMinutesExtended;
    }

    /**
     * Set the value of availableMinutesExtended
     *
     * @param availableMinutesExtended new value of availableMinutesExtended
     */
    public void setAvailableMinutesExtended(int availableMinutesExtended) {
        this.availableMinutesExtended = availableMinutesExtended;
    }


    /**
     * Get the value of availableMinutes
     *
     * @return the value of availableMinutes
     */
    public int getAvailableMinutes() {
        return availableMinutes;
    }

    /**
     * Set the value of availableMinutes
     *
     * @param availableMinutes new value of availableMinutes
     */
    public void setAvailableMinutes(int availableMinutes) {
        this.availableMinutes = availableMinutes;
    }


    /**
     * Get the value of totalDuration
     *
     * @return the value of totalDuration
     */
    public int getTotalDuration() {
        return totalDuration;
    }

    /**
     * Set the value of totalDuration
     *
     * @param totalDuration new value of totalDuration
     */
    public void setTotalDuration(int totalDuration) {
        this.totalDuration = totalDuration;
    }

}
