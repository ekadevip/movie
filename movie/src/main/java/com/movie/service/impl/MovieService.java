package com.movie.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.model.ActorModel;
import com.movie.model.DirectorModel;
import com.movie.model.GenreHasMovieModel;
import com.movie.model.GenreModel;
import com.movie.model.MovieModel;
import com.movie.model.submissionModel.SubGenre;
import com.movie.model.submissionModel.SubModel;
import com.movie.model.submissionModel.SubTotal;
import com.movie.repository.IActorRepository;
import com.movie.repository.IDirectorRepository;
import com.movie.repository.IGenreHasMovieRepository;
import com.movie.repository.IGenreRepository;
import com.movie.repository.IMovieRepository;
import com.movie.service.IMovieService;

@Service
public class MovieService implements IMovieService {

	@Autowired
	IMovieRepository movieRepository;

	@Autowired
	IGenreHasMovieRepository genreHasMovieRepository;

	@Autowired
	IGenreRepository genreRepository;

	@Autowired
	IActorRepository actorRepository;

	@Autowired
	IDirectorRepository directorRepository;

	@Override
	public int createMovie(MovieModel model, String genre) {
		// TODO Auto-generated method stub
		movieRepository.createMovie(model);
		List<GenreModel> modelGenre = genreRepository.cariGenreId(genre);
		List<MovieModel> modelMovie = movieRepository.readMovie();
		genreHasMovieRepository.createGenreHasMovie(modelGenre.get(0).getGenre_id(), modelMovie.get(0).getMovie_id());
		return 1;
	}

	@Override
	public int createSubMovie(SubModel model) {
		// TODO Auto-generated method stub
		List<ActorModel> modelActor = actorRepository.cariActorId(model.getActor_name());
		List<DirectorModel> modelDirector = directorRepository.cariDirectorId(model.getDirector_name());
		if(modelActor.isEmpty()||modelDirector.isEmpty()) {
			return 0;
		} else {
			movieRepository.createSubMovie(model, modelActor.get(0).getActor_id(), modelDirector.get(0).getDirector_id());
			List<MovieModel> modelMovie = movieRepository.readMovieLastIn();
			List<String> genres = model.getGenre();
			for (int i = 0; i < genres.size(); i++) {
				List<GenreModel> modelGenre = genreRepository.cariGenreId(genres.get(i));
				genreHasMovieRepository.createGenreHasMovie(modelGenre.get(0).getGenre_id(),
						modelMovie.get(0).getMovie_id());
			}
			return 1;
		}
	}

	@Override
	public int updateMovie(SubModel model, int actor_id, int director_id, int id) {
		// TODO Auto-generated method stub
		return movieRepository.updateMovie(model, actor_id, director_id, id);
	}

	@Override
	public int deleteMovie(int id) {
		// TODO Auto-generated method stub
		List<GenreHasMovieModel> modelGenreHasMovieModel = genreHasMovieRepository.cariGenreHasMovieId(id);
		if(modelGenreHasMovieModel.isEmpty()) {
			return 0;
		} else {
			for (int i = 0; i < modelGenreHasMovieModel.size(); i++) {
				genreHasMovieRepository.deleteGenreHasMovie(modelGenreHasMovieModel.get(i).getGenrehasmovie_id());
			}
			movieRepository.deleteMovie(id);
			return 1;
		}
	}

	@Override
	public List<SubModel> readMovieByGenre(String genre) {
		// TODO Auto-generated method stub
		List<SubModel> modelSub = movieRepository.readAllMovieByGenre(genre);
		List<MovieModel> modelMovie = movieRepository.readMovieByGenre(genre);
		for (int i = 0; i < modelSub.size(); i++) {
			int movie_id = modelMovie.get(i).getMovie_id();
			List<SubGenre> modelGenre = genreHasMovieRepository.cariGenre(movie_id);
			List<SubTotal> modelTotal = genreHasMovieRepository.hitungGenre(movie_id);
			int size = modelTotal.get(0).getTotal();
			List<String> genres = modelSub.get(i).getGenre();
			genres.remove(0);
			for (int j = 0; j < size; j++) {
				genres.add(modelGenre.get(j).getGenre());
			}
		}
		return modelSub;
	}
	
	@Override
	public List<SubModel> readMovie() {
		// TODO Auto-generated method stub
		List<SubModel> modelSub = movieRepository.readAllMovie();
		List<MovieModel> modelMovie = movieRepository.readMovie();
		for (int i = 0; i < modelSub.size(); i++) {
			int movie_id = modelMovie.get(i).getMovie_id();
			List<SubGenre> modelGenre = genreHasMovieRepository.cariGenre(movie_id);
			List<SubTotal> modelTotal = genreHasMovieRepository.hitungGenre(movie_id);
			int size = modelTotal.get(0).getTotal();
			List<String> genre = modelSub.get(i).getGenre();
			genre.remove(0);
			for (int j = 0; j < size; j++) {
				genre.add(modelGenre.get(j).getGenre());
			}
		}
		return modelSub;
	}

	@Override
	public int updateAllMovie(SubModel model, int id) {
		// TODO Auto-generated method stub
		List<MovieModel> modelMovie = movieRepository.readMovie(id);
		if(modelMovie.isEmpty()) {
			return 0;
		}else {
			List<ActorModel> modelActor = actorRepository.cariActorId(model.getActor_name());
			List<DirectorModel> modelDirector = directorRepository.cariDirectorId(model.getDirector_name());
			int actor_id = modelActor.get(0).getActor_id();
			int director_id = modelDirector.get(0).getDirector_id();
			movieRepository.updateMovie(model, actor_id, director_id, id);

			List<SubTotal> genreTotal = genreHasMovieRepository.hitungGenre(id);
			int total = genreTotal.get(0).getTotal();
			for (int i = 0; i < total; i++) {
				List<GenreHasMovieModel> modelGenreHasMovie = genreHasMovieRepository.cariGenreHasMovieId(id);
				int genrehasmovie_id = modelGenreHasMovie.get(0).getGenrehasmovie_id();
				genreHasMovieRepository.deleteGenreHasMovie(genrehasmovie_id);
			}

			List<String> genres = model.getGenre();
			for (int i = 0; i < genres.size(); i++) {
				List<GenreModel> modelGenre = genreRepository.cariGenreId(genres.get(i));
				genreHasMovieRepository.createGenreHasMovie(modelGenre.get(0).getGenre_id(), id);
			}
			return 1;
		}
	}

	@Override
	public List<SubModel> readMoviePaging(int paging) {
		// TODO Auto-generated method stub
		List<SubModel> modelSub = movieRepository.readAllMoviePaging(paging);
		List<MovieModel> modelMovie = movieRepository.readMovie();
		for (int i = 0; i < modelSub.size(); i++) {
			int movie_id = modelMovie.get(i).getMovie_id();
			List<SubGenre> modelGenre = genreHasMovieRepository.cariGenre(movie_id);
			List<SubTotal> modelTotal = genreHasMovieRepository.hitungGenre(movie_id);
			int size = modelTotal.get(0).getTotal();
			List<String> genre = modelSub.get(i).getGenre();
			genre.remove(0);
			for (int j = 0; j < size; j++) {
				genre.add(modelGenre.get(j).getGenre());
			}
		}
		return modelSub;
	}

	@Override
	public List<SubModel> readMovieById(int id) {
		// TODO Auto-generated method stub
		List<SubModel> modelSub = movieRepository.readAllMovieById(id);
		List<MovieModel> modelMovie = movieRepository.readMovieById(id);
		for (int i = 0; i < modelSub.size(); i++) {
			int movie_id = modelMovie.get(i).getMovie_id();
			List<SubGenre> modelGenre = genreHasMovieRepository.cariGenre(movie_id);
			List<SubTotal> modelTotal = genreHasMovieRepository.hitungGenre(movie_id);
			int size = modelTotal.get(0).getTotal();
			List<String> genres = modelSub.get(i).getGenre();
			genres.remove(0);
			for (int j = 0; j < size; j++) {
				genres.add(modelGenre.get(j).getGenre());
			}
		}
		return modelSub;
	}
}
