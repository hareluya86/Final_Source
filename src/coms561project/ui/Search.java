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
public class Search extends ActionSupport {
	
	private static final long serialVersionUID = 1L;
	
	private String searchText;
	private ArrayList<Product> searchResults;
		
	/**
	 * @return the result
	 */
	public String execute() throws Exception {
		
		searchResults = (ArrayList<Product>)Utilities.searchByName(searchText, 10, 0);
		
		return SUCCESS;
	}

	/**
	 * @return the searchText
	 */
	public String getSearchText() {
		return searchText;
	}

	/**
	 * @param searchText the searchText to set
	 */
	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}

	/**
	 * @return the searchResults
	 */
	public ArrayList<Product> getSearchResults() {
		return searchResults;
	}

	
}
