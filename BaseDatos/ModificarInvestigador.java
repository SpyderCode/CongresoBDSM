package BaseDatos;

import java.awt.Color;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class ModificarInvestigador  extends JInternalFrame {
	// Obtener el contexto del Frame principal Hospital
	public CongresoBD principal;
	public JPanel contentPanel;
	private JTextField txtRelevancia;
	private JTextField txtID;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtCosto;
	private JTextField txtArea;

	public ModificarInvestigador(String titulo, boolean tamaño, boolean cerrar, boolean maximizar, CongresoBD padre) {
		super(titulo, tamaño, cerrar, maximizar);
		getContentPane().setBackground(Color.WHITE);
		setVisible(true);
		principal = padre;
		contentPanel = (JPanel) this.getContentPane();
		contentPanel.setLayout(null);
		
		JLabel lblID = new JLabel();
		lblID.setText("ID");
		lblID.setBounds(45, 61, 12, 16);
		getContentPane().add(lblID);
		
		JLabel lblNombre = new JLabel();
		lblNombre.setText("Nombre");
		lblNombre.setBounds(12, 109, 45, 16);
		getContentPane().add(lblNombre);
		
		JLabel lblApellido = new JLabel();
		lblApellido.setText("Apellido");
		lblApellido.setBounds(12, 175, 45, 16);
		getContentPane().add(lblApellido);
		
		JLabel lblRelevancia = new JLabel();
		lblRelevancia.setText("Relevancia");
		lblRelevancia.setBounds(307, 175, 61, 16);
		getContentPane().add(lblRelevancia);
		
		txtRelevancia = new JTextField();
		txtRelevancia.setBounds(398, 172, 161, 22);
		getContentPane().add(txtRelevancia);
		
		txtID = new JTextField();
		txtID.setBounds(75, 58, 161, 22);
		getContentPane().add(txtID);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(75, 106, 161, 22);
		getContentPane().add(txtNombre);
		
		txtApellido = new JTextField();
		txtApellido.setBounds(75, 172, 161, 22);
		getContentPane().add(txtApellido);
		
		JLabel lblArea = new JLabel();
		lblArea.setText("Are de Invitado");
		lblArea.setBounds(281, 109, 87, 16);
		getContentPane().add(lblArea);
		
		JLabel lblCosto = new JLabel();
		lblCosto.setText("Costo");
		lblCosto.setBounds(336, 61, 32, 16);
		getContentPane().add(lblCosto);
		
		txtCosto = new JTextField();
		txtCosto.setBounds(398, 58, 130, 22);
		getContentPane().add(txtCosto);
		
		txtArea = new JTextField();
		txtArea.setBounds(398, 106, 161, 22);
		getContentPane().add(txtArea);
		
		JButton btnModificar = new JButton();
		btnModificar.setText("Modificar");
		btnModificar.setBounds(474, 245, 85, 25);
		getContentPane().add(btnModificar);

		setBounds(100, 100, 588, 319);
	}

}