package com.msvc.product.controller;

import com.msvc.product.dto.ProductRequest;
import com.msvc.product.dto.ProductResponse;
import com.msvc.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductService productService; // se inyectan los metodos de product service

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveProduct(@RequestBody ProductRequest productRequest){
        productService.createProduct(productRequest);
    }


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> listProducts(){
        return productService.getAllProducts();
    }
}
