<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri = "http://www.springframework.org/tags" prefix="spring"%>


div class="fixed-action-btn">
	<a href="editTetrimino" class="btn-floating btn-large red">
		<i class="large material-icons">add</i>
	</a>
</div>



<div class="row">
	<c:forEach items="${ tetriminos }" var="tetrimino">
		<div class="col l3 s12">
			<div class="card">
				<div class="card-image waves-effect waves-block waves-light">
					<div class="activator valign-wrapper" style="height:17em; background-color:#${ tetrimino.couleur };">
						<h5 class="valign white-text center-align" style="width: 100%;">${ tetrimino.nom }</h5>
					</div>
				</div>
				
				<div class="card-content">
					<span class="card-title activator grey-text text-darken-4">${ tetrimino.nom }<i class="material-icons right">more_vert</i></span>
					
					<p>
						<a class="activator" href="#">Détails</a>
					</p>
				</div>
				
				
				<c:if test="${ montrerActions }">
					<div class="card-action">
						<a href="${ pageContext.request.contextPath }/deleteTetrimino?tetrimino_id=${ tetrimino.id }">RETIRER</a>
						<a href="${ pageContext.request.contextPath }/editTetrimino?tetrimino_id=${ tetrimino.id }">EDITER</a>
					</div>
				</c:if>
				
				<div class="card-reveal">
					<span class="card-title grey-text text-darken-4">${ tetrimino.nom }<i class="material-icons right">close</i></span>
					<table>
						<thead>
							<tr>
								<th data-field="name">Attribut</th>
								<th data-field="valeur">Valeur</th>
							</tr>
						</thead>
						
						<tbody>
							<tr>
								<td>ID</td>
								<td>${ tetrimino.id }</td>
							</tr>
							
							<tr>
								<td>Nom</td>
								<td>${ tetrimino.nom }</td>
							</tr>
							
							<tr>
								<td>Couleur</td>
								<td>${ tetrimino.couleur }</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</c:forEach>
</div>