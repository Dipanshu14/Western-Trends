package com.niit.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
//import java.security.Principal;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import com.niit.model.Cart;
import com.niit.model.CartItem;
import com.niit.model.Customer;
//import com.niit.model.CustomerOrder;
import com.niit.model.Product;
import com.niit.service.CartItemService;
import com.niit.service.CartService;
//import com.niit.service.CustomerOrderService;
import com.niit.service.CustomerService;
import com.niit.service.ProductService;
//import com.niit.service.ShippingAddressService;

@Controller
public class ProductController {
	@Autowired
	private CustomerService customerService;
	@Autowired
	private CartService cartService;
	@Autowired
	private CartItemService cartItemService;
	@Autowired
	ProductService productService;
	/*
	 * @Autowired private CustomerOrderService customerOrderService;
	 */
	/*
	 * @Autowired private ShippingAddressService shippingAddressService;
	 */
	private Path path;

	@RequestMapping("/viewProduct/{id}")
	public String viewProduct(@PathVariable int id, Model model) throws IOException {
		Product product = productService.getProductById(id);
		model.addAttribute("product", product);
		return "viewProduct";
	}

	@RequestMapping("/products/allproducts")
	public ModelAndView getAllProduct() {
		List<Product> allProducts = productService.getAllProduct();
		return new ModelAndView("allproducts", "products", allProducts);
	}
	@RequestMapping("/cartSummary")
	public String CartSum(Model model){
		//Cart cart = cartService.getCartById(cartId);
		List<CartItem> cartItems = cartItemService.getAllCartItem();
		model.addAttribute("products", cartItems);
		return "cartSummary";
	}

	@RequestMapping("/cart/{cartId}")
	public Cart getCartById(@PathVariable(value = "cartId") int cartId) {
		return cartService.getCartById(cartId);
	}

	@RequestMapping("/cart/addtocart/{id}")
	public String addtocart(@PathVariable("id") int id, @AuthenticationPrincipal User activeUser, Model model) {
		Product product = productService.getProductById(id);
		Customer customer = customerService.getCustomerByUsername(activeUser.getUsername());
		Cart cart = customer.getCart();
		List<CartItem> cartItems = cart.getCartItems();
		for (int i = 0; i < cartItems.size(); i++) {
			if (product.getId() == cartItems.get(i).getProducts().getId()) {
				CartItem cartItem = cartItems.get(i);
				cartItem.setQuantity(cartItem.getQuantity() + 1);
				cartItem.setTotalPrice(product.getProductPrice() * cartItem.getQuantity());
				cartItemService.addCartItem(cartItem);
			}
		}
		CartItem cartItem = new CartItem();
		cartItem.setProducts(product);
		cartItem.setQuantity(1);
		cartItem.setTotalPrice(product.getProductPrice() * cartItem.getQuantity());
		cartItem.setCart(cart);
		cartItemService.addCartItem(cartItem);
		return "redirect:/customer/cart";
	}

	@RequestMapping("/customer/cart")
	public String getCart(@AuthenticationPrincipal User activeUser) {
		Customer customer = customerService.getCustomerByUsername(activeUser.getUsername());
		int cartId = customer.getCart().getCartId();
		return "redirect:/customer/cart/" + cartId;
	}

	@RequestMapping("/customer/cart/{cartId}")
	public String getCartRedirect(@PathVariable(value = "cartId") int cartId, Model model) {
		Cart cart = cartService.getCartById(cartId);
		model.addAttribute("cart", cart);
		return "cart";
	}

	@RequestMapping("/customer/cart/remove/{id}")
	public String removeItem(@PathVariable(value = "id") int id) {
		CartItem cartItem = cartItemService.getCartItemByProductId(id);
		cartItemService.removeCartItem(cartItem);
		return "cart";

	}

	@RequestMapping("/customer/cart/removeAll/{cartId}")
	public String clearCart(@PathVariable(value = "cartId") int cartId) {
		System.out.println("inside clear cart controller");
		Cart cart = cartService.getCartById(cartId);
		System.out.println("inside clear cart controller after getting cart " + cart.getCartId());
		cartItemService.removeAllCartItems(cart);
		return "cart";
	}

	/*
	 * @RequestMapping("/customer/cart/shippingaddress") public String
	 * ShippingAddress(Model model){ com.niit.model.ShippingAddress shippingAddress=
	 * new com.niit.model.ShippingAddress();
	 * model.addAttribute("shippingaddress",shippingAddress); return
	 * "shippingAddress"; }
	 */

	/*
	 * @RequestMapping(value="/customer/cart/shippingaddress",method=RequestMethod.
	 * POST) public String ShippingAddressData(@ModelAttribute("shippingaddress")
	 * com.niit.model.ShippingAddress shippingAddress) {
	 * 
	 * // ShippingAddressService.addShippingAddress(shippingAddress);
	 * shippingAddressService.addShippingAddress(shippingAddress); return
	 * "shippingAddress"; }
	 */

	@RequestMapping("/admin")
	public String adminPage() {
		return "admin";
	}

	@RequestMapping("/admin/customer")
	public String customerManagement(Model model) {
		List<Customer> customerList = customerService.getAllCustomers();
		model.addAttribute("customerList", customerList);

		return "customerManagement";
	}

	@RequestMapping("/admin/productInventory")
	public String productInventory(Model model) {
		List<Product> product = productService.getAllProduct();
		model.addAttribute("products", product);

		return "productInventory";

	}

	@RequestMapping("/admin/products/addProduct")
	public String addProduct(Model model) {
		Product product = new Product();
		model.addAttribute("products", product);
		return "addProduct";
	}

	@RequestMapping(value = "/admin/products/addProduct/submit", method = RequestMethod.POST)
	public String addProductData(@ModelAttribute("products") Product product, BindingResult result,
			HttpServletRequest request) {
		if (result.hasErrors()) {
			return "addProduct";

		}
		// System.out.println("Product Name = "+product.getName());
		productService.addProduct(product);
		MultipartFile image = product.getImage();
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		path = Paths.get(rootDirectory + "/WEB-INF/resources/images/" + product.getId() + ".jpg");

		if (image != null && !image.isEmpty()) {
			try {
				image.transferTo(new File(path.toString()));
			} catch (Exception ex) {
				ex.printStackTrace();
				throw new RuntimeException("Product image saving failed", ex);
			}
		}

		return "redirect:/admin/productInventory";
	}

	@RequestMapping("/admin/products/editProduct/{id}")
	public String editProduct(@PathVariable("id") int id, Model model) {
		Product product = productService.getProductById(id);
		model.addAttribute("products", product);
		return "editProduct";
	}

	@RequestMapping(value = "/admin/products/editProduct", method = RequestMethod.POST)
	public String editProductPost(@ModelAttribute("products") Product product, BindingResult result,
			HttpServletRequest request) {
		if (result.hasErrors()) {
			return "editProduct";
		}

		// System.out.println("Product Name controller "+product.getName());
		boolean flag = productService.editProduct(product);
		MultipartFile image = product.getImage();
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		path = Paths.get(rootDirectory + "/WEB-INF/resources/images/" + product.getId() + ".jpg");

		if (image != null && !image.isEmpty()) {
			try {
				image.transferTo(new File(path.toString()));
			} catch (Exception ex) {
				ex.printStackTrace();
				throw new RuntimeException("Product image saving failed", ex);
			}
		}

		if (flag == true)
			return "redirect:/admin/productInventory";
		else
			return "index";
	}

	@RequestMapping("/admin/products/deleteProduct/{id}")
	public String deleteProduct(@PathVariable int id, Model model, HttpServletRequest request) {
		try {
			Product product = productService.getProductById(id);
			boolean flag = productService.deleteProduct(product);
			if (flag)
				return "redirect:/admin/productInventory";
			else
				return "redirect:/admin/productInventory";
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
}