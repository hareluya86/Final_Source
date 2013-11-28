<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>ComS 561 Project - Shopping Cart</title>
<meta name="keywords" content="station shop, cart, free templates, website templates, CSS, HTML" />
<meta name="description" content="Station Shop, Shopping Cart, free CSS template by templatemo.com" />
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
        	<h1>Shopping Cart</h1>
        	<s:if test="%{#session.my_cart != null}">
        	<table width="680px" cellspacing="0" cellpadding="5">
                   	  	<tr bgcolor="#ddd">
                        	<th width="220" align="left">Image </th> 
                        	<th width="180" align="left">Description </th> 
                       	  	<th width="100" align="center">Quantity </th> 
                        	<th width="60" align="right">Price </th> 
                        	<th width="60" align="right">Total </th> 
                        	<th width="90"> </th>
                      	</tr>
    
                      	<s:iterator value="#session.my_cart.getCartItems()" status="iter">
  							<tr>
                        		<td><img src="<s:property value='getProduct().getImages().get(0).getImage()' />" alt="Image 01" /></td> 
                        		<td><s:property value="getProduct().getName()" /></td> 
                            	<td align="center"><s:text name="quantity"><s:property value="%{getQuantity()}" /></s:text> </td>
                            	<td align="right">$<s:property value="getProduct().getListPrice()" /></td> 
                            	<td align="right">$<s:property value="getTotalCost()" /></td>
                            	<td align="center"> <a href="<s:url action='removefromcart'><s:param name='product' value='getProduct().getId()' /></s:url>" >Remove</a> </td>
							</tr>
						</s:iterator>
                    	<!--
                    	<tr>
                        	<td><img src="images/product/01.jpg" alt="Image 01" /></td> 
                        	<td>Etiam in tellus</td> 
                            <td align="center"><input type="text" value="1" style="width: 20px; text-align: right" /> </td>
                            <td align="right">$100 </td> 
                            <td align="right">$100 </td>
                            <td align="center"> <a href="#">Remove</a> </td>
						</tr>
                        <tr>
                        	<td><img src="images/product/02.jpg" alt="Image 02" /> </td>
                            <td>Hendrerit justo</td> 
                       	  	<td align="center"><input type="text" value="1" style="width: 20px; text-align: right" />  </td>
                            <td align="right">$40  </td>
                            <td align="right">$40 </td>
                            <td align="center"> <a href="#">Remove</a>  </td>
						</tr>
						-->
                        <tr>
                        	<td colspan="3" align="right"  height="30px">Have you modified your basket? Please click here to <a href="shoppingcart.html"><strong>Update</strong></a>&nbsp;&nbsp; <br /> Validate <a href="http://validator.w3.org/check?uri=referer" rel="nofollow"><strong>XHTML</strong></a> &amp; <a href="http://jigsaw.w3.org/css-validator/check/referer" rel="nofollow"><strong>CSS</strong></a>&nbsp;&nbsp; </td>
                            <td align="right" style="background:#ddd; font-weight:bold"> Total </td>
                            <td align="right" style="background:#ddd; font-weight:bold">$<s:property value="#session.my_cart.totalPrice()" /> </td>
                            <td style="background:#ddd; font-weight:bold"> </td>
						</tr>
					</table>
					</s:if>
					<s:elseif test="%{#session.my_cart == null}">
						No items in cart.
						<s:property value="%{#session.my_cart}"/>
					</s:elseif>
                    <div style="float:right; width: 215px; margin-top: 20px;">
                    
					<p><a href="checkout">Proceed to checkout</a></p>
                    <p><a href="javascript:history.back()">Continue shopping</a></p>
                    	
                    </div>
            
        </div> 
        <div class="cleaner"></div>
    </div> <!-- END of templatemo_main -->
    
    <s:action name="webcontrol_footer" executeResult="true" />	
    
</div> <!-- END of templatemo_wrapper -->

</body>
</html>