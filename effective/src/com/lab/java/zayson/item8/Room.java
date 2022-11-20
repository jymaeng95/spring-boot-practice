package com.lab.java.zayson.item8;

import java.lang.ref.Cleaner;

public class Room implements AutoCloseable{
    // 클리너를 안전망으로 사용해서 종료되지 않은 경우에 언젠가 종료되도록 한다.
    private static final Cleaner cleaner = Cleaner.create();

    // 청소가 필요한 자원 - Room을 참조하면 안된다.
    private static class State implements Runnable {

        int numJunkPiles;   // 쓰레기 개수
        State(int numJunkPiles) {
            this.numJunkPiles = numJunkPiles;
        }

        @Override
        public void run() {
            System.out.println("방 청소");
            numJunkPiles = 0;
        }

    }
    // 방의 상태. cleanable과 공유

    private final State state;
    // cleanable 객체. 수거 대상이 된 경우 방을 청소

    private final Cleaner.Cleanable cleanable;
    public Room(int numJunkPiles) {
        this.state = new State(numJunkPiles);
        this.cleanable = cleaner.register(this, state);
    }

    // 자원이 반납될 때 자동으로 종료 호출
    @Override
    public void close() throws Exception {
        cleanable.clean();
    }
}
