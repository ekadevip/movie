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
import org.springframework.web.bind.annotation.RestController;

import com.movie.model.GenreModel;
import com.movie.service.IGenreService;

@RestController
@RequestMapping("/genre")
public class GenreController {

	@Autowired
	IGenreService genreService;

	@PostMapping("/create")
	public String create(@RequestBody GenreModel model) {
		genreService.createGenre(model);
		return "Insert success...";
	}

	@GetMapping("/read")
	public List<GenreModel> read() {
		return genreService.readGenre();
	}

	@PutMapping("/update")
	public String update(@RequestBody GenreModel model, @RequestParam int id) {
		int cek = genreService.updateGenre(model, id);
		if (cek == 1) {
			return "Update success...";
		} else {
			return "Update canceled. Data genre is not found";
		}
	}

	@DeleteMapping("/delete")
	public String delete(@RequestParam int id) {
		int cek = genreService.deleteGenre(id);
		if (cek == 1) {
			return "Delete success...";
		} else {
			return "Delete canceled. Data genre is not found";
		}
	}
}
