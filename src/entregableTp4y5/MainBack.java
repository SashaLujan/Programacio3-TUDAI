package entregableTp4y5;

public class MainBack {

	public static void main(String[] args) {
		
		int  notaAsignatura = 50;
		
		Asignatura asignatura = new Asignatura(notaAsignatura, "./datos/alumnos.csv");
		Biblioteca biblioteca = new Biblioteca("./datos/dataset2.csv");
		
		Backtracking backtracking = new Backtracking();
		Solucion solucionBack = backtracking.asignarLibros(biblioteca, asignatura);
		System.out.println("BACKTRACKING -> nota asignatura: "+ notaAsignatura+"\n");
		System.out.println(solucionBack);
	}

}
