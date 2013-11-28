<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<div id="templatemo_header">
   
   	<div id="site_title">
       	<h1><a href="index">ComS561 Project</a></h1>
    </div>
       
	<div id="header_right">
        <a href="myaccount">My Account</a> | <a href="shoppingcart">My Cart</a> | <a href="checkout">Checkout</a> | <a href="accountlogin">Log In</a>
	</div>
       
    <div class="cleaner"></div>
</div> <!-- END of templatemo_header -->

<div id="templatemo_menu">
	<div id="top_nav" class="ddsmoothmenu">
		<ul>
			<li><a href="index" class="selected">Home</a></li>
			<li><a href="products">Products</a>
				<ul>
					<s:iterator value="categories" status="category">
						<li>
							<a href='<s:url action="products"><s:param name="categoryId" value="id" /></s:url>'>
								<s:property value="name" />
							</a>
						</li>
					</s:iterator>				
				
				<!-- 
					<li><a href="http://www.templatemo.com/page/1">Sub menu 1</a></li>
					<li><a href="http://www.templatemo.com/page/2">Sub menu 2</a></li>
					<li><a href="http://www.templatemo.com/page/3">Sub menu 3</a></li>
				-->
			  </ul>
			</li>
			<li><a href="about">About</a></li>
			<li><a href="faqs">FAQs</a></li>
			<li><a href="checkout">Checkout</a></li>
			<li><a href="contact">Contact</a></li>
		</ul>
		<br style="clear: left" />
	</div> <!-- end of ddsmoothmenu -->
	<div id="menu_second_bar">
		<div id="top_shopping_cart">
			Shopping Cart: 
			<strong>
			<s:if test="%{#session.my_cart != null}">
			<s:property value="%{#session.my_cart.getItemCount()}"/> items
			</s:if>
			<s:elseif test="%{#session.my_cart == null}">
			0 items
			</s:elseif>
			</strong> ( <a href="shoppingcart">Show Cart</a> )
		</div>
		<div id="templatemo_search">
			<s:form action="search" theme="simple">
				<s:textfield value="Search" onfocus="clearText(this)" onblur="clearText(this)" name="searchText" cssClass="txt_field" theme="simple"  />
				<s:submit value=" Search " cssClass="sub_btn" theme="simple" />
			</s:form>
			<!-- 
			<form action="#" method="get">
			  <input type="text" value="Search" name="keyword" id="keyword" title="keyword" onfocus="clearText(this)" onblur="clearText(this)" class="txt_field" />
			  <input type="submit" name="Search" value=" Search " alt="Search" id="searchbutton" title="Search" class="sub_btn"  />
			</form>
			-->
		</div>
		<div class="cleaner"></div>
	</div>
</div> <!-- END of templatemo_menu -->
