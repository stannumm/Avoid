package com.mygdx.game.states;

/**
 * Created by pc on 22.08.2017.
 */

public class Time {

    public static void setTime(long time) {
        Time.time = time;
    }

    public static long getTime() {

        return time;
    }

    private static long time;



}
