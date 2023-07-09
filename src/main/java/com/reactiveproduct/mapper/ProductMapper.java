package com.reactiveproduct.mapper;

import com.reactiveproduct.dto.ProductRequestDto;
import com.reactiveproduct.dto.ProductResponseDto;
import com.reactiveproduct.entity.Product;
import lombok.experimental.UtilityClass;
import org.springframework.beans.BeanUtils;

@UtilityClass
public class ProductMapper {


    public ProductResponseDto toResponseDto(Product product){
        ProductResponseDto productResponseDto = new ProductResponseDto();
        BeanUtils.copyProperties(product, productResponseDto);
        return productResponseDto;
    }

    public Product toEntity(ProductRequestDto productRequestDto){
        Product product = new Product();
        BeanUtils.copyProperties(productRequestDto, product);
        return product;
    }
}
