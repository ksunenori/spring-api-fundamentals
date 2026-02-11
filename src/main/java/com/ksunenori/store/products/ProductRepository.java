package com.ksunenori.store.products;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    @EntityGraph(attributePaths = "category")
    List<Product> findProductsByCategoryId(Byte categoryId);

    //If you dont want to use join fetch use
    //@EntityGraph(attributePaths = "category")
    @Query("SELECT p from Product p JOIN FETCH p.category")
    List<Product> findAllWithCategory();
}