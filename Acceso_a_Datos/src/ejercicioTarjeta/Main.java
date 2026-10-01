package ejercicioTarjeta;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;


public class Main {

	public static void main(String[] args) {
		String fileName = "src/ejercicioTarjeta/datos.txt";
		
		try {
			List<Person> personList = ReadFile.read(fileName);
			
			Iterator<Person> it = personList.iterator();
	        while (it.hasNext()) {
	            System.out.println(it.next().toString());
	            System.out.println();
	        }
	    
		} catch (FileNotFoundException fnfe) {
			System.out.println("No se ha encontrado el fichero: \n" + fnfe.getMessage());
		} catch (IOException ioe) {
			System.out.println("Error del programa: \n" + ioe.getMessage());
		}
	}
}
