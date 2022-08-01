package com.movie.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.model.ActorModel;
import com.movie.repository.IActorRepository;
import com.movie.repository.IMovieRepository;
import com.movie.service.IActorService;

@Service
public class ActorService implements IActorService{

	@Autowired
	IActorRepository actorRepository;
	
	@Autowired
	IMovieRepository movieRepository;
	
	@Override
	public int createActor(ActorModel model) {
		// TODO Auto-generated method stub
		return actorRepository.creadActor(model);
	}

	@Override
	public List<ActorModel> readActor() {
		// TODO Auto-generated method stub
		return actorRepository.readActor();
	}

	@Override
	public int updateActor(ActorModel model, int id) {
		// TODO Auto-generated method stub
		List<ActorModel> modelActor = actorRepository.cariActorId(id);
		if(modelActor.isEmpty()) {
			return 0;
		} else {
			actorRepository.updateActor(model, id);	
			return 1;
		}
	}

	@Override
	public int deleteActor(int id) {
		// TODO Auto-generated method stub
		List<ActorModel> modelActor = actorRepository.cariActorId(id);
		if(modelActor.isEmpty()) {
			return 0;
		} else {
			actorRepository.deleteActor(id);
			return 1;
		}
	}
}
