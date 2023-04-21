package com.lab.java.zayson.item88;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.util.Date;

// final 키워드를 사용해 불변 클래스 정의
public final class Period {
    private Date start;
    private Date end;

    public Period(Date start, Date end) {
        // 불변 클래스에 대한 불변식을 위해 방어적 복사 사용
        this.start = new Date(start.getTime());
        this.end = new Date(end.getTime());

        if (this.start.compareTo(this.end) > 0) {
            throw new IllegalArgumentException(start + "가" + end + "보다 늦다.");
        }
    }
    public Date start() {
        return new Date(start.getTime());
    }

    public Date end() {
        return new Date(end.getTime());
    }

    public String toString() {
        return start + "-" + end;
    }

    // 역직렬화 유효셩 검사
    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        // defaultReadObject 호출
        stream.defaultReadObject();

        // 가변 요소들의 방어적 복사
        start = new Date(start.getTime());
        end = new Date(end.getTime());

        // 불변식 유효성 검사
        if (start.compareTo(end) > 0)
            throw new InvalidObjectException(start + "가" + end + "보다 늦다.");
    }
}

