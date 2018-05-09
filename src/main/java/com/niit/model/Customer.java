package com.niit.model;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
//import javax.validation.constraints.Pattern;
//import org.hibernate.validator.constraints.Length;
//import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Customer implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	 private int customerId;
	 //@NotEmpty(message="CustomerName field is mandatory.")
	 private String customerName;
	 //@NotEmpty(message="Email field is mandatory.")
	 private String customerEmail;
	 //@Length(max=10,min=10,message="Phone number is not valid. Should be of length 10.")
	 private String customerPhone;
	 //@NotEmpty(message="Username field is mandatory.")
	 private String username;
	 //@NotEmpty(message="Password should not be empty.")
	 private String password;
	 private boolean enabled;
	 @OneToOne
	 @JoinColumn(name = "cartId")
	 private Cart cart;
	 @OneToOne
	    @JoinColumn(name = "shippingAddressId")
	    private ShippingAddress shippingAddress;
	 @OneToOne
	    @JoinColumn(name = "billingAddressId")
	    private BillingAddress billingAddress;

	 public Customer() {	    
		// TODO Auto-generated constructor stub
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerEmail() {
		return customerEmail;
	}
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	public String getCustomerPhone() {
		return customerPhone;
	}
	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	public ShippingAddress getShippingAddress() {
		return shippingAddress;
	}
	public void setShippingAddress(ShippingAddress shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
	public BillingAddress getBillingAddress() {
		return billingAddress;
	}
	public void setBillingAddress(BillingAddress billingAddress) {
		this.billingAddress = billingAddress;
	}
}