
package Modelo;

import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author YAVIRAC9
 */
public class usuario_Mod {
    private String cl;
        private String nombre;   
        private double sueldo;
   //objeto
conexion_Mod db = new conexion_Mod ();
 
    
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
    


        
      public int GuardarUsuario() throws Exception {
    int valor=0;
     if (db.Conectar()==1) {
         String Query="insert into empleado(cl,nombre,sueldo) values ('"+cl+"','"+nombre+"',"+sueldo+")";
          //  String Query = "SELECT * FROM usuarios where usuario='"+usuario+"'" ;
            System.out.println("el SQL para Guardar en Usuario es "+Query);          
           // ResultSet resultado=db.EjecutarSQL(Query);
          // JOptionPane.showMessageDialog(null, "consulta ejecutadas es "+ Query);          
            if(db.ejecutar(Query)){                              
                valor= 1;
            }else {
               valor= 0;
          
           }
            db.desconectar();
           }
            else {  }
           return valor;
   
       } 
  
public int BuscarUsuario () throws Exception {
    int valor=0;
        try {
            if (db.Conectar()==1) {
                String Query="select * from empleado where cl='"+cl+"'";


                ResultSet resultado=db.EjecutarSQL2(Query);
                
                if(resultado.next()){
                    this.cl=resultado.getString("cl");
                 
                    
                    
                    valor= 1;
                }
            }else {
                
                valor= 0;
                
                
            }
        } catch (Exception ex) {
            Logger.getLogger(usuario_Mod.class.getName()).log(Level.SEVERE, null, ex);
        }
            
           return valor;
 }  
}

 

