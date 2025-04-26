<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
   <%@ taglib uri="jakarta.tags.core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Film Lookup Results</title>
</head>
<body>
		<h1>${film.title }</h1>

      <form action="updatingFilm.do" method="POST">
		<h2>Edit Film Info</h2>
		<input type="hidden" name="id" value ="${film.id }">
      <input type="text" name="title" value ="${film.title }">
      <label for="title">Edit Title</label><br>
      <input type="text" name="description" value ="${film.description }">
      <label for="description">Edit Description</label><br>
      <input type="number" name="year" value ="${film.year }">
      <label for="year">Edit Year</label><br>
      <input type="text" name="rating" value ="${film.rating }">
      <label for="rating">Edit Rating</label><br>
      <input type="number" name="languageId" value ="${film.languageId }">
      <label for="languageId">Edit Language</label><br>
      <input type="number" name="rentalRate" value ="${film.rentalRate }">
      <label for="rentalRate">Edit Rental Rate</label><br>
      <input type="number" name="rentalDuration" value ="${film.rentalDuration }">
      <label for="rentalDuration">Edit Rental Duration</label><br>
      <input type="number" name="replacementCost" value ="${film.replacementCost }">
      <label for="replacementCost">Edit Replacement Cost</label><br>
      <input type="number" name="length" value ="${film.length }">
      <label for="length">Edit Film Length</label><br>
      <input type="number" name="filmId" value ="${film.id }">
      <label for="filmId">Film Id</label><br>
      <button>Update</button>
      <br>	
	<br>
	
	 <form action="delete.do" method="POST">
		<h2>DELETE</h2>
		<button>DELETE</button>
		
	
</body>
</html>