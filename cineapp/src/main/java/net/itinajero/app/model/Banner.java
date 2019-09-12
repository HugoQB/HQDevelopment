package net.itinajero.app.model;

import java.util.Date;

public class Banner {

	private int id=0;
	private String titulo;
	private Date fecha;
	private String archivo;
	private String status;
	
	public Banner() {
		fecha = new Date();
		status = "Activo";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getArchivo() {
		return archivo;
	}

	public void setArchivo(String archivo) {
		this.archivo = archivo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Banner [id=" + id + ", titulo=" + titulo + ", fecha=" + fecha + ", archivo=" + archivo + ", status="
				+ status + "]";
	}
	
}
