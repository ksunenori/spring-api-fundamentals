package com.ksunenori.store.repositories;

import com.ksunenori.store.entities.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, Long> {
}