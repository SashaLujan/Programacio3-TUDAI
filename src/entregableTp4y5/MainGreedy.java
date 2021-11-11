package entregableTp4y5;

public class MainGreedy {

	public static void main(String[] args) {

		int  notaAsignatura = 50;
		
		Asignatura asignatura = new Asignatura(notaAsignatura, "./datos/alumnos.csv");
		Biblioteca biblioteca = new Biblioteca("./datos/dataset2.csv");
		
		Greedy greedy = new Greedy();
		Solucion solucionGreedy = greedy.greedy(biblioteca, asignatura);
		System.out.println("GREEDY -> nota asignatura: "+ notaAsignatura+"\n");
		System.out.println(solucionGreedy);
		System.out.println("\n");
		
	}

}
