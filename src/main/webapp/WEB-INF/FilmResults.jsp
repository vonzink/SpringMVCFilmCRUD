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
	<h1>FILM RESULTS</h1>
	
<c:if test="${not empty film}">
	<h2>${film.title}</h2>

</c:if>


<form action="updateFilm.do" method="POST">
  <input type="hidden" name="id" value="${film.id}">

  <table>
    <tr>
      <td><label for="title">Edit Title:</label></td>
      <td><input type="text" name="title" value="${film.title}"></td>
    </tr>
    <tr>
      <td><label for="description">Edit Description:</label></td>
      <td><input type="text" name="description" value="${film.description}"></td>
    </tr>
    <tr>
      <td><label for="year">Edit Year:</label></td>
      <td><input type="number" name="year" value="${film.year}"></td>
    </tr>
    <tr>
      <td><label for="rating">Edit Rating:</label></td>
      <td><input type="text" name="rating" value="${film.rating}"></td>
    </tr>
    <tr>
      <td><label for="languageId">Edit Language ID:</label></td>
      <td><input type="number" name="languageId" value="${film.languageId}"></td>
    </tr>
    <tr>
      <td><label for="rentalRate">Edit Rental Rate:</label></td>
      <td><input type="number" name="rentalRate" value="${film.rentalRate}"></td>
    </tr>
    <tr>
      <td><label for="rentalDuration">Edit Rental Duration:</label></td>
      <td><input type="number" name="rentalDuration" value="${film.rentalDuration}"></td>
    </tr>
    <tr>
      <td><label for="replacementCost">Edit Replacement Cost:</label></td>
      <td><input type="number" name="replacementCost" value="${film.replacementCost}"></td>
    </tr>
    <tr>
      <td><label for="length">Edit Film Length:</label></td>
      <td><input type="number" name="length" value="${film.length}"></td>
    </tr>
    <br>	
    <tr>
      <td colspan="2" style="text-align: center;">
        <button type="submit">Update Film</button>
      </td>
    </tr>
  </table>
</form>
	
<c:if test="${not empty message}">
    <h3>${message }</h3>
</c:if>

<br>

<form action="home.do" method="GET">
    <button type="submit">Back to Home</button>
</form>
	<form action="deleteFilm.do" method="POST">
		<input type="hidden" name="filmId" value="${film.id}">
		<h2>Delete Film</h2>
		<button type="submit">DELETE</button>
	</form>
</body>
</html>