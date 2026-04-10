package com.mycompany.geminispro.miweb.controlador;

import com.mycompany.geminispro.miweb.DAO.proveedorDAO;
import com.mycompany.geminispro.miweb.modelo.proveedor;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "proveedorControl", urlPatterns = {"/proveedorControl"})
public class proveedorControl extends HttpServlet {

    // Rutas de las vistas (Asegúrate de que estas carpetas y archivos existan en Vista)
    private final String ListPr = "Vista/ConsultarProveedores.jsp";
    private final String NewPr = "Vista/RegistrarProveedor.jsp";
    private final String ModPr = "Vista/BuscarIdProveedor.jsp";
    
    private final proveedorDAO prDAO = new proveedorDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
   
        request.setCharacterEncoding("UTF-8"); 
    
        response.setContentType("text/html;charset=UTF-8");
        String opcion = request.getParameter("opcion");
    
        if (opcion == null) opcion = "consultar";

        switch (opcion) {
            case "consultar" -> consultar(request, response);
            case "nuevoproveedor" -> mostrarFormulario(request, response);
            case "registrarproveedor" -> guardarProveedor(request, response);
            case "buscar" -> buscarProveedor(request, response);
            case "modificarproveedor" -> modificarProveedor(request, response);
            case "eliminar" -> eliminarProveedor(request, response);
            default -> consultar(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    private void consultar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<proveedor> lista = prDAO.mostrar();
        request.setAttribute("proveedores", lista);
        request.getRequestDispatcher(ListPr).forward(request, response);
    }

    private void mostrarFormulario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("proveedor", new proveedor());
        request.getRequestDispatcher(NewPr).forward(request, response);
    }

    private void guardarProveedor(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    
        proveedor pr = new proveedor();
    
        try {
            String idStr = request.getParameter("id_proveedor");
            pr.setId_proveedor((idStr != null && !idStr.isEmpty()) ? Integer.parseInt(idStr) : 0);
        
            pr.setNit(request.getParameter("nit"));
            pr.setNombre_empresa(request.getParameter("nombre_empresa"));
            pr.setContacto(request.getParameter("contacto"));
            pr.setCorreo(request.getParameter("correo"));
            pr.setDireccion(request.getParameter("direccion"));
            pr.setCiudad(request.getParameter("ciudad")); 
            pr.setTelefono(request.getParameter("telefono")); 

            String idp = request.getParameter("idp");
            int res = 0;
        
            if (idp != null && idp.trim().equalsIgnoreCase("nuevo")) {
                res = prDAO.NuevoRegistroProveedor(pr);
            } else {
                res = prDAO.ActualizarRegistroProveedor(pr);
            }

            if (res > 0) {
                response.sendRedirect("proveedorControl?opcion=consultar");
            } else {
                request.setAttribute("error", "No se pudo guardar el proveedor en la base de datos.");
                request.setAttribute("proveedor", pr);
                request.getRequestDispatcher(NewPr).forward(request, response);
            } 
        } catch (Exception e) {
            System.out.println("Error en guardarProveedor: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void buscarProveedor(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher(ModPr).forward(request, response);
    }

    private void modificarProveedor(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idBusq = request.getParameter("idbuscar");
        if (idBusq != null) {
            int id_proveedor = Integer.parseInt(idBusq);
            proveedor pr = prDAO.BuscarIdProveedor(id_proveedor);

            if (pr != null) {
                request.setAttribute("proveedor", pr);
                request.getRequestDispatcher(NewPr).forward(request, response);
            }
        }
    }

    private void eliminarProveedor(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
    
        String idEliminar = request.getParameter("id");
        if (idEliminar != null) {
            int id = Integer.parseInt(idEliminar);
            int res = prDAO.EliminarProveedor(id);
        
            if (res > 0) {
                response.sendRedirect("proveedorControl?opcion=consultar");
            }
        }
    }
}
