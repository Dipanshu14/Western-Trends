package com.niit.dao.impl;

import java.util.ArrayList;
import java.util.List;

//import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
//import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.dao.ProductDao;
import com.niit.model.Product;

@Repository
@Transactional
public class ProductDaoImpl implements ProductDao{
    	@Autowired
		SessionFactory sessionFactory;
		
    	public List<Product> getAllProduct() {
		// TODO Auto-generated method stub
		List<Product> allProduct= new ArrayList<Product>();
		Query q= sessionFactory.openSession().createQuery("From Product");
		allProduct=q.list();
		return allProduct;
	}

	public Product getProductById(int id) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Product product=(Product) session.get(Product.class, id);
		session.close();
		return product;
	}

	public boolean addProduct(Product product) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		session.saveOrUpdate(product);
		session.flush();
		session.close();
		return true;
	}

	public boolean editProduct(Product product) {
		// TODO Auto-generated method stub
		boolean flag; 
		//System.out.println("Product Name daoimpl = "+product.getName()+""+product.getId());
		try {
			//sessionFactory.openSession().saveOrUpdate(product);
			Session session=sessionFactory.openSession();
			session.saveOrUpdate(product);
			session.flush();
			session.close();
		
		flag =true;
		}
		catch(Exception e)
		{
			flag=false;
		}
		return flag;
		}

	 public boolean deleteProduct(Product product) {
		// TODO Auto-generated method stub
		 //System.out.println("Product Name = "+product.getName());
		 try {
			 Session session=sessionFactory.openSession();
			 //System.out.println("Product Name = "+product.getName());
			//session.delete(product);
			Query q=session.createQuery("delete from Product where id=?");
			q.setInteger(0, product.getId());
			q.executeUpdate();
			session.close();
			return true;
		 }
		 catch(Exception ex)
		 {
			 ex.printStackTrace();
			 return false;
		 }
		
	}
}
