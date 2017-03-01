<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri = "http://www.springframework.org/tags" prefix="spring"%>


<div class="row">
	<div class="col s3">
		<h5>Formulaire question</h5>
		<form method="post">
			<input type="hidden" name="tetrimino_id" value="${ question.idQuestion }" />
			
			<div class="input-field">
				<input id="texte_question" type="text" class="validate" name="texte_question" value="${ question.texteQuestion }" />
				<label for="texte_question">Texte question</label>
			</div>
			
			<button class="btn waves-effect waves-light" type="submit">
				Valider <i class="material-icons right">send</i>
			</button>
		</form>
	</div>
	
	<div class="col s9">
		<c:if test="${ question.id != null }">
			<div class="fixed-action-btn">
				<a href="${ pageContext.request.contextPath }/editProposition?question_id=${ question.idQuestion }" class="btn-floating btn-large red">
					<i class="large material-icons">add</i>
				</a>
			</div>
			
			
			<h5>Liste des propositions</h5>
			

			<div class="row">
				<ul class="collapsible" data-collapsible="accordion">
					<c:forEach items="${ question.propositions }" var="bloc">
						<li>
							<div class="collapsible-header">
								<a href="${ pageContext.request.contextPath }/editProposition?question_id=${ tetrimino.id }&proposition_id=${ bloc.id }"><i class="material-icons">mode_edit</i></a>
								<a href="${ pageContext.request.contextPath }/deleteProposition?question_id=${ tetrimino.id }&proposition_id=${ bloc.id }"><i class="material-icons">delete</i></a>
								Proposition: ${ proposition.texteProposition }
							</div>
							
							<div class="collapsible-body">
								<p>
									ID : ${ proposition.idProposition }<br />
									Proposition: ${ proposition.texteProposition }<br />
								</p>
							</div>
						</li>
					</c:forEach>
				</ul>
			</div>
		</c:if>
	</div>
</div>