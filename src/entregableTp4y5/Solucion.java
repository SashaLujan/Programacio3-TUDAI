package entregableTp4y5;

import java.util.HashSet;

public class Solucion {

	private HashSet<Alumno> alumnos;
	private int alumnosAp;
	private int iteraciones;
	
	public Solucion() {
		alumnos = new HashSet<>();
		alumnosAp = 0;
		iteraciones = 0;
	}
	
	public void add(Alumno alumno) {
		
		if (!alumnos.add(alumno)) {
			this.remove(alumno);
			alumnos.add(alumno);
		}
		this.setAlumnosAp(alumnosAp);
	}

	public void setAlumnosAp(int alumnosAp) {
		this.alumnosAp = alumnosAp;
	}

	public int aprobados() {
		return this.alumnosAp;
	}
	
//	public void incremAlumnosAprob() {
//		// TODO Auto-generated method stub
//		
//	}

	private void remove(Alumno alumno) {
		alumnos.remove(alumno);
	}

	public void setIteracion(int i) {
		this.iteraciones = i;
	}

	public Solucion clone() {
		Solucion copia = new Solucion();
		for (Alumno a : alumnos) {
			copia.add(a.clone());
		}
		copia.setAlumnosAp(this.alumnosAp);
		return copia;
	}
	
	public String toString() {
		String info = "Libros Entregados\n";
		for (Alumno a : alumnos) {
			if (!a.librosLeidos().equals("empty")) {
				info += a + "\nLibros: ";
				info += a.librosLeidos() + "\n";
			}
		}
		info += "iteraciones: " + iteraciones + "\n";
		info += "Alumnos aprobados: " + alumnosAp;
		return info;
	}
}
