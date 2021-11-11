package entregableTp4y5;

import java.util.HashSet;

public class Alumno implements Comparable<Alumno> {
	
	private Integer cantPuntaje;
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
	
	public boolean estaAsignado(String idLibro) {
		return this.ejempLeidos.contains(idLibro);
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
	public boolean equals(Object obj) {
		Alumno o = (Alumno) obj;
		if (!id.equals(o.id))
			return false;

		return true;
	}
	
	@Override
	public String toString() {
		return this.id + " = \npuntaje: " + this.cantPuntaje ;
	}
	
	@Override
	public int compareTo(Alumno o) {
		return  o.getCantPuntaje() - this.cantPuntaje;
	}

	public void restaurar(Libro libro) {

		this.ejempLeidos.remove(libro);
		this.cantPuntaje -= libro.getPuntaje();
	}
	
}
