package com.movie.repository;

import java.util.List;

import com.movie.model.MovieModel;
import com.movie.model.submissionModel.SubModel;

public interface IMovieRepository {
	public int createMovie(MovieModel model);
	public List<MovieModel> readMovie();
	public List<MovieModel> readMovie(int id);
	public List<MovieModel> readMovieLastIn();
	public int updateMovie(SubModel model, int actor_id, int movie_id, int id);
	public int deleteMovie(int id);
	
	public List<SubModel> readAllMovie();
	public List<SubModel> readAllMovieByGenre(String genre);
	public List<MovieModel> readGenre(int id);
	public int createSubMovie(SubModel model, int actor_id, int director_id);
	public List<MovieModel> readMovieByGenre(String genre);
	
	public List<MovieModel> cariActorId(int id);
	public List<MovieModel> cariDirectorId(int id);
	
	public List<SubModel> readAllMoviePaging(int paging);
	
	public List<MovieModel> readMovieById(int id);
	
	public List<SubModel> readAllMovieById(int id);
	
}
