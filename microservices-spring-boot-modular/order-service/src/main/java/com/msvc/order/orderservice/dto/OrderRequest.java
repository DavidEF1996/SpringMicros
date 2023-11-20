package com.msvc.order.orderservice.dto;

import com.msvc.order.orderservice.model.OrderLineItems;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest {


    private List<OrderLineItemsDto> orderLineItemsDto;


}
