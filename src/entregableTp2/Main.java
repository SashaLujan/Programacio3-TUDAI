package entregableTp2;

public class Main {

	public static void main(String[] args) {
		
		// Se construye el árbol de ejemplo utilizando el constructor previamente mencionado
		int[] valoresIniciales = new int[] {10, 5, 12, 2, 1, 3, 8, 6, 11, 25, 22, 30};
		TreeWithNode miArbol = new TreeWithNode(valoresIniciales);

		miArbol.printPreorder();
		System.out.println("--------------------");
		System.out.println( miArbol.getMaxElem());
		System.out.println("--------------------");
		System.out.println( miArbol.getHeight());
		System.out.println("--------------------");
		System.out.println( miArbol.getLongestBranch());
		System.out.println("--------------------");
		System.out.println( miArbol.getElementAtLevel(2));
		System.out.println("--------------------");
		System.out.println( miArbol.getFrontera());
		System.out.println("--------------------");

		miArbol.add(23);
		miArbol.add(4);
		miArbol.delete(11);
		miArbol.delete(25);

		System.out.println("--------------------");
		miArbol.printPreorder();
		System.out.println("--------------------");
		System.out.println( miArbol.getMaxElem());
		System.out.println("--------------------");
		System.out.println( miArbol.getHeight());
		System.out.println("--------------------");
		System.out.println( miArbol.getLongestBranch());
		System.out.println("--------------------");
		System.out.println( miArbol.getElementAtLevel(2));
		System.out.println("--------------------");
		System.out.println( miArbol.getFrontera());
		System.out.println("--------------------");

		miArbol.add(65);
		miArbol.delete(8);
		miArbol.delete(10);
		miArbol.add(55);

		System.out.println("--------------------");
		miArbol.printPreorder();
		System.out.println("--------------------");
		System.out.println( miArbol.getMaxElem());
		System.out.println("--------------------");
		System.out.println( miArbol.getHeight());
		System.out.println("--------------------");
		System.out.println( miArbol.getLongestBranch());
		System.out.println("--------------------");
		System.out.println( miArbol.getElementAtLevel(2));
		System.out.println("--------------------");
		System.out.println( miArbol.getFrontera());
	}

}
