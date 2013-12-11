package coms561project.ui;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import coms561project.data.Category;
import coms561project.data.Product;
import coms561project.utilities.Utilities;
import java.util.List;


public class Products extends ActionSupport {
	
	private static final long serialVersionUID = 1L;
	private ArrayList<Category> maanmaan = new ArrayList<Category>();
	private long categoryId;
	private String categoryName;
	private ArrayList<Category> subcategories;
	private ArrayList<Product> products;
		
	
	public String execute() throws Exception {
		
		
		if (categoryId == 0)  
		{
                    Utilities util = new Utilities();
                    subcategories = new ArrayList<Category>(util.getTopCategories());
			products = new ArrayList<Product>(util.getNewProducts());
			
			ActionContext.getContext().getSession().remove("maanmaan");
			this.maanmaan = null;			
		}
		else				//Display the category
		{
			Utilities util = new Utilities();
			Category category = util.getCategoryById( categoryId );
                        if(category == null){
                            return NONE;
                        }
			categoryName = category.getName();
			subcategories = new ArrayList<Category>(category.getSubcategories());
		
			products = new ArrayList<Product>(category.getProducts());
			
			
			boolean goingUp = false;
                        List<Category> maanmaanlist = (List)ActionContext.getContext().getSession().get("maanmaan");
			
			if (maanmaanlist == null){
				maanmaan = new ArrayList<Category>();
				maanmaan.add(category);
			}else{
                            ArrayList<Category> maanmaan = new ArrayList<Category>(maanmaanlist);
                        }
			for (int i=0; i<maanmaan.size(); i++)
			{
				if (maanmaan.get(i).getId() == category.getId())
				{
					goingUp = true;
					maanmaan = new ArrayList<Category>( maanmaan.subList(0, i+1) );
					ActionContext.getContext().getSession().put("maanmaan", maanmaan);
					this.maanmaan = maanmaan;
					break;
				}
			}
			
			
			if (!goingUp)
			{
				
				boolean matchedRootCategory = false;
				boolean matchedNewCategory = false;
				
				if (maanmaan.size() > 0)
				{
					for (Category c : util.getTopCategories())
					{
						if (c.getId() == maanmaan.get(0).getId())
							matchedRootCategory = true;
						
						if (c.getId() == category.getId())
							matchedNewCategory = true;
					}
				}
				
				if (matchedRootCategory == true && matchedNewCategory == true){
					maanmaan.clear();
					maanmaan.add(category);
				}
				else{
					maanmaan.add(category);
				}
				
				ActionContext.getContext().getSession().put("maanmaan", maanmaan);
				this.maanmaan = maanmaan;
			}
		}
		return SUCCESS;
	}


	public long getCategoryId() {
		return categoryId;
	}

	
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}


	public ArrayList<Category> getBreadcrumb() {
		return maanmaan;
	}


	public void setBreadcrumb(ArrayList<Category> maanmaan) {
		this.maanmaan = maanmaan;
	}

	public ArrayList<Category> getSubcategories() {
		return subcategories;
	}

	
	public ArrayList<Product> getProducts() {
		return products;
	}

	public String getCategoryName() {
		return categoryName;
	}

}
