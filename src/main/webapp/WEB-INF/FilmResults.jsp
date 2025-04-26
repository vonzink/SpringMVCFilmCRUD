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
	<h1>${film.title }</h1>

      <form action="updatingFilm.do" method="POST">
      <label for="title">Add Title</label>
      <input type="text" name="title" value ="${film.title }">
      <label for="description">Add Description</label>
      <input type="text" name="description" value ="${film.description }">
      <label for="year">Add Year</label>
      <input type="number" name="year" value ="${film.year }">
      <label for="rating">Add Rating</label>
      <input type="text" name="rating" value ="${film.rating }">
      <label for="languageId">Add Language</label>
      <input type="number" name="languageId" value ="${film.languageId }">
      <label for="rentalRate">Add Rental Rate</label>
      <input type="number" name="rentalRate" value ="${film.rentalRate }">
      <label for="rentalDuration">Add Rental Duration</label>
      <input type="number" name="rentalDuration" value ="${film.rentalDuration }">
      <label for="replacementCost">Add Replacement Cost</label>
      <input type="number" name="replacementCost" value ="${film.replacementCost }">
      <label for="length">Add Film Length</label>
      <input type="number" name="length" value ="${film.length }">
      <button>Submit</button>
      <br>	
	
	
	
</body>
</html>