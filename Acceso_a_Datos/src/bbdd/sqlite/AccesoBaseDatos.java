package bbdd.sqlite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AccesoBaseDatos {

	public static void main(String[] args) {

		
	 	try {
	 		
	 		//1- Crear una instancia del JDBC driver
			Class.forName("org.sqlite.JDBC");
			//2-Especificar la url de la base de datos.
			//3-Establecer una conexión usando el driver que crea el  objeto Connection.
			Connection conexion = DriverManager.getConnection("jdbc:sqlite:src\bbdd\biblioteca.db");

			//4- Crear un objeto Statement, usando Connection.
            Statement sentencia = (Statement) conexion.createStatement();
            //5- Armar el postulado SQL y enviarlo a ejecución usando  el Statement.
            //6- Recibir los resultados en el objeto ResultSet.
            ResultSet resultado = sentencia.executeQuery("select * from socio");
            // recorrer el resultado
            while (resultado.next()) {
            		System.out.println(resultado.getString("Nombre") + "-" + resultado.getInt(1));
            }
            
            //cerrar la conexion
            conexion.close();
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
