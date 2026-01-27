package com.ksunenori.store.controllers;

import com.ksunenori.store.dtos.AddItemToCartRequest;
import com.ksunenori.store.dtos.CartDto;
import com.ksunenori.store.dtos.CartItemDto;
import com.ksunenori.store.entities.Cart;
import com.ksunenori.store.entities.CartItem;
import com.ksunenori.store.mappers.CartMapper;
import com.ksunenori.store.repositories.CartRepository;
import com.ksunenori.store.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping("/carts")

public class CartController {
    private final CartRepository cartRepository;
    private final CartMapper cartMapper;
    private final ProductRepository productRepository;


    @PostMapping
    public ResponseEntity<CartDto> createCart(
            UriComponentsBuilder uriBuilder
    ) {
        var cart = new Cart();
        cartRepository.save(cart);

        var cartDto = cartMapper.toDto(cart);
        var uri =  uriBuilder.path("/carts/{id}").buildAndExpand(cartDto.getId()).toUri();

        return ResponseEntity.created(uri).body(cartDto);
    }

    @PostMapping("/{cartId}/items")
    public ResponseEntity<CartItemDto> addToCart(
            @PathVariable UUID cartId,
            @RequestBody AddItemToCartRequest request) {
        var cart = cartRepository.findById(cartId).orElse(null);
        if (cart == null) {
            return ResponseEntity.notFound().build();
        }

        var product = productRepository.findById(request.getProductId()).orElse(null);
        if (product == null) {
            return ResponseEntity.badRequest().build(); //dont return not found error bc productId comes from requestBody not url
        }

        var cartItem = cart.getCartItems().stream()
                .filter(items -> items.getProduct().getId().equals(product.getId()))
                .findFirst()
                .orElse(null);

        if (cartItem != null) {
            cartItem.setQuantity(cartItem.getQuantity() + 1);
        } else {
            cartItem = new CartItem();
            cartItem.setProduct(product);
            cartItem.setQuantity(1);
            cartItem.setCart(cart);
            cart.getCartItems().add(cartItem);
        }
        cartRepository.save(cart);

        var cartItemDto = cartMapper.toDto(cartItem);
        return ResponseEntity.status(HttpStatus.CREATED).body(cartItemDto);
    }

}
