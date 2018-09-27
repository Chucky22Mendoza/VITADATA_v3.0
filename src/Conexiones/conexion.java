package Conexiones;

import Procedimientos.Cita;
import Procedimientos.DPaciente;
import Procedimientos.IdDoctor;
import Procedimientos.Login;
import Procedimientos.NomDoctor;
import Procedimientos.NuevoUsuario;
import Procedimientos.Paciente;
import Procedimientos.Receptor;
import Procedimientos.nuevoPaciente;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class conexion {
    private static Connection cn = null;
    private static Statement st;
    private String user = "root";
    private String pass = "admin1234";
    private String host = "vitadata.c8febllwvki7.us-east-2.rds.amazonaws.com";
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
    
    //SP insertar nuevo usuario  1
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
    
    //SP inicio de sesión de usuario 2
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
    
    //SP Pacientes 3
    public DefaultComboBoxModel getNames(IdDoctor dts){
        DefaultComboBoxModel mod = new DefaultComboBoxModel();
        String query = "Select * from paciente where _idDoctor = ?";
        ResultSet rs;
        try{
            cn = this.conexion();
            CallableStatement stmt = cn.prepareCall(query);
            stmt.setInt(1, dts.getId());
            rs = stmt.executeQuery();
            
            while(rs.next()){
                mod.addElement(rs.getString("_nombre")); 
            }
            
         }catch (Exception e){
             System.out.println(e);
         }
        return mod;
    }
    
    //Sp spInsertPaciente 4
    public void NuevoPaciente(nuevoPaciente dts){
        String query = "{call spInsertPaciente(?,?,?,?,?,?,?,?,?,?,?,?,?)}";
        ResultSet rs;
        
        try{                        
            cn = this.conexion();
            CallableStatement stmt = cn.prepareCall(query);
                  
            stmt.setString(1, dts.getName());
            stmt.setInt(2, dts.getEdad());
            stmt.setString(3, dts.getFecha());
            stmt.setFloat(4,dts.getPeso());
            stmt.setFloat(5,dts.getEst());
            stmt.setString(6, dts.getNomRec());
            stmt.setInt(7,dts.getIdDoc());
            stmt.setString(8, dts.getTel());
            stmt.setString(9, dts.getPersPat());
            stmt.setString(10, dts.getNoPat());
            stmt.setString(11, dts.getFam());
            stmt.setString(12, dts.getMedQui());
            stmt.setString(13, dts.getPad());
            
            rs = stmt.executeQuery();     
            
            JOptionPane.showMessageDialog(null, "Registro de paciente completado correctamente", "Completado", JOptionPane.INFORMATION_MESSAGE);
            
        }catch (SQLException ex){
            System.out.println("error mysql:" + ex.getMessage());
        }
    }
    
    //Sp datosPac 5
    public ArrayList DPac(Paciente dts){
        ArrayList lista = new ArrayList();
        String query = "{call spDatosPac(?)}";
        ResultSet rs;
        try {
            cn = this.conexion();
            CallableStatement stmt = cn.prepareCall(query);
            stmt.setString(1, dts.getNombre());
            rs = stmt.executeQuery();     
            
            while(rs.next()){
                String nombre = rs.getString("Nombre");
                int edad = rs.getInt("Edad");
                float imc = rs.getFloat("IMC");
                String pp = rs.getString("PersPatologicos");
                String np = rs.getString("NoPatologicos");
                String fam = rs.getString("Familiares");
                String mq = rs.getString("MedicoQui");
                String pad = rs.getString("Padecimiento");
                
                DPaciente dp = new DPaciente(nombre,edad,imc,pp,np,fam,mq,pad);
                lista.add(dp);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return lista;
    }
   
     //Sp monitoreo ind 6
    public DefaultTableModel pacMon(Paciente dts){
        DefaultTableModel mod;
        String [] titulos = {"Temperatura", "Oxígeno Sangre", "Frecuencia C"};
        
        String [] registro = new String [3];
        
        mod = new DefaultTableModel(null, titulos);
        
        String query = "{call spData(?)}";
        ResultSet rs;
        try {
            cn = this.conexion();
            CallableStatement stmt = cn.prepareCall(query);
            stmt.setString(1, dts.getNombre());
            rs = stmt.executeQuery();     
            
            while(rs.next()){
                registro [0] = rs.getString("Temperatura");
                registro [1] = rs.getString("OxigenoSangre");
                registro [2] = rs.getString("FrecuenciaCardiaca");
                
                mod.addRow(registro);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return mod;
    }
   
    //Sp monitoreo gen 7
    public DefaultTableModel Mon(){
        DefaultTableModel mod;
        String [] titulos = {"Nombre", "Temperatura", "Oxígeno Sangre", "Frecuencia C"};
        
        String [] registro = new String [4];
        
        mod = new DefaultTableModel(null, titulos);
        
        String query = "{call spDatos()}";
        ResultSet rs;
        try {
            cn = this.conexion();
            CallableStatement stmt = cn.prepareCall(query);
            rs = stmt.executeQuery();     
            
            while(rs.next()){
                registro [0] = rs.getString("Nombre");
                registro [1] = rs.getString("Temperatura");
                registro [2] = rs.getString("OxigenoSangre");
                registro [3] = rs.getString("FrecuenciaCardiaca");
                
                mod.addRow(registro);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return mod;
    }
    
    //spDoctor 8
    public String Doc(IdDoctor dts){
        String query = "{call spDoctor(?)}";
        ResultSet rs;
        
        try {
            String [] registro = new String[1];
            cn = this.conexion();
            CallableStatement stmt = cn.prepareCall(query);
            
            stmt.setInt(1, dts.getId());
            rs = stmt.executeQuery();     
            
            while(rs.next()){
                registro[0] = (rs.getString("_nombre"));
            }
            return registro[0];
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
        
    }
    //spTelRec 9
    public ArrayList Rec(Paciente dts){
        ArrayList lista = new ArrayList();
        String query = "{call spTelRec(?)}";
        ResultSet rs;
        try {
            cn = this.conexion();
            CallableStatement stmt = cn.prepareCall(query);
            stmt.setString(1, dts.getNombre());
            rs = stmt.executeQuery();     
            
            while(rs.next()){
                String nombre = rs.getString("NombreRec");
                String telefono = rs.getString("TelefonoRec");
                
                Receptor rec = new Receptor(nombre,telefono);
                lista.add(rec);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return lista;
    }
    
    //sp Cita 10
    public int cita(Cita dts){
        String query = "{call spCita(?,?)}";
        ResultSet rs;
        try {
            cn = this.conexion();
            CallableStatement stmt = cn.prepareCall(query);
            stmt.setString(1, dts.getNombre());
            stmt.setInt(2, dts.getId());
            
            rs = stmt.executeQuery();   
            JOptionPane.showMessageDialog(null, "Registro de cita completado correctamente", "Completado", JOptionPane.INFORMATION_MESSAGE);
            
            return 1;
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }
        
    }
    //spHistorial 11
    public DefaultTableModel Historial(NomDoctor dts){
        DefaultTableModel mod;
        String [] titulos = {"Paciente", "Fecha de atención"};
        
        String [] registro = new String [2];
        
        mod = new DefaultTableModel(null, titulos);
        
        String query = "{call spHisDoc(?)}";
        ResultSet rs;
        try {
            cn = this.conexion();
            CallableStatement stmt = cn.prepareCall(query);
            stmt.setString(1, dts.getNombre());
            rs = stmt.executeQuery();     
            
            while(rs.next()){
                registro [0] = rs.getString("Nombre");
                registro [1] = rs.getString("FechaAtencion");
                
                mod.addRow(registro);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return mod;
    }
   }
    



