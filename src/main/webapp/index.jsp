
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
       
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/7.0.1/css/all.min.css" integrity="sha512-2SwdPD6INVrV/lHTZbO2nodKhrnDdJK9/kg2XD1r9uGqPo1cUbujc+IYdlYdEErWNu69gVcYgdxlmVmzTWnetw==" crossorigin="anonymous" referrerpolicy="no-referrer" />        
        <title>JSP Page</title>
    </head>
    <body>
               
        <div class="container-fluid mt-5 text-center py-4 w-100 mb-3" style="background-color: fuchsia;">
            <h1 class="text-white">Cabellos Sanos</h1>            
        </div>
        <!-- Inicio Navbar -->
        <nav class="navbar navbar-expand-lg navbar-dark" style="background-color: #e158f3">
            <div class="container-fluid">
                <a class="navbar-brand" href="#">Resultados Increibles</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarNavDropdown">
                    <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="${pageContext.request.contextPath}/Vista/menu.jsp">Inicio</a>
                        </li>
                        <li class="nav-item dropdown">
                           <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                              Cliente
                           </a>
                              <ul class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                              <li><a class="dropdown-item" href="<c:url value='/clienteControl?opcion=consultar'/>">Consultar Todos</a></li>
                              <li><a class="dropdown-item" href="<c:url value='/clienteControl?opcion=nuevocliente'/>">Registrar Cliente</a></li>
                              <li><a class="dropdown-item" href="<c:url value='/clienteControl?opcion=buscar'/>">Actualizar Registro</a></li>
                              <li><a class="dropdown-item" href="<c:url value='/clienteControl?opcion=eliminar'/>">Eliminar Registro</a></li>
                              </ul>
                        </li>
                        <li class="nav-item dropdown">
                           <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                              Porveedor
                           </a>
                              <ul class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                              <li><a class="dropdown-item" href="<c:url value='/clienteControl?opcion=consultar'/>">Consultar Proveedores</a></li>
                              <li><a class="dropdown-item" href="<c:url value='/clienteControl?opcion=nuevocliente'/>">Registrar Proveedor</a></li>
                              <li><a class="dropdown-item" href="<c:url value='/clienteControl?opcion=buscar'/>">Actualizar Proveedor</a></li>
                              <li><a class="dropdown-item" href="<c:url value='/clienteControl?opcion=eliminar'/>">Eliminar Registro Proveedor</a></li>
                              </ul>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                Productos
                            </a>
                            <ul class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                                <li><a class="dropdown-item" href="#">Shampoo</a></li>
                                <li><a class="dropdown-item" href="#">Acondicionador</a></li>
                                <li><a class="dropdown-item" href="#">Tratamientos</a></li>
                                <li><hr class="dropdown-divider"></li>
                                <li><a class="dropdown-item" href="#">Otros</a></li>
                            </ul>
                        </li>
                    </ul>                    
                </div>
            </div>
        </nav>
        <!-- Fin Navbar -->
        <div class="container text-center mt-4">
            <img src="${pageContext.request.contextPath}/Vista/img/imagenlogo.jpg" 
            alt="Logo de Cabellos Sanos" 
            class="img-fluid" 
            style="max-width: 2000px; height: auto;">
        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

    </body>