package entregableTp4y5;

public class Libro implements Comparable<Libro> {

	private String id;
	private String titulo;
	private String autor;
	private String genero;
	private Integer cantPaginas;
	private Integer cantEjemDispo;
	private Integer puntaje;

	public Libro(String idLibro, String titulo, String autor, String genero, Integer cantPaginas, Integer cantEjemDispo,
			Integer puntaje) {

		this.id = idLibro;
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

	public int getPuntaje() {
		return puntaje;
	}

	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}
	
	public String id() {
		return id;
	}
	
	@Override
	public Libro clone() {
		return new Libro(id, titulo, autor, genero, cantPaginas, puntaje, cantEjemDispo);
	}

	@Override
	public String toString() {
		return this.id + " = " + this.puntaje;
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
