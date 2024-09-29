
package com.redjas.vacaciones;


import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class Terms extends JFrame implements ActionListener,ChangeListener {
    
    private JPanel panelUsuario;
    private JLabel titulo, usuario, usuarioIco;
    private JTextArea terminos;
    
    private JButton aceptar, noaceptar;
    private JCheckBox leido;
    private Color morao, azul, verde, rojito;
    String nombre;
    
    public Terms(String username)
            {
                 morao = new Color(0,0,0);
                 azul = new Color(66, 135, 245);
                 verde = new Color(74, 166, 68);
                 rojito = new Color(252, 151, 0);
                      
                
                 nombre =username; 
                
                //ImageIcon plamnesa = new ImageIcon(getClass().getResource("/com/redjas/vacaciones/special.jpg"));
                //ImageIcon special = new ImageIcon(getClass().getResource("/com/redjas/vacaciones/special.jpg"));   
                //ImageIcon userImage = new ImageIcon(getClass().getResource("/com/redjas/vacaciones/special.jpg"));
                
                
                
                setLayout(null);
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                setTitle("EULA");
                getContentPane().setBackground(morao);
                //setIconImage(new ImageIcon(getClass().getResource("special.png")).getImage());
                //setIconImage(plamnesa.getImage());
                setBounds(50,50,800,600);
                
                
                String terminosycondiciones="\n\n          TÉRMINOS Y CONDICIONES" +
                    "\n\n            A.  PROHIBIDA SU VENTA O DISTRIBUCIÓN SIN AUTORIZACIÓN." +
                    "\n            B.  PROHIBIDA LA ALTERACIÓN DEL CÓDIGO FUENTE SIN AUTORIZACION." +
                   
                    "\n\n          LOS ACUERDOS LEGALES EXPUESTOS A CONTINUACIÓN RIGEN EL USO QUE USTED HAGA DE ESTE SOFTWARE" +
                    "\n          EL CREADOR  NO SE RESPONSABILIZAN DEL USO QUE USTED" + 
                    "\n          HAGA CON ESTE SOFTWARE Y SUS SERVICIOS. PARA ACEPTAR ESTOS TERMINOS HAGA CLIC EN (ACEPTO)" +
                    "\n          SI USTED NO ACEPTA ESTOS TERMINOS, HAGA CLIC EN (NO ACEPTO) Y NO UTILICE ESTE SOFTWARE." + 
                    "\n\n          EN CASO USTED USE ESTE SOFTWARE SE DARÁN POR ACEPTADOS LOS TERMINOS"; 
                    
                
                titulo = new JLabel();
                //titulo.setIcon(special);
                titulo.setBounds(0,0, 400,150);
                add(titulo);
                
                
                //Definimos el panel de usuario
                usuario = new JLabel(nombre);
                usuario.setForeground(Color.BLACK);
                
                usuarioIco = new JLabel(); 
                //usuarioIco.setIcon(userImage);
                
                
                
                panelUsuario = new JPanel();
                panelUsuario.setLayout(new FlowLayout());
                
                panelUsuario.add(usuario);
                panelUsuario.add(usuarioIco);
                
                panelUsuario.setBounds(600,10, 100,25);
                panelUsuario.setBorder(BorderFactory.createLineBorder(Color.black));
                add(panelUsuario);
                
                
                //Terminos
                
                terminos = new JTextArea();
                terminos.setBounds(10,100,765,300);
                terminos.setFont(new Font("Arial", 1, 10));
                terminos.setBorder(BorderFactory.createLineBorder(Color.black));
                terminos.setText(terminosycondiciones);
                terminos.setEditable(false);
                add(terminos);
                
                leido = new JCheckBox("Yo " + nombre + " Acepto");
                leido.setBounds(10, 405, 200, 35);
                leido.addChangeListener(this);
                leido.setBackground(rojito);
                add(leido);
                
                aceptar = new JButton("Acepto");
                aceptar.addActionListener(this);
                aceptar.setEnabled(false);
                aceptar.setBounds(10, 500, 150, 50);
                aceptar.setBackground(rojito);
                add(aceptar);
                
                noaceptar = new JButton("No Acepto");
                noaceptar.addActionListener(this);
                noaceptar.setBounds(160, 500, 150,50);
                noaceptar.setBackground(azul);
                add(noaceptar);
                
            }
    @Override
    public void stateChanged(ChangeEvent e)
    {
        if(leido.isSelected() == true){
        leido.setBackground(azul);
        aceptar.setBackground(azul);
        noaceptar.setBackground(rojito);
       aceptar.setEnabled(true);
       noaceptar.setEnabled(false);
    } else {
            leido.setBackground(new Color(255, 135, 200));
            noaceptar.setBackground(azul);
        aceptar.setBackground(rojito);
       aceptar.setEnabled(false);
       noaceptar.setEnabled(true);
    }
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e){
               
       
        
        switch(e.getActionCommand())
        {
            case("No Acepto"):
                this.setVisible(false);
                Login login = new Login();
                login.setResizable(false);
                login.setVisible(true);
                break;
              
             case("Acepto"):
                 this.setVisible(false);
                 App aplicacion = new App(this.nombre);
                 aplicacion.setResizable(false);
                 aplicacion.setVisible(true);
                    
        }
        
        
    }
    public static void main(String[] args) {
        Terms termino = new Terms("Andres");
        termino.setResizable(false);
        termino.setVisible(true);
        
    }
    
}
