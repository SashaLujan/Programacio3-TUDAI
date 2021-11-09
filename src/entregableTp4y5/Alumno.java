package entregableTp4y5;

import java.util.HashSet;

public class Alumno implements Comparable<Alumno> {
	
	private int cantPuntaje;
	private String id;
	
	private HashSet<Libro> ejempLeidos;
	
	public Alumno(int cantPuntaje, String id) {
		
		this.cantPuntaje = cantPuntaje;
		this.id = id;
		this.ejempLeidos = new HashSet<Libro>();
	}

	public int getCantPuntaje() {
		return cantPuntaje;
	}

	public void setCantPuntaje(int cantPuntaje) {
		this.cantPuntaje = cantPuntaje;
	}

	public String getId() {
		return id;
	}
	
	public HashSet<Libro> getLibros() {
		HashSet<Libro> copia = new HashSet<>();
		for(Libro l : ejempLeidos) {
			copia.add(l.clone());
		}
		return copia;
	}
	
	private void setLibros(HashSet<Libro> copia) {
		this.ejempLeidos = copia;
	}

	public void leerLibro(Libro libro) {
		this.ejempLeidos.add(libro);
		this.cantPuntaje += libro.getPuntaje();
	}

	public boolean puedeLeer(Libro libro) {
		return !this.ejempLeidos.contains(libro);
	}

	public String librosLeidos() {
		return (ejempLeidos.isEmpty()) ? "empty" : ejempLeidos.toString();
	}
	
	public boolean estaAprobado(int nota) {	
		return getCantPuntaje() >= nota;
	}
	
	@Override
	public Alumno clone() {
		Alumno copia = new Alumno(cantPuntaje, id);
		copia.setLibros(this.getLibros());
		return copia;
	}
	
	@Override
	public int compareTo(Alumno o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
