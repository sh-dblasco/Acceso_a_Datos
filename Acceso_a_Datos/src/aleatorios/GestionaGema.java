//WIP: Encontrar primer id libre

package aleatorios;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class GestionaGema {
	private static final int RECORDBYTES = 101;
	private static final int MAXSTRING = 20;
	
	File file;
	RandomAccessFile gemFileRandom;
	
	//Se usa File porque RandomAccessFile solo abre, no construye
	public GestionaGema(String fileName) {
		file = new File(fileName);
		if (!file.exists()) {
			System.out.println("Creare un fichero nuevo");
		}
	}
	
	//---------------------------------------------------------------------
	
	public void abrir() throws FileNotFoundException {
			gemFileRandom = new RandomAccessFile(file, "rw");
	}
	
	public void iniciar() throws IOException {
		if (gemFileRandom == null) {
			System.out.println("No existe el fichero.");
			return;

		} else {
			gemFileRandom.seek(0);
		}

	}
	
	public void escribir (Gema gem) throws IOException {
		StringBuffer bufferGem;

		//Escribe el id
		gemFileRandom.writeInt(gem.getId());
		
		//Escribe el nombre
		bufferGem = new StringBuffer();
		bufferGem.append(gem.getNombre());
		bufferGem.setLength(MAXSTRING);
		gemFileRandom.writeChars(bufferGem.toString());
		
		//Escribe el color
		bufferGem= new StringBuffer();
		bufferGem.append(gem.getColor());
		bufferGem.setLength(MAXSTRING);
		gemFileRandom.writeChars(bufferGem.toString());

		//Escribe la dureza
		gemFileRandom.writeDouble(gem.getDureza());

		//Escribe el tamaño
		gemFileRandom.writeDouble(gem.getTamanno());

		//Escribe si es natural
		gemFileRandom.writeBoolean(gem.isNatural());

	}
	
	public void escribir (Gema gem, int id) throws IOException {
		long pos = convertirPosicion(id);

		StringBuffer bufferGem;
		gemFileRandom.seek(pos);

		//Escribe el id
		gemFileRandom.writeInt(gem.getId());

		//Escribe el nombre
		bufferGem = new StringBuffer();
		bufferGem.append(gem.getNombre());
		bufferGem.setLength(MAXSTRING);
		gemFileRandom.writeChars(bufferGem.toString());

		//Escribe el color
		bufferGem= new StringBuffer();
		bufferGem.append(gem.getColor());
		bufferGem.setLength(MAXSTRING);
		gemFileRandom.writeChars(bufferGem.toString());

		//Escribe la dureza
		gemFileRandom.writeDouble(gem.getDureza());

		//Escribe el tamaño
		gemFileRandom.writeDouble(gem.getTamanno());

		//Escribe si es natural
		gemFileRandom.writeBoolean(gem.isNatural());

	}
	
	public Gema leer (int id) throws IOException {
		long pos = convertirPosicion(id);
		gemFileRandom.seek(pos);

		int newId = gemFileRandom.readInt();

		char[] nombre = new char[MAXSTRING];
		for (int i = 0; i < MAXSTRING; i++) {
			nombre[i] = gemFileRandom.readChar();
		}
		String nombreString = new String(nombre).trim();
		
		char[] color = new char[MAXSTRING];
		for (int i = 0; i < MAXSTRING; i++) {
			color[i] = gemFileRandom.readChar();
		}
		String colorString = new String(color).trim();
		

		double dureza = gemFileRandom.readDouble();

		double tamanno = gemFileRandom.readDouble();

		boolean natural = gemFileRandom.readBoolean();

		Gema gem = new Gema(newId, nombreString, colorString, dureza, tamanno, natural);
		return gem;
	}
	
	//WIP
	public Gema leer () throws IOException {
		int newId = gemFileRandom.readInt();

		char[] nombre = new char[MAXSTRING];
		for (int i = 0; i < MAXSTRING; i++) {
			nombre[i] = gemFileRandom.readChar();
		}
		String nombreString = new String(nombre).trim();
		
		char[] color = new char[MAXSTRING];
		for (int i = 0; i < MAXSTRING; i++) {
			color[i] = gemFileRandom.readChar();
		}
		String colorString = new String(color).trim();
		

		double dureza = gemFileRandom.readDouble();

		double tamanno = gemFileRandom.readDouble();

		boolean natural = gemFileRandom.readBoolean();

		Gema gem = new Gema(newId, nombreString, colorString, dureza, tamanno, natural);
		return gem;
	}
	
	public void cerrar () throws IOException {
		if (gemFileRandom != null) {
			gemFileRandom.close();
		}
	}
	
	public void gemasDePrueba() throws IOException {
		Gema g1 = new Gema("Alejandrita", "Cambiante", 8.5, 2, false);
		Gema g2 = new Gema("Jade", "Verde", 7, 2.7, true);
		Gema g3 = new Gema("Malaquita", "Verde", 5, 5, false);
		Gema g4 = new Gema("Ojo de Tigre", "Amarillento", 6.5, 1.8, true);
		Gema g5 = new Gema("Turmalina", "Todos", 7, 5, false);
		
		this.iniciar();
		this.escribir(g1);
		this.escribir(g2);
		this.escribir(g3);
		this.escribir(g4);
		this.escribir(g5);
	}
	
	private static int convertirPosicion (int id) {
		int pos = (id - 1) * RECORDBYTES;
		
		if (pos < 1) {
			return 0;
		} else {
			return pos;
		}
	}
	
	
	
}