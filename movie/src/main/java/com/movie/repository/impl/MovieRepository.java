package com.movie.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.movie.model.MovieModel;
import com.movie.model.submissionModel.SubModel;
import com.movie.repository.IMovieRepository;

@Repository
public class MovieRepository implements IMovieRepository {

	@Autowired
	JdbcTemplate jdbc;

	@Override
	public int createMovie(MovieModel model) {
		// TODO Auto-generated method stub
		var sql = "Insert into movie(title, rating, release_year, actor_id, director_id) values (?,?,?,?,?)";
		return jdbc.update(sql, new Object[] { model.getTitle(), model.getRating(), model.getRelease_year(),
				model.getActor_id(), model.getDirector_id() });
	}

	@Override
	public List<MovieModel> readMovie() {
		// TODO Auto-generated method stub
		String sql = "select* from movie";
		return jdbc.query(sql, new BeanPropertyRowMapper<MovieModel>(MovieModel.class));
	}
	
	@Override
	public List<MovieModel> readMovie(int id) {
		// TODO Auto-generated method stub
		String sql = "select* from movie where movie_id=?";
		return jdbc.query(sql, new BeanPropertyRowMapper<MovieModel>(MovieModel.class),id);
	}

	@Override
	public List<MovieModel> readMovieLastIn() {
		// TODO Auto-generated method stub
		String sql = "select* from movie order by movie_id desc";
		return jdbc.query(sql, new BeanPropertyRowMapper<MovieModel>(MovieModel.class));
	}

	@Override
	public int updateMovie(SubModel model, int actor_id, int director_id, int id) {
		// TODO Auto-generated method stub
		String sql = "Update movie set title=?, rating=?, release_year=?, actor_id=?, director_id=? where movie_id=?";
		return jdbc.update(sql, new Object[] { model.getTitle(), model.getRating(), model.getRelease_year(), actor_id, director_id, id });
	}

	@Override
	public int deleteMovie(int id) {
		// TODO Auto-generated method stub
		String sql = "Delete from movie where movie_id=?";
		return jdbc.update(sql, id);
	}

	@Override
	public List<MovieModel> readMovieByGenre(String genre) {
		// TODO Auto-generated method stub
		String sql = "select m.movie_id, m.title, m.rating, m.release_year, g.genre from movie m\r\n"
				+ "join genrehasmovie gm on m.movie_id = gm.movie_id\r\n" + "join genre g on gm.genre_id=g.genre_id\r\n"
				+ "where g.genre like '%" + genre + "%'";
		return jdbc.query(sql, new BeanPropertyRowMapper<MovieModel>(MovieModel.class));
	}

	@Override
	public int createSubMovie(SubModel model, int actor_id, int director_id) {
		// TODO Auto-generated method stub
		var sql = "Insert into movie(title, rating, release_year, actor_id, director_id) values (?,?,?,?,?)";
		return jdbc.update(sql,
				new Object[] { model.getTitle(), model.getRating(), model.getRelease_year(), actor_id, director_id });
	}

	@Override
	public List<MovieModel> cariActorId(int id) {
		// TODO Auto-generated method stub
		var sql = "Select * from movie where actor_id=?";
		return jdbc.query(sql, new BeanPropertyRowMapper<MovieModel>(MovieModel.class), id);
	}

	@Override
	public List<MovieModel> cariDirectorId(int id) {
		// TODO Auto-generated method stub
		var sql = "Select * from movie where director_id=?";
		return jdbc.query(sql, new BeanPropertyRowMapper<MovieModel>(MovieModel.class), id);
	}

	@Override
	public List<SubModel> readAllMovie() {
		// TODO Auto-generated method stub
		var sql = "select m.movie_id, m.title, m.rating, m.release_year, a.actor_name, d.director_name, g.genre from movie m\r\n"
				+ "join actor a on m.actor_id=a.actor_id\r\n" + "join director d on m.director_id=d.director_id\r\n"
				+ "join genrehasmovie gm on m.movie_id=gm.movie_id \r\n"
				+ "join genre g on gm.genre_id=g.genre_id group by m.title";
		return jdbc.query(sql, new BeanPropertyRowMapper<SubModel>(SubModel.class));
	}

	@Override
	public List<SubModel> readAllMovieByGenre(String genre) {
		// TODO Auto-generated method stub
		var sql = "select m.title, m.rating, m.release_year, a.actor_name, d.director_name, g.genre from movie m\r\n"
				+ "join actor a on m.actor_id=a.actor_id\r\n"
				+ "join director d on m.director_id=d.director_id\r\n"
				+ "join genrehasmovie gm on m.movie_id=gm.movie_id \r\n"
				+ "join genre g on gm.genre_id=g.genre_id where g.genre like '%"+genre+"%' group by m.title";
		return jdbc.query(sql, new BeanPropertyRowMapper<SubModel>(SubModel.class));
	}

	@Override
	public List<MovieModel> readGenre(int id) {
		// TODO Auto-generated method stub
		var sql = "select m.movie_id, g.genre from movie m\r\n" + "join actor a on m.actor_id=a.actor_id\r\n"
				+ "join director d on m.director_id=d.director_id\r\n"
				+ "join genrehasmovie gm on m.movie_id=gm.movie_id \r\n"
				+ "join genre g on gm.genre_id=g.genre_id where movie_id=?";
		return jdbc.query(sql, new BeanPropertyRowMapper<MovieModel>(MovieModel.class), id);
	}
	
	@Override
	public List<SubModel> readAllMoviePaging(int paging) {
		// TODO Auto-generated method stub
		var sql = "select m.title, m.rating, m.release_year, a.actor_name, d.director_name, g.genre from movie m\r\n"
				+ "join actor a on m.actor_id=a.actor_id\r\n" + "join director d on m.director_id=d.director_id\r\n"
				+ "join genrehasmovie gm on m.movie_id=gm.movie_id \r\n"
				+ "join genre g on gm.genre_id=g.genre_id group by m.title limit ?";
		return jdbc.query(sql, new BeanPropertyRowMapper<SubModel>(SubModel.class), paging);
	}

	@Override
	public List<MovieModel> readMovieById(int id) {
		// TODO Auto-generated method stub
		String sql = "select m.movie_id, m.title, m.rating, m.release_year, g.genre from movie m\r\n"
				+ "join genrehasmovie gm on m.movie_id = gm.movie_id\r\n" + "join genre g on gm.genre_id=g.genre_id\r\n"
				+ "where m.movie_id=?";
		return jdbc.query(sql, new BeanPropertyRowMapper<MovieModel>(MovieModel.class),id);
	}

	@Override
	public List<SubModel> readAllMovieById(int id) {
		// TODO Auto-generated method stub
		var sql = "select m.movie_id, m.title, m.rating, m.release_year, a.actor_name, d.director_name, g.genre from movie m\r\n"
				+ "join actor a on m.actor_id=a.actor_id\r\n"
				+ "join director d on m.director_id=d.director_id\r\n"
				+ "join genrehasmovie gm on m.movie_id=gm.movie_id \r\n"
				+ "join genre g on gm.genre_id=g.genre_id where m.movie_id=? group by m.title";
		return jdbc.query(sql, new BeanPropertyRowMapper<SubModel>(SubModel.class),id);
	}
}
