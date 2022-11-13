package com.itemis.conftrackmanagement;

import java.time.LocalTime;

/**
 *
 * @author Mouad Douieb
 */
public class MorningSession extends Session {
    public MorningSession() {
        super(LocalTime.of(9,0,0), LocalTime.of(12,0,0));

    }
}
