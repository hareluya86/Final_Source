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

public class UpdateCart extends ActionSupport {

    private ShoppingCart myCart;
    private int product;

    public String execute() throws Exception {

        String ret = SUCCESS;
        try {
            removeFromCart(product);
        } catch (Exception e) {
            ret = SUCCESS;
            e.printStackTrace();
        }
        return ret;

    }

    /**
     * @param aproduct the product to store.
     */
    public void setProduct(int aproduct) {
        product = aproduct;
    }

    //public float calculate
    public boolean checkForShoppingCart() {
        Map session = ActionContext.getContext().getSession();

        if (session.get("my_cart") == null) {
            return false;
        } else {
            myCart = (ShoppingCart) session.get("my_cart");
            return true;
        }
    }

    /**
     * @param item the shopping cart item being updated
     * @param newquantity the new quantity of the item.
     */
    public void changeQuantity(ShoppingCartItem item, int newquantity) {
        item.setQuantity(newquantity);
    }

    /**
     * @param aproductid the id of the product to be removed from the cart
     */
    public void removeFromCart(int aproductid) {

        Map session = ActionContext.getContext().getSession();
        if (checkForShoppingCart()) {
            ShoppingCart cart = (ShoppingCart) session.get("my_cart");
            ArrayList<ShoppingCartItem> contentstocheck = new ArrayList<ShoppingCartItem>(cart.getCartItems());
            boolean itemremoved = false;
            // Check if the item is already in the cart, and add to its quantity.
            for (int i = 0; i < contentstocheck.size(); i++) {
                if (contentstocheck.get(i).getProduct().getId() == aproductid && !itemremoved) {
                    contentstocheck.remove(i);
                    itemremoved = true;
                }
            }
            if (contentstocheck.size() < 1) {

                session.remove("my_cart");
            }
        }
    }
}