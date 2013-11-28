package coms561project.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ProductRating {

	@Id @GeneratedValue
	private long id;
	private short rating;
	private String customerName;
	private String review;
	
	public ProductRating()
	{
	}
	
	public ProductRating( short rating, String customerName,
			String review) {
		//this.id = id;
		this.rating = rating;
		this.customerName = customerName;
		this.review = review;
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	
	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}
	
	/**
	 * @return the rating
	 */
	public short getRating() {
		return rating;
	}
	
	/**
	 * @param rating the rating to set
	 */
	public void setRating(short rating) {
		this.rating = rating;
	}
	
	/**
	 * @return the customerName
	 */
	public String getCustomerName() {
		return customerName;
	}
	
	/**
	 * @param customerName the customerName to set
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	/**
	 * @return the review
	 */
	public String getReview() {
		return review;
	}
	
	/**
	 * @param review the review to set
	 */
	public void setReview(String review) {
		this.review = review;
	}
	
}
