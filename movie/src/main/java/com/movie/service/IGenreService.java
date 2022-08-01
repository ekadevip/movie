package com.movie.service;

import java.util.List;

import com.movie.model.GenreModel;

public interface IGenreService {
	public int createGenre(GenreModel model);
	public List<GenreModel> readGenre();
	public int updateGenre(GenreModel model, int id);
	public int deleteGenre(int id);
}
