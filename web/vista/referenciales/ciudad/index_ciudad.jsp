<%-- 
    Document   : index
    Created on : Nov 12, 2022, 10:13:32 PM
    Author     : juan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                        <h1 class="mt-4">Titulo de tu formulario</h1>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item active">Semillas de navegación</li>
                        </ol>
                        <div class="card">
                            <div class="card-header">Lista de ciudades</div>
                            <div class="card-body">
                                <p class="card-text">Aquí podría ir tu tabla</p>
                            </div>
                        </div>
                </main>
            <%-- Contenido inicio layout/ --%>
            
        </div>
        <jsp:include page="../../menu/javascript_sources.jsp" />
    </body>
</html>
