package com.lab.java.zayson.item9;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.StringTokenizer;

public class TryTestFirst {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        try {
            String line = br.readLine();
            // 자원이 두 개 이상인 경우 try 내부에 try가 들어가는 불편한 구조
            try {
                bw.write(line);
                bw.flush();
            } finally {
                bw.close();
            }
        } finally {
            br.close();
        }
    }
}
