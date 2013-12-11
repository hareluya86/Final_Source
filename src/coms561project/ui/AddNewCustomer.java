package coms561project.ui;

import com.opensymphony.xwork2.ActionSupport;
import coms561project.utilities.Utilities;

public class AddNewCustomer extends ActionSupport {
	
	private static final long serialVersionUID = 1L;

	
	private boolean addedNewCustomer = false;
	private boolean addedNewCustomerResult = false;
	
	private long id;
	private String userName;
	private String password;
	private String firstName;
	private String lastName;
	private String addressLine1;
	private String addressLine2;
	private String city;
	private String state;
	private String zipCode;
	private String emailAddress;
	private String phoneNumber;
	private String creditCardNumber;
	private String creditCardExpirationDate;
	
	public String execute() throws Exception {

		addedNewCustomer= true;		
		Utilities util = new Utilities();
		if (util.addNewCustomer( id,  userName,  password,
				 firstName,  lastName,  addressLine1,
				 addressLine2,  city,  state,  zipCode,
				 emailAddress,  phoneNumber,  creditCardNumber,
				 creditCardExpirationDate))
			addedNewCustomerResult = true;
		else
			addedNewCustomerResult = false;
		
		return SUCCESS;
	}


	public boolean isAddedNewCustomer() {
		return addedNewCustomer;
	}


	public void setAddedNewCustomer(boolean addedNewCustomer) {
		this.addedNewCustomer = addedNewCustomer;
	}

	
	public boolean isAddedNewCustomerResult() {
		return addedNewCustomerResult;
	}

	public void setaddedNewCustomerResult(boolean addedNewCustomerResult) {
		this.addedNewCustomerResult = addedNewCustomerResult;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getCreditCardNumber() {
		return creditCardNumber;
	}

	public void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}

	public String getCreditCardExpirationDate() {
		return creditCardExpirationDate;
	}

	public void setCreditCardExpirationDate(String creditCardExpirationDate) {
		this.creditCardExpirationDate = creditCardExpirationDate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setAddedNewCustomerResult(boolean addedNewCustomerResult) {
		this.addedNewCustomerResult = addedNewCustomerResult;
	}

	

}
