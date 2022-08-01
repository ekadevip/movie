package com.movie.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.model.GenreModel;
import com.movie.repository.IGenreRepository;
import com.movie.service.IGenreService;

@Service
public class GenreService implements IGenreService{

	@Autowired
	IGenreRepository genreRepository;
	
	@Override
	public int createGenre(GenreModel model) {
		// TODO Auto-generated method stub
		return genreRepository.createGenre(model);
	}

	@Override
	public List<GenreModel> readGenre() {
		// TODO Auto-generated method stub
		return genreRepository.readGenre();
	}

	@Override
	public int updateGenre(GenreModel model, int id) {
		// TODO Auto-generated method stub
		List<GenreModel> modelGenre = genreRepository.cariGenreId(id);
		if(modelGenre.isEmpty()) {
			return 0;
		} else {
			genreRepository.updateGenre(model, id);
			return 1;
		}
	}

	@Override
	public int deleteGenre(int id) {
		// TODO Auto-generated method stub
		List<GenreModel> modelGenre = genreRepository.cariGenreId(id);
		if(modelGenre.isEmpty()) {
			return 0;
		} else {
			genreRepository.deleteGenre(id);
			return 1;
		}
	}

}
