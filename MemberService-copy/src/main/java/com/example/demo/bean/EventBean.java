package com.example.demo.bean;

import lombok.Data;

@Data
public class EventBean {
	private Long id;
	private String titre;
	private String dateDebut;
	private String dateFin;
	private String lieu;
}
