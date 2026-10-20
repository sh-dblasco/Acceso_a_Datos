package secuencial.ejercicioTarjeta;

import java.io.Serializable;

public class Person implements Serializable {
	private static final String SEPARATOR = ",";
	private static final int YEAR = 2026;
	
	private String name;
	private String lastName;
	private String height;
	private String birthDate;
	private String phoneNumber;
	
	public Person(String line) {
		String[] data = line.split(SEPARATOR);
		
		this.name = data[0];
        this.lastName = data[1];
        this.height = data[2].replace(".", ",");
        this.birthDate = data[3];
        this.phoneNumber = data[4];
	}
	
	
	@Override
	public String toString() {
		return this.name + " " + this.lastName +
				"\n	Altura: " + this.height + 
				"\n	Edad: " + calculateAge(this.birthDate) + " años" +
				"\n	Telefono: " + this.phoneNumber;
	}
	
	private int calculateAge (String birthDate) {
		int age;
		String yearSeparator = "/";
		
		String[] data = birthDate.split(yearSeparator);
		age = YEAR - Integer.parseInt(data[2]);
		
		return age;
	}
}
