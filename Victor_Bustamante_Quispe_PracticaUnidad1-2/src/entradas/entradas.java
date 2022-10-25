package entradas;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

public class entradas {
	private SimpleStringProperty dni;
	private SimpleStringProperty nombre;
	private SimpleStringProperty pelicula;
	private SimpleDoubleProperty Nentradas;
	private SimpleStringProperty cine;
	private SimpleDoubleProperty Total;
	private static double pre=6.00;
	/**
	 * @param dni
	 * @param nombre
	 * @param pelicula
	 * @param nentradas
	 * @param cine
	 */
	public entradas(String dni, String nombre, String pelicula,
			Double nentradas, String cine) {
		super();
		double to= nentradas*pre;
		this.dni = new SimpleStringProperty(dni);
		this.nombre = new SimpleStringProperty(nombre);
		this.pelicula = new SimpleStringProperty(pelicula);
		this.Nentradas = new SimpleDoubleProperty(nentradas);
		this.cine = new SimpleStringProperty(cine);
		this.Total= new SimpleDoubleProperty(to);
	}
	public String getDni() {
		return dni.get();
	}
	public void setDni(String dni) {
		this.dni.set(dni);
	}
	public String getNombre() {
		return nombre.get();
	}
	public void setNombre(String nombre) {
		this.nombre.set(nombre);
	}
	public String getPelicula() {
		return pelicula.get();
	}
	public void setPelicula(String pelicula) {
		this.pelicula.set(pelicula);
	}
	public Double getNentradas() {
		return Nentradas.get();
	}
	public void setNentradas(Double nentradas) {
		Nentradas.set(nentradas);
	}
	public String getCine() {
		return cine.get();
	}
	public void setCine(String cine) {
		this.cine.set(cine);
	}
	
	public Double getTotal() {
		return Total.get();
	}
	public void setTotal(Double total) {
		Total.set(total);;
	}
	@Override
	public String toString() {
		return "entradas [dni=" + dni + ", nombre=" + nombre + ", pelicula=" + pelicula + ", Nentradas=" + Nentradas
				+ ", cine=" + cine + "]";
	}
	
	
	
}
