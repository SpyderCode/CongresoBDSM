package BaseDatos;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.Action;
import javax.swing.JDesktopPane;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Statement;

import Clases.LoginUser;
import Clases.Menu;

//import Modelo.Paciente;

//import Modelo.Paciente;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.SystemColor;
import javax.swing.UIManager;
import java.awt.Label;
import java.awt.Dialog.ModalExclusionType;

public class CongresoBD extends JFrame {
	JDesktopPane principal;
	static boolean admin = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CongresoBD frame = new CongresoBD();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	protected static void isAdmin() {
		try {

			Conexion conn = new Conexion();
			Connection con = Conexion.getConection();
			Statement st = (Statement) con.createStatement();
			
			String sql="Insert into adminTest values (1)";
			st.execute(sql);
			
			admin=true;
			System.err.println(admin);
			
		} catch (Exception e) {
			admin=false;
			System.err.println(admin);
		}

	}

	/**
	 * Create the frame.
	 */
	public CongresoBD() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(CongresoBD.class.getResource("/Images/mapaches.png")));
		isAdmin();
		CongresoBD t = this;
		setTitle("TECNOLOGICO DE ZACATECAS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(10, 10, 1138, 753);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu Investigador = new JMenu();
		Investigador.setText("Investigador");
		menuBar.add(Investigador);

		JMenuItem VerInvestigador = new JMenuItem("Ver");
		VerInvestigador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VerUsuarios ventanaInterna = new VerUsuarios("Ver Usuario", true, true, true, t);
				principal.add(ventanaInterna);
				ventanaInterna.setVisible(true);
			}
		});
		Investigador.add(VerInvestigador);
		
		JMenuItem AltaInvestigador = new JMenuItem("Alta");
		AltaInvestigador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AltaInvestigador ventanaInterna = new AltaInvestigador("Registrar Investigador", true, true, true, t);
				principal.add(ventanaInterna);
				ventanaInterna.setVisible(true);
			}
		});
		AltaInvestigador.setEnabled(admin);
		Investigador.add(AltaInvestigador);

		JMenu Articulo = new JMenu();
		Articulo.setText("Articulo");
		menuBar.add(Articulo);

		JMenuItem VerArticulo = new JMenuItem("Ver Articulos");
		VerArticulo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VerArticulos ventanaInterna = new VerArticulos("Ver Articulos", true, true, true, t);
				principal.add(ventanaInterna);
				ventanaInterna.setVisible(true);
			}
		});
		Articulo.add(VerArticulo);

		JMenuItem mntmAltaArticulo = new JMenuItem("Alta Articulo");
		Articulo.add(mntmAltaArticulo);
		mntmAltaArticulo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AltaArticulo ventanaInterna = new AltaArticulo("Alta Articulo", true, true, true, t);
				principal.add(ventanaInterna);
				ventanaInterna.setVisible(true);
			}
		});
		mntmAltaArticulo.setEnabled(admin);

		JMenu Ponencia = new JMenu();
		Ponencia.setText("Ponencia");
		menuBar.add(Ponencia);

		JMenuItem VerPonencia = new JMenuItem("Ver Ponencias");
		VerPonencia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VerPonencia ventanaInterna = new VerPonencia("Ver Ponencias", true, true, true, t);
				principal.add(ventanaInterna);
				ventanaInterna.setVisible(true);
			}
		});
		Ponencia.add(VerPonencia);

		JMenuItem mntmAltaPonencia = new JMenuItem("Alta Ponencia");
		Ponencia.add(mntmAltaPonencia);
		mntmAltaPonencia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AltaPonencia ventanaInterna = new AltaPonencia("Alta Ponencia", true, true, true, t);
				principal.add(ventanaInterna);
				ventanaInterna.setVisible(true);
			}
		});
		mntmAltaPonencia.setEnabled(admin);
		
		JMenu Congreso = new JMenu();
		Congreso.setText("Congreso");
		menuBar.add(Congreso);

		JMenuItem mntmVerCongreso = new JMenuItem("Ver Congreso");
		mntmVerCongreso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VerCongreso ventanaInterna = new VerCongreso("Ver Congreso", true, true, true, t);
				principal.add(ventanaInterna);
				ventanaInterna.setVisible(true);
			}
		});
		Congreso.add(mntmVerCongreso);

		JMenuItem AltaCongreso = new JMenuItem();
		AltaCongreso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AltaCongreso ventanaInterna = new AltaCongreso("Ingresar Congreso", true, true, true, t);
				principal.add(ventanaInterna);
				ventanaInterna.setVisible(true);
			}
		});
		AltaCongreso.setEnabled(admin);
		AltaCongreso.setText("Alta Congreso");
		Congreso.add(AltaCongreso);

		JMenu Revista = new JMenu();
		Revista.setText("Revista");
		menuBar.add(Revista);

		JMenuItem AltaRevista = new JMenuItem();
		AltaRevista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ingresarRevista ventanaInterna = new ingresarRevista("Ingresar Revista", true, true, true, t);
				principal.add(ventanaInterna);
				ventanaInterna.setVisible(true);
			}
		});
		AltaRevista.setEnabled(admin);

		JMenuItem mntmVerRevista = new JMenuItem("Ver Revista");
		mntmVerRevista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VerRevista ventanaInterna = new VerRevista("Ver Revista", true, true, true, t);
				principal.add(ventanaInterna);
				ventanaInterna.setVisible(true);
			}
		});
		Revista.add(mntmVerRevista);
		AltaRevista.setText("Alta Revista");
		Revista.add(AltaRevista);
		principal = new JDesktopPane();
		principal.setToolTipText("");
		principal.setBackground(new Color(0, 102, 102));
		setContentPane(principal);
		principal.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(CongresoBD.class.getResource("/Images/TecNM2017T.png")));
		label.setForeground(Color.BLACK);
		label.setBackground(Color.WHITE);
		label.setBounds(0, 0, 546, 335);
		principal.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(CongresoBD.class.getResource("/Images/mapaches.png")));
		label_1.setForeground(Color.BLACK);
		label_1.setBackground(Color.WHITE);
		label_1.setBounds(745, 321, 457, 411);
		principal.add(label_1);
		this.repaint();
		
		
		
	}
	
}


