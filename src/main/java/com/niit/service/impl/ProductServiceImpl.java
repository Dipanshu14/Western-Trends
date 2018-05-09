package com.niit.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.niit.dao.ProductDao;
import com.niit.model.Product;
import com.niit.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	ProductDao productDao;
	public List<Product> getAllProduct()
	{
		return productDao.getAllProduct();
	}
	public Product getProductById(int id) {
		// TODO Auto-generated method stub
		return productDao.getProductById(id);
	}
	
	public boolean editProduct(Product product) {
		// TODO Auto-generated method stub
		return productDao.editProduct(product);
	}
	public boolean deleteProduct(Product product) {
		// TODO Auto-generated method stub
		return productDao.deleteProduct(product);
	}
	public boolean addProduct(Product product) {
		// TODO Auto-generated method stub
		return productDao.addProduct(product);
	}
}
