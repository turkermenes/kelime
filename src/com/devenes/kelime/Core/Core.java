package com.devenes.kelime.Core;

public class Core {
    public static String[] languages = {"ingilizce"};
    public static String selectedMode = "";
    public int hours, minutes, seconds = 0;

    public void resetTime() {
        hours = 0;
        minutes = 0;
        seconds = 0;
    }

    public String timeFormat() {
        String hour = hours < 10 ? "0" + hours : String.valueOf(hours);
        String minute = minutes < 10 ? "0" + minutes : String.valueOf(minutes);
        String second = seconds < 10 ? "0" + seconds : String.valueOf(seconds);

        return hour + ":" + minute + ":" + second;
    }

}
