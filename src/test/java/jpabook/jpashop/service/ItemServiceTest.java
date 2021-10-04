package jpabook.jpashop.service;

import jpabook.jpashop.domain.item.Book;
import jpabook.jpashop.domain.item.Item;
import jpabook.jpashop.repository.ItemRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class ItemServiceTest {

    @Autowired
    ItemService itemService;

    @Autowired
    ItemRepository itemRepository;

    @Test
    public void 상품등록() throws Exception {

        //Given
        Item item = new Book();
        item.setName("jpa-book");

        //When
        Long saveId = itemService.saveItem(item);

        //Then
        Item findItem = itemRepository.findOne(saveId).get();
        assertEquals(item.getName(), findItem.getName());

    }
}