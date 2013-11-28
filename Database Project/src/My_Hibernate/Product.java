package My_Hibernate;

import java.util.Collection;
import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
public class Product {

	@Id
	private long id;
	private String partNumber;
	private String name;
	private String description;
	private Date dateAdded;
	private long numCustomerPurchases;
	private float listPrice;
	private float salePrice;
	
	
	@OneToMany
	@Cascade(CascadeType.ALL)
	@JoinTable(name = "Product_ProductImage", joinColumns = @JoinColumn(name = "ProductId"), inverseJoinColumns = @JoinColumn(name = "ProductImageId") )
	private Collection<ProductImage> images;
	
	@OneToMany
	@Cascade(CascadeType.ALL)
	@JoinTable(name = "Product_ProductRating", joinColumns = @JoinColumn(name = "ProductId"), inverseJoinColumns = @JoinColumn(name = "ProductRatingId") )
	private Collection<ProductRating> ratings;
	
	@OneToMany
	@Cascade(CascadeType.ALL)
	@JoinTable(name = "Product_ProductDetail", joinColumns = @JoinColumn(name = "ProductId"), inverseJoinColumns = @JoinColumn(name = "ProductDetailId") )
	private Collection<ProductDetail> details;
	
	public Product()
	{
	}
	
	public Product(String partNumber, String name, String description,
			Date dateAdded, long numCustomerPurchases, float listPrice,
			float salePrice, Collection<ProductImage> images, Collection<ProductRating> ratings,
			Collection<ProductDetail> details) {
	//	this.id = id;
		this.partNumber = partNumber;
		this.name = name;
		this.description = description;
		this.dateAdded = dateAdded;
		this.numCustomerPurchases = numCustomerPurchases;
		this.listPrice = listPrice;
		this.salePrice = salePrice;
		this.images = images;
		this.ratings = ratings;
		this.details = details;
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
	 * @return the partNumber
	 */
	public String getPartNumber() {
		return partNumber;
	}
	
	/**
	 * @param partNumber the partNumber to set
	 */
	public void setPartNumber(String partNumber) {
		this.partNumber = partNumber;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * @return the dateAdded
	 */
	public Date getDateAdded() {
		return dateAdded;
	}
	
	/**
	 * @param dateAdded the dateAdded to set
	 */
	public void setDateAdded(Date dateAdded) {
		this.dateAdded = dateAdded;
	}
	
	/**
	 * @return the numCustomerPurchases
	 */
	public long getNumCustomerPurchases() {
		return numCustomerPurchases;
	}
	
	/**
	 * @param numCustomerPurchases the numCustomerPurchases to set
	 */
	public void setNumCustomerPurchases(long numCustomerPurchases) {
		this.numCustomerPurchases = numCustomerPurchases;
	}
	
	/**
	 * @return the listPrice
	 */
	public float getListPrice() {
		return listPrice;
	}
	
	/**
	 * @param listPrice the listPrice to set
	 */
	public void setListPrice(float listPrice) {
		this.listPrice = listPrice;
	}
	
	/**
	 * @return the salePrice
	 */
	public float getSalePrice() {
		return salePrice;
	}
	
	/**
	 * @param salePrice the salePrice to set
	 */
	public void setSalePrice(float salePrice) {
		this.salePrice = salePrice;
	}
	
	/**
	 * @return the images
	 */
	public Collection<ProductImage> getImages() {
		return images;
	}

	public void setImages(Collection<ProductImage> images) {
		this.images = images;
	}

	public Collection<ProductRating> getRatings() {
		return ratings;
	}

	public void setRatings(Collection<ProductRating> ratings) {
		this.ratings = ratings;
	}

	public Collection<ProductDetail> getDetails() {
		return details;
	}

	public void setDetails(Collection<ProductDetail> details) {
		this.details = details;
	}
}
