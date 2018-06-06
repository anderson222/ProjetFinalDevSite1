<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Page Demande Admission</title>
</head>

<body>
	<h1>Demande d'admission</h1>

	<p> Ultricies eget, tempor sit amet, ante. <br>Donec eu libero sit amet
		quam egestas semper. Aenean ultricies mi vitae est. <br>Mauris placerat
		eleifend leo. Quisque sit amet est et sapien ullamcorper pharetra.
		Vestibulum erat wisi, condimentum sed, commodo vitae, ornare sit amet,
		wisi. Aenean fermentum, elit eget tincidunt condimentum, eros ipsum
		rutrum orci, sagittis tempus lacus enim ac dui. Donec non enim in
		turpis pulvinar facilisis. Ut felis. <br>Praesent dapibus, neque id cursus
		faucibus, tortor neque egestas augue, eu vulputate magna eros eu erat.<br>
		Aliquam erat volutpat. Nam dui mi, tincidunt quis, accumsan porttitor,
		facilisis luctus, metus </p>

	<br>

	<form action="SoumettreDossierEtudiantServlet" enctype="multipart/form-data" method="post" >
	
		Prénom <br>
		<input type="text" name="champ_prenom" /> <br> 
		<br>
		
		Nom <br>
		<input type="text" name="champ_nom" /> <br> 
		<br>
		
		Courriel <br>
		<input type="email" name="champ_courriel" /> <br>
		<br>

		<h3>Programme d'inscription</h3>
		
		<c:forEach items="${liste_programmes}" var="prog">
		<c:out value="${prog['description']}"/> <input type="checkbox" name="choix_programme" value="<c:out value="${prog['description']}"/>"/>
		<br>
		</c:forEach>
		<br>

		<h3>Session</h3>
		
		<c:forEach items="${liste_sessions}" var="session">
		<c:out value="${session['description']}"/> <input type="checkbox" name="choix_session" value="<c:out value="${session['description']}"/>"/>
		<br>
		</c:forEach>
		<br> 
		
		<br> 	
		 <input type="file" name="files"  multiple >
		<br>
		<br>
		<br>
		<br>
		
		<input type="submit" value="Soumettre" />
		
	</form>

</body>
</html>