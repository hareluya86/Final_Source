package coms561project.ui;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;


import com.opensymphony.xwork2.ActionSupport;
import coms561project.data.Customer;
import coms561project.data.Employee;
import coms561project.data.User;
import coms561project.utilities.Utilities;

/*
 * The AccountLogin action takes a username and password from the request and
 * authenticates those tokens agains the portfolioService objects authentication
 * methods. If the user is valid, the user object is stored in the session map.
 *
 * To receive the session map, this action implements the sessionAware
 * interface. This decouples the action from the servlet API. Of course, the
 * action could use the ActionContext to get this map, or even the underlying
 * Servlet Session object, but these would be needless bindings to the Servlet
 * API, certainly complicating testing.
 */
public class AccountLogin extends ActionSupport implements SessionAware {

    public String execute() {
        Utilities util = new Utilities();
        User user = util.CustomerAuthentication(getUsername(), getPassword());
        //Customer user = Utilities.CustomerAuthentication("null", "null"); 
        if (user == null) {
            /*
             * User not valid, return to input page.
             */
            AuthenticationError = true;
            return INPUT;
        } else {
            //session.put(UserAccountInterface.Customer, user);
            //watch out for this area, may need to differentiate between customer and employee
            session.put("customer", user);
        }

        return SUCCESS;
    }
    
    private static final long serialVersionUID = 1L;
    private String username;
    private String password;
    private Map session;
    private boolean AuthenticationError = false;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAuthenticationError() {
        return AuthenticationError;
    }

    public void setAuthenticationError(boolean authenticationError) {
        AuthenticationError = authenticationError;
    }

    public Map getSession() {
        return session;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setSession(Map session) {
        this.session = session;

    }
}
