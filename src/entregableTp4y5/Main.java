package entregableTp4y5;

public class Main {

	public static void main(String[] args) {

		int  notaAsignatura = 30;
		
		Asignatura asignatura = new Asignatura(notaAsignatura, "./datos/alumnos.csv");
		Biblioteca biblioteca = new Biblioteca("./datos/dataset2.csv");
		
//		Greedy greedy = new Greedy();
//		Solucion solucionGreedy = greedy.greedy(biblioteca, asignatura);
//		System.out.println("GREEDY -> nota asignatura: "+ notaAsignatura+"\n");
//		System.out.println(solucionGreedy);
//		System.out.println("\n");
		
		/*--------------------------------------------------------------------------------*/
		
		Backtracking backtracking = new Backtracking();
		Solucion solucionBack = backtracking.asignarLibros(biblioteca, asignatura);
		System.out.println("BACKTRACKING -> nota asignatura: "+ notaAsignatura+"\n");
		System.out.println(solucionBack);
	}

}
