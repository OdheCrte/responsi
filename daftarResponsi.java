/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVC;


import java.awt.ScrollPane;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author ACER
 */
public class daftarResponsi extends JFrame{
    //Daftar
    JLabel jldaftar = new JLabel("DAFTAR");
    //account
    JLabel jlusername = new JLabel("Username : ");
    JTextField jtusername = new JTextField();
    JLabel jlpassword = new JLabel("Password : ");
    JTextField jtpassword = new JTextField();
    //button
    JButton jbdaftar=new JButton("Daftar");
    JButton jbbatal = new JButton("Batal");
    JButton jbexit=new JButton("Exit");
    public daftarResponsi(){
        
        setTitle("Perpustakaan");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        setSize(680,400); // x , y
        
        add(jldaftar);
        jldaftar.setBounds(210, 80, 90, 20);
        //Username==============================================================
        add(jlusername);
        jlusername.setBounds(140,120, 380, 20);
        add(jtusername);
        jtusername.setBounds(220, 120, 150, 20);
        // Password ============================================================
        add(jlpassword);
        jlpassword.setBounds(140, 160, 90, 20);
        add(jtpassword);
        jtpassword.setBounds(220, 160, 150, 20);
        
        // BUTTON ==============================================================
        add(jbdaftar);
        jbdaftar.setBounds(160, 200, 90, 20);
        
        add(jbbatal);
        jbbatal.setBounds(280, 200, 90, 20);
        
        add(jbexit);
        jbexit.setBounds(510, 20, 90, 20);
        
    }
    
    
    //Buat ngambil data texfield
    public String getUsername(){
        return jtusername.getText();
    }
    
    public String getPassword(){
        return jtpassword.getText();
    }
}
