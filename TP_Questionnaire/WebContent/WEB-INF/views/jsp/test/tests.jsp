<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri = "http://www.springframework.org/tags" prefix="spring"%>




<div class="fixed-action-btn">
	<a href="editTest" class="btn-floating btn-large red">
		<i class="large material-icons">add</i>
	</a>
</div>



<div class="row">
	<c:forEach items="${ tests }" var="test">
		<div class="col l3 s12">
			<div class="card">
				<div class="card-image waves-effect waves-block waves-light">
					<div class="activator valign-wrapper" style="height:17em; background-color:grey;">
						<h5 class="valign white-text center-align" style="width: 100%;">${ test.nomTest }</h5>
					</div>
				</div>
				
				<div class="card-content">
					<span class="card-title activator grey-text text-darken-4">${ test.nomTest }<i class="material-icons right">more_vert</i></span>
					
					<p>
						<a class="activator" href="#">Détails</a>
					</p>
				</div>
				
				
				<c:if test="${ montrerActions }">
					<div class="card-action">
<%-- 						<a href="${ pageContext.request.contextPath }/deleteTest?test_id=${ test.id }">RETIRER</a> --%>
						<a href="${ pageContext.request.contextPath }/editTest?test_id=${ test.id }">EDITER</a>
					</div>
				</c:if>
				
				<div class="card-reveal">
					<span class="card-title grey-text text-darken-4">${ test.nomTest }<i class="material-icons right">close</i></span>
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
								<td>${ test.id }</td>
							</tr>
							
							<tr>
								<td>Nom</td>
								<td>${ test.nomTest }</td>
							</tr>
							
							<tr>
								<td>Questionnaires</td>
								<td>${ test.questionnaires.size() }</td>
							</tr>
							
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</c:forEach>
</div>