package com.lab.java.zayson.item9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TryTestThird {
    public static void main(String[] args) throws IOException {
        // try-with-resources
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int number = Integer.parseInt(st.nextToken());
        // catch로 다수의 예외 처리 가능
        } catch (NumberFormatException numberFormatException) {
            numberFormatException.printStackTrace();
        } catch (IllegalStateException illegalStateException) {
            illegalStateException.printStackTrace();
        }
    }
}
