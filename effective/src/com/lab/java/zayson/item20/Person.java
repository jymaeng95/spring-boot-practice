package com.lab.java.zayson.item20;

public class Person implements SingerSongwriter {
    @Override
    public void sing() {
        System.out.println("Sing");
    }

    @Override
    public void strum() {
        System.out.println("Strum");
    }

    @Override
    public void actSensitive() {
        System.out.println("actSensitive");
    }

    @Override
    public void compose() {
        System.out.println("Compose");
    }
}
