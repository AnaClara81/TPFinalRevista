package modelo;

import config.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author anace
 */
public class usuariosDAO {
Connection conexion;
    public static void insertarUsuarios(usuarios usuario) {
     //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

     /*  public static void insertarusuarios(usuarios usuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

 public static void actualizarUsuarios(usuarios usuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/

   public static void actualizarUsuarios(usuarios usuario) {
       // throw new UnsupportedOperationException("Not supported yet."); To change body of generated methods, choose Tools | Templates.
    }
    
    public usuariosDAO(){
        conexion con = new conexion();
        conexion = con.getConnection();
        
    }
     
    public List<usuarios> listarUsuarios() throws SQLException{
        PreparedStatement ps;
        ResultSet rs;
        List<usuarios> lista = new ArrayList<>();
        try{
            ps = conexion.prepareStatement("SELECT id, nombre, apellido, email,edad, pais FROM usuarios");
            rs = ps.executeQuery();
            while(rs.next()){
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String email = rs.getString("email");
                int edad = rs.getInt("edad");
                String pais = rs.getString("pais");
                usuarios usuarios =new usuarios (id, nombre, apellido, email, edad, pais);
                lista.add(usuarios);
            }
            return lista;
        }catch(SQLException e){
            System.out.println(e.toString());
            return null;
        }
        
    }
    
    public usuarios mostrarUsuario(int _id){
        PreparedStatement ps;
        ResultSet rs;
        usuarios usuario = null;
        
        try{
            ps = conexion.prepareStatement("SELECT id, nombre, apellido, email,edad, pais FROM usuarios WHERE id=?");
            ps.setInt(1, _id);
            rs = ps.executeQuery();
            
            while(rs.next()){
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String email = rs.getString("email");
                int edad = rs.getInt("edad");
                String pais = rs.getString("pais");
                usuario = new usuarios (id, nombre, apellido, email,edad, pais);
                
            }
            return usuario;
        }catch(SQLException e){
            System.out.println(e.toString());
            return null;
        }    
    }
    public boolean insertarUsuario(usuarios usuario) throws SQLException{
       PreparedStatement ps;
       try{
           ps = conexion.prepareStatement("INSERT INTO usuarios(nombre,apellido,email,edad,pais) VALUES (?,?,?,?,?)");
           ps.setString(1,usuario.getNombre());
           ps.setString(2,usuario.getApellido());
           ps.setString(3,usuario.getEmail());
           ps.setInt(4,usuario.setEdad());
           ps.setString(5,usuario.getPais());
           ps.execute();
           return true;
          
       }catch(SQLException e){
           System.out.println(e.toString());
           return false;
       }
    
    }
    
    
    public boolean actualizarUsuario(usuarios usuario) {
         PreparedStatement ps;
         try{
             
            ps= conexion.prepareStatement("UPDATE usuarios SET nombre=?, apellido=?,email=?,edad=?, pais=?");
            ps.setString(1,usuario.getNombre());
            ps.setString(2,usuario.getApellido());
            ps.setString(3,usuario.getEmail());
            ps.setInt(4,usuario.setEdad());
            ps.setString(5,usuario.getPais());
            ps.execute();
            return true;
         }catch(SQLException e){
             System.out.println(e.toString());
             return false;
         }
    }
    
    public boolean eliminarUsuario(int _id){
    PreparedStatement ps;
    try{
       ps= conexion.prepareStatement("DELETE FROM usuarios WHERE id=?");
       ps.setInt(1, _id);
       ps.execute();
       return true;
    
    }catch(SQLException e){
   
        System.out.println(e.toString());
        return false;
    }
    }
}
