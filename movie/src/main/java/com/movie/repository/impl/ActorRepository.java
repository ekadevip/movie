package com.movie.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.movie.model.ActorModel;
import com.movie.repository.IActorRepository;

@Repository
public class ActorRepository implements IActorRepository {

	@Autowired
	JdbcTemplate jdbc;

	@Override
	public int creadActor(ActorModel model) {
		// TODO Auto-generated method stub
		var sql = "Insert into actor(actor_name) values(?)";
		return jdbc.update(sql, new Object[] { model.getActor_name() });
	}

	@Override
	public List<ActorModel> readActor() {
		// TODO Auto-generated method stub
		var sql = "Select * from actor";
		return jdbc.query(sql, new BeanPropertyRowMapper<ActorModel>(ActorModel.class));
	}

	@Override
	public int updateActor(ActorModel model, int id) {
		// TODO Auto-generated method stub
		var sql = "Update actor set actor_name=? where actor_id=?";
		return jdbc.update(sql, new Object[] { model.getActor_name(), id });
	}

	@Override
	public int deleteActor(int id) {
		// TODO Auto-generated method stub
		var sql = "Delete from actor where actor_id=?";
		return jdbc.update(sql, id);
	}

	@Override
	public List<ActorModel> cariActorId(String actorName) {
		// TODO Auto-generated method stub
		var sql = "Select actor_id from actor where actor_name = ?";
		return jdbc.query(sql, new BeanPropertyRowMapper<ActorModel>(ActorModel.class), actorName);
	}

	@Override
	public List<ActorModel> cariActorId(int id) {
		// TODO Auto-generated method stub
		var sql = "Select * from actor where actor_id=?";
		return jdbc.query(sql, new BeanPropertyRowMapper<ActorModel>(ActorModel.class),id);
	}

}
