package entregableTp4y5;

import java.util.ArrayList;

public class Biblioteca {
	private ArrayList<Libro> libros;
	private ArrayList<Alumno> alumnos;
	
	public Biblioteca(ArrayList<Libro> libros, ArrayList<Alumno> alumnos) {
		
		this.libros = libros;
		this.alumnos = alumnos;
	}

	public ArrayList<Libro> getLibros() {
		return libros;
	}

	public void setLibros(ArrayList<Libro> libros) {
		this.libros = libros;
	}
	
}
