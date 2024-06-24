package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.User;
import com.example.demo.projection.UserProjection;

@Repository
public interface UserRepo extends CrudRepository<User, Integer> {
	Iterable<UserProjection> findAllUserBy();

	Optional<UserProjection> findAllById(Integer Id);

	List<UserProjection> findByName(String name);

	List<UserProjection> findByNameContainingIgnoreCase(String name); 
}
