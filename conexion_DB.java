package clases_ProyectoFinal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexion_DB{
	
	private static String url ="jdbc:mysql://localhost:3306/proyecto_final";
	private static String usuario = "root";
	private static String password = "";
		
	public static Connection conectando() {
		Connection conexion = null;
		try {
			conexion = DriverManager.getConnection(url, usuario, password);
			
		}catch (SQLException e) {
			System.out.println("Ha ocurrido un error al conectar la base de datos" + e.getMessage());
		}
		return conexion;
	}

}
