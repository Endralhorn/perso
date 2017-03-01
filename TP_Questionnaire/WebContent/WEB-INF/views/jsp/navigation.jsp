<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri = "http://www.springframework.org/tags" prefix="spring"%>

<nav>
	<div class="nav-wrapper">
		<div class="container">
			<a href="#" class="brand-logo">Tetris - ${ titleCode }</a>
			
			<c:if test="${ utilisateur != null }">
				<ul id="nav-mobile" class="right hide-on-med-and-down">
					<li><a href="${ pageContext.request.contextPath }/home">Accueil</a></li>
					<li><a href="${ pageContext.request.contextPath }/tetriminos">Tetriminos</a></li>
					<li><a href="${ pageContext.request.contextPath }/parties">Parties</a></li>
				</ul>
			</c:if>
		</div>
	</div>
</nav>