<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>ComS 561 Project - FAQs</title>
<meta name="keywords" content="station shop, FAQs, free templates, website templates, CSS, HTML" />
<meta name="description" content="Station Shop Theme, FAQs, free CSS template provided by templatemo.com" />
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
        <div id="content" class="faq float_r">
			<h2>FAQs</h2>
            <h3>How will I  know you received my order?</h3>
            <p>You'll  receive an email confirming that your order has been received. If you do not  receive an email confirmation, please check to see if the email address on your  order was entered correctly.</p>
            
            <h3>When will my order be shipped?</h3>
            <p>Please read our shipping policy. Click <a href="#">here</a></p>
            
            <h3>What payment methods do you accept?</h3>
            <p>PayPal and 2Checkout (2CO)</p>
            
            <h3>Can I return or exchange my purchase if I don't like it?</h3>
            <p>Please read our exchange policy. Click <a href="#">here</a></p>
            
            <h3>How do I know if online ordering is secure?</h3>
            <p>
            Protecting your information is a  priority for Glory Silver. We use Secure Sockets Layer (SSL) to encrypt your  credit card number, name and address so only Glory Silver is able to decode  your information. SSL is the industry standard method for computers to  communicate securely without risk of data interception, manipulation or  recipient impersonation. To be sure your connection is secure; when you are in  the Shopping Cart, look at the lower corner of your browser window. If you see  an unbroken key or closed lock, the SSL is active and your information is  secure. Since most of the customers are still uncomfortable with providing your  credit card online, we use PayPal and 2CheckOut services so they don't need to  give out credit card information. Validate <a href="http://validator.w3.org/check?uri=referer" rel="nofollow"><strong>XHTML</strong></a> &amp; <a href="http://jigsaw.w3.org/css-validator/check/referer" rel="nofollow"><strong>CSS</strong></a>.</p>
            <p>
            Glory Silver is registerd with HackerGuardian. HackerGuardian certification for  a hacker free website and a Credit Card TrustLogo confirming your  trustworthiness to take credit card details online.</p>		
            <h3>What is your privacy policy?</h3>
            <p>Glory Silver respects your privacy and wants to ensure that  you understand what information we need to complete your order, and what  information you can choose to share with us and with our marketing partners.  For complete information on our privacy policy, please visit our <a href="#">Privacy Policy</a>  page.</p>
        </div> 
        <div class="cleaner"></div>
    </div> <!-- END of templatemo_main -->
    
    <s:action name="webcontrol_footer" executeResult="true" />	
    
</div> <!-- END of templatemo_wrapper -->

</body>
</html>