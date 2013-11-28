package coms561project.ui.webcontrols;

import java.util.ArrayList;
import com.opensymphony.xwork2.ActionSupport;
import coms561project.data.Category;
import coms561project.utilities.Utilities;

public class Categories extends ActionSupport {
	
	private static final long serialVersionUID = 1L;
	private ArrayList<Category> categories;
		
	public String execute() throws Exception {
		
		categories = (ArrayList<Category>)Utilities.getTopCategories();
		
		return SUCCESS;
	}

	/**
	 * @return the top categories
	 */
	public ArrayList<Category> getCategories() {
		return categories;
	}	
}
