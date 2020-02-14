/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import codigo.Vista;

/**
 *
 * @author chris
 */
public class Controlador implements ActionListener{
    
    private Vista ventanaPrincipal;

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==ventanaPrincipal.getBotonAnalisis()){
            System.out.println("hola");
        }
    }
    
}
