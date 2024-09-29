
package com.redjas.vacaciones;


import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;


public class App extends JFrame implements ActionListener{
    
 
    private JPanel panelUsuario;
    private JComboBox antiguedad, departamento;
    Container contenedor;
    private JLabel titulo, usuario, usuarioIco, programadorNombre, programadorCorreo, empleadoNombre, empleadoApellido, empleadoApellido2;
    private JTextArea resultado;
    private JLabel antiguedadLabel, departamentoLabel, footer;
    private JTextField valorNombre, valorApellido, valorApellido2;
    public String username;
    private Color morao, azul, verde, rojito, colorPrincipal;
    private JMenu apariencia, salir, acerca;
    private JMenuItem darktheme, lighttheme, draculatheme, cerrarPrograma, about;   
    private JMenuBar MenuBar;
    private JFrame programador;
    private JButton calcular, reiniciar;
    
    public App(String nombre)
    {
        morao = new Color(0,0,0);
        azul = new Color(66, 135, 245);
        verde = new Color(255, 166, 0);
        rojito = new Color(252, 151, 0);
        contenedor = getContentPane();
        colorPrincipal = new Color(0,0,0);
        username = nombre;
    
        
        footer = new JLabel("©2024 &cafe");
        footer.setBounds(200, 500, 200, 25);
        add(footer);
      
        setLayout(null);
        contenedor.setBackground(new Color(250, 252, 227));
        setBounds(150,150,800,600);
        setTitle("Calculo de vacaciones");
        //ImageIcon plamnesa = new ImageIcon(getClass().getResource("planesalogo.jpg"));
        //ImageIcon special = new ImageIcon(getClass().getResource("special.png"));   
        //ImageIcon userImage = new ImageIcon(getClass().getResource("user.png"));    
        //setIconImage(new ImageIcon(getClass().getResource("planesalogo.jpg")).getImage());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
                usuario = new JLabel(nombre);
                usuario.setForeground(colorPrincipal);
                
                usuarioIco = new JLabel(); 
                
                //usuarioIco.setIcon(userImage);
                
                
                
                panelUsuario = new JPanel();
                panelUsuario.setLayout(new FlowLayout());
                
                panelUsuario.add(usuario);
                panelUsuario.add(usuarioIco);
                
                panelUsuario.setBounds(100,400, 100,25);
                panelUsuario.setBorder(BorderFactory.createLineBorder(Color.black));
                add(panelUsuario);
        
                
                titulo = new JLabel();
                //titulo.setIcon(special);
                titulo.setBounds(400,400, 400,150);
                add(titulo);
                
                MenuBar = new JMenuBar();
                MenuBar.setBackground(new Color(245, 222, 93));
                setJMenuBar(MenuBar);
                
                apariencia = new JMenu("Temas");
                apariencia.setBackground(morao);
                MenuBar.add(apariencia);
                
                acerca = new JMenu("Acerca de");
                acerca.setBackground(morao);
                MenuBar.add(acerca);
                
                salir = new JMenu("Salir");
                salir.setBackground(morao);
                MenuBar.add(salir);
                
                
                darktheme = new JMenuItem("Tema oscuro");
                darktheme.addActionListener(this);
                apariencia.add(darktheme);
                
                lighttheme = new JMenuItem("Tema claro");
                lighttheme.addActionListener(this);
                apariencia.add(lighttheme);
                
                about = new JMenuItem("Acerca del programador");
                about.addActionListener(this);
                acerca.add(about);
                
                cerrarPrograma = new JMenuItem("Salir");
                cerrarPrograma.addActionListener(this);
                salir.add(cerrarPrograma);
                
                  empleadoNombre = new JLabel("Ingrese Nombres");
                  empleadoNombre.setForeground(colorPrincipal);
        empleadoNombre.setBounds(25,25, 100,25);
        empleadoNombre.setForeground(Color.BLACK);
        add(empleadoNombre);
        
        valorNombre = new JTextField();
        valorNombre.setBounds(25,55, 200,25);
        add(valorNombre);
        
        empleadoApellido = new JLabel("Ingrese Primer Apellido");
        empleadoApellido.setForeground(colorPrincipal);
        empleadoApellido.setBounds(25,80, 150,25);
        add(empleadoApellido);
        
        valorApellido = new JTextField();
        valorApellido.setBounds(25,105,200,25);
        add(valorApellido);
        
        empleadoApellido2 = new JLabel("Ingrese Segundo Apellido");
        empleadoApellido2.setForeground(colorPrincipal);
        empleadoApellido2.setBounds(25,130, 150, 25);
        add(empleadoApellido2); 
        
        
        valorApellido2 = new JTextField();
        valorApellido2.setBounds(25,155,200,25);
        add(valorApellido2);
        
        
        
        programador = new JFrame();
        programador.setBounds(200,200, 400,200);
        programador.setLayout(new GridLayout(2,1));
        
        programadorNombre = new JLabel("Andres Antonio Rojas Ciprian");
        programadorNombre.setFont(new Font("Arial", 1, 25));
        programador.getContentPane().add(programadorNombre, JLabel.CENTER);
        
     
        
        
        antiguedadLabel = new JLabel("Seleccione antiguedad del empleado");
        antiguedadLabel.setBounds(300, 25,250,25);
        add(antiguedadLabel);
        
        antiguedad = new JComboBox();
        antiguedad.addItem("");
        antiguedad.addItem("1 año");
        antiguedad.addItem("2 a 6 años");
        antiguedad.addItem("7 años o más");
        antiguedad.setBounds(300, 55, 250,25);
        add(antiguedad);
        
        departamentoLabel = new JLabel("Seleccione departamento del empleado");
        departamentoLabel.setForeground(colorPrincipal);
        departamentoLabel.setBounds(300, 82, 250,25);
        add(departamentoLabel);
        
        departamento = new JComboBox();
        
        departamento.setBounds(300,105,250,25);
        departamento.addItem("");
        departamento.addItem("Atención al cliente");
        departamento.addItem("Logistica");
        departamento.addItem("Gerentes");
        add(departamento);
        
        
        calcular = new JButton("Calcular");
        calcular.setBounds(300, 150, 100, 25);
        calcular.addActionListener(this);
        add(calcular);
        
        reiniciar = new JButton("Reiniciar");
        reiniciar.setBounds(450, 150, 100,25);
        reiniciar.addActionListener(this);
        add(reiniciar);
        
        resultado = new JTextArea();
        resultado.setEditable(false);
        resultado.setBounds(55, 200, 700, 200);
        resultado.setFont(new Font("Arial",1, 25));
        add(resultado);
                
    }
    
    public static void main(String[] args) {
        App aplicacion = new App("Andres");
        aplicacion.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        System.out.println(e.getActionCommand());
        if(e.getActionCommand().equals("Tema oscuro"))
        {
            colorPrincipal = Color.WHITE;
            
            contenedor.setBackground(morao);
            MenuBar.setBackground(verde);
           empleadoApellido.setForeground(colorPrincipal);
           empleadoApellido2.setForeground(colorPrincipal);
           departamentoLabel.setForeground(colorPrincipal);
           empleadoNombre.setForeground(colorPrincipal);
           antiguedadLabel.setForeground(colorPrincipal);
           
            
        }
        if(e.getActionCommand().equals("Tema claro"))
        {
            contenedor.setBackground(new Color(250, 252, 227));
            MenuBar.setBackground(new Color(245, 222, 93));
           
        }
        if(e.getActionCommand().equals("Acerca del programador"))
        {
            programador.setResizable(false);
            programador.setVisible(true);
            
        }
          if(e.getActionCommand().equals("Salir"))
        {
            
            Login login = new Login();
            login.setResizable(false);
            login.setVisible(true);
            this.setVisible(false);
            
        }
         if(e.getActionCommand().equals("Reiniciar"))
         {
            valorNombre.setText("");
	    valorApellido.setText("");
	    valorApellido2.setText("");
            departamento.setSelectedIndex(0);
	    antiguedad.setSelectedIndex(0);
	    resultado.setText("");	 
         }
          
          
         if(e.getActionCommand().equals("Calcular"))
         {
             String depto = departamento.getSelectedItem().toString();
             String anti = antiguedad.getSelectedItem().toString();
             String AP = valorApellido.getText();
             String AM = valorApellido2.getText();
             System.out.println(depto);
             System.out.println(anti);
             if(valorNombre.getText().equals("") || valorApellido.getText().equals("") || valorApellido2.getText().equals("") ||
               depto.equals("") || anti.equals("")){
               
                JOptionPane.showMessageDialog(null,"Debes de llenar todos los campos.");

            } else {

                if(depto.equals("Atención al cliente")){    

                                if(anti.equals("1 año")){
					resultado.setText("\n   El trabajador " + valorNombre.getText() + " " + AP + " " + AM + 
                                                          "\n   quien labora en " + depto + " con " + anti + 
                                                          "\n   recibe 6 dias de vacaciones.");
				}
				if(anti.equals("2 a 6 años")){
					resultado.setText("\n   El trabajador " + valorNombre.getText() + " " + AP + " " + AM + 
                                                          "\n   quien labora en " + depto + " con " + anti + 
                                                          "\n   recibe 14 dias de vacaciones.");
				}
				if(anti.equals("7 años o más")){
					resultado.setText("\n   El trabajador " + valorNombre.getText() + " " + AP + " " + AM + 
                                                          "\n   quien labora en " + depto + " con " + anti + 
                                                          "\n   recibe 20 dias de vacaciones.");
				}
                     
                }
	        if(depto.equals("Logistica")){

				if(anti.equals("1 año")){
					resultado.setText("\n   El trabajador " + valorNombre.getText() + " " + AP + " " + AM + 
                                                          "\n   quien labora en " + depto + " con " + anti + 
                                                          "\n   recibe 7 dias de vacaciones.");
				}
				if(anti.equals("2 a 6 años")){
					resultado.setText("\n   El trabajador " + valorNombre.getText() + " " + AP + " " + AM + 
                                                          "\n   quien labora en " + depto + " con " + anti + 
                                                          "\n   recibe 15 dias de vacaciones.");
				}
				if(anti.equals("7 años o más")){
					resultado.setText("\n   El trabajador " + valorNombre.getText() + " " + AP + " " + AM + 
                                                          "\n   quien labora en " + depto + " con " + anti + 
                                                          "\n   recibe 22 dias de vacaciones.");
				}
	    	}
	    	if(depto.equals("Gerentes")){

				if(anti.equals("1 año")){
					resultado.setText("\n   El trabajador " + valorNombre.getText() + " " + AP + " " + AM + 
                                                          "\n   quien labora en " + depto + " con " + anti + 
                                                          "\n   recibe 10 dias de vacaciones.");
				}
				if(anti.equals("2 a 6 años")){
					resultado.setText("\n   El trabajador " + valorNombre.getText() + " " + AP + " " + AM + 
                                                          "\n   quien labora en " + depto + " con " + anti + 
                                                          "\n   recibe 20 dias de vacaciones.");
				}
				if(anti.equals("7 años o más")){
					resultado.setText("\n   El trabajador " + valorNombre.getText() + " " + AP + " " + AM + 
                                                          "\n   quien labora en " + depto + " con " + anti + 
                                                          "\n   recibe 30 dias de vacaciones.");
				}
	    		}
            }
         }
          
    }
    
}
