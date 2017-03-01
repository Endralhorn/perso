<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri = "http://www.springframework.org/tags" prefix="spring"%>

<h1>Bienvenue ${ administrateur.prenom } ${ administrateur.nom } !</h1>

<form method="post" action="${ pageContext.request.contextPath }/logout">
<!-- 	<input type="hidden" name="action" value="logout" /> -->
	
	<button class="btn waves-effect waves-light" type="submit">
		Se déconnecter <i class="material-icons right">lock</i>
	</button>
</form>