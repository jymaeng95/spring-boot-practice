package com.lab.java.zayson.item53;

public class VarargsOverloading {
    // 인수가 0-3개까지의 메서드가 95% 확률로 호출되는 경우 가변인수보다 오버로딩이 성능적으로 좋음
    public void foo() {}
    public void foo(int a1) {}
    public void foo(int a1, int a2) {}
    public void foo(int a1, int a2, int a3) {}

    // 나머지 5%의 경우에만 배열을 생성되게 해 유연한 개수의 메서드를 호출하도록 만듬
    public void foo(int a1, int a2, int a3, int... rest) {}
}
