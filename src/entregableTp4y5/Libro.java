package entregableTp4y5;

public class Libro implements Comparable<Libro> {

	private String idLibro;
	private String titulo;
	private String autor;
	private String genero;
	private Integer cantPaginas;
	private Integer cantEjemDispo;
	private Integer puntaje;

	public Libro(String idLibro, String titulo, String autor, String genero, Integer cantPaginas, Integer cantEjemDispo,
			Integer puntaje) {

		this.idLibro = idLibro;
		this.titulo = titulo;
		this.autor = autor;
		this.genero = genero;
		this.cantPaginas = cantPaginas;
		this.cantEjemDispo = cantEjemDispo;
		this.puntaje = puntaje;
	}

	public String getNombre() {
		return titulo;
	}

	public void setNombre(String nombre) {
		this.titulo = nombre;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}
	
	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public int getCantPaginas() {
		return cantPaginas;
	}

	public void setCantPaginas(int cantPaginas) {
		this.cantPaginas = cantPaginas;
	}

	public Integer getPuntaje() {
		return puntaje;
	}

	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}
	
	public String id() {
		return idLibro;
	}
	
	@Override
	public Libro clone() {
		return new Libro(idLibro, titulo, autor, genero, cantPaginas, puntaje, cantEjemDispo);
	}

	@Override
	public String toString() {
		return this.idLibro + " = " + this.puntaje;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Libro o = (Libro) obj;
		if (idLibro == null) {
			if (o.idLibro != null)
				return false;
		} else if (!idLibro.equals(o.idLibro))
			return false;
		return true;
	}
	
	@Override
	public int compareTo(Libro o) {
		return o.getPuntaje() - this.puntaje;
	}

	public void restarEjemplar() {
		cantEjemDispo--;
	}

	public int ejemplares() {
		return cantEjemDispo;
	}

	public boolean ejemplarDiponible() {
		return cantEjemDispo > 0;
	}
	
	public void sumarEjemplar() {
		cantEjemDispo++;
	}
}
