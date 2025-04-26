package com.skilldistillery.film.data;

import java.util.List;

import com.skilldistillery.film.entities.Actor;
import com.skilldistillery.film.entities.Film;

public interface FilmDAO {

  Film findFilmById(int filmId);
  Actor findActorById(int actorId);
  List<Actor> findActorsByFilmId(int filmId);
  List<Film> findFilmByKeyword(String keyword);
  String findLanguageById(int languageId);
  Film addFilm(Film newFilm); 
  Film updatingFilm(Film updatingFilm);
  void deleteFilm(Film fimToDelete);
  
		}
  
  

