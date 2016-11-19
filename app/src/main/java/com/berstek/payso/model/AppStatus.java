package com.berstek.payso.model;

/**
 * Created by John on 11/17/2016.
 */

public class AppStatus {

    private static boolean setupDone = false;

    public static boolean isSetupDone() {
        return setupDone;
    }

    public static void setSetupDone(boolean setupDone) {
        AppStatus.setupDone = setupDone;
    }
}
