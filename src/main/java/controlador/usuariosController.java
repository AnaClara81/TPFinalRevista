package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.usuarios;
import modelo.usuariosDAO;


@WebServlet(name = "usuariosController", urlPatterns = {"/usuariosController"})
public class usuariosController extends HttpServlet {

     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        usuariosDAO usuariosDao = new usuariosDAO();
        String accion;
        RequestDispatcher dispatcher =null;
        accion = request.getParameter("accion");
        
        if(accion == null || accion.isEmpty()){
           dispatcher = request.getRequestDispatcher("Vistas/usuarios.jsp"); 
        }else if(accion.equals("modificar")){
          dispatcher = request.getRequestDispatcher("Vistas/modificar.jsp");
        
        }else if(accion.equals("actualizar")){
            int id = Integer.parseInt(request.getParameter("id"));
            String nombre = request.getParameter("nombre");
            String apellido = request.getParameter("apellido");
            String email = request.getParameter("email");
            int edad = Integer.parseInt(request.getParameter("edad"));
            String pais = request.getParameter("pais");
            
           usuarios usuario = new usuarios(id,nombre,apellido,email,edad,pais);
            usuariosDAO.actualizarUsuarios(usuario);
           
            dispatcher = request.getRequestDispatcher("Vistas/usuarios.jsp");
            dispatcher.forward(request,response);
        
        
        }else if(accion.equals("eliminar")){
            
            int id = Integer.parseInt(request.getParameter("id"));
            usuariosDao.eliminarUsuario(id);
            
        dispatcher = request.getRequestDispatcher("Vistas/usuarios.jsp");
        
        }else if(accion.equals("nuevo")){
        
         dispatcher = request.getRequestDispatcher("Vistas/nuevo.jsp");
        
        }else if(accion.equals("insert")){
          String nombre=request.getParameter("nombre");
          String apellido=request.getParameter("apellido");
          String email=request.getParameter("email");
          int edad = Integer.parseInt(request.getParameter("edad"));
          String pais=request.getParameter("pais");
          
          usuarios usuario =new usuarios(0,nombre,apellido,email,edad,pais);
          usuariosDAO.insertarUsuarios(usuario);
        
          dispatcher = request.getRequestDispatcher("Vistas/usuarios.jsp");
        
        }else{
            dispatcher = request.getRequestDispatcher("Vistas/usuarios.jsp");
            
        }
   
        dispatcher.forward(request, response);
        }
    

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        doGet (request,response);
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
