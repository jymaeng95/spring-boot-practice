package com.lab.java.zayson.item13;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class HashTableTest {
    @Test
    @DisplayName("가변 객체 배열 clone : version 1 ")
    void 가변객체_clone_테스트_V1() {
        HashTable hashTable = new HashTable();
        HashTable clone = hashTable.clone();

        // 복제한 객체의 원소는 동일하지만 복제 인스턴스와 원본 인스턴스의 주소가 다르다.
        assertThat(hashTable != clone).isTrue();
        System.out.println("==========");
        System.out.println("원본 인스턴스 hashTable : " + System.identityHashCode(hashTable));
        System.out.println("복제 인스턴스 hashTable : " + System.identityHashCode(clone));

        // 복제한 인스턴스의 bucket 배열과 원본 인스턴스의 bucket 배열의 참조가 다르다.
        assertThat(hashTable.getBuckets() != clone.getBuckets()).isTrue();
        System.out.println("==========");
        System.out.println("원본 인스턴스 hashTable 내 버킷 배열 주소 : " + System.identityHashCode(hashTable.getBuckets()));
        System.out.println("복제 인스턴스 hashTable 내 버킷 배열 주소 : " + System.identityHashCode(clone.getBuckets()));

        // bucket 내부의 연결리스트는 복제된 인스턴스와 원본 인스턴스가 공유한다 (문제발생)
        assertThat(hashTable.compareEntry() == clone.compareEntry()).isTrue();

        System.out.println("==========");
        System.out.println("원본 인스턴스 hashTable 내 버킷 배열 내 연결리스트 주소 : " + System.identityHashCode(hashTable.compareEntry()));
        System.out.println("복제 인스턴스 hashTable 내 버킷 배열 내 연결리스트 주소 : " + System.identityHashCode(clone.compareEntry()));
    }

    @Test
    @DisplayName("가변 객체 배열 clone : version 2 ")
    void 가변객체_clone_테스트_V2() {
        HashTable hashTable = new HashTable();
        HashTable clone = hashTable.clone();

        // 복제한 객체의 원소는 동일하지만 복제 인스턴스와 원본 인스턴스의 주소가 다르다.
        assertThat(hashTable != clone).isTrue();
        System.out.println("==========");
        System.out.println("원본 인스턴스 hashTable : " + System.identityHashCode(hashTable));
        System.out.println("복제 인스턴스 hashTable : " + System.identityHashCode(clone));

        // 복제한 인스턴스의 bucket 배열과 원본 인스턴스의 bucket 배열의 참조가 다르다.
        assertThat(hashTable.getBuckets() != clone.getBuckets()).isTrue();
        System.out.println("==========");
        System.out.println("원본 인스턴스 hashTable 내 버킷 배열 주소 : " + System.identityHashCode(hashTable.getBuckets()));
        System.out.println("복제 인스턴스 hashTable 내 버킷 배열 주소 : " + System.identityHashCode(clone.getBuckets()));

        // bucket 내부의 연결리스트는 복제된 인스턴스와 원본 인스턴스를 공유하지 않는다.
        assertThat(hashTable.compareEntry() != clone.compareEntry()).isTrue();

        System.out.println("==========");
        System.out.println("원본 인스턴스 hashTable 내 버킷 배열 내 연결리스트 주소 : " + System.identityHashCode(hashTable.compareEntry()));
        System.out.println("복제 인스턴스 hashTable 내 버킷 배열 내 연결리스트 주소 : " + System.identityHashCode(clone.compareEntry()));
    }
}