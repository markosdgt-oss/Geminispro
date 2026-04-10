<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" >
        <title>Buscar Proveedor</title>
    </head>
    <body>
        <%@include file="/Vista/menu.jsp" %>
        
        <div class="container mt-3">
            <div class="row justify-content-center">
                <div class="col-md-5">
                    <div class="card shadow-sm">
                        <div class="card-body text-center">
                            <h4>Buscar Proveedor por ID</h4>
                            <form action="controlProveedor" method="GET">
                                <input type="hidden" name="opcion" value="buscarId">
                                <div class="input-group my-3">
                                    <input type="number" name="id_buscar" class="form-control" placeholder="Ingrese el ID" required>
                                    <button class="btn btn-info" type="submit">Consultar</button>
                                </div>
                            </form>
                            <a href="controlProveedor?opcion=consultar" class="btn btn-link">Ver lista completa</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>