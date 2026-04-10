package com.mycompany.geminispro.miweb.DAO;

import com.mycompany.geminispro.miweb.conexion.conexionDB;
import com.mycompany.geminispro.miweb.modelo.cliente;
import java.sql.*;
import java.util.*;

public class clienteDAO {

    private Connection con = null; 
    private PreparedStatement prest = null;
    private ResultSet res = null;

    public ArrayList<cliente> mostrar() {
        ArrayList<cliente> clientelista = new ArrayList<>();
    // Quitamos el nombre de la base de datos de la consulta, ya que conexionDB ya la tiene
        String sql = "SELECT * FROM cliente"; 
    
        try {
            con = conexionDB.getConnection(); // Usamos la variable global
            if (con != null) {
                prest = con.prepareStatement(sql);
                res = prest.executeQuery();
             
                System.out.println("--- INICIO DE RASTREO DAO ---");
            
                while (res.next()) {
                    cliente cl = new cliente();
                
                // Asegúrate de que estos nombres coincidan EXACTO con phpMyAdmin
                    cl.setId_cliente(res.getInt("id_cliente")); 
                    cl.setIdentificacion(res.getString("identificacion"));
                    cl.setNombres(res.getString("nombres"));
                    cl.setCorreo(res.getString("correo"));
                    cl.setDireccion(res.getString("direccion"));
                    cl.setCiudad(res.getString("ciudad"));
                    cl.setTelefono(res.getString("telefono"));
                
                    System.out.println("✅ Leyendo registro: " + cl.getNombres());
                    clientelista.add(cl);
                }
                System.out.println("--- FIN DE RASTREO: Total " + clientelista.size() + " ---");
            }
        } catch (SQLException e) {
        System.out.println("❌ ERROR SQL EN DAO: " + e.getMessage());
        } finally {
            cerrarRecursos(); // Cerramos ordenadamente
        }
        return clientelista;
    }

    public cliente BuscarIdCliente(int id) {
        cliente cl = null;
        try {
            con = conexionDB.getConnection();
            if (con != null) {
                String SQL = "SELECT * FROM cliente WHERE id_cliente = ?"; 
                prest = con.prepareStatement(SQL);
                prest.setInt(1, id);
                res = prest.executeQuery();

                if (res.next()) {
                    cl = new cliente();
                    cl.setId_cliente(res.getInt("id_cliente"));
                    cl.setIdentificacion(res.getString("identificacion"));
                    cl.setNombres(res.getString("nombres"));
                    cl.setCorreo(res.getString("correo"));
                    cl.setDireccion(res.getString("direccion"));
                    cl.setCiudad(res.getString("ciudad"));
                    cl.setTelefono(res.getString("telefono"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            cerrarRecursos();
        }
        return cl;
    }

    public int NuevoRegistroCliente(cliente cl) {
        int resp = 0;
        String sql = "INSERT INTO cliente(identificacion, nombres, correo, direccion, ciudad, telefono) VALUES (?,?,?,?,?,?)";
    
        try {
            con = conexionDB.getConnection();
            if (con != null) {
                prest = con.prepareStatement(sql);
                prest.setString(1, cl.getIdentificacion());
                prest.setString(2, cl.getNombres());
                prest.setString(3, cl.getCorreo());
                prest.setString(4, cl.getDireccion());
                prest.setString(5, cl.getCiudad());
                prest.setString(6, cl.getTelefono());
            
                resp = prest.executeUpdate();
                System.out.println("✅ Registro exitoso en la BD");
            }
        } catch (SQLException e) {
            System.out.println("❌ Error al insertar: " + e.getMessage());
        } finally {
        cerrarRecursos();
        }
        return resp;
    }

    public int ActualizarRegistroCliente(cliente cl) {
        int resp = 0;
        try {
            con = conexionDB.getConnection();
            if (con != null) {
                String sql = "UPDATE cliente SET identificacion=?, nombres=?, correo=?, direccion=?, ciudad=?, telefono=? WHERE id_cliente=?";
                prest = con.prepareStatement(sql);
                prest.setString(1, cl.getIdentificacion());
                prest.setString(2, cl.getNombres());
                prest.setString(3, cl.getCorreo());
                prest.setString(4, cl.getDireccion());
                prest.setString(5, cl.getCiudad());
                prest.setString(6, cl.getTelefono());
                prest.setInt(7, cl.getId_cliente());
                resp = prest.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            cerrarRecursos();
        }
        return resp;
    }
    
    public int EliminarCliente(int id) {
        int resp = 0;
        String sql = "DELETE FROM cliente WHERE id_cliente = ?";
        try {
            con = conexionDB.getConnection();
            if (con != null) {
                prest = con.prepareStatement(sql);
                prest.setInt(1, id);
                resp = prest.executeUpdate();
                System.out.println("✅ Cliente eliminado con éxito");
            }
        } catch (Exception e) {
            System.out.println("❌ Error al eliminar: " + e.getMessage());
            e.printStackTrace();
        } finally {
        cerrarRecursos();
    }
    return resp;
    }

    private void cerrarRecursos() {
        try {

            if (res != null && !res.isClosed()) res.close();
            if (prest != null && !prest.isClosed()) prest.close();
            if (con != null && !con.isClosed()) con.close(); // Corregido: usar 'con'
        } catch (SQLException e) {
            System.out.println("Error al cerrar recursos: " + e.getMessage());
        }
    }
}