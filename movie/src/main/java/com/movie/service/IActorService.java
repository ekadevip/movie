package com.movie.service;

import java.util.List;

import com.movie.model.ActorModel;

public interface IActorService {
	public int createActor(ActorModel model);
	public List<ActorModel> readActor();
	public int updateActor(ActorModel model, int id);
	public int deleteActor(int id);	
}
