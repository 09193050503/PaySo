package com.berstek.payso.model;

/**
 * Created by John on 11/17/2016.
 */

public class AppStatus {

    private boolean setupDone = false;

    public boolean isSetupDone() {
        return setupDone;
    }

    public void setSetupDone(boolean setupDone) {
        this.setupDone = setupDone;
    }
}
