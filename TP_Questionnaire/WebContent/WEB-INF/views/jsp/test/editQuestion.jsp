<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri = "http://www.springframework.org/tags" prefix="spring"%>


<div class="row">
	<div class="col s3">
		<h5>Formulaire tetrimino</h5>
		<form method="post">
			<input type="hidden" name="tetrimino_id" value="${ tetrimino.id }" />
			
			<div class="input-field">
				<input id="tetrimino_nom" type="text" class="validate" name="tetrimino_nom" value="${ tetrimino.nom }" />
				<label for="tetrimino_nom">Nom</label>
			</div>
			
			<div class="input-field">
				<input id="tetrimino_couleur" type="text" class="validate" name="tetrimino_couleur" value="${ tetrimino.couleur }" />
				<label for="tetrimino_couleur">Couleur</label>
			</div>
			
			<button class="btn waves-effect waves-light" type="submit">
				Valider <i class="material-icons right">send</i>
			</button>
		</form>
	</div>
	
	<div class="col s9">
		<c:if test="${ tetrimino.id != null }">
			<div class="fixed-action-btn">
				<a href="${ pageContext.request.contextPath }/editBloc?tetrimino_id=${ tetrimino.id }" class="btn-floating btn-large red">
					<i class="large material-icons">add</i>
				</a>
			</div>
			
			
			<h5>Liste des blocs</h5>
			
<!-- 			<div class="row"> -->
<!-- 				<div class="col s1"> -->
<!-- 					<table class="striped centered"> -->
<%-- 						<c:forEach begin="0" end="3" step="1" var="i"> --%>
<!-- 							<tr> -->
<%-- 								<c:forEach begin="0" end="3" step="1" var="j"> --%>
<!-- 									<td> -->
<%-- 										<c:set var="bloc" value="${ tetrimino.findBloc(j, i) }" /> --%>
										
<%-- 										<c:if test="${ bloc != null }"> --%>
<%-- 											<a href="${ pageContext.request.contextPath }/deleteBloc?tetrimino_id=${ tetrimino.id }&bloc_id=${ bloc.id }"><i class="material-icons">delete</i></a> --%>
<%-- 											<a href="${ pageContext.request.contextPath }/editBloc?tetrimino_id=${ tetrimino.id }&bloc_id=${ bloc.id }">${ bloc.poids }</a> --%>
<%-- 										</c:if> --%>
										
<%-- 										<c:if test="${ bloc == null }"> --%>
<%-- 											<a href="${ pageContext.request.contextPath }/editBloc?tetrimino_id=${ tetrimino.id }&position_x=${ j }&position_y=${ i }"> --%>
<!-- 												<i class="material-icons">add</i> -->
<!-- 											</a> -->
<%-- 										</c:if> --%>
<!-- 									</td> -->
<%-- 								</c:forEach> --%>
<!-- 							</tr> -->
<%-- 						</c:forEach> --%>
<!-- 					</table> -->
<!-- 				</div> -->
<!-- 			</div> -->
			
			
			<div class="row">
				<ul class="collapsible" data-collapsible="accordion">
					<c:forEach items="${ tetrimino.blocs }" var="bloc">
						<li>
							<div class="collapsible-header">
								<a href="${ pageContext.request.contextPath }/editBloc?tetrimino_id=${ tetrimino.id }&bloc_id=${ bloc.id }"><i class="material-icons">mode_edit</i></a>
								<a href="${ pageContext.request.contextPath }/deleteBloc?tetrimino_id=${ tetrimino.id }&bloc_id=${ bloc.id }"><i class="material-icons">delete</i></a>
								x: ${ bloc.positionX }, y: ${ bloc.positionY }
							</div>
							
							<div class="collapsible-body">
								<p>
									Poids : ${ bloc.poids }<br />
									Position X : ${ bloc.positionX }<br />
									Position Y : ${ bloc.positionY }
								</p>
							</div>
						</li>
					</c:forEach>
				</ul>
			</div>
		</c:if>
	</div>
</div>