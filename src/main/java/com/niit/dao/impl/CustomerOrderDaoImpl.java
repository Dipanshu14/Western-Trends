package com.niit.dao.impl;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.niit.dao.CustomerOrderDao;
import com.niit.model.CustomerOrder;
@Transactional
@Repository
public class CustomerOrderDaoImpl implements CustomerOrderDao{
	 @Autowired
	    private SessionFactory sessionFactory;

	 		public void addCustomerOrder(CustomerOrder customerOrder) {
	 		// TODO Auto-generated method stub
		 	Session session = sessionFactory.openSession();
	        session.saveOrUpdate(customerOrder);
	        //session.flush();
	}

}
