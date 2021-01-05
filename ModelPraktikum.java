/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Orenji
 */
public class ModelPraktikum {
    
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/responsi_perpus";
    static final String USER = "root";
    static final String PASS = "";
    Connection koneksi;
    Statement statement;
    
    public ModelPraktikum(){
        try{
            Class.forName(JDBC_DRIVER);
            koneksi = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Koneksi Berhasil");
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println("Koneksi Gagal");
        }
    }
    
    public void insertUser(String username, String password){
        int jmlData=0;
        try {
           
           
           String query = "Select * from accounts WHERE Username=" + username; 
           ResultSet resultSet = statement.executeQuery(query);
           
           while (resultSet.next()){ 
                jmlData++;
            }
           
           
            if (jmlData==0) {
                query = "INSERT INTO accounts(Username, Paswword) VALUES ('"+username+"','"+password+"')";
           
                statement = (Statement) koneksi.createStatement();
                statement.executeUpdate(query); //execute querynya
                System.out.println("Berhasil ditambahkan");
                JOptionPane.showMessageDialog(null, "Akun Anda Berhasil ditambahkan");
            }
            else {
                JOptionPane.showMessageDialog(null, "Username sudah ada");
            }
        } catch (Exception sql) {
            System.out.println(sql.getMessage());   
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }
    
    public void updateMahasiswa(String nim, String nama, String alamat){
        int jmlData=0;
         try {
           String query = "Select * from mahasiswa WHERE nim=" + nim; 
           ResultSet resultSet = statement.executeQuery(query);
           
           while (resultSet.next()){ 
                jmlData++;
            }
           
             if (jmlData==1) {
                query = "UPDATE mahasiswa SET nama='" + nama + "', alamat='" + alamat +"' WHERE nim=" + nim;
                statement = (Statement) koneksi.createStatement();
                statement.executeUpdate(query); //execute querynya
                System.out.println("Berhasil diupdate");
                JOptionPane.showMessageDialog(null, "Data Berhasil diupdate");
             }
             else {
                 JOptionPane.showMessageDialog(null, "Data Tidak Ada");
             }
           
        } catch (Exception sql) {
            System.out.println(sql.getMessage());   
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }
    
    public String[][] readAccount(){
        try{
            int jmlData = 0;
            
            String data[][] = new String[getBanyakDataA()][2]; //baris, kolom nya ada 3
            
            String query = "Select * from accounts"; 
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                data[jmlData][0] = resultSet.getString("Username"); //harus sesuai nama kolom di mysql
                data[jmlData][1] = resultSet.getString("Password");       
                jmlData++;
            }
            return data;
               
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return null;
        }
    }
    public String[][] readdaftar(){
        daftarResponsi daftarresponsi=new daftarResponsi();
        LoginResponsi loginresponsi=new LoginResponsi();
        
        loginresponsi.dispose();
        daftarresponsi.setVisible(true);
        
        
        return null;
    }
    public String[][] readUser(String Username,String Password){
        String data[][] = new String[getBanyakDataA()][3];
        try
        {
            String query = "SELECT * FROM accounts WHERE Username= '"+Username+"' AND Password ='"+Password+"'";
            statement = koneksi.createStatement();
            ResultSet RS = statement.executeQuery(query);
            
            int jmlData=0;
            
            
             while (RS.next()){
                data[jmlData][0] = RS.getString("Username"); //harus sesuai nama kolom di mysql
                data[jmlData][1] = RS.getString("Password");   
                jmlData++;
            }
             
             
             if(jmlData==1)
             {
                 ViewPraktikum viewpraktikum=new ViewPraktikum ();
                 viewpraktikum.setVisible(true);
                 readTransaction();
             }
             else
             {
                 JOptionPane.showMessageDialog(null, "Invalid Username or Password");
             }
 
           return data;
        }
        
        catch(SQLException sql) {
            System.out.println(sql.getMessage());
         }
        
        return data;
    }
    public String[][] readTransaction(){
        try{
            int jmlData = 0;
            
            String data[][] = new String[getBanyakDataT()][5]; //baris, kolom nya ada 3
            
            String query = "Select MemberId,MemberName,BookId,BookName from transactions"; 
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                //data[jmlData][0] = resultSet.getString("Id"); //harus sesuai nama kolom di mysql
                data[jmlData][0] = resultSet.getString("MemberId");       
                data[jmlData][1] = resultSet.getString("MemberName");       
                data[jmlData][2] = resultSet.getString("BookId");   
                data[jmlData][3] = resultSet.getString("BookName");       
                jmlData++;
            }
            return data;
               
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return null;
        }
    }/*
    public String[][] searchMahasiswa (String nim)  
    {
        String data[][] = new String[getBanyakData()][3];
        try
        {
            String query = "SELECT * FROM mahasiswa WHERE nim like '%"+nim+"%'";
            statement = koneksi.createStatement();
            ResultSet RS = statement.executeQuery(query);
            
            int jmlData=0;
            
            
             while (RS.next()){
                data[jmlData][0] = RS.getString("nim"); //harus sesuai nama kolom di mysql
                data[jmlData][1] = RS.getString("nama");                
                data[jmlData][2] = RS.getString("alamat");
                jmlData++;
            }
             
             if(jmlData==0)
             {
                 data = null;
             }
            
 
           return data;
        }
        
        catch(SQLException sql) {
            System.out.println(sql.getMessage());
         }
        
        return data;
    }*/
    public int getBanyakDataA(){
        int jmlData = 0;
        try{
            statement = koneksi.createStatement();
            String query = "Select * from accounts";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){ 
                jmlData++;
            }
            return jmlData;
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return 0;
        }
    }
    public int getBanyakDataT(){
        int jmlData = 0;
        try{
            statement = koneksi.createStatement();
            String query = "Select * from transactions";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){ 
                jmlData++;
            }
            return jmlData;
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return 0;
        }
    }
    
    public void deleteTransaction (String Id) {
        try{
            String query = "DELETE FROM transaction WHERE Id  = '"+Id+"'";
            statement = koneksi.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Berhasil Dihapus");
            
        }catch(SQLException sql) {
            System.out.println(sql.getMessage());
        }
    }
}
