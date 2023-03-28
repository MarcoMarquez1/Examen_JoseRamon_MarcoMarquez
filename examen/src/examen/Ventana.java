package examen;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class Ventana extends JFrame {
	private String actual = "splash";
	private String anterior = actual;
	private JPanel gran_panel = null;

	public Ventana() {
		//configuración_básica 
				this.setVisible(true);
				this.setSize(600, 600);
				this.setLayout(null);
				this.setTitle("EXAMEN");
				this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				this.setLocation(100, 100);
				this.setLocationRelativeTo(null); 
				this.getContentPane().setBackground(Color.decode("#8FDC91"));
				this.route();
	}

	public void route() {

		if(gran_panel!=null) {
			this.remove(gran_panel);
		}

		if(actual.equals("splash")) { 
			gran_panel = splash();  
		}
		if(actual.equals("login")) { 
			gran_panel = login();  
		}
		if(actual.equals("principal")) { 
			gran_panel = principal();  
		}
		if(actual.equals("registro")) { 
			gran_panel = registro();  
		}
		if(actual.equals("comoCrear")) { 
			gran_panel = comoCrear();  
		}
		if(actual.equals("cuentapersonal")) { 
			gran_panel = cuentapersonal();  
		}
		if(actual.equals("crearcuenta")) { 
			gran_panel = crearcuenta();  
		}
		if(actual.equals("listausuarios")) { 
			gran_panel = listausuarios();  
		}
		
		this.add(gran_panel);
		this.revalidate();
		this.repaint(); 
	}
	
	//------------------------------Panel de splash -------------------------------------------
		public JPanel splash() {

			JPanel splash = new JPanel();
			splash.setVisible(true);
			splash.setSize(600, 600);
			splash.setBackground(Color.CYAN);
			splash.setLayout(null);
			
			ImageIcon imagen =new ImageIcon("Foto.png");
			JButton im1=new JButton(imagen);
			im1.setSize(200,200);
			im1.setLocation(210,50);
			
			Image esc = imagen.getImage().getScaledInstance(im1.getWidth(), im1.getHeight(),Image.SCALE_SMOOTH);
			Icon ices=new ImageIcon(esc);
			im1.setIcon(ices);
			splash.add(im1);
		
			JLabel tag4 = new JLabel("Power by Jose ramon Flores y Marco Antonio Marquez");
			tag4.setSize(400,200);
			tag4.setFont(new Font("Arial", Font.BOLD, 15));
			tag4.setLocation(120, 350);
			splash.add(tag4);
		
			JButton jbnCont = new JButton("I N I C I A R");
			jbnCont.setSize(150,30);
			jbnCont.setLocation(230, 350);
			jbnCont.setBackground(Color.GREEN);
			splash.add(jbnCont);

			jbnCont.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					anterior = actual;
					actual = "login";

					route();

				}

			});

			return splash;
		}
	//------------------------------Panel de login -------------------------------------------
	public JPanel login() {

		JPanel login = new JPanel();
		login.setVisible(true);
		login.setSize(600, 600);
		login.setBackground(Color.CYAN);
		login.setLayout(null);
		
		JLabel tag1 = new JLabel("Accede A Tu Cuenta", JLabel.CENTER);
		tag1.setFont(new Font("Comic Sans",Font.BOLD,23));
		tag1.setSize(400, 20);
		tag1.setLocation(100, 20);
		tag1.setOpaque(true);
		tag1.setBackground(Color.white);
		login.add(tag1);
		

		ImageIcon imagen =new ImageIcon("Foto1.png");
		JButton im1=new JButton(imagen);
		im1.setSize(180,180);
		im1.setLocation(220,60);
		
		Image esc = imagen.getImage().getScaledInstance(im1.getWidth(), im1.getHeight(),Image.SCALE_SMOOTH);
		Icon ices=new ImageIcon(esc);
		im1.setIcon(ices);
		login.add(im1);
		
		
		JLabel tag2 = new JLabel("Ingrese correo electrónico:");
		tag2.setSize(400,400);
		tag2.setFont(new Font("Arial", Font.BOLD, 15));
		tag2.setLocation(190, 65);
		login.add(tag2);
		
		JTextField mail = new JTextField();
		mail.setSize(380, 40);
		mail.setLocation(100, 280);
		mail.setFont(new Font("Comic Sans",Font.ITALIC,15));
		login.add(mail);
		
		JLabel tag3 = new JLabel("Ingrese su contraseña: ");
		tag3.setSize(200, 420);
		tag3.setLocation(190, 135);
		tag3.setFont(new Font("Arial", Font.BOLD, 15));
		login.add(tag3);
		
		
		JPasswordField pwd = new JPasswordField();
		pwd.setSize(380, 40);
		pwd.setLocation(100, 360);
		login.add(pwd);
		
		JButton jbnCancel = new JButton("C A N C E L A R");
		jbnCancel.setSize(150,30);
		jbnCancel.setLocation(100, 450);
		jbnCancel.setBackground(Color.RED);
		login.add(jbnCancel);
		
		JButton jbnAccess = new JButton("A C C E D E R");
		jbnAccess.setSize(150,30);
		jbnAccess.setLocation(320, 450);
		jbnAccess.setBackground(Color.GREEN);
		login.add(jbnAccess);

		jbnAccess.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String email = mail.getText();

				char[] pwChrs = pwd.getPassword();
				String password = new String(pwChrs);

				BufferedReader reader;

				try {
					reader = new BufferedReader(new FileReader("usuarios.txt"));

					String line = reader.readLine();

					while (line != null) {

						String[] datos = null;

						datos = line.split(",");

						System.out.println(datos[2]);

						if(datos[2].equals(email)) {
							if(datos[3].equals(password)) {
								
								anterior = actual;
								actual = "principal";
								route();
								
								JOptionPane.showMessageDialog(null, "Acceso correcto");
								break;
							}
						}else {
							JOptionPane.showMessageDialog(null, "Acceso incorrecto");
							break;
						}
					}
					

				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}

		});
				

			

		return login;
	}
	//------------------------------Panel de registro -------------------------------------------
	public JPanel registro() {

		JPanel registro = new JPanel();
		registro.setVisible(true);
		registro.setSize(600, 600);
		registro.setBackground(Color.CYAN);
		registro.setLayout(null);
		
		JLabel tag4 = new JLabel("Panel de registro", JLabel.CENTER);
		tag4.setFont(new Font("Comic Sans",Font.BOLD,23));
		tag4.setSize(200, 40);
		tag4.setLocation(150, 10);
		tag4.setOpaque(true);
		tag4.setBackground(Color.white);
		registro.add(tag4);
		
		JLabel tag5 = new JLabel("Ingrese correo electrónico");
		tag5.setSize(200,20);
		tag5.setFont(new Font("Arial", Font.BOLD, 15));
		tag5.setLocation(50, 65);
		tag5.setForeground(Color.white);
		registro.add(tag5);
		
		JTextField mail_reg = new JTextField();
		mail_reg.setSize(380, 40);
		mail_reg.setLocation(48, 85);
		mail_reg.setFont(new Font("Comic Sans",Font.ITALIC,15));
		registro.add(mail_reg);
		
		JLabel tag6 = new JLabel("Ingrese su contraseña: ");
		tag6.setSize(200, 20);
		tag6.setLocation(50, 135);
		tag6.setFont(new Font("Arial", Font.BOLD, 15));
		tag6.setForeground(Color.white);
		registro.add(tag6);
		
		JPasswordField pwd_reg = new JPasswordField();
		pwd_reg.setSize(380, 40);
		pwd_reg.setLocation(48, 155);
		registro.add(pwd_reg);
		
		JLabel tag7 = new JLabel("Ingrese su nombre: ");
		tag7.setSize(200, 20);
		tag7.setLocation(50, 200);
		tag7.setFont(new Font("Arial", Font.BOLD, 15));
		tag7.setForeground(Color.white);
		registro.add(tag7);
		
		JTextField nombre = new JTextField();
		nombre.setSize(380, 40);
		nombre.setLocation(48, 225);
		registro.add(nombre);
		
		JLabel tag8 = new JLabel("Ingrese su apellido: ");
		tag8.setSize(200, 20);
		tag8.setLocation(50, 270);
		tag8.setFont(new Font("Arial", Font.BOLD, 15));
		tag8.setForeground(Color.white);
		registro.add(tag8);
		
		JTextField apellido = new JTextField();
		apellido.setSize(380, 40);
		apellido.setLocation(48, 295);
		registro.add(apellido);
		
		JButton saveUsr = new JButton("G U A R D A R");
		saveUsr.setSize(380, 35);
		saveUsr.setLocation(48,350);
		saveUsr.setBackground(Color.blue);
		registro.add(saveUsr);
		
		saveUsr.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				anterior = actual;
				actual = "login";
				
				route();
			}

		});
		return registro;		
	}

	//-----------------------PANEL PARA VER COMO CREAR USUARIOS------------------------------------
	public JPanel comoCrear () {

		JPanel comoCrear = new JPanel();
		comoCrear.setVisible(true);
		comoCrear.setSize(600, 600);
		comoCrear.setBackground(Color.CYAN);
		comoCrear.setLayout(null);
		
		JLabel tag1 = new JLabel("¿COMO CREAR UN USUARIO?", JLabel.CENTER);
		tag1.setFont(new Font("Comic Sans",Font.BOLD,23));
		tag1.setSize(380, 20);
		tag1.setLocation(100, 50);
		tag1.setOpaque(true);
		tag1.setBackground(Color.white);
		comoCrear.add(tag1);
		
		ImageIcon imagen =new ImageIcon("Foto 6.png");
		JButton im6=new JButton(imagen);
		im6.setSize(120,100);
		im6.setLocation(220,100);
		
		Image esc = imagen.getImage().getScaledInstance(im6.getWidth(), im6.getHeight(),Image.SCALE_SMOOTH);
		Icon ices=new ImageIcon(esc);
		im6.setIcon(ices);
		comoCrear.add(im6);
		
		
		
		JLabel tag2 = new JLabel("1- haga click en la opcion usuarios en el menu superior ");
		tag2.setFont(new Font("arial",Font.BOLD,15));
		tag2.setSize(600,20);
		tag2.setLocation(50,270);
		comoCrear.add(tag2);	
	
		JLabel tag3 = new JLabel("2- Hacer click en la opcion Crear");
		tag3.setFont(new Font("arial",Font.BOLD,15));
		tag3.setSize(600,30);
		tag3.setLocation(50,290);
		comoCrear.add(tag3);
			
			
		JLabel tag4 = new JLabel("3- Llenar los campos solicitados");
		tag4.setFont(new Font("arial",Font.BOLD,15));
		tag4.setSize(600,30);
		tag4.setLocation(50,310);
		comoCrear.add(tag4);
			
		JLabel tag5 = new JLabel("4- Escribe Una Pequeña Desripcion De Ti ");
		tag5.setFont(new Font("arial",Font.BOLD,15));
		tag5.setSize(600,20);
		tag5.setLocation(50,335);
		comoCrear.add(tag5);
			
			
		JLabel tag6 = new JLabel("5- Selecciona Tu Comida Favorita");
		tag6.setFont(new Font("arial",Font.BOLD,15));
		tag6.setSize(600,30);
		tag6.setLocation(50,350);
		comoCrear.add(tag6);
	
		JLabel tag7 = new JLabel("6- Selecciona Tu Color Favorito");
		tag7.setFont(new Font("arial",Font.BOLD,15));
		tag7.setSize(600,30);
		tag7.setLocation(50,370);
		comoCrear.add(tag7);
						
		JLabel tag8 = new JLabel("7- Hacer Click En El Boton Crear Usuario");
		tag8.setFont(new Font("arial",Font.BOLD,15));
		tag8.setSize(600,30);
		tag8.setLocation(50,390);
		comoCrear.add(tag8);
			
		JLabel tag9 = new JLabel("8- Listo El Usuario Se Ha Creado");
		tag9.setFont(new Font("arial",Font.BOLD,15));
		tag9.setSize(600,30);
		tag9.setLocation(50,410);
		comoCrear.add(tag9);
		
		JButton irCrear = new JButton("Ir a crear");
		irCrear.setSize(380, 35);
		irCrear.setLocation(100,500);
		irCrear.setBackground(Color.white);
		comoCrear.add(irCrear);
		
		irCrear.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				remove(comoCrear);
				add(crearcuenta());
				
				repaint();
				
			}
			
		});

			
		return comoCrear;
	}
	
	
//----------------PANEL PARA VER TU CUENTA-----------------------------------------	
	
	public JPanel cuentapersonal () {
		
		JPanel cuentapersonal = new JPanel();
		cuentapersonal.setVisible(true);
		cuentapersonal.setSize(600, 600);
		cuentapersonal.setBackground(Color.CYAN);
		cuentapersonal.setLayout(null);
	
		
		JLabel tag1 = new JLabel("MI CUENTA PERSONAL", JLabel.CENTER);
		tag1.setFont(new Font("Comic Sans",Font.BOLD,23));
		tag1.setSize(300, 30);
		tag1.setLocation(110, 20);
		tag1.setOpaque(true);
		tag1.setBackground(Color.white);
		cuentapersonal.add(tag1);
		
		
		ImageIcon imagen =new ImageIcon("Foto 4.png");
		JButton im4=new JButton(imagen);
		im4.setSize(100,100);
		im4.setLocation(220,55);
		Image esc = imagen.getImage().getScaledInstance(im4.getWidth(), im4.getHeight(),Image.SCALE_SMOOTH);
		Icon ices=new ImageIcon(esc);
		im4.setIcon(ices);
		cuentapersonal.add(im4);
		
		JLabel tag2 = new JLabel("Ingrese su nombre: ");
		tag2.setSize(200, 100);
		tag2.setLocation(190, 120);
		tag2.setFont(new Font("Arial", Font.BOLD, 15));
		tag2.setForeground(Color.decode("#000000"));
		cuentapersonal.add(tag2);
		
		
		JTextField nombre = new JTextField();
		nombre.setSize(380, 20);
		nombre.setLocation(100, 180);
		cuentapersonal.add(nombre);
		
		JLabel tag3 = new JLabel("Ingrese su apellidos: ");
		tag3.setSize(200, 100);
		tag3.setLocation(190, 160);
		tag3.setFont(new Font("Arial", Font.BOLD, 15));
		tag3.setForeground(Color.decode("#000000"));
		cuentapersonal.add(tag3);
		
		JTextField apellido = new JTextField();
		apellido.setSize(380,20);
		apellido.setLocation(100,220);
		apellido.setFont(new Font("comic sans",Font.ITALIC,14));
		cuentapersonal.add(apellido);
		
		
		JLabel tag4 = new JLabel("Ingrese correo electrónico:");
		tag4.setSize(200,20);
		tag4.setFont(new Font("Arial", Font.BOLD, 15));
		tag4.setLocation(190, 240);
		tag4.setForeground(Color.decode("#000000"));
		cuentapersonal.add(tag4);
		
		
		JTextField mail_reg = new JTextField();
		mail_reg.setSize(380, 20);
		mail_reg.setLocation(100, 260);
		mail_reg.setFont(new Font("Comic Sans",Font.ITALIC,15));
		cuentapersonal.add(mail_reg);
		

		JLabel tag5 = new JLabel("Ingrese su contraseña: ");
		tag5.setSize(200, 100);
		tag5.setLocation(190, 240);
		tag5.setFont(new Font("Arial", Font.BOLD, 15));
		tag5.setForeground(Color.decode("#000000"));
		cuentapersonal.add(tag5);
		
		JPasswordField pwd_reg = new JPasswordField();
		pwd_reg.setSize(380, 20);
		pwd_reg.setLocation(100, 300);
		cuentapersonal.add(pwd_reg);
		
		JLabel tag6 = new JLabel("Ingrese descripcion");
		tag6.setSize(200, 20);
		tag6.setLocation(190, 325);
		tag6.setFont(new Font("Arial", Font.BOLD, 15));
		tag6.setForeground(Color.decode("#000000"));
		cuentapersonal.add(tag6);
		
		TextArea texto = new TextArea();
		texto.setSize(380, 50);
		texto.setLocation(100, 350);
		texto.setFont(new Font("Arial", Font.BOLD, 15));
		texto.setForeground(Color.decode("#000000"));
		cuentapersonal.add(texto);
		
		JLabel tag7 = new JLabel("Comida Favorita");
		tag7.setSize(200, 20);
		tag7.setLocation(200, 400);
		tag7.setFont(new Font("Arial", Font.BOLD, 15));
		tag7.setForeground(Color.decode("#000000"));
		cuentapersonal.add(tag7);
		
		JCheckBox mi_check = new JCheckBox();
		mi_check.setText("pizza");
		mi_check.setSize(100, 15);
		mi_check.setLocation(100, 420);
		mi_check.setOpaque(true);
		mi_check.setForeground(Color.BLACK);
		cuentapersonal.add(mi_check);
		
		JCheckBox mi_check2 = new JCheckBox();
		mi_check2.setText("Sushi");
		mi_check2.setSize(100, 15);
		mi_check2.setLocation(220, 420);
		mi_check2.setOpaque(true);
		mi_check2.setForeground(Color.BLACK);
		cuentapersonal.add(mi_check2);
		
		JCheckBox mi_check3 = new JCheckBox();
		mi_check3.setText("hamburguesa");
		mi_check3.setSize(110, 15);
		mi_check3.setLocation(340, 420);
		mi_check3.setOpaque(true);
		mi_check3.setForeground(Color.BLACK);
		cuentapersonal.add(mi_check3);
		
		JLabel tag8 = new JLabel("Color favorito");
		tag8.setSize(200, 20);
		tag8.setLocation(200, 440);
		tag8.setFont(new Font("Arial", Font.BOLD, 15));
		tag8.setForeground(Color.decode("#000000"));
		cuentapersonal.add(tag8);
		
		JCheckBox mi_check4 = new JCheckBox();
		mi_check4.setText("Rojo");
		mi_check4.setSize(100, 15);
		mi_check4.setLocation(100, 460);
		mi_check4.setOpaque(true);
		mi_check4.setForeground(Color.BLACK);
		cuentapersonal.add(mi_check4);
		
		JCheckBox mi_check5 = new JCheckBox();
		mi_check5.setText("Azul");
		mi_check5.setSize(100, 15);
		mi_check5.setLocation(220, 460);
		mi_check5.setOpaque(true);
		mi_check5.setForeground(Color.BLACK);
		cuentapersonal.add(mi_check5);
		
		JCheckBox mi_check6 = new JCheckBox();
		mi_check6.setText("Negro");
		mi_check6.setSize(100, 15);
		mi_check6.setLocation(340, 460);
		mi_check6.setOpaque(true);
		mi_check6.setForeground(Color.BLACK);
		cuentapersonal.add(mi_check6);
		
		JButton saveUsr = new JButton("C A N C E L A R");
		saveUsr.setSize(200, 35);
		saveUsr.setLocation(80,510);
		saveUsr.setBackground(Color.RED);
		cuentapersonal.add(saveUsr);
		
		
		JButton saveUsr1 = new JButton("A C T U A L I Z A R");
		saveUsr1.setSize(200, 35);
		saveUsr1.setLocation(300,510);
		saveUsr1.setBackground(Color.GREEN);
		cuentapersonal.add(saveUsr1);
	
		return cuentapersonal;
	}
	
	//----------------PANEL PARA CREAR TU CUENTA-----------------------------------------	
	
		public JPanel crearcuenta () {
			
			JPanel crearcuenta = new JPanel();
			crearcuenta.setVisible(true);
			crearcuenta.setSize(600, 600);
			crearcuenta.setBackground(Color.CYAN);
			crearcuenta.setLayout(null);
		
			
			JLabel tag1 = new JLabel("CREAR MI CUENTA PERSONAL", JLabel.CENTER);
			tag1.setFont(new Font("Comic Sans",Font.BOLD,23));
			tag1.setSize(300, 30);
			tag1.setLocation(110, 20);
			tag1.setOpaque(true);
			tag1.setBackground(Color.white);
			crearcuenta.add(tag1);
			
			
			ImageIcon imagen =new ImageIcon("Foto 6.png");
			JButton im4=new JButton(imagen);
			im4.setSize(100,100);
			im4.setLocation(220,55);
			Image esc = imagen.getImage().getScaledInstance(im4.getWidth(), im4.getHeight(),Image.SCALE_SMOOTH);
			Icon ices=new ImageIcon(esc);
			im4.setIcon(ices);
			crearcuenta.add(im4);
			
			JLabel tag2 = new JLabel("Ingrese su nombre: ");
			tag2.setSize(200, 100);
			tag2.setLocation(190, 120);
			tag2.setFont(new Font("Arial", Font.BOLD, 15));
			tag2.setForeground(Color.decode("#000000"));
			crearcuenta.add(tag2);
			
			
			JTextField nombre = new JTextField();
			nombre.setSize(380, 20);
			nombre.setLocation(100, 180);
			crearcuenta.add(nombre);
			
			JLabel tag3 = new JLabel("Ingrese su apellidos: ");
			tag3.setSize(200, 100);
			tag3.setLocation(190, 160);
			tag3.setFont(new Font("Arial", Font.BOLD, 15));
			tag3.setForeground(Color.decode("#000000"));
			crearcuenta.add(tag3);
			
			JTextField apellido = new JTextField();
			apellido.setSize(380,20);
			apellido.setLocation(100,220);
			apellido.setFont(new Font("comic sans",Font.ITALIC,14));
			crearcuenta.add(apellido);
			
			
			JLabel tag4 = new JLabel("Ingrese correo electrónico:");
			tag4.setSize(200,20);
			tag4.setFont(new Font("Arial", Font.BOLD, 15));
			tag4.setLocation(190, 240);
			tag4.setForeground(Color.decode("#000000"));
			crearcuenta.add(tag4);
			
			
			JTextField mail_reg = new JTextField();
			mail_reg.setSize(380, 20);
			mail_reg.setLocation(100, 260);
			mail_reg.setFont(new Font("Comic Sans",Font.ITALIC,15));
			crearcuenta.add(mail_reg);
			

			JLabel tag5 = new JLabel("Ingrese su contraseña: ");
			tag5.setSize(200, 100);
			tag5.setLocation(190, 240);
			tag5.setFont(new Font("Arial", Font.BOLD, 15));
			tag5.setForeground(Color.decode("#000000"));
			crearcuenta.add(tag5);
			
			JPasswordField pwd_reg = new JPasswordField();
			pwd_reg.setSize(380, 20);
			pwd_reg.setLocation(100, 300);
			crearcuenta.add(pwd_reg);
			
			JLabel tag6 = new JLabel("Ingrese descripcion");
			tag6.setSize(200, 20);
			tag6.setLocation(190, 325);
			tag6.setFont(new Font("Arial", Font.BOLD, 15));
			tag6.setForeground(Color.decode("#000000"));
			crearcuenta.add(tag6);
			
			TextArea texto = new TextArea();
			texto.setSize(380, 50);
			texto.setLocation(100, 350);
			texto.setFont(new Font("Arial", Font.BOLD, 15));
			texto.setForeground(Color.decode("#000000"));
			crearcuenta.add(texto);
			
			JLabel tag7 = new JLabel("Comida Favorita");
			tag7.setSize(200, 20);
			tag7.setLocation(200, 400);
			tag7.setFont(new Font("Arial", Font.BOLD, 15));
			tag7.setForeground(Color.decode("#000000"));
			crearcuenta.add(tag7);
			
			JCheckBox mi_check = new JCheckBox();
			mi_check.setText("pizza");
			mi_check.setSize(100, 15);
			mi_check.setLocation(100, 420);
			mi_check.setOpaque(true);
			mi_check.setForeground(Color.BLACK);
			crearcuenta.add(mi_check);
			
			JCheckBox mi_check2 = new JCheckBox();
			mi_check2.setText("Sushi");
			mi_check2.setSize(100, 15);
			mi_check2.setLocation(220, 420);
			mi_check2.setOpaque(true);
			mi_check2.setForeground(Color.BLACK);
			crearcuenta.add(mi_check2);
			
			JCheckBox mi_check3 = new JCheckBox();
			mi_check3.setText("hamburguesa");
			mi_check3.setSize(110, 15);
			mi_check3.setLocation(340, 420);
			mi_check3.setOpaque(true);
			mi_check3.setForeground(Color.BLACK);
			crearcuenta.add(mi_check3);
			
			JLabel tag8 = new JLabel("Color favorito");
			tag8.setSize(200, 20);
			tag8.setLocation(200, 440);
			tag8.setFont(new Font("Arial", Font.BOLD, 15));
			tag8.setForeground(Color.decode("#000000"));
			crearcuenta.add(tag8);
			
			JCheckBox mi_check4 = new JCheckBox();
			mi_check4.setText("Rojo");
			mi_check4.setSize(100, 15);
			mi_check4.setLocation(100, 460);
			mi_check4.setOpaque(true);
			mi_check4.setForeground(Color.BLACK);
			crearcuenta.add(mi_check4);
			
			JCheckBox mi_check5 = new JCheckBox();
			mi_check5.setText("Azul");
			mi_check5.setSize(100, 15);
			mi_check5.setLocation(220, 460);
			mi_check5.setOpaque(true);
			mi_check5.setForeground(Color.BLACK);
			crearcuenta.add(mi_check5);
			
			JCheckBox mi_check6 = new JCheckBox();
			mi_check6.setText("Negro");
			mi_check6.setSize(100, 15);
			mi_check6.setLocation(340, 460);
			mi_check6.setOpaque(true);
			mi_check6.setForeground(Color.BLACK);
			crearcuenta.add(mi_check6);
			
			JButton saveUsr = new JButton("C A N C E L A R");
			saveUsr.setSize(200, 35);
			saveUsr.setLocation(80,510);
			saveUsr.setBackground(Color.RED);
			crearcuenta.add(saveUsr);
			
			
			JButton saveUsr1 = new JButton("Crear cuenta");
			saveUsr1.setSize(200, 35);
			saveUsr1.setLocation(300,510);
			saveUsr1.setBackground(Color.GREEN);
			crearcuenta.add(saveUsr1);
		
			saveUsr1.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					BufferedWriter writer;

					String n = nombre.getText();
					String a = apellido.getText();
					String m = mail_reg.getText();
					String p = new String(pwd_reg.getPassword());

					try {

						 writer = new BufferedWriter(new FileWriter("usuarios.txt",true));

						 writer.newLine();
						 writer.append(n+","+a+","+m+","+p);

						 writer.close();


					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
			});
			return crearcuenta;
		}
	
//-----------------------------PANEL DE LISTA DE USUARIOS------------------------------------
		public  JPanel listausuarios() {
			
			JPanel listausuarios = new JPanel();
			listausuarios.setVisible(true);
			listausuarios.setSize(600, 600);
			listausuarios.setBackground(Color.CYAN);
			listausuarios.setLayout(null);
			
			JLabel tag10 = new JLabel("Usuarios", JLabel.CENTER);
			tag10.setFont(new Font("Comic Sans",Font.BOLD,23));
			tag10.setSize(300, 40);
			tag10.setLocation(100, 10);
			tag10.setOpaque(true);
			tag10.setBackground(Color.white);
			listausuarios.add(tag10);

			JLabel tag11 = new JLabel("Consulta los usuarios registrados");
			tag11.setSize(300,20);
			tag11.setFont(new Font("Arial", Font.BOLD, 15));
			tag11.setLocation(100, 65);
			listausuarios.add(tag11);

			JButton loadUsr = new JButton("CONSULTAR USUARIOS");
			loadUsr.setSize(380, 40);
			loadUsr.setLocation(50, 85);
			loadUsr.setFont(new Font("Comic Sans",Font.ITALIC,15));
			listausuarios.add(loadUsr);

			loadUsr.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub

					String[] columnNames = { "Nombre", "Apellidos", "Correo", "Password" };

					String[][] data = new String[10][4];
					int i = 0;
					BufferedReader reader;

					try {
						reader = new BufferedReader(new FileReader("usuarios.txt"));

						String line = reader.readLine();
						JScrollPane sp = null;

						while (line != null) {

							data[i] = line.split(",");

							JTable j = new JTable(data, columnNames);
							sp = new JScrollPane(j);
							sp.setSize(300,200);
							sp.setLocation(100, 160); 

							line = reader.readLine();
							i++;
						} 

						listausuarios.add(sp);


					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} 

				}

			});

			/*listausuarios.setVisible(true);
			listausuarios.setSize(500, 700);
			listausuarios.setBackground(Color.CYAN);
			listausuarios.setLayout(null);
		
			
			JLabel tag1 = new JLabel("LISTA DE USUARIOS", JLabel.CENTER);
			tag1.setFont(new Font("Comic Sans",Font.BOLD,23));
			tag1.setSize(400, 20);
			tag1.setLocation(100, 10);
			tag1.setOpaque(true);
			tag1.setBackground(Color.white);
			listausuarios.add(tag1);
			
			
			JLabel tag2 = new JLabel("Seleccione un usuario");
			tag2.setFont(new Font("arial",Font.BOLD,15));
			tag2.setSize(200,30);
			tag2.setLocation(50,145);
			this.add(tag2);
			

			JComboBox user = new JComboBox();
			user.setSize(300,40);
			user.setLocation(48,180);
			user.addItem("editar a jonathan");
			
			this.add(user);
			this.repaint();
			
			JPanel crear=new JPanel ();
			crear.setBackground(Color.decode("#FC1A1A"));
			crear.setSize(455, 90);
			crear.setLocation(20,270);
			add(crear);
		
			JPanel crear2=new JPanel();
			crear2.setBackground(Color.decode("#FC1A1A"));
			crear2.setSize(700,600);
			crear2.setLocation(0,0);
			crear2.setLayout(null);
			add(crear2);

			String  [] cabezera=new String [] {"USUARIO","NOMBRE","ACCIONES"};
			Object [][] filas=new  Object [3][3] ;
						
			
			JTable table =new JTable (filas,cabezera);
			table.setBackground(Color.decode("#FFFFFF"));
			table.setLayout(new BorderLayout());
			table.setLocation(0,70);
			crear.add(new JScrollPane(table));
			
		

			JButton saveUsr = new JButton("A C C E D E R");
			saveUsr.setSize(380,30);
			saveUsr.setLocation(100, 450);
			crear.add(saveUsr);*/
			
			return listausuarios;
			
		}
		
	//------------------------------Panel de principal -------------------------------------------
	public JPanel principal() {

		JPanel principal = new JPanel();
		principal.setVisible(true);
		principal.setSize(600, 600);
		principal.setBackground(Color.CYAN);
		principal.setLayout(null);
		
		JLabel tag8 = new JLabel("HOLA, BIENVENIDO", JLabel.CENTER);
		tag8.setFont(new Font("Comic Sans",Font.BOLD,23));
		tag8.setSize(400, 20);
		tag8.setLocation(100, 100);
		tag8.setOpaque(true);
		tag8.setBackground(Color.white);
		principal.add(tag8);
		
		ImageIcon imagen =new ImageIcon("Foto 3.png");
		JButton im1=new JButton(imagen);
		im1.setSize(170,170);
		im1.setLocation(210,250);
		
		Image esc = imagen.getImage().getScaledInstance(im1.getWidth(), im1.getHeight(),Image.SCALE_SMOOTH);
		Icon ices=new ImageIcon(esc);
		im1.setIcon(ices);
		principal.add(im1);
		
		JMenuBar jmb = new JMenuBar();
		jmb.setSize(this.getWidth(),20);
		
		this.add(jmb);
		
		JMenu jm1 = new JMenu("CUENTA");
		JMenu jm2 = new JMenu("ARCHIVO");
		JMenu jm3 = new JMenu("AYUDA");
		jmb.add(jm1);
		jmb.add(jm2);
		jmb.add(jm3);
		
		JMenuItem jmi1 = new JMenuItem("LISTA DE USUARIOS ");
		JMenuItem jmi2 = new JMenuItem("CREAR USUARIOS ");
		
		jm2.add(jmi1);
		jm2.add(jmi2);
		
		
		JMenuItem jmi3 = new JMenuItem("MI CUENTA ");
		JMenuItem jmi4 = new JMenuItem("CERRAR SESION ");
		
		jm1.add(jmi3);
		jm1.add(jmi4);
		
		JMenuItem jmi5 = new JMenuItem("¿Como crear cuenta? ");
		
		jm3.add(jmi5);
		
		jmi3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				anterior = actual;
				actual = "cuentapersonal";
				route();
			}
			
		});

		jmi4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub			
				
				remove(principal);
				add(login());
				route();	
			}
		});
		
		jmi5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				anterior = actual;
				actual = "comoCrear";
				route();	
			}
			
		});
		
		jmi2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				anterior = actual;
				actual = "crearcuenta";
				route();	
			}
			
		});
		
		jmi1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				anterior = actual;
				actual = "listausuarios";
				route();
			}
			
		});
		return principal;
	}

	
	
}