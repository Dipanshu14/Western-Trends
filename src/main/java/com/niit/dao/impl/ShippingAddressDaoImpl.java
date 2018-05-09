/*package com.niit.dao.impl;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.dao.ShippingAddressDao;
import com.niit.model.ShippingAddress;
@Repository
@Transactional
public class ShippingAddressDaoImpl implements ShippingAddressDao{
	@Autowired
	SessionFactory sessionFactory;
	public boolean addShippingAddress(ShippingAddress ShippingAddress) {
		// TODO Auto-generated method stub
		Session session= sessionFactory.openSession();
		session.flush();
		session.close();
		return true;
	}

}
*/