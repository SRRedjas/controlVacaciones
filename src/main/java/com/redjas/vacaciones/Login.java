package com.redjas.vacaciones;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.ImageIcon;


public class Login extends JFrame implements ActionListener {
    
    /*
    morao 102, 0, 122
    azul 0, 31, 122
    verde 0, 122, 18
    */
    private JTextField nombre;
    private JLabel imagen, programa, labelNombre, rights, estudiante, curso, seccion;
    private JButton login;
    public String usuario;
    
    public Login()
    {   
        
        
        //Ventana config
        //ImageIcon plamnesa = new javax.swing.ImageIcon(getClass().getResource("/com/redjas/vacaciones/special.jpg"));
        //ImageIcon special = new ImageIcon(getClass().getResource("/com/redjas/vacaciones/special.jpg"));
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(252, 151, 0));
        //setIconImage(new javax.swing.ImageIcon(getClass().getResource("/com/redjas/vacaciones/special.jpg")).getImage());
        //setIconImage(plamnesa.getImage());
        setTitle("&cafe");
        setBounds(150,150,800,600);
     
        
        
        
        //Imagen Principal
        
        imagen = new JLabel(); 
        //imagen.setIcon(special);
        imagen.setBounds(200,70, 400, 100);
        add(imagen);
        
        
        //Nombre Programa 
        programa = new JLabel("Sistema de Calculo de Vacaciones");
        programa.setBounds(300, 0, 400,50);
        programa.setFont(new Font("Arial", 1, 15));
        programa.setForeground(new Color(255,255,255));
        add(programa);
        
        labelNombre = new JLabel("Ingrese su nombre:");
        labelNombre.setBounds(350, 150, 400,50);
        labelNombre.setFont(new Font("Arial", 1, 15));
        labelNombre.setForeground(new Color(255,255,255));
        add(labelNombre);
        
        
        nombre = new JTextField();
        nombre.setBounds(300,200,255,25);
        nombre.getFocusAccelerator();
        nombre.setFont(new Font("Arial", 1, 14));
        nombre.setForeground(new Color(252, 151, 0));
        add(nombre);
        
        login = new JButton("Log in");
        login.addActionListener(this);
        login.setBounds(300,250,255,25);
        add(login);
        
        rights = new JLabel("&Cafe");
        rights.setBounds(325, 350, 400,50);
        rights.setFont(new Font("Arial", 1, 15));
        rights.setForeground(new Color(255,255,255));
        add(rights);
        
        estudiante = new JLabel("Andres Antonio Rojas Ciprian");
        estudiante.setBounds(325, 400, 400,50);
        estudiante.setFont(new Font("Arial", 1, 15));
        estudiante.setForeground(new Color(255,255,255));
        add(estudiante);
        
        curso = new JLabel("Programación II Sección 'A'");
        curso.setBounds(325, 450, 400,50);
        curso.setFont(new Font("Arial", 1, 15));
        curso.setForeground(new Color(255,255,255));
        add(curso);
    }
    
    
    public static void main(String[] args) {
        // TODO code application logic here
           Login ventana = new Login();
           ventana.setVisible(true);
           ventana.setResizable(false);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getActionCommand().equals("Log in"))
        {
            if(nombre.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null, "Ingrese su nombre para continuar.");
            }
            else
            {   
                this.usuario = nombre.getText();
                Terms termino = new Terms(this.usuario);
                termino.setVisible(true);
                termino.setResizable(false);
                setVisible(false);
                
            }
        }
        
    }
    
}
