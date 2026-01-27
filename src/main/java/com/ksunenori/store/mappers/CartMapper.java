package com.ksunenori.store.mappers;

import com.ksunenori.store.dtos.CartDto;
import com.ksunenori.store.dtos.CartItemDto;
import com.ksunenori.store.entities.Cart;
import com.ksunenori.store.entities.CartItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CartMapper {
    @Mapping(target = "totalPrice", expression = "java(cart.getTotalPrice())")
    CartDto toDto(Cart cart);

    @Mapping(target = "totalPrice", expression = "java(cartItem.getTotalPrice())")
    CartItemDto toDto(CartItem cartItem);
}
