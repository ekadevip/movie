package com.movie.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.movie.model.GenreHasMovieModel;
import com.movie.model.submissionModel.SubGenre;
import com.movie.model.submissionModel.SubTotal;
import com.movie.repository.IGenreHasMovieRepository;

@Repository
public class GenreHasMovieRepository implements IGenreHasMovieRepository {

	@Autowired
	JdbcTemplate jdbc;

	@Override
	public int createGenreHasMovie(int genre_id, int movie_id) {
		// TODO Auto-generated method stub
		var sql = "Insert into genrehasmovie(genre_id, movie_id) values(?,?)";
		return jdbc.update(sql, new Object[] { genre_id, movie_id});
	}

	@Override
	public int updateGenreHasMovie(int genre_id, int id) {
		// TODO Auto-generated method stub
		var sql = "Update genrehasmovie set genre_id=? where genrehasmovie_id=?";
		return jdbc.update(sql, new Object[] {genre_id, id});
	}

	@Override
	public int deleteGenreHasMovie(int id) {
		// TODO Auto-generated method stub
		var sql = "Delete from genrehasmovie where genrehasmovie_id=?";
		return jdbc.update(sql,id);
	}

	@Override
	public List<GenreHasMovieModel> cariGenreHasMovieId(int id) {
		// TODO Auto-generated method stub
		var sql = "Select * from genrehasmovie where movie_id=?";
		return jdbc.query(sql, new BeanPropertyRowMapper<GenreHasMovieModel>(GenreHasMovieModel.class),id);
	}

	@Override
	public List<GenreHasMovieModel> readGenreHasMovie() {
		// TODO Auto-generated method stub
		var sql = "Select * from genrehasmovie";
		return jdbc.query(sql, new BeanPropertyRowMapper<GenreHasMovieModel>(GenreHasMovieModel.class));
	}

	@Override
	public List<SubGenre> cariGenre(int id) {
		// TODO Auto-generated method stub
		var sql = "select g.genre from movie m\r\n"
				+ "join genrehasmovie gm on m.movie_id =gm.movie_id\r\n"
				+ "join genre g on gm.genre_id=g.genre_id\r\n"
				+ "where m.movie_id=?";
		return jdbc.query(sql, new BeanPropertyRowMapper<SubGenre>(SubGenre.class),id);
	}

	@Override
	public List<SubTotal> hitungGenre(int id) {
		// TODO Auto-generated method stub
		var sql = "select count(g.genre) as total from movie m\r\n"
				+ "join genrehasmovie gm on m.movie_id =gm.movie_id\r\n"
				+ "join genre g on gm.genre_id=g.genre_id\r\n"
				+ "where m.movie_id =?";
		return jdbc.query(sql, new BeanPropertyRowMapper<SubTotal>(SubTotal.class),id);
	}
	
	@Override
	public List<GenreHasMovieModel> cariGenreId(String genre) {
		// TODO Auto-generated method stub
		var sql = "select g.genre_id from genrehasmovie gm\r\n"
				+ "join movie m on gm.movie_id =m.movie_id\r\n"
				+ "join genre g on gm.genre_id=g.genre_id\r\n"
				+ "where g.genre like '%"+genre+"%'";
		return jdbc.query(sql, new BeanPropertyRowMapper<GenreHasMovieModel>(GenreHasMovieModel.class));
	}
	
	@Override
	public List<GenreHasMovieModel> cariGenreHasMovieIdByMovieId(int movie_id) {
		// TODO Auto-generated method stub
		var sql = "select gm.genrehasmovie_id from movie m \r\n"
				+ "join genrehasmovie gm on m.movie_id=gm.movie_id\r\n"
				+ "where gm.movie_id=?";
		return jdbc.query(sql, new BeanPropertyRowMapper<GenreHasMovieModel>(GenreHasMovieModel.class), movie_id);
	}

}
