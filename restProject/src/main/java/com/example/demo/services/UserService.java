package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.models.Address;
import com.example.demo.models.Blogs;
import com.example.demo.models.User;
import com.example.demo.projection.AddressRepo;
import com.example.demo.projection.UserProjection;
import com.example.demo.repository.BlogRepo;
import com.example.demo.repository.UserRepo;

@Service
public class UserService {

	/*
	 * HashMap<Integer, User> data = new HashMap<>(); AtomicInteger atoInteger = new
	 * AtomicInteger();
	 */

	@Autowired
	UserRepo userRepo;
	
	@Autowired
	AddressRepo addressRepo;
	
	@Autowired
	BlogRepo blogRepo;

	public User create(User user) {

		return this.userRepo.save(user);
	}

	/*
	 * public Iterable<User> getAll() { return this.userRepo.findAll(); }
	 */

	public Iterable<UserProjection> getAll() {
		return this.userRepo.findAllUserBy();
	}

	/*
	 * public User getUserById(int id) { return
	 * this.userRepo.findById(id).orElseThrow(() -> { throw new
	 * ResponseStatusException(HttpStatus.NOT_FOUND,
	 * "User with specified Id Not Found"); }); }
	 */
	
	public User getUserByIdwithPassword(int id) {
		return this.userRepo.findById(id).orElseThrow(() -> {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User with specified Id Not Found");
		});
	}

	public UserProjection getUserById(int id) {
		return this.userRepo.findAllById(id).orElseThrow(() -> {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User with specified Id Not Found");
		});
	}

	public List<UserProjection> getUserByName(String name) {
		return this.userRepo.findByName(name);
	}
	
	public List<UserProjection> getUserByNameLike(String name) {
		return this.userRepo.findByNameContainingIgnoreCase(name);
	}
	
	

	public User deleteUser(int id) {
		User user = this.userRepo.findById(id).orElseThrow(() -> {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User with specified Id Not Found");
		});
		this.userRepo.deleteById(id);
		return user;
	}

	public User editUser(int id, User user) {
		this.userRepo.findById(id).orElseThrow(() -> {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User with specified Id Not Found");
		});
		user.setId(id);
		return this.userRepo.save(user);

	}
	
	public Address addAddress(Integer user_id, Address address) {
		User foundUser = this.getUserByIdwithPassword(user_id);
		Address saveAddress = this.addressRepo.save(address);
		foundUser.setAddress(saveAddress);
		this.userRepo.save(foundUser);
		return saveAddress;
	}
	
	public Address getAddressById(Integer user_id) {
		User user = this.getUserByIdwithPassword(user_id);
		return user.getAddress();
	}
	
	public Blogs addBlogs(Integer user_id, Blogs blogs) {
		User foundUser = this.getUserByIdwithPassword(user_id);
		blogs.setUser(foundUser);
		return this.blogRepo.save(blogs);
	}
	
	public List<Blogs> getBlogs(Integer user_id){
		User user = this.getUserByIdwithPassword(user_id);
		return user.getBlogs();
	}

}
