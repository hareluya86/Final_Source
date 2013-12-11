package coms561project.ui;

import java.util.Date;
import java.util.Map;
import java.util.Properties;

import java.util.Collection;
import java.util.ArrayList;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import coms561project.data.Product;
import coms561project.data.ProductDetail;
import coms561project.data.ProductImage;
import coms561project.data.ProductRating;
import coms561project.data.ShoppingCart;
import coms561project.data.ShoppingCartItem;
import coms561project.utilities.Utilities;

public class AddToCart extends ActionSupport {

    private ShoppingCart myCart;
    private int product;

    public String execute() throws Exception {

        String ret = SUCCESS;
        try {
         
            Utilities util = new Utilities();
            Product thisproduct = util.getProductById(product);
            storeInCart(thisproduct, 1);
        } catch (Exception e) {
            ret = SUCCESS;
            e.printStackTrace();
        }
        return ret;

    }


    public void setProduct(int aproduct) {
        product = aproduct;
    }


    public boolean checkForShoppingCart() {
        Map session = ActionContext.getContext().getSession();

        if (session.get("my_cart") == null) {
            return false;
        } else {
            myCart = (ShoppingCart) session.get("my_cart");
            return true;
        }
    }

    public void makeShoppingCart() {
        myCart = new ShoppingCart();
        Map session = ActionContext.getContext().getSession();
        session.put("my_cart", (ShoppingCart) myCart);
    }

 
    public void storeInCart(Product prod, int quantity) {
        Map session = ActionContext.getContext().getSession();
        if (checkForShoppingCart()) {

          
            ShoppingCart cart = (ShoppingCart) session.get("my_cart");
            ArrayList<ShoppingCartItem> contentstocheck = new ArrayList<ShoppingCartItem>(cart.getCartItems());
            boolean quantityadded = false;
  
            for (int i = 0; i < contentstocheck.size(); i++) {
                if (contentstocheck.get(i).getProduct().getId() == prod.getId()) {
                    contentstocheck.get(i).setQuantity(contentstocheck.get(i).getQuantity() + 1);
                    quantityadded = true;
                }
            }
         
            if (!quantityadded) {
                ShoppingCartItem newItem = new ShoppingCartItem();
                newItem.setProduct(prod);
                newItem.setQuantity(quantity);
                Collection<ShoppingCartItem> currentItems = myCart.getCartItems();
                currentItems.add(newItem);
                myCart.setCartItems(currentItems);
            }
            session.put("my_cart", (ShoppingCart) myCart);
        } else {
           
            makeShoppingCart();
            ShoppingCartItem newItem = new ShoppingCartItem();
            newItem.setProduct(prod);
            newItem.setQuantity(quantity);
            ArrayList<ShoppingCartItem> currentItems = new ArrayList<ShoppingCartItem>();
            currentItems.add(newItem);
            myCart.setCartItems(currentItems);
            session.put("my_cart", (ShoppingCart) myCart);
        }
    }
}
