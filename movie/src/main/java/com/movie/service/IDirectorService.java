package com.movie.service;

import java.util.List;

import com.movie.model.DirectorModel;

public interface IDirectorService {
	public int createDirector(DirectorModel model);
	public List<DirectorModel> readDirector();
	public int updateDirector(DirectorModel model, int id);
	public int deleteDirector(int id);	
}
