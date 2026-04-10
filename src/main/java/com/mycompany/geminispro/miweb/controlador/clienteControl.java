package com.mycompany.geminispro.miweb.controlador;

import com.mycompany.geminispro.miweb.DAO.clienteDAO;
import com.mycompany.geminispro.miweb.modelo.cliente;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "clienteControl", urlPatterns = {"/clienteControl"})
public class clienteControl extends HttpServlet {

    private final String Listcl = "Vista/Consultar.jsp";
    private final String NewCl = "Vista/RegistrarCliente.jsp";
    private final String ModCl = "Vista/BuscarIdCliente.jsp";
    
    private final clienteDAO clDAO = new clienteDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
   
        request.setCharacterEncoding("UTF-8"); 
    
        response.setContentType("text/html;charset=UTF-8");
        String opcion = request.getParameter("opcion");
    
        if (opcion == null) opcion = "consultar";

        switch (opcion) {
            case "consultar" -> consultar(request, response);
            case "nuevocliente" -> mostrarFormulario(request, response);
            case "registrarcliente" -> guardarCliente(request, response);
            case "buscar" -> buscarcliente(request, response);
            case "modificarcliente" -> modificarcliente(request, response);
            case "eliminar" -> eliminarcliente(request, response);
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
        List<cliente> lista = clDAO.mostrar();
        request.setAttribute("clientes", lista);
        request.getRequestDispatcher(Listcl).forward(request, response);
    }

    private void mostrarFormulario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("cliente", new cliente());
        request.getRequestDispatcher(NewCl).forward(request, response);
    }

    private void guardarCliente(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    
        cliente cl = new cliente();
    
        try {
            String idStr = request.getParameter("id_cliente");
            cl.setId_cliente((idStr != null && !idStr.isEmpty()) ? Integer.parseInt(idStr) : 0);
        
            cl.setIdentificacion(request.getParameter("identificacion")); 
            cl.setNombres(request.getParameter("nombres"));
            cl.setCorreo(request.getParameter("correo"));
            cl.setDireccion(request.getParameter("direccion"));
            cl.setCiudad(request.getParameter("ciudad")); 
            cl.setTelefono(request.getParameter("telefono")); 

            String idc = request.getParameter("idc");
            int res = 0;
        
            if (idc != null && idc.trim().equalsIgnoreCase("nuevo")) {
                res = clDAO.NuevoRegistroCliente(cl);
            } else {
                res = clDAO.ActualizarRegistroCliente(cl);
            }

            if (res > 0) {
                response.sendRedirect("clienteControl?opcion=consultar");
            } else {
                request.setAttribute("error", "No se pudo guardar en la base de datos.");
                request.setAttribute("cliente", cl);
                request.getRequestDispatcher(NewCl).forward(request, response);
                request.setCharacterEncoding("UTF-8");
            } 
        } catch (Exception e) {
        System.out.println("Error en guardarCliente: " + e.getMessage());
        e.printStackTrace();
        }
}

    private void buscarcliente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher(ModCl).forward(request, response);
    }

    private void modificarcliente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idBusq = request.getParameter("idbuscar");
        if (idBusq != null) {
            int id_cliente = Integer.parseInt(idBusq);
            cliente cl = clDAO.BuscarIdCliente(id_cliente);

            if (cl != null) {
                request.setAttribute("cliente", cl);
                request.getRequestDispatcher(NewCl).forward(request, response);
            }
        }
    }

    private void eliminarcliente(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
    
        String idEliminar = request.getParameter("id");
        if (idEliminar != null) {
            int id = Integer.parseInt(idEliminar);
            int res = clDAO.EliminarCliente(id);
        
            if (res > 0) {
                response.sendRedirect("clienteControl?opcion=consultar");
            }
        }
    }
}
 