<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri = "http://www.springframework.org/tags" prefix="spring"%>


<div class="row">
	<div class="col s3">
		<h5>Formulaire test</h5>
		<form method="post">
			<input type="hidden" name="test_id" value="${ test.id }" />
			
			<div class="input-field">
				<input id="test_nom" type="text" class="validate" name="test_nom" value="${ test.nomTest }" />
				<label for="test_nom">Nom</label>
			</div>
			
			<button class="btn waves-effect waves-light" type="submit">
				Valider <i class="material-icons right">send</i>
			</button>
		</form>
	</div>
	
	<div class="col s9">
		<c:if test="${ test.id != null }">
			<div class="fixed-action-btn">
				<a href="${ pageContext.request.contextPath }/editQuestionnaire?test_id=${ test.id }" class="btn-floating btn-large red">
					<i class="large material-icons">add</i>
				</a>
			</div>
			
			
			<h5>Liste des questionnaires</h5>
				
			
			<div class="row">
				<ul class="collapsible" data-collapsible="accordion">
					<c:forEach items="${ test.questionnaires }" var="bloc">
						<li>
							<div class="collapsible-header">
								<a href="${ pageContext.request.contextPath }/editQuestionnaire?test_id=${ test.id }&questionnaire_id=${ questionnaire.idQuestionnaire }"><i class="material-icons">mode_edit</i></a>
								<a href="${ pageContext.request.contextPath }/deleteQuestionnaire?test_id=${ test.id }&questionnaire_id=${ questionnaire.idQuestionnaire }"><i class="material-icons">delete</i></a>
								Nom: ${ questionnaire.nomQuestionnaire }
							</div>
							
							<div class="collapsible-body">
								<p>
									ID: ${ questionnaire.idQuestionnaire }<br />
									Nom: ${ questionnaire.nomQuestionnaire }<br />
									Nombre Questions: ${ questionnaire.questions.size() }
								</p>
							</div>
						</li>
					</c:forEach>
				</ul>
			</div>
		</c:if>
	</div>
</div>