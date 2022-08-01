package com.movie.repository;

import java.util.List;

import com.movie.model.GenreModel;

public interface IGenreRepository {
	public int createGenre(GenreModel model);
	public List<GenreModel> readGenre();
	public int updateGenre(GenreModel model, int id);
	public int deleteGenre(int id);
	
	public List<GenreModel> cariGenreId(String genre);
	public List<GenreModel> cariGenreId(int id);
}
