package com.ksunenori.store.mappers;

import com.ksunenori.store.dtos.ProductDto;
import com.ksunenori.store.entities.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    @Mapping(source = "category.id", target = "categoryId")
    ProductDto toDto(Product product);
}
