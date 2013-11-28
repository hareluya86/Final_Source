package My_Hibernate;

import java.util.Collection;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
public class Category {

	@Id @GeneratedValue
	private long id;
	private String name;
	private String description;
	private String image;
	
	@OneToMany
	@Cascade(CascadeType.ALL)
	@JoinTable(name = "Category_Subcategories", joinColumns = @JoinColumn(name = "CategoryId"), inverseJoinColumns = @JoinColumn(name = "CategoryId2") )
	private Collection<Category> subcategories;
	
	@OneToMany
	@Cascade(CascadeType.ALL)	
	@JoinTable(name = "Category_Products", joinColumns = @JoinColumn(name = "CategoryId"), inverseJoinColumns = @JoinColumn(name = "ProductId") )
	private Collection<Product> products;
	
	public Category()
	{
	}

	public Category(String name, String description, String image,
			Collection<Category> subcategories, Collection<Product> products) {
		//this.id = id;
		this.name = name;
		this.description = description;
		this.image = image;
		this.subcategories = subcategories;
		this.products = products;
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
	 * @return the image
	 */
	public String getImage() {
		return image;
	}
	
	/**
	 * @param image the image to set
	 */
	public void setImage(String image) {
		this.image = image;
	}

	public Collection<Category> getSubcategories() {
		return subcategories;
	}

	public void setSubcategories(Collection<Category> subcategories) {
		this.subcategories = subcategories;
	}

	public Collection<Product> getProducts() {
		return products;
	}

	public void setProducts(Collection<Product> products) {
		this.products = products;
	}
	


	
}
