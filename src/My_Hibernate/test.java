package My_Hibernate;

import java.util.ArrayList;
import java.util.Date;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import My_Hibernate.Catalog;
import My_Hibernate.Category;
import My_Hibernate.Customer;
import My_Hibernate.Employee;
import My_Hibernate.Product;
import My_Hibernate.ProductDetail;
import My_Hibernate.ProductImage;
import My_Hibernate.ProductRating;
import My_Hibernate.ShoppingCart;
import My_Hibernate.ShoppingCartItem;

public class test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		short i = 4;
		long j = 6;
				
		Date d = new Date();
		Customer customer = new Customer("maan","111","maan","Al","","","Ames","IA","50014","alduaiji@iastate.edu","5154411201","11111","12/2013");
		ShoppingCart shopingcart = new ShoppingCart(null, customer);
		ShoppingCartItem shoppingcartitem = new ShoppingCartItem(null, 1);
		ProductDetail PD = new ProductDetail("Shoe", "Running Shoe");
		ProductImage PI = new ProductImage("hi", "Hello");
		ProductRating PR = new ProductRating(i, "T", "Good Product");
		ArrayList<ProductImage> ar = new ArrayList<ProductImage>();
		ar.add(PI);
		ArrayList<ProductDetail> ar1 = new ArrayList<ProductDetail>();
		ar1.add(PD);
		ArrayList<ProductRating> ar2 = new ArrayList<ProductRating>();
		Product P = new Product("1", "Shoe", "Puma Shoe", d, j, 50, 30, ar, ar2, ar1);
		ArrayList<Product> ar3 = new ArrayList<Product>();
		ar3.add(P);
		Employee E = new Employee("employee1", "1111", "al", "maan", "saad @iastate.edu");
		Employee E2 = new Employee("employee2", "2222", "al", "maan", "saad@iastate.edu");
		ArrayList<Employee>ar4 = new ArrayList<Employee>();
		ar4.add(E);
		ArrayList<Employee>ar5 = new ArrayList<Employee>();
		ar4.add(E2);
		Category category = new Category("Sport", "shoe", "", null, ar3);
		ArrayList<Category>ar6 = new ArrayList<Category>();
		ar6.add(category);
		ar6.add( new Category("Pants","","",null,null) );
		ar6.add( new Category("Shirts","","",null,null) );
		ar6.add( new Category("Socks","","",null,null) );
		ar6.add( new Category("Hats","","",null,null) );
		ar6.add( new Category("Coats","","",null,null) );
		ar6.add( new Category("Shorts","","",null,null) );

		ArrayList<Category> shoesSubcategories = new ArrayList<Category>();
		shoesSubcategories.add( new Category("Nikes","","",null,null) );
		shoesSubcategories.add( new Category("Reebok","","",null,null) );
		shoesSubcategories.add( new Category("Adidas","","",null,null) );
		shoesSubcategories.add( new Category("Ugly Boots","","",null,null) );
		
		ar6.add( new Category("Shoes","","",shoesSubcategories,null) );
		
		Catalog catalog = new Catalog(ar6, ar4, ar5);
		
		SessionFactory sessionfactory = new AnnotationConfiguration().configure().buildSessionFactory();
		org.hibernate.Session session = sessionfactory.openSession();
		session.beginTransaction();
		session.save(E);
		//session.save(PR);
		//session.save(PI);
		//session.save(PD);
		//session.save(P);
		//session.save(category);
		
		session.save(catalog);
		session.save(customer);
		session.save(shoppingcartitem);
		session.save(shopingcart);
		
		
		session.getTransaction().commit();	
		
	/*	AnnotationConfiguration config = new AnnotationConfiguration();
		config.addAnnotatedClass(ProductDetail.class);
		config.addAnnotatedClass(ProductImage.class);
		config.addAnnotatedClass(ProductRating.class);
		config.addAnnotatedClass(Product.class);
		config.addAnnotatedClass(Category.class);
		config.addAnnotatedClass(Employee.class);
		config.addAnnotatedClass(Catalog.class);
		config.addAnnotatedClass(Customer.class);
		config.addAnnotatedClass(ShoppingCartItem.class);
		config.addAnnotatedClass(ShoppingCart.class);
		config.configure();
		//test t = new test();
		new SchemaExport(config).create(true, true);*/
		
		

	}

}
