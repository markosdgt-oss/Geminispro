
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
    <head>

        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" >
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/7.0.1/css/all.min.css" integrity="sha512-2SwdPD6INVrV/lHTZbO2nodKhrnDdJK9/kg2XD1r9uGqPo1cUbujc+IYdlYdEErWNu69gVcYgdxlmVmzTWnetw==" crossorigin="anonymous" referrerpolicy="no-referrer" />

        <title>Registrar Cliente</title>
    </head>
    <body>
       
        <%@include file="/Vista/menu.jsp" %>

        <div class="container mt-3">
            <div class="card">
                <h3>${cliente.id_cliente == 0 ? "Registrar nuevo cliente" : "Editar Cliente" }</h3>
                <hr />
                <div class="card-body">
                    <form action="clienteControl" method="POST">
                        <input type="hidden" name="id_cliente" value="${cliente.id_cliente}">
    
                        <div class="mb-3">
                            <label>Identificación: </label>
                            <input name="identificacion" value="${cliente.identificacion}" type="number" class="form-control" required>
                        </div>
                        <div class="mb-3">
                            <label>Nombres: </label>
                            <input name="nombres" value="${cliente.nombres}" type="text" class="form-control" required>
                        </div>
                        <div class="mb-3">
                            <label>Correo: </label>
                            <input name="correo" value="${cliente.correo}" type="email" class="form-control" required>
                        </div>
                        <div class="mb-3">
                            <label>Dirección: </label>
                            <input name="direccion" value="${cliente.direccion}" type="text" class="form-control" required>
                        </div>
                        <div class="mb-3">
                            <label>Ciudad: </label>
                            <input name="ciudad" value="${cliente.ciudad}" type="text" class="form-control" required>
                        </div>
                        <div class="mb-3">
                            <label>Teléfono: </label>
                            <input name="telefono" value="${cliente.telefono}" type="text" class="form-control" required>
                        </div>
    
                        <div class="mb-3">
                            <input type="hidden" name="opcion" value="registrarcliente">
                            <input type="hidden" name="idc" value="${cliente.id_cliente == 0 ? 'nuevo' : 'Editar'}">

                                <button type="submit" class="btn btn-primary btn-sm">
                                    ${cliente.id_cliente != 0 ? 'Actualizar' : 'Registrar'}
                                </button>
                            <a href="clienteControl?opcion=consultar" class="btn btn-dark btn-sm">Regresar</a>
                        </div>
                    </form>
                </div>
            </div>            
        </div>
    </body>
</html>
