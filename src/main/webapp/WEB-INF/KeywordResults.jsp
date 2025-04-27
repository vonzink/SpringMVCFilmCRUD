<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
   <%@ taglib uri="jakarta.tags.core" prefix="c" %>

    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Film Results</title>
</head>
<body>
  <h2>Search Results:</h2>

  <c:forEach var="film" items="${films}">
      <h3>Title: ${film.title}</h3>
      
      <p><strong>Description:</strong> ${film.description}</p>
      <p><strong>Release Year:</strong> ${film.year}</p>
      <p><strong>Language:</strong> ${film.language}</p>
      <p><strong>Rating:</strong> ${film.rating}</p>
      <p><strong>Length:</strong> ${film.length} minutes</p>
      <p><strong>ID:</strong> ${film.id}</p>

		<form action="getFilm.do" method="POST">
		<input type="hidden" name="filmId" value="${film.id}">
		 <button type="submit">Update</button>
		</form>
		<br>
        <form action="deleteFilm.do" method="POST">
		<input type="hidden" name="filmId" value="${film.id}">
		 <button type="submit">Delete</button>
		</form>
	
      <h4>Actors:</h4>
      <ul>
        <c:forEach var="actor" items="${film.actors}">
          <li>${actor.firstName} ${actor.lastName}</li>
        </c:forEach>
      </ul>
      
      <h4>Categories:</h4>
	<c:if test="${not empty film.categories}">
  	<ul>
    	<c:forEach var="category" items="${film.categories}">
      		<li>${category.name}</li>
    	</c:forEach>
  		</ul>
	</c:if>

<c:if test="${empty film.categories}">
  <p>No categories found for this film.</p>
</c:if>
  </c:forEach>

<c:if test="${not empty message}">
    <h3>${message }</h3>
    
</c:if>
<form action="home.do" method="GET">
    <button type="submit">Back to Home</button>

</form>
</body>
</html>