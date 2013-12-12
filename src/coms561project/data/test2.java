/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package coms561project.data;

import coms561project.utilities.Utilities;
import java.util.ArrayList;
import java.util.Date;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 *
 * @author vincent.a.lee
 */
public class test2 {
    
    public static void main(String[] args){
        
        //Change these variables only!
        String desc = "This is how you create a product3";
        String detailName = "Shirt";
        String detailDescription = "Running Shirt";
        String imageName = "bye";
        String imageDescription = "bye";
        String name = "New product3";
        Date d = new Date();
        short rating=10;
        String ratingBy="T";
        String ratingDescription = "Super Product";
        long j = 6;
        float price = (float) 1.99;
        long cat = 3;
        //Change these variables only!
        
        
        
        
        ProductDetail PD = new ProductDetail(detailName, detailDescription);
        ProductImage PI = new ProductImage(imageName, imageDescription);
        ProductRating PR;
        PR = new ProductRating(rating, ratingBy, ratingDescription);
        ArrayList<ProductImage> images = new ArrayList<ProductImage>();
        images.add(PI);
        ArrayList<ProductDetail> details = new ArrayList<ProductDetail>();
        details.add(PD);
        ArrayList<ProductRating> ratings = new ArrayList<ProductRating>();
        
        Product p = new Product();
        p.setDateAdded(d);
        p.setDescription(desc);
        p.setDetails(details);
        p.setImages(images);
        p.setListPrice(price);
        p.setName(name);
        p.setRatings(ratings);
        
        Utilities u = new Utilities();
        
        Category toBeAddedTo = u.getCategoryById(cat);
        ArrayList<Product> products = new ArrayList<Product>(toBeAddedTo.getProducts());
        products.add(p);
        toBeAddedTo.setProducts(products);
        
        SessionFactory sessionfactory = u.getSessionFactory();
        org.hibernate.Session session = sessionfactory.openSession();
        session.beginTransaction();
        session.save(p);
        session.getTransaction().commit();
        
    }
}
