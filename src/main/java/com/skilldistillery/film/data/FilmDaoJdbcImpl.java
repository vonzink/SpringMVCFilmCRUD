package com.skilldistillery.film.data;

import java.util.List;

import org.springframework.stereotype.Component;

import com.skilldistillery.film.entities.Actor;
import com.skilldistillery.film.entities.Film;

@Component
public class FilmDaoJdbcImpl implements FilmDAO {

	@Override
	public Film findFilmById(int filmId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Actor findActorById(int actorId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Actor> findActorsByFilmId(int filmId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Film> findFilmByKeyword(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String findFilmLanguage(int languageId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String AddFilm(String title) {
		// TODO Auto-generated method stub
		return null;
	}

}
