package com.project.microservice.inventroy.repository;

import com.project.microservice.inventroy.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface InventoryRepository extends JpaRepository<Inventory, Long> {


    boolean existsBySkuCodeAndQuantityGreaterThanEqual(String skuCode, Integer quantity);
}
