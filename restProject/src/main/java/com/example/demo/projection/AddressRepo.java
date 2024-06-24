package com.example.demo.projection;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.models.Address;

public interface AddressRepo extends CrudRepository<Address, Integer>{

}
