package com.movie.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.movie.model.DirectorModel;
import com.movie.repository.IDirectorRepository;

@Repository
public class DirectorRepository implements IDirectorRepository {

	@Autowired
	JdbcTemplate jdbc;

	@Override
	public int createDirector(DirectorModel model) {
		// TODO Auto-generated method stub
		var sql = "Insert into director(director_name) values(?)";
		return jdbc.update(sql, new Object[] {model.getDirector_name()});
	}

	@Override
	public List<DirectorModel> readDirector() {
		// TODO Auto-generated method stub
		var sql = "Select * from director";
		return jdbc.query(sql, new BeanPropertyRowMapper<DirectorModel>(DirectorModel.class));
	}

	@Override
	public int updateDirector(DirectorModel model, int id) {
		// TODO Auto-generated method stub
		var sql = "Update director set director_name=? where director_id=?";
		return jdbc.update(sql, new Object[] {model.getDirector_name(),id});
	}

	@Override
	public int deleteDirector(int id) {
		// TODO Auto-generated method stub
		var sql = "Delete from director where director_id=?";
		return jdbc.update(sql, id);
	}
	
	@Override
	public List<DirectorModel> cariDirectorId(String directorName) {
		// TODO Auto-generated method stub
		var sql = "Select director_id from director where director_name = ?";
		return jdbc.query(sql, new BeanPropertyRowMapper<DirectorModel>(DirectorModel.class), directorName);
	}

	@Override
	public List<DirectorModel> cariDirectorId(int id) {
		// TODO Auto-generated method stub
		var sql = "Select * from director where director_id=?";
		return jdbc.query(sql, new BeanPropertyRowMapper<DirectorModel>(DirectorModel.class),id);
	}
}
