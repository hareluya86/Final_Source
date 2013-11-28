<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<div class="sidebar_box"><span class="bottom"></span>
	<h3>Categories</h3>   
	<div class="content"> 
		<ul class="sidebar_list">		
			<s:iterator value="categories" status="category">
				<s:if test="%{#category.first}">
					<li class="first">
						<a href='<s:url action="products"><s:param name="categoryId" value="id" /></s:url>'>
							<s:property value="name" />
						</a>	
					</li>
				</s:if>
				<s:elseif test="%{#category.last}">
					<li class="last">
						<a href='<s:url action="products"><s:param name="categoryId" value="id" /></s:url>'>
							<s:property value="name" />
						</a>
					</li>
				</s:elseif>
				<s:else>
					<li>
						<a href='<s:url action="products"><s:param name="categoryId" value="id" /></s:url>'>
							<s:property value="name" />
						</a>
					</li>
				</s:else>
			</s:iterator>		

			<!-- 
			<li class="first"><a href="#">Aenean varius nulla</a></li>
			<li><a href="#">Cras mattis arcu</a></li>
			<li><a href="#">Donec turpis ipsum</a></li>
			<li><a href="#">Fusce sodales mattis</a></li>
			<li><a href="#">Maecenas et mauris</a></li>
			<li><a href="#">Mauris nulla tortor</a></li>
			<li><a href="#">Nulla odio ipsum</a></li>
			<li><a href="#">Nunc ac viverra nibh</a></li>
			<li><a href="#">Praesent id venenatis</a></li>
			<li><a href="#">Quisque odio velit</a></li>
			<li><a href="#">Suspendisse posuere</a></li>
			<li><a href="#">Tempus lacus risus</a></li>
			<li><a href="#">Ut tincidunt imperdiet</a></li>
			<li><a href="#">Vestibulum eleifend</a></li>
			<li class="last"><a href="#">Velit mi rutrum diam</a></li>
			-->
		</ul>
	</div>
</div>
