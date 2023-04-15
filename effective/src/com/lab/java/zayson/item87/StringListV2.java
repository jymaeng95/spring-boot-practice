package com.lab.java.zayson.item87;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class StringListV2 implements Serializable {
    // transient 키워드를 이용해 필드를 직렬화 대상에서 제외
    private transient int size = 0;
    private transient Entry head = null;

    private static class Entry {
        String data;
        Entry next;
        Entry previous;
    }

    // StringListV2 인스턴스 직렬화

    /**
     * @serialData List Size, List All Elements
     * @param stream
     * @throws IOException
     */
    private void writeObject(ObjectOutputStream stream) throws IOException {
        stream.defaultWriteObject();  // 다음 릴리스에 transient로 선언되지 않은 필드가 추가되는 경우 문제없이 호환
        stream.writeInt(size); // size 직렬화

        // 해당 객체를 루트론 연결된 원소를 모두 기록
        for (Entry e = head; e != null; e = e.next) {
            stream.writeObject(e.data);
        }
    }

    // 인스턴스 역직렬화
    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        stream.defaultReadObject();
        int numElements = stream.readInt();

        // 모든 원소를 읽어 리스트에 삽입
        for (int index = 0; index < numElements; index++) {
            Object element = stream.readObject();
            // add((String) element);
        }
    }
}
