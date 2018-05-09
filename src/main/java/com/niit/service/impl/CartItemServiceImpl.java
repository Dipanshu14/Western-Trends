package com.niit.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.dao.CartItemDao;
import com.niit.model.Cart;
import com.niit.model.CartItem;
import com.niit.service.CartItemService;

@Service
public class CartItemServiceImpl implements CartItemService{
	@Autowired
    private CartItemDao cartItemDao;

	public void addCartItem(CartItem cartItem) {
		// TODO Auto-generated method stub
		cartItemDao.addCartItem(cartItem);
	}

	public void removeCartItem(CartItem cartItem) {
		// TODO Auto-generated method stub
		cartItemDao.removeCartItem(cartItem);
	}

	public void removeAllCartItems(Cart cart) {
		// TODO Auto-generated method stub
		cartItemDao.removeAllCartItems(cart);
	}

	public CartItem getCartItemByProductId(int id) {
		// TODO Auto-generated method stub
		  return cartItemDao.getCartItemByProductId(id);
	}

	public List<CartItem> getAllCartItem() {
		// TODO Auto-generated method stub
		return cartItemDao.getAllCartItem();
	}


}
