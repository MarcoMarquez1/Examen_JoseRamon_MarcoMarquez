package examen;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Ventana extends JFrame {
	private String actual = "splash";
	private String anterior = "login";
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
		tag1.setLocation(100, 10);
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
				anterior = actual;
				actual = "principal";

				route();

			}

		});

		return login;
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
				
				

				JMenuItem jmi5 = new JMenuItem("¿COMO CREAR USUARIOS? ");
				jm3.add(jmi5);

				return principal;
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
}