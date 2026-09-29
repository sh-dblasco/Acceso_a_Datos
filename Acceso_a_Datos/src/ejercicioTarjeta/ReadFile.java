package ejercicioTarjeta;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class ReadFile {
	
	public static List<Person> read(String fileName) throws IOException, FileNotFoundException {
		List<Person> personList = new ArrayList<Person>();
		String objectFile = "src/ejercicioTarjeta/tarjetas.dat";
		
		File file = new File (fileName);
		BufferedReader inputStream = null;
		FileOutputStream fs = null;
		ObjectOutputStream os = null;
		
		try {
			inputStream = new BufferedReader(new FileReader(file));
			fs = new FileOutputStream(objectFile);
			os = new ObjectOutputStream(fs);
			
			String line = inputStream.readLine();
			
			do {
				Person person = new Person(line);
				os.writeObject(person);
				personList.add(person);
				line = inputStream.readLine();
				
			} while (line != null);
			
		} finally {
			if (inputStream != null) {
				inputStream.close();
			}
			
			if (os != null) {
				os.close();
			}
			
			if (fs != null) {
				fs.close();
			}
		}
		
		return personList;
	}
	
}
