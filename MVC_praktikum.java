/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVC;

/**
 *
 * @author Orenji
 */
public class MVC_praktikum {
    LoginResponsi lr= new LoginResponsi();
    ViewPraktikum vp = new ViewPraktikum();
    ModelPraktikum mp = new ModelPraktikum();
    daftarResponsi dr=new  daftarResponsi();
    EditResponsi er=new EditResponsi();
    ControllerPraktikum cp = new ControllerPraktikum(vp, mp,lr,dr,er);
}
