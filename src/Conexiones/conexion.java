package Conexiones;

import Procedimientos.Login;
import Procedimientos.NuevoUsuario;
import java.sql.*;

public class conexion {
    private static Connection cn = null;
    private static Statement st;
    private String user = "root";
    private String pass = "milito22";
    private String host = "localhost";
    private String nombreDB = "vitadata";
    
    public Connection conexion(){
        try{
            if(cn == null){
                Class.forName("com.mysql.jdbc.Driver").newInstance( );
                String servidor = "jdbc:mysql://" + host + "/" + nombreDB;
                cn = DriverManager.getConnection(servidor,user,pass);
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }        
        return cn;
    }    
    
    Statement createStatement(){
        throw new UnsupportedOperationException("No soportado");
    }
    
    public static void cerrar() throws SQLException{
        if (cn != null) {
                cn.close();
                st.close();
      }
    }
    
    //SP insertar nuevo usuario
    public void nuevoUsuario(NuevoUsuario dts){
        
        String query = "{call spInsertUser(?,?,?,?,?,?)}";
        ResultSet rs;
        
        try{                        
            cn = this.conexion();
            CallableStatement stmt = cn.prepareCall(query);
            
            stmt.setString(1, dts.getName());            
            stmt.setString(2, dts.getUser());                        
            stmt.setString(3, dts.getPass());
            stmt.setString(4, dts.getMail());
            stmt.setString(5, dts.getCed());
            stmt.setString(6, dts.getInd());
            
            rs = stmt.executeQuery();
            
            System.out.println(rs);
            
        }catch (SQLException ex){
            System.out.println("error mysql:" + ex.getMessage());
        }
    }
    
    //SP inicio de sesión de usuario
    public int Usuario(Login dts){
        
        String query = "{call spUsers(?,?)}";
        ResultSet rs;
        
        try{                        
            int[] result = new int[1];
            cn = this.conexion();
            CallableStatement stmt = cn.prepareCall(query);
            
                  
            stmt.setString(1, dts.getUser());                        
            stmt.setString(2, dts.getPass());
            
            rs = stmt.executeQuery();
            
            while(rs.next()){
                result[0] = (rs.getInt(6));
            }
            
            return result[0];
            
        }catch (SQLException ex){
            System.out.println("error mysql:" + ex.getMessage());
            return 0;
        }
        
    }
}


