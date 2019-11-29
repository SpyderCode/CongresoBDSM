package BaseDatos;

import java.awt.Color;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class AltaInvestigador  extends JInternalFrame {
	// Obtener el contexto del Frame principal Hospital
	public CongresoBD principal;
	public JPanel contentPanel;
	private JTextField txtNombre;
	private JTextField txtId;
	private JTextField txtEspecialidad;
	private JTextField txtApellido;

	public AltaInvestigador(String titulo, boolean tamaño, boolean cerrar, boolean maximizar, CongresoBD padre) {
		super(titulo, tamaño, cerrar, maximizar);
		getContentPane().setBackground(Color.WHITE);
		setVisible(true);
		principal = padre;
		contentPanel = (JPanel) this.getContentPane();
		contentPanel.setLayout(null);
		
		JLabel lblRegistrarInvestigador = new JLabel("Registrar");
		lblRegistrarInvestigador.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 69));
		lblRegistrarInvestigador.setBounds(67, 0, 335, 84);
		getContentPane().add(lblRegistrarInvestigador);
		
		JLabel label = new JLabel("ID");
		label.setFont(new Font("Tahoma", Font.PLAIN, 29));
		label.setBounds(22, 97, 36, 45);
		getContentPane().add(label);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 29));
		lblNombre.setBounds(22, 154, 106, 45);
		getContentPane().add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setFont(new Font("Tahoma", Font.PLAIN, 29));
		lblApellido.setBounds(22, 205, 106, 45);
		getContentPane().add(lblApellido);
		
		JLabel lblEspecialidad = new JLabel("Especialidad");
		lblEspecialidad.setFont(new Font("Tahoma", Font.PLAIN, 29));
		lblEspecialidad.setBounds(22, 263, 156, 45);
		getContentPane().add(lblEspecialidad);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(197, 172, 163, 22);
		getContentPane().add(txtNombre);
		txtNombre.setColumns(10);
		
		txtId = new JTextField();
		txtId.setColumns(10);
		txtId.setBounds(197, 115, 163, 22);
		getContentPane().add(txtId);
		
		txtEspecialidad = new JTextField();
		txtEspecialidad.setColumns(10);
		txtEspecialidad.setBounds(197, 281, 163, 22);
		getContentPane().add(txtEspecialidad);
		
		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		txtApellido.setBounds(197, 223, 163, 22);
		getContentPane().add(txtApellido);
		
		JButton btnRegistra = new JButton("Registrar");
		btnRegistra.setBounds(421, 295, 97, 25);
		getContentPane().add(btnRegistra);

		setBounds(100, 100, 542, 369);
	}
}