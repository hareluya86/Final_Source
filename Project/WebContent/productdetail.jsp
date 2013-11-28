<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>ComS 561 Project</title>
<meta name="keywords" content="station shop, product detail, web design theme, free website template, templatemo" />
<meta name="description" content="Station Shop Theme, Product Detail, free template provided by templatemo.com" />
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
        	
            <h1><s:property value="product.name" /></h1>
            <div class="content_half float_l">
        	<a  rel="lightbox[portfolio]" href='<s:property value="product.images[0].image" />'><img src='<s:property value="product.images[0].thumbnail" />' alt='<s:property value="product.name" />' /></a>
            </div>
            <div class="content_half float_r">
				<table>
                    <tr>
                        <td height="30" width="160">Price:</td>
                        <td>$<s:property value="getText('{0,number,#,##0.00}',{product.salePrice})"/></td>
                    </tr>
                    <tr>
                        <td height="30">Availability:</td>
                        <td>In Stock</td>
                    </tr>
                    <tr>
                        <td height="30">Model:</td>
                        <td><s:property value="product.partNumber" /></td>
                    </tr>
                    <tr><td height="30">Quantity</td><td><input type="text" value="1" style="width: 20px; text-align: right" /></td></tr>
                </table>
                <div class="cleaner h20"></div>
                <a href='<s:url action="addtocart"><s:param name="product" value="id" /></s:url>' class="add_to_card">Add to Cart</a>
			</div>
            <div class="cleaner h30"></div>
            
            <h5>Product Description</h5>
            <p><s:property value="product.description" /></p>	
            
            <div class="cleaner h50"></div>
            
            <h4>Other Images</h4>
            <s:iterator value="product.images" status="image">
            	<s:if test="%{#image.first}"></s:if>
            	<s:else>
		        	<div class="product_box">
		            	<a href='<s:property value="image"/>'><img src='<s:property value="thumbnail"/>' alt="" /></a>
		            </div>              	
            	</s:else>
			</s:iterator>
			
                        
            <!-- Optional Suggested Products Styles
            <h4>Etiam In Tellus</h4>
        	<div class="product_box">
            	<a href="productdetail.html"><img src="images/product/01.jpg" alt="Image 01" /></a>
                <h3>Ut eu feugiat</h3>
                <p class="product_price">$ 100</p>
                  <a href="shoppingcart.html" class="add_to_card">Add to Cart</a>
                <a href="<s:url action="addtocart" />" class="add_to_card">Add to Cart</a>  
                <a href="productdetail.html" class="detail">Detail</a>
            </div>        	
            <div class="product_box">
            	<a href="productdetail.html"><img src="images/product/02.jpg" alt="Image 02" /></a>
                <h3>Curabitur et turpis</h3>
                <p class="product_price">$ 200</p>
                <a href="shoppingcart.html" class="add_to_card">Add to Cart</a>
                <a href="productdetail.html" class="detail">Detail</a>
            </div>        	
            <div class="product_box no_margin_right">
            	<a href="productdetail.html"><img src="images/product/03.jpg" alt="Image 03" /></a>
                <h3>Mauris consectetur</h3>
                <p class="product_price">$ 120</p>
                <a href="shoppingcart.html" class="add_to_card">Add to Cart</a>
                <a href="productdetail.html" class="detail">Detail</a>
            </div>     
            -->
        </div> 
        <div class="cleaner"></div>
    </div> <!-- END of templatemo_main -->
    
    <s:action name="webcontrol_footer" executeResult="true" />	
    
</div> <!-- END of templatemo_wrapper -->

</body>
</html>