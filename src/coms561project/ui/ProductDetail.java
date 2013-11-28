package coms561project.ui;

import com.opensymphony.xwork2.ActionSupport;

import coms561project.data.Product;
import coms561project.utilities.Utilities;

/**
 * 
 * @author Tim
 *
 */
public class ProductDetail extends ActionSupport {
	
	private static final long serialVersionUID = 1L;
	
	private int productId;
	private Product product;
		
	/**
	 * @return the product
	 */
	public Product getProduct() {
		return product;
	}

	/**
	 * @return the result
	 */
	public String execute() throws Exception {
		
		if (productId == 0)  //Display new products
		{
			return ERROR;
		}
		
		//Get the product
                Utilities util = new Utilities();
		product = util.getProductById(productId);	
		
		return SUCCESS;
	}

	/**
	 * @return the productId
	 */
	public int getProductId() {
		return productId;
	}

	/**
	 * @param productId the productId to set
	 */
	public void setProductId(int productId) {
		this.productId = productId;
	}

}
