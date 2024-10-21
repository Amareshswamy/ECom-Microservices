package com.project.microservice.inventroy.service;

import com.project.microservice.inventroy.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    public boolean isInStock(String skuCode, Integer quantity) {
        //find the inventory for skuCode which is >= 0
         return  inventoryRepository.existsBySkuCodeAndQuantityGreaterThanEqual(skuCode, quantity);

    }
}
