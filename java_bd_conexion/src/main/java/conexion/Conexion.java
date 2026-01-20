package conexion; // Esto es vital para que el import funcione

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    public static Connection getConexion() {
        Connection con = null;
        try {
            // Aquí va tu código de DriverManager.getConnection...
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Normalizacion",
                    "postgres", "renato.2004");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
}