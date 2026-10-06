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
	
	public void abrir() {
		try {
			gemFileRandom = new RandomAccessFile(file, "rw");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void iniciar() {
		try {
			if (gemFileRandom == null) {
				System.out.println("No existe el fichero.");
				return;
				
			} else {
				gemFileRandom.seek(0);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void escribir (Gema gem) {
		long pos = convertirPosicion(gem.getId());
		
		try {
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
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Gema leer (int id) {
		Gema gem = null;
		long pos = convertirPosicion(id);
		
		try {
			int newId = gemFileRandom.readInt();
			
			char nombre[] = new char[MAXSTRING];
			for (int i = 0; i < MAXSTRING; i++) {
				nombre[i] = gemFileRandom.readChar();
			}
			String nombreString = new String(nombre);
			
			char color[] = new char[MAXSTRING];
			for (int i = 0; i < MAXSTRING; i++) {
				nombre[i] = gemFileRandom.readChar();
			}
			String colorString = new String(color);
			
			double dureza = gemFileRandom.readDouble();
			
			double tamanno = gemFileRandom.readDouble();
			
			boolean natural = gemFileRandom.readBoolean();
			
			gem = new Gema(newId, nombreString, colorString, dureza, tamanno, natural);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return gem;
	}
	
	public void cerrar () {
		
	}
	
	private static int convertirPosicion (int id) {
		int pos = (id - 1) * RECORDBYTES;
		
		if (pos < 1) {
			return 1;
		} else {
			return pos;
		}
	}
	
	
	
}