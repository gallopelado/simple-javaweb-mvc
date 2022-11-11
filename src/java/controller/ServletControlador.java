package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Rectangulo;

/**
 *
 * @author juan
 */
@WebServlet(name = "ServletControlador", urlPatterns = {"/ServletControlador"})
public class ServletControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        //1. En este caso no hay necesidad de procesar parametros
        
        //2. Creamos los JavaBeans
        Rectangulo rec = new Rectangulo(3, 6);
        
        //3. Agregar las variables en cierto alcance
        req.setAttribute("mensaje", "Saludos desde el servlet");
        
        HttpSession session = req.getSession();
        session.setAttribute("rectangulo", rec);
        
        //4. Redireccionamos
        RequestDispatcher rd = req.getRequestDispatcher("vista/desplegarVariables.jsp");
        // Se propagan los objetos request y response
        // para que puedan ser utilizados por el JSP seleccionado
        rd.forward(req, resp);
        /*
         Ya no se necesita hacer nada mas despues del redireccionamiento
        ya que el flujo continua con el JSP
        */
    }
    
}
