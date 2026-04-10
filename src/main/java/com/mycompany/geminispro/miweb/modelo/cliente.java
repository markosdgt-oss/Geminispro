package com.mycompany.geminispro.miweb.modelo;

/**
 * Modelo para la entidad Cliente
 * @author marko
 */
public class cliente {
    private int id_cliente;
    private String identificacion;
    private String nombres;
    private String correo;
    private String direccion;
    private String ciudad;
    private String telefono;

    // 1. Constructor vacío (Indispensable para Servlets)
    public cliente() {
    }

    // 2. Constructor con todos los parámetros (Opcional, pero muy útil)
    public cliente(int id_cliente, String identificacion, String nombres, String correo, String direccion, String ciudad, String telefono) {
        this.id_cliente = id_cliente;
        this.identificacion = identificacion;
        this.nombres = nombres;
        this.correo = correo;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.telefono = telefono;
    }

    // 3. Métodos Getter y Setter corregidos
    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
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

    // 4. Método de compatibilidad (Puente para el error de dedo en el controlador)
    // Esto evita que el programa se detenga si en el controlador escribiste "setIndentificacion"
    public void setIndentificacion(String identificacion) {
        this.identificacion = identificacion;
    }
}
