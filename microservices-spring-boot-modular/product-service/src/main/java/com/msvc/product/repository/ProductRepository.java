package com.msvc.product.repository;

import com.msvc.product.model.ProductModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<ProductModel, String> {

}
