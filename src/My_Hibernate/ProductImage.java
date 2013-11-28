package My_Hibernate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ProductImage {

	@Id@GeneratedValue
	private long id;
	private String thumbnail;
	private String image;
	
	public ProductImage()
	{
	}
	
	public ProductImage(String thumbnail, String image) {
	//	this.id = id;
		this.thumbnail = thumbnail;
		this.image = image;
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
	 * @return the thumbnail
	 */
	public String getThumbnail() {
		return thumbnail;
	}
	
	/**
	 * @param thumbnail the thumbnail to set
	 */
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
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
	
}
