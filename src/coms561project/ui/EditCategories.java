package coms561project.ui;

import java.util.Date;
import java.util.Map;
import java.util.Properties;

import java.util.Collection;
import java.util.ArrayList;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import coms561project.data.Category;
import coms561project.data.Product;
import coms561project.data.ProductDetail;
import coms561project.data.ProductImage;
import coms561project.data.ProductRating;
import coms561project.data.ShoppingCart;
import coms561project.data.ShoppingCartItem;
import coms561project.utilities.Utilities;

public class EditCategories extends ActionSupport {
	
	private static final long serialVersionUID = 1L;
	private ArrayList<Category> categories;
		
	public String execute() throws Exception {
		
		//categories = (ArrayList<Category>)Utilities.getTopCategories();
		categories = getCategories();
		
		return SUCCESS;
	}

	/**
	 * @return the categories
	 */
	public ArrayList<Category> getCategories() {
		return categories;
	}	
	
}