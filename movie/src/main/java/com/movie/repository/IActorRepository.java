package com.movie.repository;

import java.util.List;

import com.movie.model.ActorModel;

public interface IActorRepository {
	public int creadActor(ActorModel model);
	public List<ActorModel> readActor();
	public int updateActor(ActorModel model, int id);
	public int deleteActor(int id);	
	
	public List<ActorModel> cariActorId(String actorName);
	public List<ActorModel> cariActorId(int id);
}
