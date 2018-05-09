package com.niit.dao;

import java.util.List;

import com.niit.model.Cart;
import com.niit.model.CartItem;
import com.niit.model.Product;

public interface CartItemDao {

    void addCartItem(CartItem cartItem);

    void removeCartItem(CartItem cartItem);

    void removeAllCartItems(Cart cart);

    CartItem getCartItemByProductId(int id);
    public List<CartItem> getAllCartItem();
}
