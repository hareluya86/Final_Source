<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>ComS 561 Project - Search</title>
<meta name="keywords" content="station shop, products, theme, website templates, CSS, HTML" />
<meta name="description" content="Station Shop Products - free CSS template by templatemo.com" />
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
        	<h1>Search Results</h1>
	        	
			<s:iterator value="searchResults" status="product">
				<div class="product_box">
					<a href='<s:url action="productdetail"><s:param name="productId" value="id" /></s:url>'><img src='<s:property value="images[0].thumbnail" />' alt='<s:property value="name" />' /></a>
					<h3><s:property value="name" /></h3>
					<p class="product_price">$<s:property value="getText('{0,number,#,##0.00}',{salePrice})"/></p>
					<a href='<s:url action="shoppingcart"><s:param name="productId" value="id" /></s:url>' class="add_to_card">Add to Cart</a>
					<a href='<s:url action="productdetail"><s:param name="productId" value="id" /></s:url>' class="detail">Detail</a>
				</div>
			</s:iterator>	
        	<!--
            <div class="product_box">
            	<a href="productdetail.html"><img src="images/product/01.jpg" alt="Image 01" /></a>
                <h3>Integer eleifend sed</h3>
                <p class="product_price">$ 100</p>
                <a href="shoppingcart.html" class="add_to_card">Add to Cart</a>
                <a href="productdetail.html" class="detail">Detail</a>
            </div>        	
            <div class="product_box">
            	<a href="productdetail.html"><img src="images/product/02.jpg" alt="Image 02" /></a>
                <h3>Nam cursus facilisis</h3>
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
            <div class="product_box">
            	<a href="productdetail.html"><img src="images/product/04.jpg" alt="Image 04" /></a>
                <h3>Proin volutpat</h3>
                <p class="product_price">$ 260</p>
                <a href="shoppingcart.html" class="add_to_card">Add to Cart</a>
                <a href="productdetail.html" class="detail">Detail</a>
            </div>        	
            <div class="product_box">
            	<a href="productdetail.html"><img src="images/product/05.jpg" alt="Image 05" /></a>
                <h3>Aenean tempus</h3>
                <p class="product_price">$ 80</p>
                <a href="shoppingcart.html" class="add_to_card">Add to Cart</a>
                <a href="productdetail.html" class="detail">Detail</a>
            </div>        	
            <div class="product_box no_margin_right">
            	<a href="productdetail.html"><img src="images/product/06.jpg" alt="Image 06" /></a>
                <h3>Nulla luctus urna</h3>
                <p class="product_price">$ 193</p>
                <a href="shoppingcart.html" class="add_to_card">Add to Cart</a>
                <a href="productdetail.html" class="detail">Detail</a>
            </div>        	
            <div class="product_box">
            	<a href="productdetail.html"><img src="images/product/07.jpg" alt="Image 07" /></a>
                <h3>Pellentesque, Validate <a href="http://validator.w3.org/check?uri=referer" rel="nofollow"><strong>XHTML</strong></a> &amp; <a href="http://jigsaw.w3.org/css-validator/check/referer" rel="nofollow"><strong>CSS</strong></a>.</h3>
                <p class="product_price">$ 30</p>
                <a href="shoppingcart.html" class="add_to_card">Add to Cart</a>
                <a href="productdetail.html" class="detail">Detail</a>
            </div>        	
            <div class="product_box">
            	<a href="productdetail.html"><img src="images/product/08.jpg" alt="Image 08" /></a>
                <h3>Suspendisse fermentum</h3>
                <p class="product_price">$ 220</p>
                <a href="shoppingcart.html" class="add_to_card">Add to Cart</a>
                <a href="productdetail.html" class="detail">Detail</a>
            </div>        	
            <div class="product_box no_margin_right">
            	<a href="productdetail.html"><img src="images/product/09.jpg" alt="Image 09" /></a>
                <h3>Donec laoreet velit</h3>
                <p class="product_price">$ 65</p>
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