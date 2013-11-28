package coms561project.ui.webcontrols;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;

import coms561project.data.Product;
import coms561project.utilities.Utilities;
import java.util.List;

public class BestSellers extends ActionSupport {
	
	private static final long serialVersionUID = 1L;
	
	private ArrayList<Product> products;
		
	public String execute() throws Exception {
		
		products = (ArrayList<Product>)Utilities.getBestSellers();
            //List<Product> temp = Utilities.getBestSellers();
            //products = new ArrayList<Product>(temp);
		
		return SUCCESS;
	}

	/**
	 * @return the products
	 */
	public ArrayList<Product> getProducts() {
		return products;
	}

}
