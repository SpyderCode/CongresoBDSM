package BaseDatos;

import java.awt.Color;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;



import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class AltaCongreso  extends JInternalFrame {
	// Obtener el contexto del Frame principal 
	public CongresoBD principal;
	public JPanel contentPanel;
	private JTextField txtNombre;
	private JTextField txtLugar;
	private JTextField txtID;
	private JTextField txtArea;
	private JTextField txtCosto;
	private JTextField txtRelevancia;

	public AltaCongreso(String titulo, boolean tamaño, boolean cerrar, boolean maximizar, CongresoBD padre) {
		super(titulo, tamaño, cerrar, maximizar);
		getContentPane().setForeground(Color.DARK_GRAY);
		getContentPane().setBackground(Color.DARK_GRAY);
		setVisible(true);
		principal = padre;
		contentPanel = (JPanel) this.getContentPane();
		contentPanel.setLayout(null);
		
		JLabel lblNombre = new JLabel();
		lblNombre.setForeground(Color.WHITE);
		lblNombre.setText("Nombre");
		lblNombre.setBounds(12, 184, 45, 16);
		getContentPane().add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(69, 181, 126, 22);
		getContentPane().add(txtNombre);
		
		JLabel lblApellido = new JLabel();
		lblApellido.setForeground(Color.WHITE);
		lblApellido.setText("Lugar");
		lblApellido.setBounds(12, 237, 45, 16);
		getContentPane().add(lblApellido);
		
		txtLugar = new JTextField();
		txtLugar.setBounds(69, 234, 126, 22);
		getContentPane().add(txtLugar);
		
		JLabel lblID = new JLabel();
		lblID.setForeground(Color.WHITE);
		lblID.setText("ID");
		lblID.setBounds(24, 133, 12, 16);
		getContentPane().add(lblID);
		
		txtID = new JTextField();
		txtID.setBounds(69, 130, 126, 22);
		getContentPane().add(txtID);
		
		JLabel lblArea = new JLabel();
		lblArea.setForeground(Color.WHITE);
		lblArea.setText("\u00C1rea de Inter\u00E9s");
		lblArea.setBounds(346, 184, 93, 16);
		getContentPane().add(lblArea);
		
		txtArea = new JTextField();
		txtArea.setBounds(442, 181, 93, 22);
		getContentPane().add(txtArea);
		
		JLabel lblCosto = new JLabel();
		lblCosto.setForeground(Color.WHITE);
		lblCosto.setText("Costo");
		lblCosto.setBounds(346, 133, 61, 16);
		getContentPane().add(lblCosto);
		
		txtCosto = new JTextField();
		txtCosto.setBounds(442, 130, 93, 22);
		getContentPane().add(txtCosto);
		
		JLabel lblRelevancia = new JLabel();
		lblRelevancia.setForeground(Color.WHITE);
		lblRelevancia.setText("Relevancia");
		lblRelevancia.setBounds(346, 237, 61, 16);
		getContentPane().add(lblRelevancia);
		
		txtRelevancia = new JTextField();
		txtRelevancia.setBounds(442, 234, 93, 22);
		getContentPane().add(txtRelevancia);
		
		JButton button = new JButton();
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				CallableStatement cs =null;
				try {
					Connection con = Conexion.getConection();
				    cs=con.prepareCall("{call altacongreso(?,?,?,?,?,?)}");
				    cs.setString("idcon",txtID.getText());
				    cs.setString("nom",txtNombre.getText());
				    cs.setString("lug",txtLugar.getText());
				    cs.setString("cost",txtCosto.getText());
				    cs.setString("area",txtArea.getText());
				    cs.setString("rele",txtRelevancia.getText());
				    cs.execute();
				    JOptionPane.showMessageDialog(null,"Datos Guardados Correctamente ");
				
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
			}
		});
		button.setText("Dar de Alta");
		button.setBounds(69, 303, 114, 25);
		getContentPane().add(button);
		
		JLabel AltaCongreso = new JLabel("Congreso");
		AltaCongreso.setForeground(Color.CYAN);
		AltaCongreso.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 64));
		AltaCongreso.setBounds(12, 24, 706, 93);
		getContentPane().add(AltaCongreso);
		
		JButton btnDarDeBaja = new JButton();
		btnDarDeBaja.setText("Dar de Baja");
		btnDarDeBaja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				CallableStatement cs =null;
				try {
					Connection con = Conexion.getConection();
				    cs=con.prepareCall("{call deletecongreso(?)}");
				    cs.setString("id",txtID.getText());
				 
				   
				    cs.execute();
				    JOptionPane.showMessageDialog(null,"Datos eliminados correctamente ");
				  
			
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
			}
		});
		btnDarDeBaja.setBounds(222, 303, 126, 25);
		getContentPane().add(btnDarDeBaja);
		
		JButton btnModificarDatos = new JButton();
		btnModificarDatos.setText("Modificar datos");
		btnModificarDatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				CallableStatement cs =null;
				try {
					Connection con = Conexion.getConection();
					 cs=con.prepareCall("{call updateCongreso(?,?,?,?,?,?)}");
					    cs.setString("idcon",txtID.getText());
					    cs.setString("nom",txtNombre.getText());
					    cs.setString("lug",txtLugar.getText());
					    cs.setString("cost",txtCosto.getText());
					    cs.setString("area",txtArea.getText());
					    cs.setString("rele",txtRelevancia.getText());
				   
				    cs.execute();
				    JOptionPane.showMessageDialog(null,"Datos modificados correctamente ");
				  
			
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
			}
		});
		btnModificarDatos.setBounds(394, 303, 126, 25);
		getContentPane().add(btnModificarDatos);

		setBounds(100, 100, 578, 369);
	}
}