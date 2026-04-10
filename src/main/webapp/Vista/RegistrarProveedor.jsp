<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
    <head>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" >
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/7.0.1/css/all.min.css" />
        <title>Registrar Proveedor</title>
    </head>
    <body>
        
        <%@include file="/Vista/menu.jsp" %>

        <div class="container mt-3">
            <div class="card">
                <div class="card-header bg-dark text-white">
                    <h3>${proveedor.id_proveedor == 0 ? "Registrar nuevo proveedor" : "Editar Proveedor" }</h3>
                </div>
                <hr />
                <div class="card-body">
                    <form action="controlProveedor" method="POST">
                        <input type="hidden" name="id_proveedor" value="${proveedor.id_proveedor}">
    
                        <div class="mb-3">
                            <label>NIT / Identificación: </label>
                            <input name="nit" value="${proveedor.nit}" type="text" class="form-control" required>
                        </div>
                        <div class="mb-3">
                            <label>Nombre de la Empresa: </label>
                            <input name="nombre" value="${proveedor.nombre}" type="text" class="form-control" required>
                        </div>
                        <div class="mb-3">
                            <label>Teléfono: </label>
                            <input name="telefono" value="${proveedor.telefono}" type="text" class="form-control" required>
                        </div>
                        <div class="mb-3">
                            <label>Dirección: </label>
                            <input name="direccion" value="${proveedor.direccion}" type="text" class="form-control" required>
                        </div>
    
                        <div class="mb-3">
                            <input type="hidden" name="opcion" value="registrarproveedor">
                            <input type="hidden" name="idp" value="${proveedor.id_proveedor == 0 ? 'nuevo' : 'Editar'}">

                            <button type="submit" class="btn btn-primary btn-sm">
                                ${proveedor.id_proveedor != 0 ? 'Actualizar' : 'Registrar'}
                            </button>
                            <a href="controlProveedor?opcion=consultar" class="btn btn-dark btn-sm">Regresar</a>
                        </div>
                    </form>
                </div>
            </div>            
        </div>
    </body>
</html>