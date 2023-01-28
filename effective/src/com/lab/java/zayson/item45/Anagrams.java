package com.lab.java.zayson.item45;

import java.io.File;
import java.util.Arrays;

public class Anagrams {
    public static String alphabetize(String s) {
        char[] a = s.toCharArray();
        Arrays.sort(a);

        return new String(a);
    }
}
