<%-- 
    Document   : form_ciudad.jsp
    Created on : Nov 13, 2022, 12:28:06 PM
    Author     : juan
--%>

<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
                        <h1 class="mt-4">Formulario de ciudad</h1>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item active">Semillas de navegación</li>
                        </ol>
                        <div class="card">
                            <div class="card-header">Datos de ciudad</div>
                            <div class="card-body">
                                
                                <%-- Aqui va el formulario de ciudad --%>
                                <c:if test = "${editar == false}">
                                    <form name="frm_ciudad" id="frm_ciudad" action="${pageContext.request.contextPath}/CiudadController?accion=guardar" method="post">
                                </c:if>
                                <c:if test = "${editar == true}">
                                    <form name="frm_ciudad" id="frm_ciudad" action="${pageContext.request.contextPath}/CiudadController?accion=editar" method="post">
                                </c:if>
                                    <c:if test = "${editar == true}">
                                    <input type="hidden" name="txt_ciudad_id" id="txt_ciudad_id" value="${id}">
                                    </c:if>
                                    <div class="mb-3">
                                        <label for="txt_ciudad_descripcion" class="form-label">Descripción</label>
                                        <input type="text" class="form-control" id="txt_ciudad_descripcion" name="txt_ciudad_descripcion" aria-describedby="descripciónciudad" autofocus="on" value="${descripcion}" autocomplete="off">
                                        <div id="emailHelp" class="form-text">${mensaje_usuario}</div>
                                    </div>
                                    <c:if test = "${editar == false}">
                                    <button type="submit" class="btn btn-primary" name="btn_ciudad_guardar" id="btn_ciudad_guardar">Guardar</button>    
                                    </c:if>
                                    <c:if test = "${editar == true}">
                                    <button type="submit" class="btn btn-warning" name="btn_ciudad_guardar" id="btn_ciudad_editar">Editar</button>    
                                    </c:if>
                                    
                                </form>
                                <%-- Aqui va el formulario de ciudad/ --%>
                                
                            </div>
                        </div>
                </main>
            <%-- Contenido inicio layout/ --%>
            
        </div>
        <jsp:include page="../../menu/javascript_sources.jsp" />
    </body>
</html>
