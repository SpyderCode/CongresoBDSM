package BaseDatos;

import java.awt.Color;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;

public class AltaPonencia  extends JInternalFrame {
	// Obtener el contexto del Frame principal Hospital
	public CongresoBD principal;
	public JPanel contentPanel;
	private JTextField txtID;
	private JTextField txtIdInvestigador;
	private JTextField txtIdCongreso;
	private JTextField txtNombre;

	public AltaPonencia(String titulo, boolean tamaño, boolean cerrar, boolean maximizar, CongresoBD padre) {
		super(titulo, tamaño, cerrar, maximizar);
		getContentPane().setBackground(Color.WHITE);
		setVisible(true);
		principal = padre;
		contentPanel = (JPanel) this.getContentPane();
		contentPanel.setLayout(null);
		
		JLabel lblPonencia = new JLabel("PONENCIA");
		lblPonencia.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 70));
		lblPonencia.setBounds(12, 13, 389, 70);
		getContentPane().add(lblPonencia);
		
		JLabel lblID = new JLabel("ID");
		lblID.setFont(new Font("Tahoma", Font.PLAIN, 29));
		lblID.setBounds(12, 106, 36, 45);
		getContentPane().add(lblID);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 29));
		lblNombre.setBounds(226, 106, 112, 45);
		getContentPane().add(lblNombre);
		
		JLabel lblIdInvestigador = new JLabel("ID Investigador");
		lblIdInvestigador.setFont(new Font("Tahoma", Font.PLAIN, 29));
		lblIdInvestigador.setBounds(12, 159, 220, 45);
		getContentPane().add(lblIdInvestigador);
		
		JLabel lblIdCongreso = new JLabel("ID Congreso");
		lblIdCongreso.setFont(new Font("Tahoma", Font.PLAIN, 29));
		lblIdCongreso.setBounds(12, 219, 220, 45);
		getContentPane().add(lblIdCongreso);
		
		JCheckBox chckbxAceptado = new JCheckBox("Aceptado");
		chckbxAceptado.setHorizontalAlignment(SwingConstants.LEFT);
		chckbxAceptado.setBackground(Color.WHITE);
		chckbxAceptado.setFont(new Font("Tahoma", Font.PLAIN, 27));
		chckbxAceptado.setBounds(12, 273, 154, 45);
		getContentPane().add(chckbxAceptado);
		
		txtID = new JTextField();
		txtID.setBounds(50, 124, 164, 22);
		getContentPane().add(txtID);
		txtID.setColumns(10);
		
		txtIdInvestigador = new JTextField();
		txtIdInvestigador.setColumns(10);
		txtIdInvestigador.setBounds(226, 177, 164, 22);
		getContentPane().add(txtIdInvestigador);
		
		txtIdCongreso = new JTextField();
		txtIdCongreso.setColumns(10);
		txtIdCongreso.setBounds(226, 237, 164, 22);
		getContentPane().add(txtIdCongreso);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(350, 124, 164, 22);
		getContentPane().add(txtNombre);
		
		JButton btnAlta = new JButton("Alta");
		btnAlta.setBounds(334, 293, 97, 25);
		getContentPane().add(btnAlta);
		
		JButton btnBaja = new JButton("Baja");
		btnBaja.setBounds(440, 293, 97, 25);
		getContentPane().add(btnBaja);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.setBounds(549, 293, 97, 25);
		getContentPane().add(btnModificar);

		setBounds(100, 100, 674, 369);
	}
}