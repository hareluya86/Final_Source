<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<div><span class="bottom"></span>
	<h3>Edit Categories</h3>   
	<div class="content"> 
		
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
	</div>
</div>
