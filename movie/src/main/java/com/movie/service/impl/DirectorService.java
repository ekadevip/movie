package com.movie.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.model.DirectorModel;
import com.movie.repository.IDirectorRepository;
import com.movie.repository.IMovieRepository;
import com.movie.service.IDirectorService;

@Service
public class DirectorService implements IDirectorService{

	@Autowired
	IDirectorRepository directoRepository;
	
	@Autowired
	IMovieRepository movieRepository;
	
	@Override
	public int createDirector(DirectorModel model) {
		// TODO Auto-generated method stub
		return directoRepository.createDirector(model);
	}

	@Override
	public List<DirectorModel> readDirector() {
		// TODO Auto-generated method stub
		return directoRepository.readDirector();
	}

	@Override
	public int updateDirector(DirectorModel model, int id) {
		// TODO Auto-generated method stub
		List<DirectorModel> modelDirectori = directoRepository.cariDirectorId(id);
		if(modelDirectori.isEmpty()) {
			return 0;
		} else {
			directoRepository.updateDirector(model, id);
			return 1;
		}
	}

	@Override
	public int deleteDirector(int id) {
		// TODO Auto-generated method stub
		List<DirectorModel> modelDirector = directoRepository.cariDirectorId(id);
		if(modelDirector.isEmpty()) {
			return 0;
		} else {
			directoRepository.deleteDirector(id);
			return 1;
		}
	}
}
