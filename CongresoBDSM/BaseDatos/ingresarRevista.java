package BaseDatos;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;

import javax.swing.JButton;
//import javax.swing.JDialog;
//import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.jar.JarOutputStream;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.ImageIcon;

public class ingresarRevista extends JInternalFrame {
	// Obtener el contexto del Frame principal Hospital
	public CongresoBD principal;
	public JPanel contentPanel;
	private JTextField txtID;
	private JTextField txtNombre;
	private JTextField txtRelevancia;
	private JTextField txtFecha;
	private JTextField txtPub;
	private JTextField txtNumEdicion;
	private JTextField txtCosto;

	public ingresarRevista(String titulo, boolean tamaño, boolean cerrar, boolean maximizar, CongresoBD padre) {
		super(titulo, tamaño, cerrar, maximizar);
		getContentPane().setBackground(Color.DARK_GRAY);
		setVisible(true);
		principal = padre;
		contentPanel = (JPanel) this.getContentPane();
		contentPanel.setLayout(null);
		
		JButton btnDarDeAlta = new JButton("Dar de Alta");
		btnDarDeAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				CallableStatement cs =null;
				try {
					Connection con = Conexion.getConection();
				    cs=con.prepareCall("{call altarevista(?,?,?,?,?,?,?)}");
				    cs.setString("idrev",txtID.getText());
				    cs.setString("cost",txtCosto.getText());
				    cs.setString("rele",txtRelevancia.getText());
				    cs.setString("numrev",txtNumEdicion.getText());
				    cs.setString("nom",txtNombre.getText());
				    cs.setString("fecha",txtFecha.getText());
				    cs.setString("tipo",txtPub.getText());
				   
				    cs.execute();
				    JOptionPane.showMessageDialog(null,"Datos Guardados Correctamente ");
				  
			
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
			}
		});
		btnDarDeAlta.setBounds(272, 296, 116, 25);
		getContentPane().add(btnDarDeAlta);
		
		JLabel lblId = new JLabel("ID");
		lblId.setForeground(Color.WHITE);
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblId.setBounds(12, 70, 34, 34);
		getContentPane().add(lblId);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setForeground(Color.WHITE);
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblNombre.setBounds(12, 107, 106, 34);
		getContentPane().add(lblNombre);
		
		JLabel lblRelevancia = new JLabel("Relevancia");
		lblRelevancia.setForeground(Color.WHITE);
		lblRelevancia.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblRelevancia.setBounds(12, 154, 132, 34);
		getContentPane().add(lblRelevancia);
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setForeground(Color.WHITE);
		lblFecha.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblFecha.setBounds(12, 201, 132, 34);
		getContentPane().add(lblFecha);
		
		JLabel lblTipoDePublicacion = new JLabel("Tipo de publicacion");
		lblTipoDePublicacion.setForeground(Color.WHITE);
		lblTipoDePublicacion.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblTipoDePublicacion.setBounds(12, 242, 259, 34);
		getContentPane().add(lblTipoDePublicacion);
		
		JLabel lblCosto = new JLabel("Costo");
		lblCosto.setForeground(Color.WHITE);
		lblCosto.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblCosto.setBounds(293, 107, 132, 34);
		getContentPane().add(lblCosto);
		
		JLabel lblNumedicion = new JLabel("NumEdicion");
		lblNumedicion.setForeground(Color.WHITE);
		lblNumedicion.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblNumedicion.setBounds(293, 154, 174, 34);
		getContentPane().add(lblNumedicion);
		
		txtID = new JTextField();
		txtID.setBounds(59, 82, 116, 22);
		getContentPane().add(txtID);
		txtID.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(155, 119, 116, 22);
		getContentPane().add(txtNombre);
		
		txtRelevancia = new JTextField();
		txtRelevancia.setColumns(10);
		txtRelevancia.setBounds(155, 166, 116, 22);
		getContentPane().add(txtRelevancia);
		
		txtFecha = new JTextField();
		txtFecha.setColumns(10);
		txtFecha.setBounds(155, 213, 116, 22);
		getContentPane().add(txtFecha);
		
		txtPub = new JTextField();
		txtPub.setColumns(10);
		txtPub.setBounds(272, 254, 359, 22);
		getContentPane().add(txtPub);
		
		txtNumEdicion = new JTextField();
		txtNumEdicion.setColumns(10);
		txtNumEdicion.setBounds(451, 166, 116, 22);
		getContentPane().add(txtNumEdicion);
		
		txtCosto = new JTextField();
		txtCosto.setColumns(10);
		txtCosto.setBounds(451, 119, 116, 22);
		getContentPane().add(txtCosto);
		
		JLabel lblNewLabel = new JLabel("REVISTA");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 95));
		lblNewLabel.setBounds(204, 0, 603, 103);
		getContentPane().add(lblNewLabel);
		
		JButton btnDarDeBaja = new JButton("Dar de Baja");
		btnDarDeBaja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				CallableStatement cs =null;
				try {
					Connection con = Conexion.getConection();
				    cs=con.prepareCall("{call deleterevista(?)}");
				    cs.setString("id",txtID.getText());
				 
				   
				    cs.execute();
				    JOptionPane.showMessageDialog(null,"Revista eliminada correctamente ");
				  
			
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
			}
		});
		btnDarDeBaja.setBounds(428, 296, 136, 25);
		getContentPane().add(btnDarDeBaja);

		setBounds(100, 100, 674, 369);
		
		
		JButton btnModificarDatos = new JButton();
		btnModificarDatos.setText("Modificar datos");
		btnModificarDatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				CallableStatement cs =null;
				try {
					Connection con = Conexion.getConection();
				    cs=con.prepareCall("{call updateRevista(?,?,?,?,?,?,?)}");
				    cs.setString("idrev",txtID.getText());
				    cs.setString("cost",txtCosto.getText());
				    cs.setString("rele",txtRelevancia.getText());
				    cs.setString("numrev",txtNumEdicion.getText());
				    cs.setString("nom",txtNombre.getText());
				    cs.setString("fecha",txtFecha.getText());
				    cs.setString("tipo",txtPub.getText());
				   
				    cs.execute();
				    JOptionPane.showMessageDialog(null,"Datos modificados correctamente ");
				  
			
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
			}
		});
		btnModificarDatos.setBounds(602, 296, 126, 25);
		getContentPane().add(btnModificarDatos);

		setBounds(100, 100, 771, 369);
	}
}
