package coms561project.ui;

import java.util.ArrayList;
import com.opensymphony.xwork2.ActionSupport;
import coms561project.data.ShoppingCart;
import coms561project.utilities.Utilities;

public class ShoppingCarts extends ActionSupport {
	
	private ShoppingCart myCart;
	
	public ShoppingCart getShoppingCart() {
		return myCart;
	}
	
}