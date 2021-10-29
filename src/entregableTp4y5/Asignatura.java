package entregableTp4y5;

import java.util.ArrayList;

public class Asignatura {
	private Alumno a;
	private int puntajeMin;
	
	public Asignatura(Alumno a, int puntajeMin) {
		super();
		this.a = a;
		this.puntajeMin = puntajeMin;
	}
	
	public Alumno getA() {
		return a;
	}
	public void setA(Alumno a) {
		this.a = a;
	}
	public int getPuntajeMin() {
		return puntajeMin;
	}
	public void setPuntajeMin(int puntajeMin) {
		this.puntajeMin = puntajeMin;
	}
}
