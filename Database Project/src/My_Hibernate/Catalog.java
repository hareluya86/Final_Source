/**
 * 
 */
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

/**
 * @author 
 *
 */

@Entity
public class Catalog {

	@Id
	@GeneratedValue
	private long id;
	@OneToMany
	@Cascade(CascadeType.ALL)
	@JoinTable(name = "Catalog_Category", joinColumns = @JoinColumn(name = "CatalogId"), inverseJoinColumns = @JoinColumn(name = "CategoryId") )
	private Collection<Category> subcategories;
	
	@OneToMany
	@Cascade(CascadeType.ALL)
	@JoinTable(name = "Catalog_Admin", joinColumns = @JoinColumn(name = "CatalogId"), inverseJoinColumns = @JoinColumn(name = "AdminId") )
	private Collection<Employee> administrators;
	
	@OneToMany
	@Cascade(CascadeType.ALL)
	@JoinTable(name = "Catalog_Editors", joinColumns = @JoinColumn(name = "CatalogId"), inverseJoinColumns = @JoinColumn(name = "EditorId") )
	private Collection<Employee>  editors;
	
	public Catalog()
	{
	}
	
	public Catalog(Collection<Category>  subcategories, Collection<Employee>  administrators, Collection<Employee>  editors) {
		//this.id = id;
		this.subcategories = subcategories;
		this.administrators = administrators;
		this.editors = editors;
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

	public Collection<Category> getSubcategories() {
		return subcategories;
	}

	public void setSubcategories(Collection<Category> subcategories) {
		this.subcategories = subcategories;
	}

	public Collection<Employee> getAdministrators() {
		return administrators;
	}

	public void setAdministrators(Collection<Employee> administrators) {
		this.administrators = administrators;
	}

	public Collection<Employee> getEditors() {
		return editors;
	}

	public void setEditors(Collection<Employee> editors) {
		this.editors = editors;
	}	

}
