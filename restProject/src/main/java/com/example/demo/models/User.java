package com.example.demo.models;

import java.util.List;

import com.example.demo.projection.UserProjection;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Size(min = 2, max = 10)
	private String name;
	@NotNull(message = "Email Cannot be NULL")
	@NotEmpty
	@Email
	private String email;
	private String password;
	private String city;
	
	@JsonIgnore
	@OneToOne
	@JoinColumn(name = "address_id")
	private Address address;
	
	@JsonIgnore
	@OneToMany(mappedBy = "user")
	private List<Blogs> blogs;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", city=" + city
				+ "]";
	}


	public User(int id, String name, String email, String password, String city) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.city = city;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

}
