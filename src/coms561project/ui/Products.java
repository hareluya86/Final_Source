package coms561project.ui;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import coms561project.data.Category;
import coms561project.data.Product;
import coms561project.utilities.Utilities;

/**
 * 
 * @author Tim
 *
 */
public class Products extends ActionSupport {
	
	private static final long serialVersionUID = 1L;
	private ArrayList<Category> breadcrumb = new ArrayList<Category>();
	private int categoryId;
	private String categoryName;
	private ArrayList<Category> subcategories;
	private ArrayList<Product> products;
		
	/**
	 * @return the result
	 */
	public String execute() throws Exception {
		
		
		if (categoryId == 0)  //Display new products
		{
			subcategories = (ArrayList<Category>)Utilities.getTopCategories();
			products = (ArrayList<Product>)Utilities.getNewProducts();
			
			ActionContext.getContext().getSession().remove("breadcrumb");
			this.breadcrumb = null;			
		}
		else				//Display the category
		{
			
			Category category = Utilities.getCategoryById( categoryId );
			categoryName = category.getName();
			subcategories = (ArrayList<Category>)category.getSubcategories();
			//products = (ArrayList<Product>)category.getProducts();
			//Test Data
			products = (ArrayList<Product>)Utilities.getNewProducts();
			
			//Get the breadcrumb and check if we're going up or down the tree
			boolean goingUp = false;
			ArrayList<Category> breadcrumb = (ArrayList<Category>)ActionContext.getContext().getSession().get("breadcrumb");
			if (breadcrumb == null)
			{
				breadcrumb = new ArrayList<Category>();
				breadcrumb.add(category);
			}				
				
			for (int i=0; i<breadcrumb.size(); i++)
			{
				if (breadcrumb.get(i).getId() == category.getId())
				{
					goingUp = true;
					breadcrumb = new ArrayList<Category>( breadcrumb.subList(0, i+1) );
					ActionContext.getContext().getSession().put("breadcrumb", breadcrumb);
					this.breadcrumb = breadcrumb;
					break;
				}
			}
			
			//Append the new category on the end of the breadcrumb
			if (!goingUp)
			{
				//Make sure you're not navigating between top categories
				boolean matchedRootCategory = false;
				boolean matchedNewCategory = false;
				
				if (breadcrumb.size() > 0)
				{
					for (Category c : Utilities.getTopCategories())
					{
						if (c.getId() == breadcrumb.get(0).getId())
							matchedRootCategory = true;
						
						if (c.getId() == category.getId())
							matchedNewCategory = true;
					}
				}
				
				if (matchedRootCategory == true && matchedNewCategory == true)
				{
					breadcrumb.clear();
					breadcrumb.add(category);
				}
				else
				{
					breadcrumb.add(category);
				}
				
				ActionContext.getContext().getSession().put("breadcrumb", breadcrumb);
				this.breadcrumb = breadcrumb;
			}
		}
		
		return SUCCESS;
	}

	/**
	 * @return the category
	 */
	public int getCategoryId() {
		return categoryId;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	/**
	 * @return the breadcrumb
	 */
	public ArrayList<Category> getBreadcrumb() {
		return breadcrumb;
	}

	/**
	 * @param breadcrumb the breadcrumb to set
	 */
	public void setBreadcrumb(ArrayList<Category> breadcrumb) {
		this.breadcrumb = breadcrumb;
	}

	/**
	 * @return the subcategories
	 */
	public ArrayList<Category> getSubcategories() {
		return subcategories;
	}

	/**
	 * @return the products
	 */
	public ArrayList<Product> getProducts() {
		return products;
	}

	/**
	 * @return the categoryName
	 */
	public String getCategoryName() {
		return categoryName;
	}

}
