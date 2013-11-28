package coms561project.utilities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import coms561project.data.*;

public class Utilities {
	
	private static SessionFactory sessionFactory = getSessionFactory();
	
	//Test
	private static ArrayList<Category> testCategories;
	//Test	

	/**
	 * Gets a Category object by its ID
	 * @param categoryId the ID
	 * @return the Category
	 */
	public static Category getCategoryById( int categoryId )
	{
		//Test data
		if (testCategories == null)
			return new Category();
			
		for (Category c: testCategories)
		{
			Category d = findCategory( categoryId, c );
			if (d != null)
				return d;
		}
		
		
		return new Category();
	}

	/**
	 * Gets a Customer ID by the Customer's user name
	 * @param searchString the user name
	 * @return the ID of the Customer found in the query
	 */
	public static int getCustomerIdByUserName( String searchString )
	{
		SessionFactory sessionFactory;
		Session session;
		
		sessionFactory = getSessionFactory();
		session = sessionFactory.openSession();
		
		Query query;
		
		//Return all entries
		if (searchString.compareTo("") == 0)
		{
			return 0;
		}
		else
		{
			query = session.createQuery("from Customer EP " +
										"where EP.userName = '" + searchString + "' ");
		}
		int eps = query.list().size();
		
	//	AddNewCustomer eps = (AddNewCustomer)query.list();
		
		session.close();
		sessionFactory.close();
		
			return eps;
	}
	
	/**
	 * Adds a new customer to the database
	 * @param id the ID
	 * @param userName the user name 
	 * @param password the password
	 * @param firstName the first name
	 * @param lastName the last name
	 * @param addressLine1 the first line of the address
	 * @param addressLine2 the second line of the address
	 * @param city the city
	 * @param state the state
	 * @param zipCode the zip code
	 * @param emailAddress the email address
	 * @param phoneNumber the phone number
	 * @param creditCardNumber the credit card number
	 * @param creditCardExpirationDate the credit card expiration date
	 * @return the result of successfully creating a new customer
	 */
	public static boolean addNewCustomer(long id, String userName, String password,
			String firstName, String lastName, String addressLine1,
			String addressLine2, String city, String state, String zipCode,
			String emailAddress, String phoneNumber, String creditCardNumber,
			String creditCardExpirationDate)
	{
		if (getCustomerIdByUserName(userName) != 0 )
			return false;
		
		else
		{
			try {
				SessionFactory sessionFactory;
				Session session;
				
				sessionFactory = getSessionFactory();
				session = sessionFactory.openSession();
				
				Transaction tx = session.beginTransaction();		
				
						
				Customer C = new Customer( userName,  password,
						 firstName,  lastName,  addressLine1,
						 addressLine2,  city,  state,  zipCode,
						 emailAddress,  phoneNumber,  creditCardNumber,
						 creditCardExpirationDate);
				
			
				session.save(C);
			
				tx.commit();	
				
				session.close();
			}
			catch (Exception e)
			{
				return false;
			}
			
			return true;
		}
	}

	/**
	 * Obtains a Customer given a correct user name and password
	 * @param userName the user name
	 * @param password the password
	 * @return a Customer if the user name and password are correct
	 */
	public static Customer CustomerAuthentication(String userName, String password)
	{
		SessionFactory sessionFactory;
		Session session;
		
		sessionFactory = getSessionFactory();
		session = sessionFactory.openSession();
		
		Query query;
		
		//Return all entries
		if (userName == null || (userName.compareTo("") == 0) || (password.compareTo("") == 0))
		{
			return null;
		}
		else
		{
			query = session.createQuery("from Customer EP " +
										"where EP.userName = '" + userName + "' and EP.password = '"+ password +"'" );
		}
		
		ArrayList<Customer> eps = (ArrayList<Customer>)query.list();
		
		Customer c = null;
		if (eps.size() > 0)
			 c = eps.get(0);
		session.close();
		sessionFactory.close();
		
		return c;	
	}

	
	
	/*TEST*/
	/**
	 * A test function to find a subcategory by ID given a category
	 * @param id the ID of the category to find
	 * @param c the root of the category tree to search
	 * @return the category, if it exists
	 */
	private static Category findCategory(int id, Category c)
	{
		if (c.getId() == id)
			return c;
		
		if (c.getSubcategories() == null)
			return null;
		
		for (Category d : c.getSubcategories())
		{
			Category g = findCategory(id, d);
			if (g != null)
				return g;
		}
		
		return null;
	}
	/* TEST */
	
	/**
	 * Gets the top categories in the product catalog
	 * @return a list of categories
	 */
	public static List<Category> getTopCategories()
	{
		/*
		//Test data
		ArrayList<Category> categories = new ArrayList<Category>();
		categories.add( new Category(2, "Pants","","",null,null) );
		categories.add( new Category(3, "Shirts","","",null,null) );
		categories.add( new Category(4, "Socks","","",null,null) );
		categories.add( new Category(5, "Hats","","",null,null) );
		categories.add( new Category(6, "Coats","","",null,null) );
		categories.add( new Category(7, "Shorts","","",null,null) );
		
		ArrayList<Category> nikesSubcategories = new ArrayList<Category>();
		nikesSubcategories.add( new Category(12,"Jordans","","",null,null) );
		nikesSubcategories.add( new Category(13,"Sandals","","",null,null) );
		nikesSubcategories.add( new Category(14,"Running Shoes","","",null,null) );
		nikesSubcategories.add( new Category(15,"Cleats","","",null,null) );
		
		
		ArrayList<Category> shoesSubcategories = new ArrayList<Category>();
		shoesSubcategories.add( new Category(8,"Nikes","","",nikesSubcategories,null) );
		shoesSubcategories.add( new Category(9,"Reebok","","",null,null) );
		shoesSubcategories.add( new Category(10,"Adidas","","",null,null) );
		shoesSubcategories.add( new Category(11,"Ugly Boots","","",null,null) );
		
		categories.add( new Category(1,"Shoes","","",shoesSubcategories,null) );
		
		testCategories = categories;
		
		return categories;
		*/
		
		
		
		/*
		
		SessionFactory sessionFactory;
		Session session;
		
		sessionFactory = getSessionFactory();
		session = sessionFactory.openSession();
		
		Query query = session.createQuery("from Catalog");
		
		//Make sure the catalog exists
		if (query.list().isEmpty())
		{
			session.close();
			sessionFactory.close();
			
			return new ArrayList<Category>();
		}
		
		//Only one catalog for this project
		Catalog catalog = (Catalog)query.list().get(0);
		
		//Close down
		session.close();
		sessionFactory.close();
		
		return (List<Category>) catalog.getSubcategories();
		*/
	}

	/**
	 * Gets a list of the bestselling products
	 * @return the bestselling products
	 */
	public static List<Product> getBestSellers()
	{
		
		//Test data
		ArrayList<Product> products = new ArrayList<Product>();
		ArrayList<ProductImage> productImages = new ArrayList<ProductImage>();
		productImages.add( new ProductImage(1, "images/templatemo_image_01.jpg", "images/templatemo_image_01.jpg") );
		
		products.add( new Product(1, "111-111", "Cow", "It moos", null, 0, 40, 30, productImages, null, null) );
		products.add( new Product(2, "111-112", "Pig", "It oinks", null, 0, 40, 30, productImages, null, null) );
		products.add( new Product(3, "111-113", "Horse", "It neighs", null, 0, 40, 30, productImages, null, null) );
		products.add( new Product(4, "111-114", "Donkey", "It brays", null, 0, 40, 30, productImages, null, null) );
		products.add( new Product(5, "111-115", "Sheep", "It baas", null, 0, 40, 30, productImages, null, null) );
		products.add( new Product(6, "111-116", "Owl", "It hoots", null, 0, 40, 30, productImages, null, null) );
		
		productImages.set(0, new ProductImage(2, "images/product/07.jpg", "images/product/07.jpg") );
		products.add( new Product(6, "111-116", "Owl", "It hoots", null, 0, 40, 30, productImages, null, null) );
		
		return products;
		
		/*
		
		SessionFactory sessionFactory;
		Session session;
		
		sessionFactory = getSessionFactory();
		session = sessionFactory.openSession();
		
		Query query = session.createQuery("from Product P " +
										  "order by P.numCustomerPurchases desc");
		query.setMaxResults(7);
		
		//No products
		if (query.list().isEmpty())
		{
			session.close();
			sessionFactory.close();
			
			return new ArrayList<Product>();
		}
		
		//Close down
		session.close();
		sessionFactory.close();
		
		return (List<Product>)query.list();
		*/
		
	}
	
	/**
	 * Gets a list of the new products
	 * @return the new products
	 */
	public static List<Product> getNewProducts()
	{
		//Test data
		ArrayList<Product> products = new ArrayList<Product>();
		ArrayList<ProductImage> productImages = new ArrayList<ProductImage>();
		productImages.add( new ProductImage(1, "images/templatemo_image_01.jpg", "images/templatemo_image_01.jpg") );
		
		products.add( new Product(1, "111-111", "Cow", "It moos", null, 0, 40, 30, productImages, null, null) );
		products.add( new Product(2, "111-112", "Pig", "It oinks", null, 0, 40, 30, productImages, null, null) );
		products.add( new Product(3, "111-113", "Horse", "It neighs", null, 0, 40, 30, productImages, null, null) );
		products.add( new Product(4, "111-114", "Donkey", "It brays", null, 0, 40, 30, productImages, null, null) );
		products.add( new Product(5, "111-115", "Sheep", "It baas", null, 0, 40, 30, productImages, null, null) );
		products.add( new Product(6, "111-116", "Owl", "It hoots", null, 0, 40, 30, productImages, null, null) );
		
		productImages.set(0, new ProductImage(2, "images/product/07.jpg", "images/product/07.jpg") );
		products.add( new Product(6, "111-116", "Owl", "It hoots", null, 0, 40, 30, productImages, null, null) );
		
		return products;
				
		
	}
	
	/**
	 * Searches the database by a query string
	 * @param queryString the string to search
	 * @param resultSize the size of the list of items to retrieve
	 * @param page the page of the results to retrieve
	 * @return the list of items found by the query
	 */
	public static List<Product> searchByName(String queryString, int resultSize, int page)
	{
		//Test data
		ArrayList<Product> products = new ArrayList<Product>();
		ArrayList<ProductImage> productImages = new ArrayList<ProductImage>();
		productImages.add( new ProductImage(1, "images/templatemo_image_01.jpg", "images/templatemo_image_01.jpg") );
		
		products.add( new Product(1, "111-111", "Cow", "It moos", null, 0, 40, 30, productImages, null, null) );
		products.add( new Product(2, "111-112", "Pig", "It oinks", null, 0, 40, 30, productImages, null, null) );
		products.add( new Product(3, "111-113", "Horse", "It neighs", null, 0, 40, 30, productImages, null, null) );
		products.add( new Product(4, "111-114", "Donkey", "It brays", null, 0, 40, 30, productImages, null, null) );
		products.add( new Product(5, "111-115", "Sheep", "It baas", null, 0, 40, 30, productImages, null, null) );
		products.add( new Product(6, "111-116", "Owl", "It hoots", null, 0, 40, 30, productImages, null, null) );
		
		productImages.set(0, new ProductImage(2, "images/product/07.jpg", "images/product/07.jpg") );
		products.add( new Product(6, "111-116", "Owl", "It hoots", null, 0, 40, 30, productImages, null, null) );
		
		return products;
		
		/*
		SessionFactory sessionFactory;
		Session session;
		
		sessionFactory = getSessionFactory();
		session = sessionFactory.openSession();
		
		Query query = session.createQuery("from Product P " +
										  "where P.name like :query or " +
										  "P.description like :query " +
										  "order by P.numCustomerPurchases desc");
		query.setParameter("query", queryString + "%");
		query.setMaxResults(resultSize);
		query.setFirstResult(resultSize * page);
		
		//No products
		if (query.list().isEmpty())
		{
			session.close();			
			return new ArrayList<Product>();
		}
		
		//Close down
		session.close();
		sessionFactory.close();
		
		return (List<Product>)query.list();
		*/
	}
	
	/**
	 * Gets a new SessionFactory
	 * @return the SessionFactory
	 */
	private static SessionFactory getSessionFactory() //throws Exception
	{
		//Create a new global SessionFactory if one does not exist
		if (sessionFactory == null)
		{
			Configuration configuration = new Configuration();
			configuration.configure();
			
			sessionFactory = configuration.buildSessionFactory();
		}
		
		return sessionFactory;
	}
	
	/**
	 * Gets a product by its ID
	 * @param productId the ID of the product to retrieve
	 * @return the product
	 */
	public static Product getProductById( long productId ) 
	{
		//Product nothing = new Product();
		if (productId == 1)
		{
			Date tempDate = new Date(2012, 1, 3);
	   	 	//ProductImage tempImage = new ProductImage("None", "None");
	   	 	//Collection<ProductImage> tempImages = null;
	   	 	ArrayList<ProductImage> tempImages = new ArrayList<ProductImage>();
	   	 	ProductImage pimage = new ProductImage("images/product/01.jpg", "images/product/01.jpg");
	   	 	tempImages.add(pimage);
	   	 	tempImages.add(new ProductImage("images/product/03.jpg","images/product/03.jpg"));
	  	 	tempImages.add(new ProductImage("images/product/09.jpg","images/product/09.jpg"));
	  	 	tempImages.add(new ProductImage("images/product/08.jpg","images/product/08.jpg"));


	   	 	Collection<ProductRating> tempRatings = null;
	   	 	Collection<ProductDetail> tempDetails = null;
	   	 	Product nothing = new Product(1, "1", "Cow", "Is nothing",
	   				tempDate, (long)2, (float)30.00,
	   				(float)3.35, tempImages, tempRatings,
	   				tempDetails);
			return nothing;
		} else if (productId==2)
		{
			Date tempDate = new Date(2012, 1, 3);
	   	 	//ProductImage tempImage = new ProductImage("None", "None");
	   	 	//Collection<ProductImage> tempImages = null;
	   	 	ArrayList<ProductImage> tempImages = new ArrayList<ProductImage>();
	   	 	ProductImage pimage = new ProductImage("images/product/02.jpg", "images/product/02.jpg");
	   	 	tempImages.add(pimage);
	   	 	Collection<ProductRating> tempRatings = null;
	   	 	Collection<ProductDetail> tempDetails = null;
	   	 	Product nothing = new Product(2, "1", "Pig", "Is nothing",
	   				tempDate, (long)2, (float)30.00,
	   				(float)3.35, tempImages, tempRatings,
	   				tempDetails);
			return nothing;
			
		} else
		{
			Date tempDate = new Date(2012, 1, 3);
	   	 	//ProductImage tempImage = new ProductImage("None", "None");
	   	 	//Collection<ProductImage> tempImages = null;
	   	 	ArrayList<ProductImage> tempImages = new ArrayList<ProductImage>();
	   	 	ProductImage pimage = new ProductImage("images/product/03.jpg", "images/product/03.jpg");
	   	 	tempImages.add(pimage);
	   	 	Collection<ProductRating> tempRatings = null;
	   	 	Collection<ProductDetail> tempDetails = null;
	   	 	Product nothing = new Product(3, "1", "Horse", "Is nothing",
	   				tempDate, (long)2, (float)30.00,
	   				(float)3.35, tempImages, tempRatings,
	   				tempDetails);
			return nothing;
		
		}
	}
}
