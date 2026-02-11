package com.ksunenori.store.orders;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    OrderDto toDto(Order order);

    //Explicit mapping of status as a String (default enum)
    default String map(PaymentStatus status) {
        return status == null ? null : status.name();
    }
}
