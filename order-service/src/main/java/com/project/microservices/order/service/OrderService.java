package com.project.microservices.order.service;

import com.project.microservices.order.client.InventoryClient;
import com.project.microservices.order.dto.OrderRequest;
import com.project.microservices.order.event.OrderPlacedEvent;
import com.project.microservices.order.model.Order;
import com.project.microservices.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import java.util.UUID;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService
{
    private final OrderRepository orderRepository;

    private final InventoryClient inventoryClient;

    private final KafkaTemplate<String,OrderPlacedEvent> kafkaTemplate;

    public void placeOrder(OrderRequest orderRequest)
    {
        System.out.println("Order request inside the Service started: " + orderRequest);

        // 1.using mockito
        // 2.using wiremock

        var isProductInStock =  inventoryClient.isInStock(orderRequest.skuCode(), orderRequest.quantity());

        System.out.println("Order request after Clinet call the Service started"+ isProductInStock);
        //map the orderRequest to Order object and

        if(isProductInStock) {
            Order order = new Order();
            order.setOrderNumber(UUID.randomUUID().toString());
            order.setPrice(orderRequest.price());
            order.setSkuCode(orderRequest.skuCode());
            order.setQuantity(orderRequest.quantity());
            orderRepository.save(order);

            //send the message to the kafka topic
            // orderNumber and emial
            OrderPlacedEvent orderPlacedEvent = new OrderPlacedEvent();
            orderPlacedEvent.setOrderNumber(order.getOrderNumber());
            orderPlacedEvent.setEmail(orderRequest.userDetails().email());
            orderPlacedEvent.setFirstName(orderRequest.userDetails().firstName());
            orderPlacedEvent.setLastName(orderRequest.userDetails().lastName());
            //log.info("OrderPlacedEvent: {}", orderPlacedEvent);
            kafkaTemplate.send("order-placed", orderPlacedEvent);
        }
        else{
            throw new RuntimeException("Product is skuCode"+ orderRequest.skuCode() + "is not in stock");
        }
       // save it to the database
        //System.out.println("Order request inside the Service ended: " + order);
    }
}
