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
	
	public void incremAlumnosAprob() {
		// TODO Auto-generated method stub
		
	}

	public void add(Alumno alumno) {
		
		if (!alumnos.add(alumno)) {
			this.remove(alumno);
			alumnos.add(alumno);
		}
		this.setAlumnosAp(alumnosAp);
	}

	private void remove(Alumno alumno) {
		// TODO Auto-generated method stub
		
	}

	public void setAlumnosAp(int alumnosAp) {
		this.alumnosAp = alumnosAp;
	}

	public int aprobados() {
		return this.alumnosAp;
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
}
