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
      <label for="filmId">Film Id</label><br>
      <input type="text" name="filmId">
      <button>Lookup</button>
      <br>
     
    </form> 
	<h1>Add New Film</h1>
	<form action="addFilm.do" method="POST">
      <label for="title">Add Title</label>
      <input type="text" name="title"><br>
      <label for="description">Add Description</label>
      <input type="text" name="description"><br>
      <label for="year">Add Year</label>
      <input type="number" name="year"><br>
      <label for="rating">Add Rating</label>
      <input type="text" name="rating"><br>
      <label for="languageId">Add Language</label>
      <input type="number" name="languageId"><br>
      <label for="rentalRate">Add Rental Rate</label>
      <input type="number" name="rentalRate"><br>
      <label for="rentalDuration">Add Rental Duration</label>
      <input type="number" name="rentalDuration"><br>
      <label for="replacementCost">Add Replacement Cost</label>
      <input type="number" name="replacementCost"><br>
      <label for="length">Add Film Length</label>
      <input type="number" name="length"><br>
      <button>Add Film</button>
      <br>
      
     
     </form> 
	
	
	
	
	
</body>
</html>