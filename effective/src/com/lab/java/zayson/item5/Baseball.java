package com.lab.java.zayson.item5;

import java.util.function.Supplier;

public class Baseball extends Sports {
    private static final int BATTER = 9;
    private static final int PITCHER = 1;

    @Override
    public int getPlayers() {
        return BATTER + PITCHER;
    }
}
