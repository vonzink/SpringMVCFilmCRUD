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

      <h4>Actors:</h4>
      <ul>
        <c:forEach var="actor" items="${film.actors}">
          <li>${actor.firstName} ${actor.lastName}</li>
        </c:forEach>
      </ul>

    </div>
  </c:forEach>


<c:if test="${not empty message}">
    <h3>${message }</h3>
    
  <p>No films found matching your keyword.</p>
</c:if>
</body>
</html>