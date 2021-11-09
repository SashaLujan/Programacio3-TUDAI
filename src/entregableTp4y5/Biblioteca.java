package entregableTp4y5;

import java.util.ArrayList;

public class Biblioteca {
	
	private ArrayList<Libro> libros;
	private CSVReaderLibros libroReader;
	
	public Biblioteca(String Path) {
		
		this.libroReader = new CSVReaderLibros();
		libroReader.setPath(Path);
		this.libros = libroReader.read();
	}

	public ArrayList<Libro> getLibros() {
		
		ArrayList<Libro> copia = new ArrayList<>();
		for (Libro l : libros) {
			copia.add(l);
		}
		return copia;
	}
	
}
