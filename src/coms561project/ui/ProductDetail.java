package coms561project.ui;

import com.opensymphony.xwork2.ActionSupport;

import coms561project.data.Product;
import coms561project.utilities.Utilities;


public class ProductDetail extends ActionSupport {
	
	private static final long serialVersionUID = 1L;
	
	private int productId;
	private Product product;

	public Product getProduct() {
		return product;
	}

	public String execute() throws Exception {
		
		if (productId == 0)  
		{
			return ERROR;
		}
		
	
                Utilities util = new Utilities();
		product = util.getProductById(productId);	
		
		return SUCCESS;
	}

	public int getProductId() {
		return productId;
	}

	
	public void setProductId(int productId) {
		this.productId = productId;
	}

}
