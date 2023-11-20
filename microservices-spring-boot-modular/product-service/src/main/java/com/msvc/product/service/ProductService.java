package com.msvc.product.service;


import com.msvc.product.dto.ProductRequest;
import com.msvc.product.dto.ProductResponse;
import com.msvc.product.model.ProductModel;
import com.msvc.product.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ProductService {

    @Autowired
    private ProductRepository productRepository; //se inyecta el repository porque es el que extiende los metodos jpql

    public void createProduct(ProductRequest productRequest){

        ProductModel productModel=  ProductModel.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();

        productRepository.save(productModel);
        log.info("success", productModel.getId());
    }


    public List<ProductResponse> getAllProducts(){
        List<ProductModel> products= productRepository.findAll();
        return products.stream().map(this::matToProductResponse).collect(Collectors.toList());
    }

    private ProductResponse matToProductResponse(ProductModel productModel){
        return ProductResponse.builder()
                .id(productModel.getId())
                .description(productModel.getDescription())
                .name(productModel.getName())
                .price(productModel.getPrice())
                .build();
    }
}
