package com.reactiveproduct.controller;

import com.reactiveproduct.dto.ProductRequestDto;
import com.reactiveproduct.dto.ProductResponseDto;
import com.reactiveproduct.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("products")
public class ProductController {

    @Autowired
    ProductService productService;
    @GetMapping("/{id}")
    public Mono<ProductResponseDto> findByProductId(@PathVariable("id") String id){
        return productService.findById(id);
    }

    @GetMapping
    public Flux<ProductResponseDto> findAll(@RequestParam(value = "minPrice", required = false) Double minPrice, @RequestParam(value = "maxPrice", required = false) Double maxPrice){
        if(minPrice == null && maxPrice == null) {
            return productService.findAll();
        }
        else {
            return productService.search(minPrice, maxPrice);
        }
    }

    @PostMapping
    public Mono<ProductResponseDto> create(@RequestBody  Mono<ProductRequestDto> productRequestDto){
        return productService.save(productRequestDto);
    }

    @PutMapping("/{id}")
    public Mono<ProductResponseDto> update(@PathVariable("id") String id, @RequestBody  Mono<ProductRequestDto> productRequestDto){
        return productService.update(id, productRequestDto);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> update(@PathVariable("id") String id){
        return productService.delete(id);
    }


}
