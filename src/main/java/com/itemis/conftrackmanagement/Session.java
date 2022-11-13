package com.itemis.conftrackmanagement;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

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
     * Session start time
     */
    private LocalTime startTime;

    /**
     * Session end time
     */
    private LocalTime endTime;

    /**
     * Session end time extended
     */
    private LocalTime endTimeExtended;

    /**
     * Session talks list
     */
    private List<Talk> talks = new ArrayList<>();

    public Session(LocalTime startTime, LocalTime endTime, LocalTime endTimeExtended) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.endTimeExtended = endTimeExtended;

        this.availableMinutes = (int) ChronoUnit.MINUTES.between(this.startTime, this.endTime);
        this.availableMinutesExtended = (int) ChronoUnit.MINUTES.between(this.startTime, this.endTimeExtended);
    }

    public Session(LocalTime startTime, LocalTime endTime) {
        this(startTime, endTime, endTime);
    }

    public boolean addTalk(Talk talk, boolean extended) {
        if (this.checkTalk(talk, extended)) {

            this.talks.add(talk);

            this.updateTime();
            return true;
        }
        return false;
    }

    public void addTalk(Talk talk) {
        this.talks.add(talk);
        this.updateTime();
    }

    public int calculatedAvailableMinutes(boolean extended) {
        return extended ? this.availableMinutesExtended : this.availableMinutes;
    }

    protected boolean checkTalk(Talk talk, boolean extended) {

        if (talk == null) {
            return false;
        }

        LocalTime end = this.startTime.plus(this.totalDuration + talk.getDuration(), ChronoUnit.MINUTES);

        return extended ? (end.compareTo(this.endTimeExtended) < 1) : (end.compareTo(this.endTime) < 1);
    }

    protected void updateTime() {

        Talk lastTalk = this.talks.get(this.talks.size() - 1);

        this.totalDuration += lastTalk.getDuration();
        this.availableMinutes -= lastTalk.getDuration();
        this.availableMinutesExtended -= lastTalk.getDuration();
    }

    @Override
    public String toString() {

        String output = "";

        LocalTime start = this.startTime;

        for (Talk talk : talks) {
            output += String.format("%s %s\n", start, talk.toString());

            start = start.plus(talk.getDuration(), ChronoUnit.MINUTES);
        }

        return output;
    }

    /**
     * Get the value of talks
     *
     * @return the value of talks
     */
    public List<Talk> getTalks() {
        return talks;
    }

    /**
     * Set the value of talks
     *
     * @param talks new value of talks
     */
    public void setTalks(List<Talk> talks) {
        this.talks = talks;
    }

    /**
     * Get the value of endTimeExtended
     *
     * @return the value of endTimeExtended
     */
    public LocalTime getEndTimeExtended() {
        return endTimeExtended;
    }

    /**
     * Set the value of endTimeExtended
     *
     * @param endTimeExtended new value of endTimeExtended
     */
    public void setEndTimeExtended(LocalTime endTimeExtended) {
        this.endTimeExtended = endTimeExtended;
    }

    /**
     * Get the value of startTime
     *
     * @return the value of startTime
     */
    public LocalTime getStartTime() {
        return startTime;
    }

    /**
     * Set the value of startTime
     *
     * @param startTime new value of startTime
     */
    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    /**
     * Get the value of endTime
     *
     * @return the value of endTime
     */
    public LocalTime getEndTime() {
        return endTime;
    }

    /**
     * Set the value of endTime
     *
     * @param endTime new value of endTime
     */
    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

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
