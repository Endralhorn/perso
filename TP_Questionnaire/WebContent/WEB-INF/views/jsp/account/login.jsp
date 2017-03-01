<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri = "http://www.springframework.org/tags" prefix="spring"%>

<form method="post" action="${ pageContext.request.contextPath }/account/login">
	<input type="hidden" name="action" value="login" />
	
	<div class="input-field">
		<i class="material-icons prefix">account_circle</i>
		<input id="name" type="text" class="validate" name="username" />
		<label for="name">Votre nom</label>
		<form:errors path="userPass"/>
		
	</div>
	
	<div class="input-field">
		<i class="material-icons prefix">vpn_key</i>
		<input id="password" type="password" class="validate" name="password" />
		<label for="password">Votre mot de passe</label>
		<form:errors path="userPass"/>		
	</div>
	
	<button class="btn waves-effect waves-light" type="submit">
		OK <i class="material-icons right">send</i>
	</button>
	
	<a href="${ pageContext.request.contextPath }/subscribe" class="btn waves-effect waves-light" type="submit">
		S'inscrire
	</a>
</form>