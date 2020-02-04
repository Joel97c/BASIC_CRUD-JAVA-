package Modelo;
import java.sql.*;
import javax.swing.JOptionPane;

public class conexion_Mod {
  private static Connection Conexion;
  private  Statement sentencia; 
  
  private final String db_name="empleados";//
      private final String user="postgres";//
         private final String pass="1234";//
    

  public int  Conectar() throws Exception {
           //Cargamos el Driver, previmente se debe agregar al programa Libraries/MySQL ODBC
            Class.forName("org.postgresql.Driver");
         
            Conexion = DriverManager.getConnection("jdbc:postgresql://localhost:5432/" + db_name, user, pass);
            
            if (Conexion != null)
         { 
                        JOptionPane.showMessageDialog(null, "Se ha iniciado la conexión con el servidor de forma exitosa Nombre de la Base de Dato: "+db_name+" Usuario "+user+" Clave "+pass);
            return 1;
         }else {
              
                JOptionPane.showMessageDialog(null, "Error en Conexion");
            return 0;
    
            }
           }
  public void desconectar() throws SQLException {                  
            if(Conexion!=null){
                //cerrar la conexion
                 Conexion.close();
             //    JOptionPane.showMessageDialog(null, "Se ha finalizado la conexión con el servidor");
                 Conexion=null;
            }else{
            JOptionPane.showMessageDialog(null, "no se puede cerrar una conexion que no ha sido iniciada");
            }      
    } 
 public boolean ejecutar(String SQL){
    boolean estado=false;
     try {
         sentencia=Conexion.createStatement();
         sentencia.execute(SQL);
         sentencia.close();
     } catch (SQLException ex) {
         System.err.println("Error: ConectorBD.ejecutar(SQL) "+SQL);
     }
    
return estado;
}
  public ResultSet ejecutarSQL(String SQL){
    ResultSet resultado=null;
     try {
         sentencia=Conexion.createStatement();
    resultado=sentencia.executeQuery(SQL);
         
     } catch (SQLException ex) {
         System.err.println("Error: ConectorBD.ejecutar(SQL) "+SQL);
     }
    
return resultado;
}
public ResultSet EjecutarSQL2(String sql){
 ResultSet resultado=null;

     try {
         sentencia= Conexion.createStatement();
         resultado=sentencia.executeQuery(sql);
     } catch (SQLException ex) {
         System.err.println("Error: ConetorBD.Seleccionar(SQL) "+sql);
         System.err.println("Error: "+ex.getMessage());
         
     } 
 return resultado;
 } 
 

   
}

