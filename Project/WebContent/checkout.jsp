<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>ComS 561 Project - Checkout</title>
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
        	<h2>Checkout</h2>
            <h5><strong>BILLING DETAILS</strong></h5>
            <div class="content_half float_l checkout">
				Enter your full name as it is on the credit card:                				
                <input type="text" style="width:300px;" 
                	value='<s:property value="customer.firstName" /> <s:property value="customer.lastName" />' />
                Address:
                <input type="text"  style="width:300px;" value='<s:property value="customer.addressLine1" />' />
                City:
                <input type="text"  style="width:300px;" value='<s:property value="customer.city" />'  />
            </div>
            
            <div class="content_half float_r checkout">
            	Email:
				<input type="text"  style="width:300px;" value='<s:property value="customer.emailAddress" />'  />
                Phone:<br />
				<span style="font-size:10px">Please, specify your reachable phone number. YOU MAY BE GIVEN A CALL TO VERIFY AND COMPLETE THE ORDER.</span>
                <input type="text" value='<s:property value="customer.phoneNumber" />'  style="width:300px;"  />
            </div>
            
            <div class="cleaner h50"></div>
            <h3>Shopping Cart</h3>
            <h4>TOTAL: <strong>$<s:property value="getText('{0,number,#,##0.00}',{carttotal})"/></strong></h4>
			<p><input type="checkbox" />I have accepted the Terms of Use.</p>
            <table style="border:1px solid #CCCCCC;" width="100%">
                <tr>
                    <td height="80px"> <img src="images/paypal.gif" alt="paypal" /></td>
                    <td width="400px;" style="padding: 0px 20px;">Recommended if you have a PayPal account. Fastest delivery time.
                    </td>
                    <td><a href="#" class="more">PAYPAL</a></td>
                </tr>
                <tr>
                    <td  height="80px"><img src="images/2co.gif" alt="paypal" />
                    </td>
                    <td  width="400px;" style="padding: 0px 20px;">2Checkout.com, Inc. is an authorized retailer of goods and services provided by Template-Guide.com
2CheckOut accepts customer orders via online checks, Visa, MasterCard, Discover, American Express, Diners, JCB and debit cards with the Visa, Mastercard logo. Sed laoreet ornare ligula eu blandit. Validate <a href="http://validator.w3.org/check?uri=referer" rel="nofollow"><strong>XHTML</strong></a> &amp; <a href="http://jigsaw.w3.org/css-validator/check/referer" rel="nofollow"><strong>CSS</strong></a>.
                    </td>
                    <td><a href="#" class="more">2CHECKOUT</a></td>
                </tr>
            </table>
		</div>
        <div class="cleaner"></div>
    </div> <!-- END of templatemo_main -->
    
    <s:action name="webcontrol_footer" executeResult="true" />	
    
</div> <!-- END of templatemo_wrapper -->

</body>
</html>