package com.movie.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "GENRE")
public class GenreModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int genre_id;
	String genre;
}
