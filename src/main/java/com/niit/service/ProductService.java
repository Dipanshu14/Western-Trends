package com.niit.service;

import java.util.List;

import com.niit.model.Product;

public interface ProductService {
	public List<Product> getAllProduct();
	Product getProductById(int id);
	boolean addProduct(Product product);
	boolean editProduct(Product product);
	boolean deleteProduct(Product product);

}
