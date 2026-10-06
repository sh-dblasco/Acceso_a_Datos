package aleatorios;

public class Main {

	public static void main(String[] args) {


		GestionaGema almacenGemas = new GestionaGema("randomFile.dat");
		
		Gema g1 = new Gema(1, "Alejandrita", "Cambiante", 8.5, 2, false);
		Gema g2 = new Gema(2, "Jade", "Verde", 7, 2.7, true);
		Gema g3 = new Gema(3, "Malaquita", "Verde", 5, 5, false);
		Gema g4 = new Gema(4, "Ojo de Tigre", "Amarillento", 6.5, 1.8, true);
		Gema g5 = new Gema(5, "Turmalina", "Todos", 7, 5, false);
		
		almacenGemas.abrir();
		
		almacenGemas.iniciar();
		almacenGemas.escribir(g1);
		almacenGemas.escribir(g2);
		almacenGemas.escribir(g3);
		almacenGemas.escribir(g4);
		almacenGemas.escribir(g5);
		
		Gema gemaLeida = almacenGemas.leer(2);
		System.out.println(gemaLeida.toString());
		
		almacenGemas.cerrar();
	}

}
