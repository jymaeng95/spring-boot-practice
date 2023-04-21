package com.lab.java.zayson.item89;

import java.util.Arrays;

public enum ElvisV2 {
    INSTANCE;
    private String[] favoriteSongs = {"Hound Dog", "heartbreak hotel"};

    public void printFavorites() {
        System.out.println(Arrays.toString(favoriteSongs));
    }
}
