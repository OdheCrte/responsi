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
 * @author Orenji
 */
public class ViewPraktikum extends JFrame{
    
    
    JLabel jlnim = new JLabel("Nim : ");
    JTextField jtnim = new JTextField();
    JLabel jlnama = new JLabel("Nama : ");
    JTextField jtnama = new JTextField();
    JLabel jlalamat = new JLabel("Alamat : ");
    JTextField jtalamat = new JTextField();
    JTextField jtcari = new JTextField();
    JLabel jlperpus= new JLabel("PERPUSTAKAAN");
    JLabel jllist=new JLabel("LIST BUKU YANG DIPINJAM");
    //Button
    JButton jbhome = new JButton("Home");
    JButton jbpinjam = new JButton("Pinjam");
    JButton jbtampil = new JButton("Tampil");
    JButton jbaboutus= new JButton("About Us");
    JButton jblogout=new JButton("Logout");
    JButton jbhapus =new JButton("Hapus");
    JButton jbedit =new JButton("Edit");
    
    JTable tabel;
    DefaultTableModel dtm;
    JScrollPane scrollPane;
    Object namaKolom[] = {"ID", "Nama", "ID Buku","Judul Buku"};
    public ViewPraktikum(){
        dtm = new DefaultTableModel(namaKolom, 0);
        tabel = new JTable(dtm);
        scrollPane = new JScrollPane(tabel);
        
        setTitle("Perpustakaan");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        setSize(680,400); // x , y (750,400)
        
        
        //header
        add(jlperpus);
        jlperpus.setBounds(180, 20, 120, 20);
        //Judul Tabel
        add(jllist);
        jllist.setBounds(140, 60, 200, 20);
        add(scrollPane);
        scrollPane.setBounds(20, 80, 480, 300);
        
        
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
        
        add(jbhapus);
        jbhapus.setBounds(140, 40, 90, 20);
        
        add(jbedit);
        jbedit.setBounds(260, 40, 90, 20);
    }
    //Buat ngambil data texfield
    /*
    public String getNim(){
        return jtnim.getText();
    }
    
    public String getNama(){
        return jtnama.getText();
    }
    
    public String getAlamat(){
        return jtalamat.getText();
    }
    public String getSearch(){
        return jtcari.getText();
    }
*/
}
