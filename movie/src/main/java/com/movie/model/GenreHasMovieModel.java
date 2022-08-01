package com.movie.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "GENREHASMOVIE")
public class GenreHasMovieModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int genrehasmovie_id;
	int genre_id;
	int movie_id;
}
