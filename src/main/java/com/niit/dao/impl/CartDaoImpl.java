package com.niit.dao.impl;
import java.io.IOException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.SessionFactory.SessionFactoryOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.niit.dao.CartDao;
import com.niit.model.Cart;
import com.niit.service.CustomerOrderService;
@Repository
@Transactional
public class CartDaoImpl implements CartDao{
	 @Autowired
	    private SessionFactory sessionFactory;
	 @Autowired
	    private CustomerOrderService customerOrderService;
	public Cart getCartById(int cartId) {
		// TODO Auto-generated method stub
		 Session session = sessionFactory.openSession();
	        Cart c=(Cart) session.get(Cart.class, cartId);
	        System.out.println("Inside cartDAOIMPL "+c.getCartId());
	        session.close();
	        return c;
	}
	public Cart validate(int cartId) throws IOException {
		// TODO Auto-generated method stub
		Cart cart = getCartById(cartId);
        if(cart == null || cart.getCartItems().size() == 0){
            throw new IOException(cartId + "");
        }

        update(cart);
        return cart;
	}
		public void update(Cart cart) {
		// TODO Auto-generated method stub
		 int cartId = cart.getCartId();
	        double grandTotal = customerOrderService.getCustomerOrderGrandTotal(cartId);
	        cart.setGrandTotal(grandTotal);
	        Session session = sessionFactory.openSession();
	        session.saveOrUpdate(cart);
	        session.close();
}		
}