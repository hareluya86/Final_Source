package coms561project.ui;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;
import coms561project.data.Product;
import coms561project.utilities.Utilities;


public class Index extends ActionSupport {
	
	private static final long serialVersionUID = 1L;
	private ArrayList<Product> newproducts;


	public String execute() {
		Utilities util = new Utilities();
		newproducts = new ArrayList<Product>(util.getNewProducts());
		
		return SUCCESS;
	}


	public ArrayList<Product> getNewproducts() {
		return newproducts;
	}	
}
