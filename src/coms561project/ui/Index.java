package coms561project.ui;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;
import coms561project.data.Product;
import coms561project.utilities.Utilities;

/**
 * 
 * @author Tim
 *
 */
public class Index extends ActionSupport {
	
	private static final long serialVersionUID = 1L;
	private ArrayList<Product> newproducts;

	/**
	 * @return the result
	 */
	public String execute() {
		
		newproducts = (ArrayList<Product>)Utilities.getNewProducts();
		
		return SUCCESS;
	}

	/**
	 * @return the newproducts
	 */
	public ArrayList<Product> getNewproducts() {
		return newproducts;
	}	
}
