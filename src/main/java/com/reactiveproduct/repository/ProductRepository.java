package com.reactiveproduct.repository;

import com.reactiveproduct.entity.Product;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface ProductRepository extends ReactiveMongoRepository<Product, String> {

    @Query
    Flux<Product> findByPriceBetween(double minPrice, double maxPrice);
}
