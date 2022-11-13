<%-- 
    Document   : index
    Created on : Nov 10, 2022, 10:15:07 PM
    Author     : juan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <%-- headers --%>
        <jsp:include page="vista/menu/headers.jsp" />  
        <%-- headers/ --%>
        <title>Taller de 4to</title>
    </head>
    <body class="sb-nav-fixed">
        <%-- Nav del user --%>
        <jsp:include page="vista/menu/user_nav.jsp" />  
        <%-- Nav del user/ --%>
        
        <div id="layoutSidenav">
            
            <%-- Menu layout --%>
            <jsp:include page="vista/menu/menu_layout.jsp" />
            <%-- Menu layout/ --%>
            
            <%-- Contenido inicio layout --%>
            <jsp:include page="vista/menu/start_content_layout.jsp" />
            <%-- Contenido inicio layout/ --%>
            
        </div>
        <jsp:include page="vista/menu/javascript_sources.jsp" />
    </body>
</html>

