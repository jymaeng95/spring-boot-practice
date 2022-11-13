package com.lab.java.zayson.item5;

import java.util.function.Supplier;

public class Soccer extends Sports {
    private static final int FIELD_PLAYER = 10;
    private static final int GOALKEEPER = 1;

    @Override
    public int getPlayers() {
        return FIELD_PLAYER + GOALKEEPER;
    }
}
