package com.movie.service;

import java.util.List;

import com.movie.model.MovieModel;
import com.movie.model.submissionModel.SubModel;

public interface IMovieService {
	public int createMovie(MovieModel model, String genre);
	public int updateMovie(SubModel model, int actor_id, int director_id, int id);
	public int deleteMovie(int id);
	
	public List<SubModel> readMovie();
	public int createSubMovie(SubModel model);
	public List<SubModel> readMovieByGenre(String genre);
	
	public int updateAllMovie(SubModel model, int id);
	
	public List<SubModel> readMoviePaging(int paging);
	
	public List<SubModel> readMovieById(int id);
}
