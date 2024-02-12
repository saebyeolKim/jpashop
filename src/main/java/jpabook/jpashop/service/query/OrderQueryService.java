package jpabook.jpashop.service.query;

import jpabook.jpashop.api.OrderApiController;
import jpabook.jpashop.domain.Order;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Transactional(readOnly = true)
@Service
public class OrderQueryService {

//    public List<OrderDto> orderV3() {
//        List<Order> orders = orderRepository.findAllWithItem();
//        List<OrderApiController.OrderDto> collect = orders.stream()
//                .map(o -> new OrderApiController.OrderDto(o))
//                .collect(toList());
//        return collect;
//    }
}
