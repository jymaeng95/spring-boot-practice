package com.lab.java.zayson.item88;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class BogusPeriod {
    // 진짜 Period 인스턴스에서 만들어질 수 없는 바이트 스트림
    private static final byte[] serializedForm = {(byte) 0xac, (byte) 0xed, 0x00, 0x05, 0x73, 0x72, 0x00, 0x06}; // 나머지 생략

    public static void main(String[] args) {
        Period p = (Period) deserialize(serializedForm);
        System.out.println(p);
    }

    // 주어진 직렬화 형태(바이트 스트림)로부터 객체를 만들어 반환
    static Object deserialize(byte[] sf) {
        try {
            return new ObjectInputStream(new ByteArrayInputStream(sf)).readObject();
        } catch (IOException | ClassNotFoundException exception) {
            throw new IllegalArgumentException(exception);
        }
    }
}
