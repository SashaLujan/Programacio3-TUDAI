package entregableTp4y5;

public class Libro {

	private int id;
	private String nombre;
	private String autor;
	private String genero;
	private int cantPaginas;
	private int cnatEjemDispo;
	private int puntaje;
	
	public Libro(int id, String nombre, String autor, String genero, int cantPaginas, int cnatEjemDispo, int puntaje) {
		
		this.id = id;
		this.nombre = nombre;
		this.autor = autor;
		this.genero = genero;
		this.cantPaginas = cantPaginas;
		this.cnatEjemDispo = cnatEjemDispo;
		this.puntaje = puntaje;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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

	public int getCnatEjemDispo() {
		return cnatEjemDispo;
	}

	public void setCnatEjemDispo(int cnatEjemDispo) {
		this.cnatEjemDispo = cnatEjemDispo;
	}

	public int getPuntaje() {
		return puntaje;
	}

	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}
	
	
	
}
