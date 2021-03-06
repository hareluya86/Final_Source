package coms561project.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class ShoppingCartItem {

	@Id @GeneratedValue
	private long id;
	private int quantity;
	@OneToOne
	@JoinColumn(name = "FK_ProductId")
	private Product product;

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public ShoppingCartItem()
	{
	}
	
	public ShoppingCartItem(Product p , int quantity) {
	//	this.id = id;
		this.product = p;
		this.quantity = quantity;
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
	
	public float getTotalCost() {
		float totalcost = quantity * product.getListPrice();
		return totalcost;
	}
	
	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}
	
	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}
