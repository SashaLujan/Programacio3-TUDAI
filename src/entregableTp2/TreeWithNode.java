package entregableTp2;

import java.util.LinkedList;

public class TreeWithNode {

	private TreeNode root;

	public TreeWithNode() {
		this.root = null;
	}

	// complejidad O(n*h) donde n es el tamaño del arreglo y h la altura del arbol
	public TreeWithNode(int[] valoresIniciales) {
		this.root = null;
		for (int i = 0; i < valoresIniciales.length; i++) {
			TreeNode nodo = new TreeNode(valoresIniciales[i]);
			add(nodo.getValue());
		}
	}

	public void add(Integer value) {
		if (this.root == null)
			this.root = new TreeNode(value);
		else
			this.add(this.root, value);
	}

	private void add(TreeNode actual, int value) {
		if (actual.getValue() > value) {
			if (actual.getLeft() == null) {
				TreeNode temp = new TreeNode(value);
				actual.setLeft(temp);
			} else {
				add(actual.getLeft(), value);
			}
		} else if (actual.getValue() < value) {
			if (actual.getRight() == null) {
				TreeNode temp = new TreeNode(value);
				actual.setRight(temp);
			} else {
				add(actual.getRight(), value);
			}
		}
	}

	// complejidad O(n) donde n es la cantidad de nodos del arbol
	public int getHeight() { // retorna la altura del arbol
		if (this.root == null)
			return 0;
		else
			return this.getHeight(this.root); // O(n)
	}

	// complejidad O(n) donde n es la cantidad de nodos del arbol
	private int getHeight(TreeNode cursor) {
		if (cursor.getLeft() == null && cursor.getRight() == null) { // Es una hoja
			return 0; // tengo altura 0
		} else {
			// Si tengo al menos un hijo
			int heightLeft = 0;
			int heightRight = 0;
			if (cursor.getLeft() != null)
				heightLeft = 1 + this.getHeight(cursor.getLeft());
			if (cursor.getLeft() != null)
				heightRight = 1 + this.getHeight(cursor.getLeft());
			int mayor = Math.max(heightLeft, heightRight);
			return mayor;
		}
	}

	// complejidad O(1), es constante ya que siempre devuelve un valor
	public Integer getRoot() { // retorna los datos de la raiz
		if (this.root != null)
			return this.root.getValue();
		return null;
	}

	// complejidad O(1), es constante ya que siempre devuelve un valor
	public boolean isEmpty() { // retorna si esta vacio no
		return this.root == null;
	}

	public void printPostOrder() { // recorrido post order
		printPostOrder(this.root);
	}

	// Complejidad O(n) donde n es la cantidad de nodos del arbol
	public void printPostOrder(TreeNode node) {
		if (node == null) {
			return;
		}
		printPreOrder(node.getLeft());
		printPreOrder(node.getRight());
		System.out.print(node.getValue() + " ");
	}

	public void printPreOrder() { // recorrido pre order
		printPreOrder(this.root);
	}

	// Complejidad O(n) donde n es la cantidad de nodos del arbol
	public void printPreOrder(TreeNode node) {

		if (node == null) {
			return;
		}
		System.out.print(node.getValue() + " ");

		if (node.getLeft() == null) {
			System.out.print("-");
		}

		printPreOrder(node.getLeft());

		if (node.getRight() == null) {
			System.out.print("-");
		}
		printPreOrder(node.getRight());
	}

	public void printInOrder() { // recorrido in order
		printInOrder(this.root);
	}

	// complejidad O(n) donde n es la cantidad de nodos del arbol
	public void printInOrder(TreeNode node) {
		if (node == null) {
			return;
		}
		printInOrder(node.getLeft());
		System.out.print(node.getValue() + " ");
		printInOrder(node.getRight());
	}

	// complejidad O(n) donde n es la cantidad de nodos del arbol.
	public LinkedList<Integer> getLongestBranch() {
		LinkedList<Integer> list;
		list = getLongestBranchAux(this.root);
		return list;
	}

	private LinkedList<Integer> getLongestBranchAux(TreeNode puntero) {
		LinkedList<Integer> leftList = new LinkedList<Integer>();
		LinkedList<Integer> rightList = new LinkedList<Integer>();
		LinkedList<Integer> finalList = new LinkedList<Integer>();

		if (puntero == null) {
			return finalList;
		}
		if (puntero.getLeft() == null && puntero.getRight() == null) {
			finalList.add(puntero.getValue());
			return finalList;
		}
		if (puntero.getLeft() != null) {
			leftList.add(puntero.getValue());
			leftList.addAll(getLongestBranchAux(puntero.getLeft()));
		}
		if (puntero.getRight() != null) {
			rightList.add(puntero.getValue());
			rightList.addAll(getLongestBranchAux(puntero.getRight()));
		}
		if (rightList.size() >= leftList.size()) {
			finalList = rightList;
		} else {
			finalList = leftList;
		}
		return finalList;
	}

	// complejidad O(n) donde n es la cantidad de arboles
	public LinkedList<Integer> getFrontera(TreeNode puntero) {
		LinkedList<Integer> border = new LinkedList<Integer>();

		if (this.isEmpty()) {
			return border;
		} else {
			if (puntero.getLeft() == null && puntero.getRight() == null) {
				border.add(puntero.getValue());
			}
			if (puntero.getLeft() != null) {
				border.addAll(getFrontera(puntero.getLeft()));
			}
			if (puntero.getRight() != null) {
				border.addAll(getFrontera(puntero.getRight()));
			}
		}
		return border;
	}

	// complejidad O(1)
	public boolean isSheet(TreeNode puntero) { // retorna si un nodo es Hoja o no
		return (puntero.getLeft() == null && puntero.getRight() == null);
	}

	// complejidad O(h) donde h es la logitud de la rama mas larga
	public Integer getMaxElem() {
		if (root == null)
			return null;
		else {
			TreeNode nodo = root;
			while (nodo.getRight() != null) {
				nodo = nodo.getRight();
			}
			return nodo.getValue();
		}
	}

	// Complejidad O(n) donde n es la cantidad de nodos del arbol
	// en el peor de los casos tiene que recorrer todo el arbol para encontrar el
	// valor.
	public boolean hasElem(int info) { // retorna si tiene o no un elemento
		TreeNode nodo = root;
		while (nodo != null) {
			if (info == nodo.getValue()) {
				return true;
			} else if (info > nodo.getValue()) {
				nodo = nodo.getRight();
			} else {
				nodo = nodo.getLeft();
			}
		}
		return false;
	}

	public LinkedList<Integer> getElementAtLevel(int level) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		if (this.root != null) {
			list = getElementAtLevelList(level, this.root);
		}
		return list;
	}

	// complejidad O(n) donde n es el numero de nodos del arbol
	private LinkedList<Integer> getElementAtLevelList(int level, TreeNode puntero) { // retorna la lista con los nodos
																						// de un nivel pedido
		LinkedList<Integer> list = new LinkedList<Integer>();
		if (puntero == null) {
			return list;
		}
		if (level == 0) {
			list.add(puntero.getValue());
		} else {
			list.addAll(getElementAtLevelList(level - 1, puntero.getLeft()));
			list.addAll(getElementAtLevelList(level - 1, puntero.getRight()));
		}
		return list;
	}

	public boolean delete(int value) {
		boolean esHijoIzq = false;
		TreeNode aux = root;
		TreeNode padre = root;

		while (aux.getValue() != value) {
			padre = aux;
			if (value < aux.getValue()) {
				esHijoIzq = true;
				aux = aux.getLeft();
			} else {
				esHijoIzq = false;
				aux = aux.getRight();
			}
			if (aux == null) {
				return false;
			}
		}

		if (aux.getLeft() == null && aux.getRight() == null) {
			if (aux == root) {
				root = null;
			} else if (esHijoIzq) {
				padre.setLeft(null);
			} else {
				padre.setRight(null);
			}
		} else if (aux.getRight() == null) {
			if (aux == root) {
				root = aux.getLeft();
			} else if (esHijoIzq) {
				padre.setLeft(aux.getLeft());
			} else {
				padre.setRight(aux.getLeft());
			}
		} else if (aux.getLeft() == null) {
			if (aux == root) {
				root = aux.getRight();
			} else if (esHijoIzq) {
				padre.setLeft(aux.getRight());
			} else {
				padre.setRight(aux.getRight());
			}
		} else {
			TreeNode nodoReemplazo = replacementNode(aux);
			if (aux == root) {
				root = nodoReemplazo;
			} else if (esHijoIzq) {
				padre.setLeft(nodoReemplazo);
			} else {
				padre.setRight(nodoReemplazo);
			}
			nodoReemplazo.setLeft(aux.getLeft());
		}
		return true;

	}

	public TreeNode replacementNode(TreeNode nodoReemp) { // busca el nodo más a la derecha del sub Árbol izquierda
		TreeNode reemplazaPadre = nodoReemp;
		TreeNode reemplazo = nodoReemp;
		TreeNode aux = nodoReemp.getRight();

		while (aux != null) {
			reemplazaPadre = reemplazo;
			reemplazo = aux;
			aux = aux.getLeft();
		}
		if (reemplazo != nodoReemp.getRight()) {
			reemplazaPadre.setLeft(reemplazo.getRight());
			reemplazo.setRight(nodoReemp.getRight());
		}
		System.out.println("El nodo reemplazo es: " + reemplazo.getValue());
		return reemplazo;
	}

	public LinkedList<Integer> differenceBetweenAdjacentSheets() {

		LinkedList<Integer> list = new LinkedList<Integer>();

		return this.differenceBetweenAdjacentSheets(list);
	}

	private LinkedList<Integer> differenceBetweenAdjacentSheets(LinkedList<Integer> list) {
		return list;// paso por parámetros una lista de hojas
	}
}
