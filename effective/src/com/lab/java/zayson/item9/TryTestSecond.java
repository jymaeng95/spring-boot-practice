package com.lab.java.zayson.item9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TryTestSecond {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            StringTokenizer st = new StringTokenizer(br.readLine());    // br.readLine()에서 예외 발생 시
            int number = Integer.parseInt(st.nextToken());
        } finally {
            br.close(); // br.close()도 예외 발생

            // br.close()예외만 출력, br.readLine()예외는 사라짐
        }
    }
}
