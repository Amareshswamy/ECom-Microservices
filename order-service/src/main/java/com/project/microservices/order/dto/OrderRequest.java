package com.project.microservices.order.dto;

import java.math.BigDecimal;

public record OrderRequest(Long id, String OrderNumber, String skuCode, BigDecimal price, Integer quantity, UserDetails userDetails) {


    public record UserDetails(String email, String firstName, String lastName) {
    }
}
