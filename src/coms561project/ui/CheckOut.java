package coms561project.ui;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import coms561project.data.*;

public class CheckOut extends ActionSupport {

    private static final long serialVersionUID = 1L;
    private User user;
    private Customer customer;
    private Employee employee;
    private ShoppingCart cart;
    private double carttotal;

    public String execute() throws Exception {

        user = (User) ActionContext.getContext().getSession().get("customer");
        
        if(user instanceof Employee){
            employee = (Employee) ActionContext.getContext().getSession().get("customer");
            return "employee";
        }else if(user instanceof Customer){
            customer = (Customer) ActionContext.getContext().getSession().get("customer");
        }
        else{
            return "loginrequired"; //user group not identified
        }
        
        cart = (ShoppingCart) ActionContext.getContext().getSession().get("my_cart");
        if (customer == null) {
            return "loginrequired";
        } else if (cart == null) {
            return "cartitemsrequired";
        }

        carttotal = 0;
        for (ShoppingCartItem item : cart.getCartItems()) {
            carttotal = carttotal + (double) item.getTotalCost();
        }

        return SUCCESS;
    }

    /**
     * @return the customer
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * @return the cart
     */
    public ShoppingCart getCart() {
        return cart;
    }

    /**
     * @return the carttotal
     */
    public double getCarttotal() {
        return carttotal;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
    
    
    
}
