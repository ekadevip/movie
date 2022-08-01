package com.movie.repository;

import java.util.List;

import com.movie.model.DirectorModel;

public interface IDirectorRepository {
	public int createDirector(DirectorModel model);
	public List<DirectorModel> readDirector();
	public int updateDirector(DirectorModel model, int id);
	public int deleteDirector(int id);	
	
	public List<DirectorModel> cariDirectorId(String director_name);
	public List<DirectorModel> cariDirectorId(int id);
}
