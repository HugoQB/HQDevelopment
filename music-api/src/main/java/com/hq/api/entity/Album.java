package com.hq.api.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Albums")
public class Album {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String titulo;
	private Date lanzado;
	private String genero;
	private double precio;
	
	public void setId(int id) {
		this.id = id;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public void setLanzado(Date lanzado) {
		this.lanzado = lanzado;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public int getId() {
		return id;
	}
	public String getTitulo() {
		return titulo;
	}
	public Date getLanzado() {
		return lanzado;
	}
	public String getGenero() {
		return genero;
	}
	public double getPrecio() {
		return precio;
	}
	@Override
	public String toString() {
		return "Album [id=" + id + ", titulo=" + titulo + ", lanzado=" + lanzado + ", genero=" + genero + ", precio="
				+ precio + "]";
	}
	
	
	
}
