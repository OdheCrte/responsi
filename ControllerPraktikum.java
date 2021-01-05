/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVC;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author Orenji
 */
public class ControllerPraktikum {
    
    ModelPraktikum modelpraktikum;
    ViewPraktikum viewpraktikum;
    LoginResponsi loginresponsi;
    daftarResponsi daftarresponsi;
    EditResponsi editresponsi;

    public ControllerPraktikum(ViewPraktikum vpc, ModelPraktikum mpc,LoginResponsi lrc,daftarResponsi drc,EditResponsi erc) {
        this.modelpraktikum = mpc;
        this.viewpraktikum = vpc;
        this.loginresponsi=lrc;
        this.daftarresponsi=drc;
        this.editresponsi=erc;
        
        if (modelpraktikum.getBanyakDataT() != 0) {
            String dataTransaction[][] = modelpraktikum.readTransaction();
            viewpraktikum.tabel.setModel((new JTable(dataTransaction, viewpraktikum.namaKolom)).getModel());
        } else {
            JOptionPane.showMessageDialog(null, "Data Tidak Ada");
        }

        loginresponsi.jbdaftar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 String dataMahasiswa[][] = modelpraktikum.readdaftar();
            }
        });
        daftarresponsi.jbdaftar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = daftarresponsi.getUsername();
                String password = daftarresponsi.getPassword();
                modelpraktikum.insertUser(username,password);

                
                String dataMahasiswa[][] = modelpraktikum.readAccount();
            }
        });
        loginresponsi.jblogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = loginresponsi.getUsername();
                String password = loginresponsi.getPassword();
                modelpraktikum.readUser(username,password);

                
                String dataMahasiswa[][] = modelpraktikum.readAccount();
            }
        });
        
        /*
        viewpraktikum.jbedit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String nim = viewpraktikum.getNim();
                String nama = viewpraktikum.getNama();
                String alamat = viewpraktikum.getAlamat();
                modelpraktikum.updateMahasiswa(nim, nama, alamat);
                
                String dataMahasiswa[][] = modelpraktikum.readMahasiswa();
                viewpraktikum.tabel.setModel(new JTable(dataMahasiswa, viewpraktikum.namaKolom).getModel());
            }
        });*/
        /*
        viewpraktikum.jbcarinim.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String nim = viewpraktikum.getSearch();
                String dataMahasiswa[][] = modelpraktikum.searchMahasiswa(nim);
                 viewpraktikum.tabel.setModel((new JTable(dataMahasiswa, viewpraktikum.namaKolom)).getModel());
            }
            
        });*/
        /*
        daftarresponsi.jbbatal.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String dataMahasiswa[][] = modelpraktikum.readt();
                viewpraktikum.tabel.setModel(new JTable(dataMahasiswa, viewpraktikum.namaKolom).getModel());
            }
            
        });*/

        viewpraktikum.tabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mousePressed(e);
                int baris = viewpraktikum.tabel.getSelectedRow();
                int kolom = viewpraktikum.tabel.getSelectedColumn(); // ga kepake sekarang

                String dataterpilih = viewpraktikum.tabel.getValueAt(baris, 0).toString();

                System.out.println(dataterpilih);

                int input = JOptionPane.showConfirmDialog(null,
                        "Apa anda ingin menghapus NIM " + dataterpilih + "?", "Pilih Opsi...", JOptionPane.YES_NO_OPTION);

                if (input == 0) {
                    modelpraktikum.deleteTransaction(dataterpilih);
                    String dataMahasiswa[][] = modelpraktikum.readTransaction();
                    viewpraktikum.tabel.setModel(new JTable(dataMahasiswa, viewpraktikum.namaKolom).getModel());
                } else {
                    JOptionPane.showMessageDialog(null, "Tidak Jadi Dihapus");
                }
            }
        }
        );
    }
}
