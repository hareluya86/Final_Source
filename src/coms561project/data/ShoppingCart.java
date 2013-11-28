package coms561project.data;

import java.util.Collection;
import java.util.Set;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class ShoppingCart {

	@Id @GeneratedValue
	private long id;
	
	
	@OneToMany
	@JoinTable(name = "ShoppingCart_ShoppingCartItem", joinColumns=@JoinColumn(name = "ShoppingCartId"), inverseJoinColumns= @JoinColumn(name = "ShoppingCartItemId") )
	private Collection<ShoppingCartItem> cartItems;
	
	@OneToOne
	@JoinColumn(name = "FK_CustomerId")
	private Customer customer;
	
	public ShoppingCart()
	{
	}
	
	public Collection<ShoppingCartItem> getCartItems() {
		return cartItems;
	}

	public void setCartItems(Collection<ShoppingCartItem> cartItems) {
		this.cartItems = cartItems;
	}

	public int getItemCount()
	{
		ArrayList<ShoppingCartItem> theitems = (ArrayList<ShoppingCartItem>)cartItems;
		int itemcount = 0;
		for(int i = 0; i < cartItems.size();i++)
		{
			itemcount += theitems.get(i).getQuantity();
		}
		return itemcount;
	}
	/*
	public ArrayList<Float> runningTotalCost()
	{
		ArrayList<ShoppingCartItem> theitems = (ArrayList<ShoppingCartItem>)cartItems;
		ArrayList<Float> totals = new ArrayList<Float>();
		for(int i = 0; i < cartItems.size();i++)
		{
			if (i == 0)
			{
				totals.set(i, theitems.get(i).getProduct().getListPrice() * theitems.get(i).getQuantity());
			} else {
				totals.set(i , totals.get(i-1) + theitems.get(i).getProduct().getListPrice() * theitems.get(i).getQuantity());
			}
		}
		return totals;
	}
	*/
	
	public float totalPrice()
	{
		ArrayList<ShoppingCartItem> theitems = (ArrayList<ShoppingCartItem>)cartItems;
		float totalprice = 0;
		for(int i = 0; i < cartItems.size();i++)
		{
			totalprice += theitems.get(i).getProduct().getListPrice() * theitems.get(i).getQuantity();
		}
		return totalprice;
	}
	
	public ShoppingCart( Collection<ShoppingCartItem> cartItems, Customer customer) {
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
