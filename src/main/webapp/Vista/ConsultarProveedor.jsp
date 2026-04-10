<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
    <head>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" >
        <title>Consultar Proveedores</title>
    </head>
    <body>
        <%@include file="/Vista/menu.jsp" %>
        
        <div class="container mt-3">
            <h3>Listado de Proveedores</h3>
            <hr/>
            <a href="Vista/RegistrarProveedor.jsp" class="btn btn-success btn-sm mb-3">Nuevo Proveedor</a>
            
            <table class="table table-bordered table-striped">
                <thead class="table-dark">
                    <tr>
                        <th>ID</th>
                        <th>NIT</th>
                        <th>Nombre</th>
                        <th>Teléfono</th>
                        <th>Dirección</th>
                        <th>Acciones</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="p" items="${listaProveedores}">
                        <tr>
                            <td>${p.id_proveedor}</td>
                            <td>${p.nit}</td>
                            <td>${p.nombre}</td>
                            <td>${p.telefono}</td>
                            <td>${p.direccion}</td>
                            <td>
                                <a href="controlProveedor?opcion=editar&id=${p.id_proveedor}" class="btn btn-warning btn-sm">Editar</a>
                                <a href="controlProveedor?opcion=eliminar&id=${p.id_proveedor}" class="btn btn-danger btn-sm" onclick="return confirm('¿Desea eliminar este proveedor?')">Eliminar</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
</html>