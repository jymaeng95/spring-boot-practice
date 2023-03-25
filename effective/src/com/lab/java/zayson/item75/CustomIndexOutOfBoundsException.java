package com.lab.java.zayson.item75;

public class CustomIndexOutOfBoundsException extends RuntimeException {
    private final int lowerBound;
    private final int upperBound;
    private final int index;

    // 예외 객체 생성 시 예외 발생 정보를 생성자로 넘겨 stackTrace를 위한 상세 정보를 담는다.
    public CustomIndexOutOfBoundsException(int lowerBound, int upperBound, int index) {
        super(String.format("최솟값 : %d, 최댓값 : %d, 인덱스 : %d", lowerBound, upperBound, index));

        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
        this.index = index;
    }

    public int getLowerBound() {
        return lowerBound;
    }

    public int getUpperBound() {
        return upperBound;
    }

    public int getIndex() {
        return index;
    }
}
