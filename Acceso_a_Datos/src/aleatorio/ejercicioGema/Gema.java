package aleatorio.ejercicioGema;

import java.util.Objects;

public class Gema {
	private int id;				//4 bytes
	private String nombre;		//20 caracteres max - 40 bytes
	private String color;		//20 caracteres max - 40 bytes
	private double dureza;		//8 bytes
	private double tamanno;		//8 bytes
	private boolean natural;	//1 byte
	
	private static int contador = 1;
	
	
	public Gema(String nombre, String color, double dureza, double tamanno, boolean natural) {
		super();
		this.id = contador;
		contador++;
		this.nombre = nombre;
		this.color = color;
		this.dureza = dureza;
		this.tamanno = tamanno;
		this.natural = natural;
	}
	
	public Gema(int id, String nombre, String color, double dureza, double tamanno, boolean natural) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.color = color;
		this.dureza = dureza;
		this.tamanno = tamanno;
		this.natural = natural;
	}
	//--------------------------------------------------------------------------------------------
	
	@Override
	public String toString() {
		return nombre + " [id=" + id +
				", color=" + color +
				", dureza=" + dureza +
				", tamanno=" + tamanno
				+ ", natural=" + natural +
				"]";
	}
	
	//--------------------------------------------------------------------------------------------
	
	public String getNombre () {
		return this.nombre;
	}
	
	public int getId () {
		return this.id;
	}
	
	public String getColor() {
		return color;
	}

	public double getDureza() {
		return dureza;
	}

	public double getTamanno() {
		return tamanno;
	}

	public boolean isNatural() {
		return natural;
	}
	
	//--------------------------------------------------------------------------------------------
	
	
	
	//--------------------------------------------------------------------------------------------

	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Gema other = (Gema) obj;
		
		return Objects.equals(id, other.id);
	}
	
	
}
