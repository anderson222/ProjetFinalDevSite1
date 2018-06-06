<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Page de confirmation</title>
</head>
<body>
<h2>Demande d'admission envoyée</h2>

<h2>Informations personnelles :</h2>
<h3><c:out value="${requestScope.prenom}"/></h3>
<h3><c:out value="${requestScope.nom}"/></h3>
<h3><c:out value="${requestScope.courriel}"/></h3>
<br>

<h2>Choix des programmes : </h2>

<c:forEach items="${requestScope.choix_prog}" var="prog">
<h3><c:out value="${prog}" /></h3>
</c:forEach>

	<br>

<h2>Choix des sessions : </h2>

<c:forEach items="${requestScope.choix_session}" var="session">
<h3><c:out value="${session}" /></h3>
</c:forEach>

</body>
</html>