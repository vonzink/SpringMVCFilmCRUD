package com.skilldistillery.film.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.skilldistillery.film.data.FilmDAO;
import com.skilldistillery.film.entities.Film;

@Controller
public class FilmController {
	
	@Autowired
	private FilmDAO filmDao; 
	
	@RequestMapping(path= { "home.do", "/" })
	private String goHome(Model model) {
		return "home"; 
	}
	@RequestMapping(path= { "getFilm.do" })
	private String lookupFilm(Model model, @RequestParam("filmId") int filmId) {
		Film film = filmDao.findFilmById(filmId);
		if(film != null) {
		model.addAttribute("film", film);
		model.addAttribute("message", " film found " + filmId); 
		return "FilmResults"; 
	} else {
		model.addAttribute("message", " no film found " + filmId); 
	}
		return "FilmResults";
	}	
	@RequestMapping(path= { "addFilm.do" })
	private String addFilm(Model model,  Film film) {
		Film makeFilm = filmDao.addFilm(film);
		
		if (makeFilm != null) {
	        model.addAttribute("film", makeFilm);
	        model.addAttribute("message", "Film added successfully!");
	    } else {
	        model.addAttribute("message", " Failed to add film. Please try again. ");
	    }
	    return "FilmResults";
	}

	@RequestMapping(path= { "updateFilm.do" })
	private String updateFilm(Model model, Film film, @RequestParam("id") int filmId) {
		if (filmId <= 1000) {
	        model.addAttribute("message", " Cannot update original films ");
	        return "FilmResults";
		}
		Film updateFilm = filmDao.updateFilm(film);
		 if (updateFilm != null) {
			 model.addAttribute("message", " Film updated successfully! ");;
		    } else {
		        model.addAttribute("message", " Failed to update film with ID: " + filmId);
		        return "FilmResults";
		    }
		return "FilmResults";
	}
	
	@RequestMapping(path= { "deleteFilm.do" })
	private String deleteFilm(Model model, @RequestParam("filmId") int filmId) {
		if (filmId <= 1000) {
	        model.addAttribute("message", " Cannot delete original films ");
	        return "FilmResults";
		}
		Film deleteFilm = filmDao.findFilmById(filmId);
		  if (deleteFilm != null ) {
		        filmDao.deleteFilm(deleteFilm);
		        model.addAttribute("message", " Film with ID " + filmId + " was deleted successfully. ");
		    } else {
		        model.addAttribute("message", " Film with ID " + filmId + " not found. Nothing was deleted. ");
		    }
		return "redirect:home.do";
	}
	@RequestMapping(path = { "findFilmByKeyword.do" })
	private String findFilmByKeyword(Model model, @RequestParam("keyword") String keyword) {
	    List<Film> films = filmDao.findFilmByKeyword(keyword);
	    if (films != null && !films.isEmpty()) {
	    	model.addAttribute("message", " Film " + keyword + " was found. ");
	    } else {
	        model.addAttribute("message", " Film " + keyword + " not found. Nothing was deleted. ");
	    }
	    model.addAttribute("films", films);
	    return "KeywordResults";
		}
}