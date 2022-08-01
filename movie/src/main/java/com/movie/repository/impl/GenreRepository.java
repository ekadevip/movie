package com.movie.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.movie.model.GenreModel;
import com.movie.repository.IGenreRepository;

@Repository
public class GenreRepository implements IGenreRepository{

	@Autowired
	JdbcTemplate jdbc;
	
	@Override
	public int createGenre(GenreModel model) {
		// TODO Auto-generated method stub
		var sql = "Insert into genre(genre) values(?)";
		return jdbc.update(sql, new Object[]{model.getGenre()});
	}

	@Override
	public List<GenreModel> readGenre() {
		// TODO Auto-generated method stub
		var sql = "Select * from genre";
		return jdbc.query(sql, new BeanPropertyRowMapper<GenreModel>(GenreModel.class));
	}

	@Override
	public int updateGenre(GenreModel model, int id) {
		// TODO Auto-generated method stub
		var sql = "Update genre set genre=? where genre_id=?";
		return jdbc.update(sql, new Object[] {model.getGenre(),id});
	}

	@Override
	public int deleteGenre(int id) {
		// TODO Auto-generated method stub
		var sql = "Delete from genre where genre_id=?";
		return jdbc.update(sql,id);
	}
	
	@Override
	public List<GenreModel> cariGenreId(String genre) {
		// TODO Auto-generated method stub
		var sql = "Select * from genre where genre like '%"+genre+"%'";
		return jdbc.query(sql, new BeanPropertyRowMapper<GenreModel>(GenreModel.class));
	}

	@Override
	public List<GenreModel> cariGenreId(int id) {
		// TODO Auto-generated method stub
		var sql = "Select * from genre where genre_id =?";
		return jdbc.query(sql, new BeanPropertyRowMapper<GenreModel>(GenreModel.class),id);
	}
}
