/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

import javax.swing.*;


/**
 *
 * @author chris
 */
public class Vista extends JFrame{
    private JButton botonAnalisis;
    private JLabel titulo;
    private JLabel analisis;
    
    public Vista(){
        
        setSize(600 , 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JPanel p = new JPanel();
        JButton botonAnalisis = new JButton("Analizar");
        JLabel titulo = new JLabel("Analisis lexico") ;
        JLabel analisis = new JLabel();
        p.add(botonAnalisis);
        p.add(titulo);
        p.add(analisis);
        add(p);
    }
    public void setAnalisis (String x){
       titulo.setText(x);
    }
    public JButton getBotonAnalisis() {
        return botonAnalisis;
    }
    
}
