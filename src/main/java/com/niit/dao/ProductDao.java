package com.niit.dao;

import java.util.List;

import com.niit.model.Product;

public interface ProductDao {
public List<Product> getAllProduct();
Product getProductById(int id);
boolean addProduct(Product product);
boolean editProduct(Product product);
boolean deleteProduct(Product product);
}

