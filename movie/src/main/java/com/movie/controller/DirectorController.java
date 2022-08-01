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

import com.movie.model.DirectorModel;
import com.movie.service.IDirectorService;

@RestController
@RequestMapping("/director")
public class DirectorController {
	
	@Autowired
	IDirectorService directorService;
	
	@PostMapping("/create")
	public String create(@RequestBody DirectorModel model) {
		directorService.createDirector(model);
		return "Insert success...";
	}
	
	@GetMapping("/read")
	public List<DirectorModel> read(){
		return directorService.readDirector();
	}
	
	@PutMapping("/update")
	public String update(@RequestBody DirectorModel model, @RequestParam int id) {
		int cek = directorService.updateDirector(model, id);
		if(cek==1) {
			return "Update success...";
		} else {
			return "Update canceled. Data director is not found";
		}
	}
	
	@DeleteMapping("/delete")
	public String delete(@RequestParam int id) {
		int cek = directorService.deleteDirector(id);
		if(cek==1) {
			return "Delete success...";
		}else {
			return "Delete canceled. Data director is not found";
		}
	}
}
