package entregableTp4y5;

import java.util.ArrayList;
import java.util.Collections;

public class Greedy {
	
	private int contA;
	private int contL;
	
	public Greedy() {
		int contA = 0;
		int contL = 0;
	}
	
	//este metodo va a informar la asignacion de los libros a los alumnos
	//el parametro que se pasa de la biblioteca va a tener la lista de libros
	//y el parametro asignatura va a tener la lista de alumnos y las condiciones para poder aprobar
	public Solucion greedy(Biblioteca biblioteca, Asignatura asignatura) {

		ArrayList<Libro> libros = biblioteca.getLibros();
		ArrayList<Alumno> alumnos = asignatura.getAlumnos();
		int nota = asignatura.nota();
		
		Collections.sort(alumnos); //ordena de mayor a menor los alumnos que esten mas posibilidad de aprobar
		Collections.sort(libros); //ordena de mayor a menor los libros con mas puntaje
	
		Solucion solucion = this.asignarLibros(alumnos, nota, libros);

		return solucion;
	}
	
	// Que es un candidato? --> Un alumnno
	//maximizar cantidad de alumnos aprobados
	private Solucion asignarLibros(ArrayList<Alumno> alumnos, int nota, ArrayList<Libro> libros) {
		
		int indexL = 0;
		int indexA = 0;
		int alumnosAp = 0;
		
		Solucion solucion = new Solucion();
		
		while(indexA != -1 && indexL != -1) {
			//primero selecciona el alumnno
			indexA = seleccionarAlumno(indexA, alumnos, nota);
			
			if(indexA != -1) {
				Alumno alumno = alumnos.get(indexA);
				
				//selecciona el libro
				while(alumnos.get(indexA).getCantPuntaje() < nota && indexL != -1) {
					indexL = seleccionarLibro(alumno, libros, nota, indexL);
					
					if(indexL != -1) { //se le asigna un libro a el alumno
						Libro libro = libros.get(indexL);
						alumno.leerLibro(libro.clone());
						
						libro.restarEjemplar();
						if(!libro.ejemplarDiponible()) {
							libros.remove(indexL);
						}
					}
				}
				solucion.add(alumno);
				if(alumno.getCantPuntaje() >= nota) {
					alumnosAp++;
					solucion.setAlumnosAp(alumnosAp);
				}
				if(!libros.isEmpty()) {
					indexL = 0;
				}
				indexA++;
			}
		}
		solucion.setIteracion(contA + contL);
		contA = 0;
		contL = 0;
		return solucion;
	}
	
	//se le pasa un candidato (el alumno) y la lista de lisbro que tidavia no fueron asignados
	//el indice es la posicion donde comienza la busqueda
	private int seleccionarLibro(Alumno alumno, ArrayList<Libro> libros, int nota, int indexL) {
		
		int salto = (int) Math.floor(libros.size() / 10);
		
		if (salto == 0) {
			salto = 1;
		}
		
		int p = alumno.getCantPuntaje();
		int sum = Integer.MAX_VALUE;
		int ultPosible = -1;
		int proPosible = -1;
		while (indexL < libros.size() && sum > nota) {
			contL++;

			if (alumno.puedeLeer(libros.get(indexL)) && libros.get(indexL).ejemplarDiponible()) {

				sum = libros.get(indexL).getPuntaje() + p;

				//el primer libro posible de leer
				//no importa si se alcanza la nota de aprobacion
				if (proPosible == -1) {
					proPosible = indexL;
				}

				//ultimo libro posible de leer
				//solo si se alcanza la nota de aprobacion
				if (sum >= nota) {
					ultPosible = indexL;
				}

				//optimizacion salto
				indexL += salto;
			} else {
				indexL++;
			}
		}

		//ultimo Posible tiene puntaje mas cercano a la nota de aprobacion
		//si nunca se alcanzo la nota de aprobacion se retorna el primero posible
		return (ultPosible == -1) ? proPosible : ultPosible;
	}

	//se le pasa como parametro la lista de alumnos, el indice es donde comienza la busqueda
	private int seleccionarAlumno(int index, ArrayList<Alumno> alumnos, int nota) {
		
		if(index == -1) {
			return index;
		}
		
		boolean fin = false;
		
		while(index < alumnos.size() && !fin) {
			contA++;
			fin = alumnos.get(index).getCantPuntaje() < nota;
			
			if(!fin) {
				index++;
			}
		}
		return (index < alumnos.size() ? index : -1);
	}	
}
