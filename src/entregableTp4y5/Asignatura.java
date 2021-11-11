package entregableTp4y5;

import java.util.ArrayList;

public class Asignatura {
	
	private ArrayList<Alumno> alumnos;
	private int nota;

	private CSVReaderAlumnos alumnoReader;

	public Asignatura(int nota, String path) {
		this.nota = nota;
		alumnoReader = new CSVReaderAlumnos();
		alumnoReader.setPath(path);
		alumnos = alumnoReader.read();
	}

	public int nota() {
		return nota;
	}

	public ArrayList<Alumno> getAlumnos() {
		ArrayList<Alumno> copia = new ArrayList<>();

		for (Alumno a : alumnos) {
			copia.add(a.clone());
		}
		return copia;
	}
	
	public void imprimirAlumnos(String info, ArrayList<Alumno> alumnos) {
		System.out.println(info);
		for (int i = 0; i < alumnos.size(); i++) {
			System.out.println(alumnos.get(i));
		}
		System.out.println();
	}
}
