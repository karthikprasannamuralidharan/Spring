package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String city;
	private String state;
	private Integer zipCode;
	
	@JsonIgnore
	@OneToOne(mappedBy = "address")
	private User user;
	
	public Address(Integer id, String city, String state, Integer zipCode) {
		super();
		this.id = id;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", city=" + city + ", state=" + state + ", zipCode=" + zipCode + "]";
	}

	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
