package entregableTp2;

public class Tree {

	private Integer value;
	private Tree left;
	private Tree right;

	public Tree(Integer value) {
		this.value = value;
		this.left = null;
		this.right = null;
	}

	public void add(Integer newValue) {
		if (this.value == null)
			this.value = newValue;
		else {
			if (this.value > newValue) {
				if (this.left == null)
					this.left = new Tree(newValue);
				else
					this.left.add(newValue);
			} else if (this.value < newValue) {
				if (this.right == null)
					this.right = new Tree(newValue);
				else
					this.right.add(newValue);
			}
		}
	}

	public int getHeight() {
		if (this.left == null && this.right == null) { // Si soy una hoja o la raiz(altura cero)
			return 0; // tengo altura 0
		} else {
			// Si tengo al menos un hijo
			int heightLeft = 0;
			int heightRight = 0;

			if (this.left != null)
				heightLeft = this.left.getHeight() + 1;

			if (this.right != null)
				heightRight = this.right.getHeight() + 1;

			int higher = Math.max(heightLeft, heightRight);

			return higher; //retorna mayor
		}
	}

}
