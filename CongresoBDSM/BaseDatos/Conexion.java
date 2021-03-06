package BaseDatos;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Statement;

public class Conexion {
	static Connection con=null;
	static String username;
	static String Password;
	static boolean status=false;
	
public static  Connection getConection(){
    	
        status = false;
        String url = "jdbc:mysql://localhost:3306/congreso";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            
        }catch (ClassNotFoundException e){
            JOptionPane.showMessageDialog(null, "No se pudo establece la conexion... revisar Conexion con Base De Datos" + e.getMessage(),
            "Error de Conexion",JOptionPane.ERROR_MESSAGE);
        }
        try{
        	System.out.println(Conexion.Password);
            con = (Connection) DriverManager.getConnection(url, Conexion.username, Conexion.Password);
            
            status = true;
        }catch (SQLException e){
             JOptionPane.showMessageDialog(null, "Error" + e.getMessage(),
            "Error de Conexion",JOptionPane.ERROR_MESSAGE);
        }
        return con;
    }
public static void setcuenta(String usuario, String password){
    Conexion.username = usuario;
    Conexion.Password = password;
}
public static boolean getstatus(){
    return  status;
}
public static ResultSet Consulta(String consulta){
    Connection con = getConection();
    java.sql.Statement declara;
    try{
        declara=con.createStatement();
        ResultSet respuesta = declara.executeQuery(consulta);
        return respuesta;
    }catch (SQLException e){
        JOptionPane.showMessageDialog(null, "Error" + e.getMessage(),
        "Error de Conexion",JOptionPane.ERROR_MESSAGE);
    }
    return null;
}





}
