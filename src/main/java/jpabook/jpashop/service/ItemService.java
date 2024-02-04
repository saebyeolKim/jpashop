package jpabook.jpashop.service;

import jpabook.jpashop.domain.item.Book;
import jpabook.jpashop.domain.item.Item;
import jpabook.jpashop.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    @Transactional
    public void saveItem(Item item) {
        itemRepository.save(item);
    }

    //변경 감지 기능 사용
    @Transactional
    public Item updateItem(Long itemId, String name, int price, int stockQuantity) { //변경해야 할 파라미터가 많다면 Dto 를 생성해서 넣어주자
        //merge 는 JPA 가 준영속 엔티티를 상대로 밑의 코드를 실행해줌
        //merge 는 전체 데이터가 변경되기 때문에 가급적이면 변경 감지 기능을 사용해야 한다.
        Item findItem = itemRepository.findOne(itemId); //영속성 컨텐츠이기 때문에 itemRepository 를 불러오지 않아도 된다.
        //의미있는 비즈니스 로직을 엔티티에 생성해야 함 (밑의 코드 처럼). set 제거 필요
        //findItem.change(name, price, stockQuantity)
        findItem.setPrice(price);
        findItem.setName(name);
        findItem.setStockQuantity(stockQuantity);
        return findItem;
    }

    public List<Item> findItems() {
        return itemRepository.findAll();
    }

    public Item findOne(Long itemId) {
        return itemRepository.findOne(itemId);
    }
}
