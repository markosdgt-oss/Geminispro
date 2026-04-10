package com.mycompany.geminispro.miweb.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Clase de conexión para GeminisPro
 * @author marko
 */
public class conexionDB {

    private static final String DATABASE = "deminisdb"; 
    private static final String USER = "root";
    private static final String PASSWORD = ""; 

    private static final String URL = "jdbc:mysql://localhost:3307/" + DATABASE + "?serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";

    public static Connection getConnection() {
        Connection cn = null;
        try {
            Class.forName(DRIVER);
            cn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("✅ CONEXIÓN EXITOSA AL PUERTO 3307 - BD: " + DATABASE);
        } catch (ClassNotFoundException e) {
            System.out.println("❌ Error: No se encontró el Driver -> " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("❌ Error de SQL: " + e.getMessage());
            System.out.println("Causa: Revisa que el servicio MySQL en el puerto 3307 esté ACTIVO.");
        }
        return cn;
    }

    // Método principal para probar la conexión (Run File)
    public static void main(String[] args) {
        getConnection();
    }
}
