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
		getContentPane().setBackground(Color.WHITE);
		setVisible(true);
		principal = padre;
		contentPanel = (JPanel) this.getContentPane();
		contentPanel.setLayout(null);
		
		JLabel lblNombre = new JLabel();
		lblNombre.setText("Nombre");
		lblNombre.setBounds(12, 184, 45, 16);
		getContentPane().add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(69, 181, 171, 22);
		getContentPane().add(txtNombre);
		
		JLabel lblApellido = new JLabel();
		lblApellido.setText("Lugar");
		lblApellido.setBounds(12, 237, 45, 16);
		getContentPane().add(lblApellido);
		
		txtLugar = new JTextField();
		txtLugar.setBounds(69, 234, 171, 22);
		getContentPane().add(txtLugar);
		
		JLabel lblID = new JLabel();
		lblID.setText("ID");
		lblID.setBounds(24, 133, 12, 16);
		getContentPane().add(lblID);
		
		txtID = new JTextField();
		txtID.setBounds(54, 130, 171, 22);
		getContentPane().add(txtID);
		
		JLabel lblArea = new JLabel();
		lblArea.setText("Area de Interes");
		lblArea.setBounds(264, 184, 93, 16);
		getContentPane().add(lblArea);
		
		txtArea = new JTextField();
		txtArea.setBounds(369, 181, 114, 22);
		getContentPane().add(txtArea);
		
		JLabel lblCosto = new JLabel();
		lblCosto.setText("Costo");
		lblCosto.setBounds(264, 133, 32, 16);
		getContentPane().add(lblCosto);
		
		txtCosto = new JTextField();
		txtCosto.setBounds(308, 130, 86, 22);
		getContentPane().add(txtCosto);
		
		JLabel lblRelevancia = new JLabel();
		lblRelevancia.setText("Relevancia");
		lblRelevancia.setBounds(264, 237, 61, 16);
		getContentPane().add(lblRelevancia);
		
		txtRelevancia = new JTextField();
		txtRelevancia.setBounds(343, 234, 140, 22);
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
		button.setBounds(192, 303, 114, 25);
		getContentPane().add(button);
		
		JLabel AltaCongreso = new JLabel("Alta y Baja Congreso");
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
		btnDarDeBaja.setBounds(357, 303, 126, 25);
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
		btnModificarDatos.setBounds(524, 304, 126, 25);
		getContentPane().add(btnModificarDatos);

		setBounds(100, 100, 771, 369);
	}
}