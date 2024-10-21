package com.project.microservices.product.controller;

import com.project.microservices.product.dto.ProductRequest;
import com.project.microservices.product.dto.ProductResponse;
import com.project.microservices.product.model.Product;
import com.project.microservices.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200/")
public class ProductController
{
    private final ProductService productService;

    @CrossOrigin(origins = "http://localhost:4200/")
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ProductResponse createProduct(@RequestBody ProductRequest productRequest)
    {
      return productService.createProduct(productRequest);

    }

    @CrossOrigin(origins = "http://localhost:4200/")
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> getAllProducts()
    {
//        try{
//            Thread.sleep(5000);
//        }
//        catch (InterruptedException e) {
//           throw new RuntimeException(e);
//        }
      return productService.getAllProducts();
    }
}
