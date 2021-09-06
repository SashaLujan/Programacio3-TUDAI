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
		System.out.println(node.getValue() + " ");
	}

	public void printPreorder() {
		printPreorder(this.root);
	}

	public void printPreorder(TreeNode node) {

		if (node == null) {
			return;
		}
		System.out.println(node.getValue() + " ");
		printPreorder(node.getLeft());
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
		System.out.println(node.getValue() + " ");
		printPreorder(node.getRight());
	}

	public LinkedList<Integer> getLongestBranch() {
		LinkedList<Integer> ramaMasLarga;
		ramaMasLarga = getLongestBranchAux(this.root);
		return ramaMasLarga;
	}

	private LinkedList<Integer> getLongestBranchAux(TreeNode puntero) {
		// TODO Auto-generated method stub
		return null;
	}

	public LinkedList<Integer> getFrontera() {
		LinkedList<Integer> hojas = new LinkedList<Integer>();
		hojas = listarHojas(root);
		return hojas;
	}

	private LinkedList<Integer> listarHojas(TreeNode puntero) {
		LinkedList<Integer> lista = new LinkedList<Integer>();

		if (puntero == null) {
			return lista;
		}
		if (puntero.getLeft() == null && puntero.getRight() == null) {
			lista.add(puntero.getValue());
		}
		if (puntero.getLeft() != null) {
			lista.addAll(listarHojas(puntero.getLeft()));
		}
		if (puntero.getRight() != null) {
			lista.addAll(listarHojas(puntero.getRight()));
		}
		return lista;
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

	public LinkedList<TreeNode> getElementAtLevel(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean delete(int i) {
		return false;
		// TODO Auto-generated method stub

	}
}
