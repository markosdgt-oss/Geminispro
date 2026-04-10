<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Buscar Cliente - GeminisPro</title>
        
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
    </head>
    <body class="bg-light">
        
        <%@ include file="menu.jsp"%>

        <div class="container mt-5">
            <div class="row justify-content-center">
                <div class="col-md-6">
                    <div class="card shadow-sm">
                        <div class="card-header bg-primary text-white text-center">
                            <h5 class="card-title mb-0">
                                <i class="bi bi-person-search"></i> Buscar Cliente para Modificar
                            </h5>
                        </div>
                        <div class="card-body p-4">
                            <form action="clienteControl" method="GET">
                                <input type="hidden" name="opcion" value="modificarcliente">
                                
                                <div class="mb-3">
                                    <label for="idbuscar" class="form-label">ID del Cliente:</label>
                                    <div class="input-group">
                                        <input type="number" 
                                               class="form-control" 
                                               id="idbuscar"
                                               name="idbuscar"  
                                               placeholder="Ej: 101" 
                                               required>
                                        <button type="submit" class="btn btn-primary">
                                            <i class="bi bi-search"></i> Buscar
                                        </button>
                                    </div>
                                    <div class="form-text">Ingrese el código numérico (ID) del cliente registrado.</div>
                                </div>
                            </form>
                        </div>
                        <div class="card-footer text-center">
                            <a href="clienteControl?opcion=consultar" class="btn btn-link btn-sm text-decoration-none">
                                <i class="bi bi-arrow-left"></i> Volver a la lista
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    </body>
</html>
