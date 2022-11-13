<%-- 
    Document   : index
    Created on : Nov 12, 2022, 10:13:32 PM
    Author     : juan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <%-- headers --%>
        <jsp:include page="../../menu/headers.jsp" />  
        <%-- headers/ --%>
        <title>Inicio Ciudad</title>
    </head>
    <body class="sb-nav-fixed">
        <%-- Nav del user --%>
        <jsp:include page="../../menu/user_nav.jsp" />  
        <%-- Nav del user/ --%>
        
        <div id="layoutSidenav">
            
            <%-- Menu layout --%>
            <jsp:include page="../../menu/menu_layout.jsp" />
            <%-- Menu layout/ --%>
            
            <%-- Contenido inicio layout --%>
            <div id="layoutSidenav_content">
                <main>
                    <div class="container-fluid px-4">
                        <h1 class="mt-4">Ciudades</h1>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item active">Semillas de navegación</li>
                        </ol>
                        <div class="card">
                            <div class="card-header d-flex justify-content-between">
                                <h3>Lista de ciudades</h3>
                                <a href="${pageContext.request.contextPath}/CiudadController?accion=nuevo" class="btn btn-primary" role="button">Nuevo</a>
                            </div>
                            <div class="card-body">
                                <table class="table">
                                    <thead>
                                        <tr>
                                            <th scope="col">Descripción</th>
                                            <th scope="col">Acción</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach var="item" items="${lista_ciudades}">
                                        <tr>
                                            <th scope="row">${item.descripcion}</th>
                                            <td>
                                                <a href="${pageContext.request.contextPath}/CiudadController?accion=editar&id=${item.id}" class="btn btn-primary" role="button">Editar</a>
                                                <a href="${pageContext.request.contextPath}/CiudadController?accion=eliminar&id=${item.id}" class="btn btn-danger" role="button">Eliminar</a>
                                            </td>
                                        </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                            <c:if test = "${mensaje_usuario != null}">
                            <div class="card-footer">
                                <div class="alert alert-success alert-dismissible fade show" role="alert">
                                    <strong>¡Exitoso!</strong> Se ha procesado
                                    <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                                </div>
                            </div>
                            </c:if>
                        </div>
                </main>
            <%-- Contenido inicio layout/ --%>
            
        </div>
        <jsp:include page="../../menu/javascript_sources.jsp" />
    </body>
</html>
