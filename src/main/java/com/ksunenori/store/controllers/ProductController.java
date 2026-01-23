package com.ksunenori.store.controllers;

import com.ksunenori.store.dtos.ProductDto;
import com.ksunenori.store.entities.Product;
import com.ksunenori.store.mappers.ProductMapper;
import com.ksunenori.store.repositories.CategoryRepository;
import com.ksunenori.store.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@AllArgsConstructor
@Getter
@RequestMapping("/product")
@RestController
public class ProductController {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final CategoryRepository categoryRepository;

    @GetMapping()
    public List<ProductDto> getAllProducts(
            @RequestParam(required = false, name = "categoryId") Byte categoryId) {
        List<Product> products;

        if (categoryId != null) {
            products = productRepository.findProductsByCategoryId(categoryId);
        } else {
            products = productRepository.findAllWithCategory();
        }
        return products.stream().map(productMapper::toDto).toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable long id) {
        var product = productRepository.findById(id).orElse(null);
        if (product == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(productMapper.toDto(product));
    }
}

