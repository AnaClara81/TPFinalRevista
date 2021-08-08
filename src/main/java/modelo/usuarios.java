
package modelo;

/**
 *
 * @author anace
 */
public class usuarios {
    private int id;
    private String nombre;
    private String apellido;
    private String email;
    private int edad;
    private String pais;
    
    
    public usuarios(int id, String nombre, String apellido, String email,int edad, String pais){
    this.id=id;
    this.nombre=nombre;
    this.apellido=apellido;
    this.email=email;
    this.edad=edad;
    this.pais=pais;
    
    
    }

   

  

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

   public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

int setEdad() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
     
}
