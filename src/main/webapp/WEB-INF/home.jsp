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
      <label for="filmId">Film Id</label>
      <input type="text" name="filmId">
      <button>Submit</button>
      <br>
     
    </form> 
	
	<form action="addFilm.do" method="POST">
      <label for="title">Add Title</label>
      <input type="text" name="title">
      <label for="description">Add Description</label>
      <input type="text" name="description">
      <label for="year">Add Year</label>
      <input type="number" name="year">
      <label for="rating">Add Rating</label>
      <input type="text" name="rating">
      <label for="languageId">Add Language</label>
      <input type="number" name="languageId">
      <label for="rentalRate">Add Rental Rate</label>
      <input type="number" name="rentalRate">
      <label for="rentalDuration">Add Rental Duration</label>
      <input type="number" name="rentalDuration">
      <label for="replacementCost">Add Replacement Cost</label>
      <input type="number" name="replacementCost">
      <label for="length">Add Film Length</label>
      <input type="number" name="length">
      <button>Submit</button>
      <br>
     
     </form> 
	
	
	
	
	
	
	
</body>
</html>