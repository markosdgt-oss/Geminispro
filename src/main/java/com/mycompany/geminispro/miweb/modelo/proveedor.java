package com.mycompany.geminispro.miweb.modelo;

public class proveedor {
    
    private int id_proveedor;
    private String nit;
    private String nombre_empresa;
    private String correo;
    private String direccion;
    private String ciudad;
    private String telefono;

    // Constructor vacío (Obligatorio para Java Web)
    public proveedor() {
    }

    // Constructor con parámetros (Opcional, pero útil)
    public proveedor(int id_proveedor, String nit, String nombre_empresa, String correo, String direccion, String ciudad, String telefono) {
        this.id_proveedor = id_proveedor;
        this.nit = nit;
        this.nombre_empresa = nombre_empresa;
        this.correo = correo;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.telefono = telefono;
    }

    // Métodos Getter y Setter (Fundamentales para que el DAO y el Control funcionen)

    public int getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(int id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getNombre_empresa() {
        return nombre_empresa;
    }

    public void setNombre_empresa(String nombre_empresa) {
        this.nombre_empresa = nombre_empresa;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setContacto(String parameter) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
