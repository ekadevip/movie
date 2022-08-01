package com.movie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.movie.model.MovieModel;
import com.movie.model.submissionModel.SubModel;
import com.movie.service.IMovieService;

@RestController
@RequestMapping("/movie")
public class MovieController {
	
	@Autowired
	IMovieService movieService;

	@PostMapping("/create")
	public String create(@RequestBody MovieModel model, @RequestParam String genre) {
		movieService.createMovie(model, genre);
		return "Insert success...";
	}

	@PostMapping("/createSM")
	public String create(@RequestBody SubModel model) {
		int cek = movieService.createSubMovie(model);
		if(cek==1) {
			return "Insert success...";
		}else {
			return "Insert canceled. Data actor or director is not found.";
		}
	}

	@GetMapping("/read")
	public List<SubModel> read(){
		return movieService.readMovie();
	}
	
	@GetMapping("/readMovieById")
	@ResponseBody
	public SubModel readMovieById(@RequestParam int id){
		return movieService.readMovieById(id).get(0);
	}
	
	@GetMapping("readByGenre")
	public List<SubModel> readMovieByGenre(@RequestParam String genre){
		return movieService.readMovieByGenre(genre);
	}
	
	@GetMapping("/readPaging")
	public List<SubModel> readPaging(@RequestParam int paging){
		return movieService.readMoviePaging(paging);
	}

	
	@PutMapping("/update")
	public String update(@RequestBody SubModel model, @RequestParam int id) {
		int cek = movieService.updateAllMovie(model, id);
		if(cek==1) {
			return "Update success...";
		} else {
			return "Update canceled. Data movie is not found";
		}
	}

	@DeleteMapping("/delete")
	public String delete(@RequestParam int id) {
		System.out.println("hai");
		int cek = movieService.deleteMovie(id);
		if(cek==1) {
			return "Delete success...";
		} else {
			return "Delete canceled. Data movie is not found";
		}
	}
}