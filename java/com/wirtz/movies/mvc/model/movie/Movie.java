package com.wirtz.movies.mvc.model.movie;

import java.io.Serializable;

public class Movie implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long id;   
	private String name;
    private float puntuacion;
    /*Minutes*/
    private int duracion; 
    
    
    public int getDuracion() {
		return duracion;
	}
	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getPuntuacion() {
		return puntuacion;
	}
	public void setPuntuacion(float puntuacion) {
		this.puntuacion = puntuacion;
	}
	public Movie(long id, String name, float price) {
		super();
		this.id = id;
		this.name = name;
		this.puntuacion = price;
	}
	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}
    
	
	
    
    
}
