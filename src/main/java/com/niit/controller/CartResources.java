package com.niit.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.niit.model.Cart;
import com.niit.model.CartItem;
//import com.niit.model.User;
import com.niit.service.CartItemService;
import com.niit.service.CartService;
import com.niit.service.CustomerService;
import com.niit.service.ProductService;

//@Controller
public class CartResources {
	@Autowired
    private CartService cartService;

    @Autowired
    private CartItemService cartItemService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ProductService productService;
    
	
    	
    	/*@RequestMapping("/cart/addtocart/{id}")
    	public String addtocart(@PathVariable("id") int id, @AuthenticationPrincipal User activeUser, Model model)
    	{
    		Product product = productService.getProductById(id);
    		Customer customer = customerService.getCustomerByUsername(activeUser.getUsername());
   		 Cart cart = customer.getCart();      	
   		List<CartItem> cartItems = cart.getCartItems();
   		 for (int i=0; i < cartItems.size(); i++)
   		 {		
   	            if(product.getId() == cartItems.get(i).getProducts().getId())
   	            {
   	                CartItem cartItem = cartItems.get(i);
   	                cartItem.setQuantity(cartItem.getQuantity() + 1);
   	                cartItem.setTotalPrice(product.getProductPrice()*cartItem.getQuantity());
   	                cartItemService.addCartItem(cartItem);
   	            }
   	            }
   	            CartItem cartItem = new CartItem();
   	            cartItem.setProducts(product);
   	            cartItem.setQuantity(1);
   	            cartItem.setTotalPrice(product.getProductPrice()*cartItem.getQuantity());
   	            cartItem.setCart(cart);
   	            cartItemService.addCartItem(cartItem);
					return "allproducts";
    	}*/
    	
    	
    	/*@RequestMapping("/cart/viewProduct/{id}/cart/Add to cart",method=RequestMethod.POST)
    	public String addItem (@ModelAttribute("products") Product product, Principal authentication)
    	{
    	//System.out.println("Inside Cart Resources line 0 "+authentication.getName()+ "  "+id);
        Customer customer = customerService.getCustomerByUsername(authentication.getName());
        System.out.println("Inside Cart Resources line 1");
        Cart cart = customer.getCart();        
        //System.out.println("Inside Cart Resources line 3");
        List<CartItem> cartItems = cart.getCartItems();
        System.out.println("Inside Cart Resources line 4");
        for (int i=0; i < cartItems.size(); i++){
        	System.out.println("Inside Cart Resources line 5");
            if(product.getId() == cartItems.get(i).getProducts().getId()){
                CartItem cartItem = cartItems.get(i);
                cartItem.setQuantity(cartItem.getQuantity() + 1);
                cartItem.setTotalPrice(product.getProductPrice()*cartItem.getQuantity());
                cartItemService.addCartItem(cartItem);
            }
        }

        CartItem cartItem = new CartItem();
        cartItem.setProducts(product);
        cartItem.setQuantity(1);
        cartItem.setTotalPrice(product.getProductPrice()*cartItem.getQuantity());
        cartItem.setCart(cart);
        cartItemService.addCartItem(cartItem);
        
        return "" ;
    	}
*/
    

   

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Illegal request, please verify your payload")
    public void handleClientErrors (Exception ex){

    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Internal Server Error")
    public void handleServerErrors (Exception ex){

}
}
