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

import javax.swing.Action;
import javax.swing.JDesktopPane;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

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

public class CongresoBD extends JFrame {
	JDesktopPane principal;

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

	/**
	 * Create the frame.
	 */
	public CongresoBD() {
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
				VerUsuarios ventanaInterna=new VerUsuarios("Ver Usuario", true, true, true, t);
				principal.add(ventanaInterna);
				ventanaInterna.setVisible(true);
			}
		});
		Investigador.add(VerInvestigador);
		JMenuItem AltaInvestigador = new JMenuItem("Alta");
		AltaInvestigador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AltaInvestigador ventanaInterna=new AltaInvestigador("Registrar Investigador", true, true, true, t);
				principal.add(ventanaInterna);
				ventanaInterna.setVisible(true);
			}
		});
		Investigador.add(AltaInvestigador);
		
		JMenu Articulo = new JMenu();
		Articulo.setText("Articulo");
		menuBar.add(Articulo);
		
		JMenuItem VerArticulo = new JMenuItem("Ver Articulos");
		VerArticulo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VerArticulos ventanaInterna=new VerArticulos("Ver Articulos", true, true, true, t);
				principal.add(ventanaInterna);
				ventanaInterna.setVisible(true);
			}
		});
		Articulo.add(VerArticulo);
		
		JMenu Ponencia = new JMenu();
		Ponencia.setText("Ponencia");
		menuBar.add(Ponencia);
		
		JMenuItem VerPonencia = new JMenuItem("Ver Ponencias");
		VerPonencia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VerPonencia ventanaInterna=new VerPonencia("Ver Ponencias", true, true, true, t);
				principal.add(ventanaInterna);
				ventanaInterna.setVisible(true);
			}
		});
		Ponencia.add(VerPonencia);
		
		JMenu Congreso = new JMenu();
		Congreso.setText("Congreso");
		menuBar.add(Congreso);
		
		JMenuItem AltaCongreso = new JMenuItem();
		AltaCongreso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AltaCongreso ventanaInterna = new AltaCongreso("Ingresar Congreso", true, true, true, t);
				principal.add(ventanaInterna);
				ventanaInterna.setVisible(true);
			}
		});
		AltaCongreso.setText("Congreso");
		Congreso.add(AltaCongreso);
		
		JMenuItem mntmAltaPonencia = new JMenuItem("Alta Ponencia");
		mntmAltaPonencia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AltaPonencia ventanaInterna=new AltaPonencia("Alta Ponencia", true, true, true, t);
				principal.add(ventanaInterna);
				ventanaInterna.setVisible(true);
			}
		});
		Congreso.add(mntmAltaPonencia);
		
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
		AltaRevista.setText("Revista");
		Revista.add(AltaRevista);
		
		JMenuItem mntmAltaArticulo = new JMenuItem("Alta Articulo");
		mntmAltaArticulo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AltaArticulo ventanaInterna=new AltaArticulo("Alta Articulo", true, true, true, t);
				principal.add(ventanaInterna);
				ventanaInterna.setVisible(true);
			}
		});
		Revista.add(mntmAltaArticulo);
		principal = new JDesktopPane();
		principal.setBackground(new Color(0, 102, 102));
		setContentPane(principal);
		principal.setLayout(null);
		this.repaint();
	}
}
