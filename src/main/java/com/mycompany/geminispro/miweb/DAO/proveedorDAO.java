package com.mycompany.geminispro.miweb.DAO;

import com.mycompany.geminispro.miweb.conexion.conexionDB;
import com.mycompany.geminispro.miweb.modelo.proveedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class proveedorDAO {

    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Conexion cn = new Conexion();

    public List<proveedor> mostrar() {
        List<proveedor> lista = new ArrayList<>();
        String sql = "SELECT * FROM proveedores";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                proveedor pr = new proveedor();
                pr.setId_proveedor(rs.getInt("id_proveedor"));
                pr.setNit(rs.getString("nit"));
                pr.setNombre_empresa(rs.getString("nombre_empresa"));
                pr.setCorreo(rs.getString("correo"));
                pr.setDireccion(rs.getString("direccion"));
                pr.setCiudad(rs.getString("ciudad"));
                pr.setTelefono(rs.getString("telefono"));
                lista.add(pr);
            }
        } catch (Exception e) {
            System.err.println("Error en mostrar proveedores: " + e.getMessage());
        }
        return lista;
    }

    public int NuevoRegistroProveedor(proveedor pr) {

        String sql = "INSERT INTO proveedores (nit, nombre_empresa, correo, direccion, ciudad, telefono) VALUES (?,?,?,?,?,?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, pr.getNit());
            ps.setString(2, pr.getNombre_empresa());
            ps.setString(3, pr.getCorreo());
            ps.setString(4, pr.getDireccion());
            ps.setString(5, pr.getCiudad());
            ps.setString(6, pr.getTelefono());
            return ps.executeUpdate();
        } catch (Exception e) {
            System.err.println("Error al registrar proveedor: " + e.getMessage());
            return 0;
        }
    }

    public proveedor BuscarIdProveedor(int id) {
        proveedor pr = new proveedor();
        String sql = "SELECT * FROM proveedores WHERE id_proveedor = " + id;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                pr.setId_proveedor(rs.getInt("id_proveedor"));
                pr.setNit(rs.getString("nit"));
                pr.setNombre_empresa(rs.getString("nombre_empresa"));
                pr.setCorreo(rs.getString("correo"));
                pr.setDireccion(rs.getString("direccion"));
                pr.setCiudad(rs.getString("ciudad"));
                pr.setTelefono(rs.getString("telefono"));
            }
        } catch (Exception e) {
            System.err.println("Error al buscar proveedor: " + e.getMessage());
        }
        return pr;
    }

    public int ActualizarRegistroProveedor(proveedor pr) {
 
        String sql = "UPDATE proveedores SET nit=?, nombre_empresa=?, correo=?, direccion=?, ciudad=?, telefono=? WHERE id_proveedor=?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, pr.getNit());
            ps.setString(2, pr.getNombre_empresa());
            ps.setString(3, pr.getCorreo());
            ps.setString(4, pr.getDireccion());
            ps.setString(5, pr.getCiudad());
            ps.setString(6, pr.getTelefono());
            ps.setInt(7, pr.getId_proveedor());
            return ps.executeUpdate();
        } catch (Exception e) {
            System.err.println("Error al actualizar proveedor: " + e.getMessage());
            return 0;
        }
    }

    public int EliminarProveedor(int id) {
        String sql = "DELETE FROM proveedores WHERE id_proveedor = " + id;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            return ps.executeUpdate();
        } catch (Exception e) {
            System.err.println("Error al eliminar proveedor: " + e.getMessage());
            return 0;
        }
    }

    private static class Conexion {

        public Conexion() {
        }

        private Connection getConnection() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
    }
}