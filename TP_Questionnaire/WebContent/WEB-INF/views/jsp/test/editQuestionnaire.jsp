<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri = "http://www.springframework.org/tags" prefix="spring"%>


<div class="row">
	<div class="col s3">
		<h5>Formulaire questionnaire</h5>
		<form method="post">
			<input type="hidden" name="questionnaire_id" value="${ questionnaire.idQuestionnaire }" />
			
			<div class="input-field">
				<input id="questionnaire_nom" type="text" class="validate" name="questionnaire_nom" value="${ questionnaire.nomQuestionnaire }" />
				<label for="questionnaire_nom">Nom</label>
			</div>
			
			<button class="btn waves-effect waves-light" type="submit">
				Valider <i class="material-icons right">send</i>
			</button>
		</form>
	</div>
	
	<div class="col s9">
		<c:if test="${ questionnaire.idQuestionnaire != null }">
			<div class="fixed-action-btn">
				<a href="${ pageContext.request.contextPath }/editQuestion?questionnaire_id=${ questionnaire.idQuestionnaire }" class="btn-floating btn-large red">
					<i class="large material-icons">add</i>
				</a>
			</div>
			
			
			<h5>Liste des questions</h5>
			

			<div class="row">
				<ul class="collapsible" data-collapsible="accordion">
					<c:forEach items="${ questionnaire.questions }" var="question">
						<li>
							<div class="collapsible-header">
								<a href="${ pageContext.request.contextPath }/editQuestion?questionnaire_id=${ questionnaire.idQuestionnaire }&question_id=${ question.idQuestion }"><i class="material-icons">mode_edit</i></a>
								<a href="${ pageContext.request.contextPath }/deleteQuestion?questionnaire_id=${ questionnaire.idQuestionnaire }&question_id=${ question.idQuestion }"><i class="material-icons">delete</i></a>
								Nom: ${ question.texteQuestion }
							</div>
							
							<div class="collapsible-body">
								<p>
									ID : ${ question.idQuestion }<br />
									Nom: ${ question.texteQuestion }<br />
									Nombre propositions : ${ question.propositions.size() }
								</p>
							</div>
						</li>
					</c:forEach>
				</ul>
			</div>
		</c:if>
	</div>
</div>