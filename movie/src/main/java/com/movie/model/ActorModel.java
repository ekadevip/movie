package com.movie.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "ACTOR")
public class ActorModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int actor_id;
	String actor_name;
}
