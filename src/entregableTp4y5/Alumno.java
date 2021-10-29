package entregableTp4y5;

public class Alumno {
	int cantPuntaje;
	int dni;
	
	public Alumno(int cantPuntaje, int dni) {
		
		this.cantPuntaje = cantPuntaje;
		this.dni = dni;
	}

	public int getCantPuntaje() {
		return cantPuntaje;
	}

	public void setCantPuntaje(int cantPuntaje) {
		this.cantPuntaje = cantPuntaje;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}
	
}
