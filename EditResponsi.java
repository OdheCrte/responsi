/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVC;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
/**
 *
 * @author ACER
 */
public class EditResponsi extends JFrame{
    JLabel jlidangg = new JLabel("ID Anggota  : ");
    JTextField jtidangg = new JTextField();
    JLabel jlnamaangg = new JLabel("Nama        : ");
    JTextField jtnamaangg = new JTextField();
    JLabel jlidbuk = new JLabel("ID Buku     : ");
    JTextField jtidbuk = new JTextField();
    JLabel jljdlbuk=new JLabel("Judul Buku  :");
    JTextField jtjdlbuk = new JTextField();
    JLabel jlperpus= new JLabel("PERPUSTAKAAN");
    //Button
    JButton jbhome = new JButton("Home");
    JButton jbpinjam = new JButton("Pinjam");
    JButton jbtampil = new JButton("Tampil");
    JButton jbaboutus= new JButton("About Us");
    JButton jblogout=new JButton("Logout");
    JButton jbhapus =new JButton("Hapus");
    JButton jbedit =new JButton("Edit");
    
    
    public EditResponsi(){
        
        setTitle("Perpustakaan");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        setSize(680,400); // x , y
        
        //header
        add(jlperpus);
        jlperpus.setBounds(180, 20, 120, 20);
        //ID Anggta=============================================================
        add(jlidangg);
        jlidangg.setBounds(80,100, 380, 20);
        add(jtidangg);
        jtidangg.setBounds(180, 100, 150, 20);
        //Nama Anggota=============================================================
        add(jlnamaangg);
        jlnamaangg.setBounds(80,140, 380, 20);
        add(jtnamaangg);
        jtnamaangg.setBounds(180, 140, 150, 20);
        //ID Buku=============================================================
        add(jlidbuk);
        jlidbuk.setBounds(80,180, 380, 20);
        add(jtidbuk);
        jtidbuk.setBounds(180, 180, 150, 20);
        // Judul Buku ============================================================
        add(jljdlbuk);
        jljdlbuk.setBounds(80, 220, 90, 20);
        add(jtjdlbuk);
        jtjdlbuk.setBounds(180, 220, 150, 20);
        
        // BUTTON ==============================================================
        add(jblogout);
        jblogout.setBounds(510, 20, 90, 20);
        
        add(jbhome);
        jbhome.setBounds(510, 160, 90, 20);
        
        add(jbpinjam);
        jbpinjam.setBounds(510, 200, 90, 20);
        
        add(jbtampil);
        jbtampil.setBounds(510, 240, 90, 20);
        
        add(jbaboutus);
        jbaboutus.setBounds(510,280,90,20);
        
    }
    //Buat ngambil data texfield
    public String getIdAngg(){
        return jtidangg.getText();
    }
    
    public String getNamaAngg(){
        return jtnamaangg.getText();
    }
    
    public String getIdBuku(){
        return jtidbuk.getText();
    }
    public String getJudulBuku(){
        return jtjdlbuk.getText();
    }

}
