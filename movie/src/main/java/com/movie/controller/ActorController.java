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

import com.movie.model.ActorModel;
import com.movie.service.IActorService;

@RestController
@RequestMapping("/actor")
public class ActorController {

	@Autowired
	IActorService actorService;
	
	@PostMapping("/create")
	public String create(@RequestBody ActorModel model) {
		actorService.createActor(model);
		return "Insert success...";
	}

	@GetMapping("/read")
	public List<ActorModel> read() {
		return actorService.readActor();
	}

	@PutMapping("/update")
	public String update(@RequestBody ActorModel model, @RequestParam int id) {
		int cek = actorService.updateActor(model, id);
		if (cek == 1) {
			return "Update success...";
		} else {
			return "Update canceled. Data actor is not found";
		}
	}

	@DeleteMapping("/delete")
	public String delete(@RequestParam int id) {
		int cek = actorService.deleteActor(id);
		if (cek == 1) {
			return "Delete success...";
		} else {
			return "Delete canceled. Data genre is not found";
		}
	}
}
