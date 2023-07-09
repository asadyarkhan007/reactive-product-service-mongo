package com.reactiveproduct.service;

import com.reactiveproduct.dto.ProductRequestDto;
import com.reactiveproduct.dto.ProductResponseDto;
import com.reactiveproduct.mapper.ProductMapper;
import com.reactiveproduct.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public Mono<ProductResponseDto> findById(String id) {
       return productRepository.findById(id).map(ProductMapper::toResponseDto);
    }

    public Mono<ProductResponseDto> save(Mono<ProductRequestDto> productMap) {
        return  productMap.map(ProductMapper::toEntity).flatMap(productRepository::insert).map(ProductMapper::toResponseDto);
    }

    public Mono<ProductResponseDto> update(String id, Mono<ProductRequestDto> product) {
        return productRepository.findById(id)
                .flatMap( p -> product.map(ProductMapper::toEntity).doOnNext( product1 -> product1.setId(id)))
                        .flatMap(product2 -> productRepository.save(product2).map(ProductMapper::toResponseDto));

    }

    public Mono<Void> delete(String id) {
        return productRepository.deleteById(id);

    }

    public Flux<ProductResponseDto> findAll() {
        return productRepository.findAll().map(ProductMapper::toResponseDto);
    }

    public Flux<ProductResponseDto> search(double minPrice, double maxPrice) {
        return productRepository.findByPriceBetween(minPrice,maxPrice).map(ProductMapper::toResponseDto);
    }


}
