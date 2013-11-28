<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<div class="sidebar_box"><span class="bottom"></span>
	<h3>Best Sellers </h3>   
	<div class="content">
	
		<s:iterator value="products" status="product">
			<div class="bs_box">
				<a href='<s:url action="productdetail"><s:param name="productId" value="id" /></s:url>'>
					<img src='<s:property value="images[0].thumbnail" />' alt='<s:property value="name" />' />
				</a>
				<h4>
					<a href='<s:url action="productdetail"><s:param name="productId" value="id" /></s:url>'>
						<s:property value="name" />
					</a>
				</h4>
				<p class="price">$<s:property value="getText('{0,number,#,##0.00}',{salePrice})"/></p>
				<div class="cleaner"></div>
			</div>
		</s:iterator>	
	
	<!-- 
		<div class="bs_box">
			<a href="#"><img src="images/templatemo_image_01.jpg" alt="Image 01" /></a>
			<h4><a href="#">Donec nunc nisl</a></h4>
			<p class="price">$10</p>
			<div class="cleaner"></div>
		</div>
		<div class="bs_box">
			<a href="#"><img src="images/templatemo_image_01.jpg" alt="Image 02" /></a>
			<h4><a href="#">Aenean eu tellus</a></h4>
			<p class="price">$12</p>
			<div class="cleaner"></div>
		</div>
		<div class="bs_box">
			<a href="#"><img src="images/templatemo_image_01.jpg" alt="Image 03" /></a>
			<h4><a href="#">Phasellus ut dui</a></h4>
			<p class="price">$20</p>
			<div class="cleaner"></div>
		</div>
		<div class="bs_box">
			<a href="#"><img src="images/templatemo_image_01.jpg" alt="Image 04" /></a>
			<h4><a href="#">Vestibulum ante</a></h4>
			<p class="price">$16</p>
			<div class="cleaner"></div>
		</div>
	-->
	</div>
</div>