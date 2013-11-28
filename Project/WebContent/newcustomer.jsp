<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>ComS 561 Project - Account Login</title>
<meta name="keywords" content="station shop, checkout, theme, free templates, website templates, CSS, HTML" />
<meta name="description" content="Station Shop Theme, Checkout, free CSS template provided by templatemo.com" />
<link href="css/templatemo_style.css" rel="stylesheet" type="text/css" />

<link rel="stylesheet" type="text/css" href="css/ddsmoothmenu.css" />

<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/ddsmoothmenu.js">

/***********************************************
* Smooth Navigational Menu- (c) Dynamic Drive DHTML code library (www.dynamicdrive.com)
* This notice MUST stay intact for legal use
* Visit Dynamic Drive at http://www.dynamicdrive.com/ for full source code
***********************************************/

</script>

<script language="javascript" type="text/javascript">
function clearText(field)
{
    if (field.defaultValue == field.value) field.value = '';
    else if (field.value == '') field.value = field.defaultValue;
}
</script>

<script type="text/javascript">

ddsmoothmenu.init({
	mainmenuid: "top_nav", //menu DIV id
	orientation: 'h', //Horizontal or vertical menu: Set to "h" or "v"
	classname: 'ddsmoothmenu', //class added to menu's outer DIV
	//customtheme: ["#1c5a80", "#18374a"],
	contentsource: "markup" //"markup" or ["container_id", "path_to_menu_file"]
})

</script>

<link rel="stylesheet" type="text/css" media="all" href="css/jquery.dualSlider.0.2.css" />

<script src="js/jquery-1.3.2.min.js" type="text/javascript"></script>
<script src="js/jquery.easing.1.3.js" type="text/javascript"></script>
<script src="js/jquery.timers-1.2.js" type="text/javascript"></script>

</head>

<body>

<div id="templatemo_wrapper">

    <s:action name="webcontrol_header" executeResult="true" />
    
    <div id="templatemo_main">
   		<div id="sidebar" class="float_l">
		    <s:action name="webcontrol_categories" executeResult="true" />	
        </div>
        <div id="content" class="float_r">
			<a href="<s:url action='accountlogin'/>">Login to an Existing Account</a>

			<s:if test="addedNewCustomer == true">
				<s:if test="addedNewCustomerResult == true">
					<div id="newcustomerstatusmessagesuccess">
					Your a Account is Successfully Created
					</div>
				</s:if>
				<s:else>
					<div id="newcustomerstatusmessagefailure">
					The user name chosen already exists...please try another name
					</div>	
				</s:else>
			</s:if>
		
			<div id="newemployeecontent">
				<s:form action="addnewcustomer" theme="simple" validate="true">
					<div id="fieldError">
						<s:fielderror />
					</div>
					<div class="newcustomerfields">
						<span id="userName">
							user name
							<s:textfield name="userName" theme="simple" /><br />
						</span>
						<span id="password">
							password
							<s:password name="password"/><br/>
						</span>
						<span id="firstName">
							first name
							<s:textfield name="firstName" theme="simple"/><br/>
						</span>
						<span id="lastName">
							last name<br />
							<s:textfield name="lastName" theme="simple" /><br/>
						</span>
						<span id="addressLine1">
							address 1:
							<s:textfield name="addressLine1" theme="simple" /><br/>
						</span>
						<span id="addressLine2">
							address 2:<br />
							<s:textfield name="addressLine2" theme="simple" /><br/>
						</span>
						<span id="city">
							city
							<s:textfield name="city" theme="simple" /><br/>
						</span>
						<span id="state">
							state
							<s:textfield name="state" theme="simple" /><br/>
						</span>				
						<span id="zipCode">
							zip code
							<s:textfield name="zipCode" theme="simple" /><br/>
						</span>
						<span id="emailAddress">
							E-mail:
							<s:textfield name="emailAddress" theme="simple" /><br/>
						</span>
						<span id="phoneNumber">
							phone number:
							<s:textfield name="phoneNumber" theme="simple" /><br/>
						</span>
						<span id="creditCardNumber">
							credit card number:
							<s:textfield name="creditCardNumber" theme="simple" /><br/>
						</span>
						<span id="creditCardExpirationDate">
							credit card expiration date: 
							<s:textfield name="creditCardExpirationDate" theme="simple" /><br/>
						</span>
					</div>
					<div class="newcustomerbutton">
						<s:submit  value="Create" theme="simple" />
						
					</div>
		
				</s:form>
			</div>



		</div>
        <div class="cleaner"></div>
    </div> <!-- END of templatemo_main -->
    
    <s:action name="webcontrol_footer" executeResult="true" />	
    
</div> <!-- END of templatemo_wrapper -->

</body>
</html>