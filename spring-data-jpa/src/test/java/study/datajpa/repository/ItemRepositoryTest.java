package study.datajpa.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import study.datajpa.entity.Item;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ItemRepositoryTest {
    @Autowired
    ItemRepository itemRepository;

    @Test
    public void save() {
        Item item = new Item("A");

        // JPA persist를 해야 GeneratedValue 증가
        // 트랜잭션이 없어도 동작 (리포지토리 구현체에 트랜잭셔널 정의)
        itemRepository.save(item);
    }

}