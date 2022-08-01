package com.movie.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "DIRECTOR")
public class DirectorModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int director_id;
	String director_name;
}
