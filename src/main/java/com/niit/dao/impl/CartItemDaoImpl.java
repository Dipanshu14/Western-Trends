package com.niit.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.dao.CartItemDao;
import com.niit.model.Cart;
import com.niit.model.CartItem;
import com.niit.model.Product;

@Repository
@Transactional
public class CartItemDaoImpl implements CartItemDao{

    @Autowired
    private SessionFactory sessionFactory;

    public void addCartItem(CartItem cartItem){
        Session session = sessionFactory.openSession();
        session.saveOrUpdate(cartItem);
        session.close();
   
    }

    public void removeCartItem(CartItem cartItem){
    	try {
        Session session = sessionFactory.openSession();
        //session.delete(cartItem);
        //System.out.println("cart Item ID = "+cartItem.getCartItemId());
        Query q=session.createQuery("delete from CartItem where id=?");
		q.setInteger(0, cartItem.getCartItemId());
		q.executeUpdate();
        session.close();
        session.flush();
		 }
		 catch(Exception ex)
		 {
			 ex.printStackTrace();
		 }
		

    }

    public void removeAllCartItems(Cart cart){
        List<CartItem> cartItems = cart.getCartItems();
        System.out.println("Cart Item = "+cartItems.get(0));
        for (CartItem item : cartItems){
            removeCartItem(item);
        }
    }

    public CartItem getCartItemByProductId(int id){
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from CartItem where id = ?");
        query.setInteger(0, id);
        //session.flush();
        return (CartItem) query.uniqueResult();
    }

	public List<CartItem> getAllCartItem() {
		// TODO Auto-generated method stub
		List<CartItem> cartitem= new ArrayList<CartItem>();
		Query q= sessionFactory.openSession().createQuery("From CartItem");
		cartitem=q.list();
		return cartitem;
	
	}

}
