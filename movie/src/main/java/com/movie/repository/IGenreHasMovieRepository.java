package com.movie.repository;

import java.util.List;

import com.movie.model.GenreHasMovieModel;
import com.movie.model.submissionModel.SubGenre;
import com.movie.model.submissionModel.SubTotal;

public interface IGenreHasMovieRepository {
	public int createGenreHasMovie(int genre_id, int movie_id);
	public int updateGenreHasMovie(int genre, int id);
	public int deleteGenreHasMovie(int id);
	public List<GenreHasMovieModel> cariGenreHasMovieId(int id);
	
	public List<GenreHasMovieModel> readGenreHasMovie();
	public List<SubGenre> cariGenre(int id);
	public List<SubTotal> hitungGenre(int id);
	public List<GenreHasMovieModel> cariGenreId(String genre);
	
	public List<GenreHasMovieModel> cariGenreHasMovieIdByMovieId(int movie_id);
}

