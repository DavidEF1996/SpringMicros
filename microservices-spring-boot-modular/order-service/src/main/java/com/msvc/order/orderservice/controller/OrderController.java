package com.msvc.order.orderservice.controller;

import com.msvc.order.orderservice.dto.OrderRequest;
import com.msvc.order.orderservice.model.OrderModel;
import com.msvc.order.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String makeOrder(@RequestBody OrderRequest orderRequest){
        orderService.placeOrder(orderRequest);
        return "success" + orderRequest.toString();
    }


    @GetMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<OrderModel> makeOrder(){
        return  orderService.getOrders();
    }
}
