package My_Hibernate;

import java.util.Collection;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
public class ShoppingCart {

	@Id @GeneratedValue
	private long id;
	
	@OneToMany
	@Cascade(CascadeType.ALL)
	@JoinTable(name = "ShoppingCart_ShoppingCartItem", joinColumns=@JoinColumn(name = "ShoppingCartId"), inverseJoinColumns= @JoinColumn(name = "ShoppingCartItemId") )
	private Collection<ShoppingCart> cartItems;
	
	@OneToOne
	@Cascade(CascadeType.ALL)
	@JoinColumn(name = "FK_CustomerId")
	private Customer customer;
	
	public ShoppingCart()
	{
	}
	
	public Collection<ShoppingCart> getCartItems() {
		return cartItems;
	}

	public void setCartItems(Collection<ShoppingCart> cartItems) {
		this.cartItems = cartItems;
	}

	
	
	public ShoppingCart( Collection<ShoppingCart> cartItems, Customer customer) {
		//this.id = id;
		this.cartItems = cartItems;
		this.customer = customer;
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	
	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}
	

	/**
	 * @return the customer
	 */
	public Customer getCustomer() {
		return customer;
	}
	
	/**
	 * @param customer the customer to set
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
}
