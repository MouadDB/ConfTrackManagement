package com.itemis.conftrackmanagement;

import java.time.LocalTime;

/**
 *
 * @author Mouad Douieb
 */
public class AfternoonSession extends Session {
    public AfternoonSession() {
        super(LocalTime.of(13,0,0), LocalTime.of(16,0,0), LocalTime.of(17,0,0));
    }
}
