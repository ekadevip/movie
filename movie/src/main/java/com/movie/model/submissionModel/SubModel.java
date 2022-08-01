package com.movie.model.submissionModel;

import java.util.List;

import lombok.Data;

@Data
public class SubModel {
	int movie_id;
	String title;
	double rating;
	int release_year;
	String actor_name;
	String director_name;
	List<String> genre;
}
