package Controlador;
import Modelo.usuario_Mod;
import Vista.Usuario;
import javax.swing.JOptionPane;
public class acceso_controller {
  private String cl;
  private String nombre;
   private double sueldo;
   
   
    public String getCl() {
        return cl;
    }

    /**
     * @param cl the cl to set
     */
    public void setCl(String cl) {
        this.cl = cl;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the sueldo
     */
    public double getSueldo() {
        return sueldo;
    }

    /**
     * @param sueldo the sueldo to set
     */
    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }
   
  
Usuario v = new Usuario();
  usuario_Mod m = new usuario_Mod();
   
    

  public void GuardarUsuario()throws Exception {
      m.setCl(cl);
      m.setNombre(nombre);
      m.setSueldo(sueldo);
      
    if(m.BuscarUsuario()==1){
    
    JOptionPane.showMessageDialog(null, "El numero de Cedula ya existe");
    } else{
    m.GuardarUsuario();
    }
        
  
  
          
  }
      public void BuscarUsuario()throws Exception {
      
    
      m.setCl(cl);
      
      if(m.BuscarUsuario()==1){
          this.cl=m.getCl();
         
        // v.mostrardatos();
        }else
         v.MostrarError("error");  
	}    


             


      
}

   
   
        

