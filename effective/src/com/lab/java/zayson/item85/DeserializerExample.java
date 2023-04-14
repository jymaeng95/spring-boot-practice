package com.lab.java.zayson.item85;

import java.util.HashSet;
import java.util.Set;

public class DeserializerExample {
    static byte[] bomb() {
        Set<Object> root = new HashSet<>();
        Set<Object> s1 = root;
        Set<Object> s2 = new HashSet<>(); // 새로우 해시셋

        for (int loop = 0; loop < 100; loop++) {
            Set<Object> t1 = new HashSet<>();
            Set<Object> t2 = new HashSet<>();
            t1.add("foo");  // t1을 t2와 다르게 만듬

            s1.add(t1);
            s1.add(t2);

            s2.add(t1);
            s2.add(t2);
            s1 = t1;
            s2 = t2;
        }
//        return serialize(root);
        return null;
    }
}
