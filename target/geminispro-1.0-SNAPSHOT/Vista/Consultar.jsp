<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Lista de Clientes - GeminisPro</title>
        
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
    </head>
    <body class="bg-light">
        
        <%@ include file="menu.jsp" %>

        <div class="container mt-4">
            <div class="card shadow-sm">
                <div class="card-header bg-white py-3">
                    <h3 class="text-center text-primary mb-0">Lista de Clientes Registrados</h3>
                </div>
                <div class="card-body">
                    <div class="d-flex justify-content-between align-items-center mb-3">
                        <p class="text-muted mb-0">Gestión de base de datos de clientes</p>
                        <a href="clienteControl?opcion=registrarcliente" class="btn btn-success">
                            <i class="fa fa-plus-circle"></i> Nuevo Registro
                        </a>
                    </div>
                    
                    <div class="table-responsive">
                        <table class="table table-striped table-hover border">
                            <thead class="table-dark">
                                <tr>
                                    <th>ID</th>
                                    <th>Identificación</th>
                                    <th>Nombres</th>
                                    <th>Correo Electrónico</th>
                                    <th>Dirección</th>
                                    <th>Ciudad</th>
                                    <th>Teléfono</th>
                                    <th class="text-center">Acciones</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${clientes}" var="item">
                                    <tr>
                                        <td>${item.id_cliente}</td>
                                        <td>${item.identificacion}</td>
                                        <td>${item.nombres}</td>
                                        <td>${item.correo}</td>
                                        <td>${item.direccion}</td> 
                                        <td>${item.ciudad}</td>
                                        <td>${item.telefono}</td>
                                        <td class="text-center">
                                            <a href="clienteControl?opcion=modificarcliente&idbuscar=${item.id_cliente}" class="btn btn-warning btn-sm">
                                                <i class="fa fa-edit"></i>
                                            </a>                       
                                            <a href="clienteControl?opcion=eliminar&id=${item.id_cliente}" 
                                                class="btn btn-danger btn-sm" 
                                                onclick="return confirm('¿Está seguro de eliminar a ${item.nombres}?')">
                                                    <i class="fa fa-trash"></i>
                                            </a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    
                    <c:if test="${empty clientes}">
                        <div class="alert alert-info text-center">
                            No hay clientes registrados en el sistema.
                        </div>
                    </c:if>
                </div>
            </div>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    </body>
</html>
