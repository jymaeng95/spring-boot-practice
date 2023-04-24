package com.lab.java.zayson.item90;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Date;

// 바깥 클래스 Serializable 구현
public class Period implements Serializable{
    private static final long serialVersionUID = 1203981209381092L;
    private final Date start;
    private final Date end;

    public Period(Date start, Date end) {
        this.start = start;
        this.end = end;
    }

    // 직렬화 프록시 클래스 (Serializable 구현)
    private static class SerializationProxy implements Serializable {
        private final Date start;
        private final Date end;

        // 바깥 클래스 인수를 중첩클래스 데이터로 복사
        SerializationProxy(Period p) {
            this.start = p.start;
            this.end = p.end;
        }

        // 역직렬화 시 직렬화 프록시 -> 바깥 클래스로 변환
        private Object readResolve() {
            return new Period(start, end);
        }

        private static final long serialVersionUID = 128371293871293877L;
    }

    // 직렬화 프록시 패턴용 writeReplace 메서드
    private Object writeReplace() {
        return new SerializationProxy(this);
    }

    // 직렬화 인스턴스 생성을 통한 불변식 훼손을 방어
    private void readObject(ObjectInputStream stream) throws InvalidObjectException {
        throw new InvalidObjectException("프록시가 필요합니다.");
    }
}
