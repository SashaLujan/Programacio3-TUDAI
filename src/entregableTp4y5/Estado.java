package entregableTp4y5;

import java.util.ArrayList;

public class Estado {

	private ArrayList<Alumno> alumnos;
	private ArrayList<Libro> libros;

	private Solucion solucion;
	private int indexLibro;
	private int aprobados;
	private int nota;
	
	public Estado(ArrayList<Libro> libros, ArrayList<Alumno> alumnos, int nota) {

		this.alumnos = alumnos;
		this.libros = libros;
		this.indexLibro = 0;
		this.aprobados = 0;
		this.nota = nota;
		this.solucion = new Solucion();
	}

	public int aprobados() {
		return aprobados;
	}

	public Solucion solucion() {
		return this.solucion.clone();
	}

	public Libro sigLibro() {
		
		Libro l = null;
		if (indexLibro < libros.size() && indexLibro >= 0) {
			l = libros.get(indexLibro);
		}
		return l;
	}

	public ArrayList<Alumno> alumnos() {
		return alumnos;
	}

	public void asignar(Alumno alumno, Libro libro) {
		
		alumno.leerLibro(libro.clone());
		libro.restarEjemplar();
		if (!libro.ejemplarDiponible()) {
			indexLibro++;
		}
		if (alumno.estaAprobado(nota)) {
			this.aprobados++;
			solucion.setAlumnosAp(this.aprobados);
			solucion.add(alumno.clone());
		}
	}

	public void restaurar(Alumno alumno, Libro libro) {

		if (alumno.estaAprobado(nota)) {
			this.aprobados--;
			solucion.setAlumnosAp(this.aprobados);
		}
		alumno.restaurar(libro);
		solucion.add(alumno.clone());

		if (!libro.ejemplarDiponible()) {
			indexLibro--;
		}
		libro.sumarEjemplar();
	}

	public void seguir() {
		indexLibro++;
	}

	public void volver() {
		indexLibro--;		
	}

	public boolean posible(Alumno alumno, Libro libro) {
		return alumno.puedeLeer(libro) && !alumno.estaAprobado(nota) && libro.ejemplarDiponible();
	}

}
