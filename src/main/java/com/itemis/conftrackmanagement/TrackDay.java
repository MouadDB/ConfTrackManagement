package com.itemis.conftrackmanagement;

import com.itemis.conftrackmanagement.session.MorningSession;
import com.itemis.conftrackmanagement.session.AfternoonSession;

/**
 *
 * @author Mouad Douieb
 */
public class TrackDay {

    private MorningSession morning = new MorningSession();

    private AfternoonSession afternoon = new AfternoonSession();

    public TrackDay() {
        morning = new MorningSession();

        afternoon = new AfternoonSession();
    }

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

    /**
     * Get the value of afternoon
     *
     * @return the value of afternoon
     */
    public AfternoonSession getAfternoon() {
        return afternoon;
    }

    /**
     * Set the value of afternoon
     *
     * @param afternoon new value of afternoon
     */
    public void setAfternoon(AfternoonSession afternoon) {
        this.afternoon = afternoon;
    }

    /**
     * Get the value of morning
     *
     * @return the value of morning
     */
    public MorningSession getMorning() {
        return morning;
    }

    /**
     * Set the value of morning
     *
     * @param morning new value of morning
     */
    public void setMorning(MorningSession morning) {
        this.morning = morning;
    }

    @Override
    public String toString() {
        return "Track " + name + "\n" + morning + afternoon;
    }

}
