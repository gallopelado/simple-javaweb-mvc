package controller.referenciales.ciudad;

import dao.referenciales.ciudad.CiudadDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.referenciales.ciudad.CiudadModel;

/**
 *
 * @author juan
 */
@WebServlet(name = "CiudadController", urlPatterns = { "/CiudadController" })
public class CiudadController extends HttpServlet {

    // traer todas las ciudades
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        // Dependiendo de las opciones recibidas
        var accion = req.getParameter("accion");
        var ciudad = new CiudadDAO();
        RequestDispatcher rd = null;
        switch (accion) {
            case "index":
                List<CiudadModel> lista_ciudades = ciudad.seleccionarTodos();
                req.setAttribute("lista_ciudades", lista_ciudades);
                rd = req.getRequestDispatcher("vista/referenciales/ciudad/index_ciudad.jsp");
                rd.forward(req, resp);
                break;
            case "nuevo":
                req.setAttribute("editar", false);
                rd = req.getRequestDispatcher("vista/referenciales/ciudad/form_ciudad.jsp");
                rd.forward(req, resp);
                break;
            case "editar":
                req.setAttribute("editar", true);
                String id = req.getParameter("id");
                if(id != null) {
                    req.setAttribute("id", id);
                    var ciu = ciudad.seleccionarPorId(Integer.parseInt(id));
                    if(ciu.getDescripcion()!= null) req.setAttribute("descripcion", ciu.getDescripcion());
                    rd = req.getRequestDispatcher("vista/referenciales/ciudad/form_ciudad.jsp");
                    rd.forward(req, resp);
                } else {
                    // Aquí si el id es nulo, entonces puedes enviar a la página de errores
                }
                break;
            case "eliminar":
                req.setAttribute("editar", false);
                if(req.getParameter("id")!=null) {
                    Boolean resultado = ciudad.eliminar(Integer.parseInt(req.getParameter("id")));
                    if(resultado) {
                        req.setAttribute("mensaje_usuario", "Se ha borrado el registro exitosamente");
                        resp.sendRedirect(req.getContextPath()+"/CiudadController?accion=index");
                    } else resp.sendRedirect(req.getContextPath()+"/CiudadController?accion=index");
                }
                break;
            default:
                // ninguna opción correcta, lo mandas a la pagina de error
                throw new AssertionError();
        }
        
    }

    // Guardar una nueva ciudad
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // verificar los parametros recibidos
        var ciudad = new CiudadDAO();
        req.setCharacterEncoding("UTF-8");
        Boolean resultado = false;
        var accion = req.getParameter("accion");
        if(accion==null) {
            // mandar a la pagina de error
        }
        RequestDispatcher rd = null;
        var mensaje_usuario = "";
        String descripcion = req.getParameter("txt_ciudad_descripcion");
        if(descripcion!=null && !descripcion.trim().equals("")) {
            
            if(accion.equals("guardar")) {
                req.setAttribute("editar", false);
                resultado = ciudad.agregar(new CiudadModel(null, descripcion.toUpperCase()));
                mensaje_usuario = resultado ? "Guardado exitoso" : "No se pudo guardar";
                req.setAttribute("mensaje_usuario", mensaje_usuario);

                if (resultado) {
                    resp.sendRedirect(req.getContextPath()+"/CiudadController?accion=index");
                } else {
                    rd = req.getRequestDispatcher("vista/referenciales/ciudad/form_ciudad.jsp");
                    rd.forward(req, resp);
                }
            }
            
            if(accion.equals("editar")) {
                req.setAttribute("editar", true);
                String id = req.getParameter("txt_ciudad_id");
                if(id==null) {
                    // mandar a la pagina de error
                }
                resultado = ciudad.modificar(new CiudadModel(Integer.parseInt(id), descripcion.toUpperCase()));
                mensaje_usuario = resultado ? "Editado exitoso" : "No se pudo editar";
                req.setAttribute("mensaje_usuario", mensaje_usuario);

                if (resultado) {
                    resp.sendRedirect(req.getContextPath()+"/CiudadController?accion=index");
                } else {
                    rd = req.getRequestDispatcher("vista/referenciales/ciudad/form_ciudad.jsp");
                    rd.forward(req, resp);
                }
            }
            
            
            
        } else {
    
            if(accion.equals("editar"))req.setAttribute("editar", true);
            else req.setAttribute("editar", false);
    
            req.setAttribute("mensaje_usuario", "Ingrese correctamente los datos");
            rd = req.getRequestDispatcher("vista/referenciales/ciudad/form_ciudad.jsp");
            rd.forward(req, resp);
        }
    }
    
}
