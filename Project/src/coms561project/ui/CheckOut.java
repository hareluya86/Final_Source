package coms561project.ui;


import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import coms561project.data.Category;
import coms561project.data.Customer;
import coms561project.data.ShoppingCart;
import coms561project.data.ShoppingCartItem;

public class CheckOut extends ActionSupport {
	
	private static final long serialVersionUID = 1L;
	private Customer customer;
	private ShoppingCart cart;
	private double carttotal;
		
	public String execute() throws Exception {

		customer = (Customer)ActionContext.getContext().getSession().get("customer");
		cart = (ShoppingCart)ActionContext.getContext().getSession().get("my_cart");
		if (customer == null)
			return "loginrequired";		
		else if (cart == null)
			return "cartitemsrequired";		
		
		carttotal = 0;
		for (ShoppingCartItem item: cart.getCartItems())
		{
			carttotal = carttotal + (double)item.getTotalCost();
		}
		
		return SUCCESS;
	}

	/**
	 * @return the customer
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * @return the cart
	 */
	public ShoppingCart getCart() {
		return cart;
	}

	/**
	 * @return the carttotal
	 */
	public double getCarttotal() {
		return carttotal;
	}


}
