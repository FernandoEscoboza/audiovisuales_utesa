
//SQL: Lenguaje de consulta estandar
package clases;
import java.sql.*;
import javax.swing.JOptionPane;


public class conectar {
   Connection conect = null;
   private final String url = "jdbc:mysql://localhost:3306/audiovisuales_utesa";
    private final String user = "root";
    private final String pass = "";
    
   
   public Connection conexion() throws ClassNotFoundException {
       
       try{
           //cargamos el driver MySql
           Class.forName("org.gjt.mm.mysql.Driver");
           
           //aqui cargamos la url, el usuario y contraseña de la base de datos
           conect = DriverManager.getConnection(url,user,pass);
           
//           JOptionPane.showMessageDialog(null,"Conectado");
       
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null,"Error "+e);
       } 
       return conect;
       
       
   }
}
