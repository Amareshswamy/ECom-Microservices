package com.project.microservices.order.controller;

import com.project.microservices.order.dto.OrderRequest;
import com.project.microservices.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OrderController
{
    private final OrderService orderService;

    // add the required methods here

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public String placeOrder(@RequestBody OrderRequest orderRequest)
    {
        System.out.println("Order request: " + orderRequest);
        orderService.placeOrder(orderRequest);
        return "Order placed successfully";
    }
}
