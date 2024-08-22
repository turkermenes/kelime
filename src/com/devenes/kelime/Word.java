package com.devenes.kelime;

public class Word {
    String english, turkish;
    int rep;
    public Word() {
        english = "";
        turkish = "";
        rep = 0;
    }
    public Word(String english, String turkish) {
        this.english = english;
        this.turkish = turkish;
    }
    public Word(String english, String turkish, int rep) {
        this.english = english;
        this.turkish = turkish;
        this.rep = rep;
    }
    public String getEnglish() {
        return english;
    }

    public void setEnglish(String english) {
        this.english = english;
    }

    public String getTurkish() {
        return turkish;
    }

    public void setTurkish(String turkish) {
        this.turkish = turkish;
    }

    public int getRep() {
        return rep;
    }

    public void setRep(int rep) {
        this.rep = rep;
    }

    public String toString() {
        return english + " = " + turkish + " [" + rep + "]";
    }
}
