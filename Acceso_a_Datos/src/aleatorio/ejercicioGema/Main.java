package aleatorio.ejercicioGema;

import java.io.FileNotFoundException;
import java.io.IOException;

import entrada.Teclado;

public class Main {
	static GestionaGema almacenGemas = new GestionaGema("randomFile.dat");
	
	private static void menu() {
		System.out.println("0.Salir del programa");
		System.out.println("1.Insertar una gema");
		System.out.println("2.Insertar una gema por id");
		System.out.println("3.Leer todas las gemas");
		System.out.println("4.Leer gema por id");
		System.out.println("5.Insertar gemas de prueba");
	}
	
	private static void crearGema() throws IOException {
		String nombre = Teclado.leerCadena("Introduce el nombre: ");
		String color = Teclado.leerCadena("Introduce el color: ");
		double dureza = Teclado.leerReal("Introduce la dureza: ");
		double tamanno = Teclado.leerReal("Introduce el tamaño: ");
		boolean natural = Teclado.leerBooleano("Introduce si es natural: ");
		
		Gema gem = new Gema(nombre, color, dureza, tamanno, natural);
		almacenGemas.escribir(gem);
	}
	
	private static void crearGemaId() throws IOException {
		int id = Teclado.leerEntero("Introduce el id: ");
		String nombre = Teclado.leerCadena("Introduce el nombre: ");
		String color = Teclado.leerCadena("Introduce el color: ");
		double dureza = Teclado.leerReal("Introduce la dureza: ");
		double tamanno = Teclado.leerReal("Introduce el tamaño: ");
		boolean natural = Teclado.leerBooleano("Introduce si es natural: ");
		
		Gema gem = new Gema(nombre, color, dureza, tamanno, natural);
		almacenGemas.escribir(gem);
	}
	
	private static void leerGema() throws IOException {
		int id = Teclado.leerEntero("Introduce el id de la gema: ");
		Gema gem = almacenGemas.leer(id);
		System.out.println(gem.toString());
	}

	public static void main(String[] args) {
		int opcion;

		try {
			almacenGemas.abrir();

			do {
				menu();
				opcion = Teclado.leerEntero("-- ");

				switch(opcion) {
				case 0:
					break;

				case 1: //Insertar una gema
					crearGema();
					break;

				case 2: //Insertar una gema por id
					crearGemaId();
					break;

				case 3: //Leer todas las gemas
					break;

				case 4: //Leer gema por id
					leerGema();
					break;

				case 5: //Insertar gemas de prueba
					almacenGemas.gemasDePrueba();
					break;

				default:
					System.out.println("Introduce una opcion valida");
					break;
				}
				System.out.println();
				
			} while (opcion != 0);
			almacenGemas.cerrar();

		} catch (FileNotFoundException fnfe) {
			System.out.println("No se ha encontrado el archivo: " + fnfe.getMessage());

		} catch (IOException ioe) {
			System.out.println("Ha ocurrido un error: " + ioe.getMessage());

		}
	}

}
