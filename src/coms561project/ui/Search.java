package coms561project.ui;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;
import coms561project.data.Product;
import coms561project.utilities.Utilities;


public class Search extends ActionSupport {

    private static final long serialVersionUID = 1L;
    private String searchText;
    private ArrayList<Product> searchResults;

   
    public String execute() throws Exception {
        Utilities util = new Utilities();
        searchResults = new ArrayList<Product>(util.searchByName(searchText, 10, 1));

        return SUCCESS;
    }

 
    public String getSearchText() {
        return searchText;
    }


    public void setSearchText(String searchText) {
        this.searchText = searchText;
    }

    public ArrayList<Product> getSearchResults() {
        return searchResults;
    }
}
