package com.example.demo.projection;

import java.util.List;

import com.example.demo.models.Address;
import com.example.demo.models.Blogs;

public interface UserProjection {
	public int getId();

	public String getName();

	public String getEmail();

	public String getCity();
	
	public Address getAddress();
	
	public List<Blogs> getBlogs();
	
	public String getTitle();
}
