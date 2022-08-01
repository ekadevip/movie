package com.movie.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.movie.model.submissionModel.SubModel;
import com.movie.service.IGenreService;
import com.movie.service.IMovieService;

@Controller
public class BerandaController {

	@Autowired
	IMovieService movieService;

	@Autowired
	IGenreService genreService;

	@RequestMapping("/home")
	public String Home() {
		String html = "movie/home";
		return html;
	}

	@RequestMapping("/list")
	public String movieList(Model model) {
		List<SubModel> modelSub = new ArrayList<SubModel>();
		modelSub = movieService.readMovie();
		model.addAttribute("movie", modelSub);
		return "/movie/list";
	}

	@RequestMapping("/add")
	public String movieAddModal() {
		return "/movie/add";
	}

	@RequestMapping("/create")
	public String mahasiswaCreate(HttpServletRequest request) {

		SubModel modelMovie = new SubModel();
		modelMovie.setTitle(request.getParameter("title"));
		modelMovie.setRating(Double.valueOf(request.getParameter("rating")));
		modelMovie.setRelease_year(Integer.valueOf(request.getParameter("release_year")));
		modelMovie.setActor_name(request.getParameter("actor_name"));
		modelMovie.setDirector_name(request.getParameter("director_name"));
		
		List<String> genreAdd = new ArrayList<>();
		List<String> genres = new ArrayList<>();
		for (var model : genreService.readGenre()) {
			genres.add(model.getGenre());
		}
		for (var genre : genres) {
			if (request.getParameter(genre) != null) {
				genreAdd.add(genre);
			}
		}
		modelMovie.setGenre(genreAdd);
		movieService.createSubMovie(modelMovie);
		return "/movie/home";
	}
}
