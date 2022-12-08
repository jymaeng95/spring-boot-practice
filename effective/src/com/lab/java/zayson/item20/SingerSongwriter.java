package com.lab.java.zayson.item20;

public interface SingerSongwriter extends Singer, Songwriter{
    // 현실세계에는 Singer, Songwriter를 모두 다 하는 SingerSongwirter가 존재
    // 하지만 Singer, Songwriter가 계층 구조가 존재한다고 보기어렵다.

    void strum();

    void actSensitive();
}
