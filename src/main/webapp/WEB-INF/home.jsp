<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
   <%@ taglib uri="jakarta.tags.core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Welcome to Film Site</h1>
	
	<!-- example form from  -->
	<form action="getFilm.do" method="POST">
      <label for="filmId">Search by Film Id</label><br>
      <input type="text" name="filmId">
      <button>Lookup</button>
      <br>
	</form>
	
    <form action="findFilmByKeyword.do" method="GET">
  		<label for="keyword">Search by Keyword</label><br>
  		<input type="text" id="keyword" name="keyword">
 		<button type="submit">Search</button>
  		<br>
    
    </form> 
	<h1>Add New Film</h1>
	<form action="addFilm.do" method="POST">
  <table>
    <tr>
      <td><label for="title">Add Title:</label></td>
      <td><input type="text" name="title"></td>
    </tr>
    <tr>
      <td><label for="description">Add Description:</label></td>
      <td><input type="text" name="description"></td>
    </tr>
    <tr>
      <td><label for="year">Add Year:</label></td>
      <td><input type="number" name="year"></td>
    </tr>
    <tr>
      <td><label for="rating">Add Rating:</label></td>
      <td><input type="text" name="rating"></td>
    </tr>
    <tr>
      <td><label for="languageId">Add Language:</label></td>
      <td><input type="number" name="languageId"></td>
    </tr>
    <tr>
      <td><label for="rentalRate">Add Rental Rate:</label></td>
      <td><input type="number" name="rentalRate"></td>
    </tr>
    <tr>
      <td><label for="rentalDuration">Add Rental Duration:</label></td>
      <td><input type="number" name="rentalDuration"></td>
    </tr>
    <tr>
      <td><label for="replacementCost">Add Replacement Cost:</label></td>
      <td><input type="number" name="replacementCost"></td>
    </tr>
    <tr>
      <td><label for="length">Add Film Length:</label></td>
      <td><input type="number" name="length"></td>
    </tr>
    <tr>
      <td colspan="2"><button type="submit">Save Film</button></td>
    </tr>
  </table>
</form>
	<c:if test="${not empty message}">
    <h3>${message }</h3>
    </c:if>
</body>
</html>