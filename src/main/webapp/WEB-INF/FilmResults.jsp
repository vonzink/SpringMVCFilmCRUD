<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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

<!-- Update Film Form -->
<form action="updateFilm.do" method="POST">
  <input type="hidden" name="id" value="${film.id}">

  <table>
    <tr>
      <td><label for="title">Edit Title:</label></td>
      <td><input type="text" name="title" id="title" value="${film.title}"></td>
    </tr>
    <tr>
      <td><label for="description">Edit Description:</label></td>
      <td>
        <textarea name="description" id="description" rows="6" cols="20" style="resize: both;">${film.description}</textarea>
      </td>
    </tr>
    <tr>
      <td><label for="year">Edit Year:</label></td>
      <td><input type="number" name="year" id="year" value="${film.year}"></td>
    </tr>
    <tr>
      <td><label for="rating">Edit Rating:</label></td>
      <td>
        <select name="rating" id="rating">
          <option value="G" ${film.rating == 'G' ? 'selected' : ''}>G</option>
          <option value="PG" ${film.rating == 'PG' ? 'selected' : ''}>PG</option>
          <option value="PG-13" ${film.rating == 'PG-13' ? 'selected' : ''}>PG-13</option>
          <option value="R" ${film.rating == 'R' ? 'selected' : ''}>R</option>
          <option value="NC-17" ${film.rating == 'NC-17' ? 'selected' : ''}>NC-17</option>
        </select>
      </td>
    </tr>
    <tr>
      <td><label for="languageId">Edit Language ID:</label></td>
      <td><input type="number" name="languageId" id="languageId" value="${film.languageId}"></td>
    </tr>
    <tr>
      <td><label for="rentalRate">Edit Rental Rate:</label></td>
      <td><input type="number" name="rentalRate" id="rentalRate" value="${film.rentalRate}" step="0.01"></td>
    </tr>
    <tr>
      <td><label for="rentalDuration">Edit Rental Duration:</label></td>
      <td><input type="number" name="rentalDuration" id="rentalDuration" value="${film.rentalDuration}" step="0.01"></td>
    </tr>
    <tr>
      <td><label for="replacementCost">Edit Replacement Cost:</label></td>
      <td><input type="number" name="replacementCost" id="replacementCost" value="${film.replacementCost}"  step="0.01"></td>
    </tr>
    <tr>
      <td><label for="length">Edit Film Length:</label></td>
      <td><input type="number" name="length" id="length" value="${film.length}"></td>
    </tr>
    <tr>
      <td colspan="2" style="text-align: center; padding-top: 10px;">
        <button type="submit">Update Film</button>
      </td>
    </tr>
  </table>
</form>

<!-- Display message if any -->
<c:if test="${not empty message}">
  <h3>${message}</h3>
</c:if>

<!-- Back to Home Button -->
<form action="home.do" method="GET" style="margin-top: 20px;">
  <button type="submit">Back to Home</button>
</form>

<!-- Delete Film Button -->
<form action="deleteFilm.do" method="POST" style="margin-top: 20px;">
  <input type="hidden" name="filmId" value="${film.id}">
  
  <br>
  <h2>Delete Film</h2>
  <button type="submit">DELETE</button>
</form>

</body>
</html>