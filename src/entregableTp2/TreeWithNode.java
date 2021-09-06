package entregableTp2;

import java.util.LinkedList;

public class TreeWithNode {

	private TreeNode root;

	public TreeWithNode() {
		this.root = null;
	}

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

	public int getHeight() {
		if (this.root == null)
			return 0;
		else
			return this.getHeight(this.root); // O(n)
	}

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

	public Integer getRoot() {
		if (this.root != null)
			return this.root.getValue();
		return null;
	}

	public boolean isEmpty() {
		return this.root == null;
	}

	public void printPostorder() {
		printPostorder(this.root);
	}

	public void printPostorder(TreeNode node) {
		if (node == null) {
			return;
		}
		printPreorder(node.getLeft());
		printPreorder(node.getRight());
		System.out.print(node.getValue() + " ");
	}

	public void printPreorder() {
		printPreorder(this.root);
	}

	public void printPreorder(TreeNode node) {

		if (node == null) {
			return;
		}
		System.out.print(node.getValue() + " ");

		if (node.getLeft()==null) {
			System.out.print("-");
		}
		
		printPreorder(node.getLeft());
		
		if (node.getRight()==null) {
			System.out.print("-");
		}
		printPreorder(node.getRight());
	}

	public void printInorder() {
		printInorder(this.root);
	}

	public void printInorder(TreeNode node) {
		if (node == null) {
			return;
		}
		printPreorder(node.getLeft());
		System.out.print(node.getValue() + " ");
		printPreorder(node.getRight());
	}

	public LinkedList<Integer> getLongestBranch() {
		LinkedList<Integer> ramaMasLarga;
		ramaMasLarga = getLongestBranchAux(this.root);
		return ramaMasLarga;
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

	public LinkedList<Integer> getFrontera() {
		LinkedList<Integer> hojas = new LinkedList<Integer>();
		hojas = listarHojas(root);
		return hojas;
	}

	private LinkedList<Integer> listarHojas(TreeNode puntero) {
		LinkedList<Integer> list = new LinkedList<Integer>();

		if (puntero == null) {
			return list;
		}
		if (puntero.getLeft() == null && puntero.getRight() == null) {
			list.add(puntero.getValue());
		}
		if (puntero.getLeft() != null) {
			list.addAll(listarHojas(puntero.getLeft()));
		}
		if (puntero.getRight() != null) {
			list.addAll(listarHojas(puntero.getRight()));
		}
		return list;
	}

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

	public boolean hasElem(int info) {
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

	private LinkedList<Integer> getElementAtLevelList(int level, TreeNode puntero) {
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
	
	public boolean delete(int valor) {
		TreeNode aux = root;
		TreeNode padre = root;
		boolean esHijoIzq = true;
		
		while(aux.getValue() != valor) {
			padre = aux;
			if(valor < aux.getValue()) {
				esHijoIzq = true;
				aux = aux.getLeft();
			}
			else {
				esHijoIzq = false;
				aux = aux.getRight();
			}
			if (aux == null) {
				return false;
			}
		}
		
		if(aux.getLeft() == null && aux.getRight() == null) {
			if(aux == root) {
				root = null;
			}
			else if(esHijoIzq) {
				padre.setLeft(null);
			}
			else {
				padre.setRight(null);
			}
		} else if(aux.getRight() == null) {
			if(aux == root) {
				root = aux.getLeft();
			}
			else if(esHijoIzq) {
				padre.setLeft(aux.getLeft());
			}
			else {
				padre.setRight(aux.getLeft());
			}
		} else if(aux.getLeft() == null) {
			if(aux == root) {
				root = aux.getRight();
			}
			else if(esHijoIzq) {
				padre.setLeft(aux.getRight());
			}
			else {
				padre.setRight(aux.getRight());
			}
		} else {
			TreeNode nodoReemplazo = getReemplazoNodo(aux);
			if(aux == root) {
				root = nodoReemplazo;
			}
			else if(esHijoIzq) {
				padre.setLeft(nodoReemplazo);
			}
			else {
				padre.setRight(nodoReemplazo);
			}
			nodoReemplazo.setLeft(aux.getLeft());
		}
		return true; 
	}
	private TreeNode buscarNodo(int num) {
		TreeNode aux = this.root;
		while (aux.getValue() != num) {
			if (num < aux.getValue()) {
				aux = aux.getLeft();
			} else {
				aux = aux.getRight();
			}
			if (aux == null) {
				return null;
			}
		}
		return aux;
	}

	private TreeNode getReemplazoNodo(TreeNode nodoReemp){
		TreeNode reemplazaPadre = nodoReemp;
		TreeNode reemplazo = nodoReemp;
		TreeNode aux = nodoReemp.getRight();

		while (aux != null){
			reemplazaPadre = reemplazo;
			reemplazo = aux;
			aux = aux.getLeft();
		}
		if (reemplazo != nodoReemp.getRight()){
			reemplazaPadre.setLeft(reemplazo.getRight());
			reemplazo.setRight(nodoReemp.getRight());
		}
		System.out.println("El nodo reemplazo es: " + reemplazo.getValue());
		return reemplazo;
	}
}
