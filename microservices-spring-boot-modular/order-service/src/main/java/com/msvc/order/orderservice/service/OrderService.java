package com.msvc.order.orderservice.service;

import com.msvc.order.orderservice.dto.OrderLineItemsDto;
import com.msvc.order.orderservice.dto.OrderRequest;
import com.msvc.order.orderservice.model.OrderLineItems;
import com.msvc.order.orderservice.model.OrderModel;
import com.msvc.order.orderservice.repository.OrderRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;


    public void placeOrder (OrderRequest orderRequest){
        OrderModel orderModel = new OrderModel();
        orderModel.setNumberOrder(UUID.randomUUID().toString());

        List<OrderLineItems> orderLineItems  = orderRequest.getOrderLineItemsDto()
                .stream()
                .map(this::generateOrderItem)
                .collect(Collectors.toList());

        orderModel.setOrderLineItems(orderLineItems);
        orderRepository.save(orderModel);
    }


    private OrderLineItems generateOrderItem(OrderLineItemsDto orderLineItemsDto){
        OrderLineItems orderLineItems = new OrderLineItems();
        orderLineItems.setAmount(orderLineItemsDto.getAmount());
        orderLineItems.setPrice(orderLineItemsDto.getPrice());
        orderLineItems.setSkuCode(orderLineItemsDto.getSkuCode());
        return orderLineItems;
    }
}
