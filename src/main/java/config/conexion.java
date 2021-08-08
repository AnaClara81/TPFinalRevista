
package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author anace
 */
public class conexion {
    public String driver ="com.mysql.jdbc.Driver";
    public Connection getConnection(){
        Connection conexion = null;
        try{
            Class.forName(driver);
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/revista",
                    "ana","21581");
        }catch(ClassNotFoundException | SQLException e){
            System.out.println(e.toString());
        }
        return conexion;
    }
 public static void main(String[]args) throws SQLException{
     Connection conexion =null;
     conexion con = new conexion();  
        conexion = con.getConnection();
        PreparedStatement ps;
        ResultSet rs;
        ps = conexion.prepareStatement("SELECT * FROM usuarios");
          rs = ps.executeQuery();
          while(rs.next()){
              int id = rs.getInt("id");
              String nombre = rs.getString("nombre");
              String apellido = rs.getString("apellido");
              String email = rs.getString("email");
              int edad = rs.getInt("edad");
              String pais = rs.getString("pais");
              System.out.println("id: "+id+ " nombre: "+nombre+ "  apellido: "+apellido+ " email: "+email+" edad: "+edad+ " pais: "+pais);
          }
        
}


}
