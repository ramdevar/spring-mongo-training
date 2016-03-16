package com.rana.ecom.dao;

import java.util.List;

import com.rana.ecom.model.Post;
import com.rana.ecom.model.Product;

public interface IEcomDao {
	
	public List<Post> getPostsFromDB();
	
	public List<Product> getProductByCategory(String category, int skip, int limit) throws Exception;
	
	public Product getProductById(String id) throws Exception;

}
