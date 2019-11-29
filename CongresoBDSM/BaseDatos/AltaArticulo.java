package BaseDatos;

import java.awt.Color;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

public class AltaArticulo  extends JInternalFrame {
	// Obtener el contexto del Frame principal Hospital
	public CongresoBD principal;
	public JPanel contentPanel;
	private JTextField txtId;
	private JTextField txtIdInvestigador;
	private JTextField txtIdRevista;
	private JTextField txtNombre;

	public AltaArticulo(String titulo, boolean tamaño, boolean cerrar, boolean maximizar, CongresoBD padre) {
		super(titulo, tamaño, cerrar, maximizar);
		getContentPane().setBackground(Color.WHITE);
		setVisible(true);
		principal = padre;
		contentPanel = (JPanel) this.getContentPane();
		contentPanel.setLayout(null);
		
		JLabel lblArticulo = new JLabel("Articulo");
		lblArticulo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 70));
		lblArticulo.setBounds(12, 13, 389, 70);
		getContentPane().add(lblArticulo);
		
		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 29));
		lblId.setBounds(12, 108, 36, 45);
		getContentPane().add(lblId);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 29));
		lblNombre.setBounds(226, 108, 112, 45);
		getContentPane().add(lblNombre);
		
		JLabel lblIdInvestigador = new JLabel("ID Investigador");
		lblIdInvestigador.setFont(new Font("Tahoma", Font.PLAIN, 29));
		lblIdInvestigador.setBounds(12, 161, 220, 45);
		getContentPane().add(lblIdInvestigador);
		
		JLabel lblIdRevista = new JLabel("ID Revista");
		lblIdRevista.setFont(new Font("Tahoma", Font.PLAIN, 29));
		lblIdRevista.setBounds(12, 221, 220, 45);
		getContentPane().add(lblIdRevista);
		
		JCheckBox Aceptado = new JCheckBox("Aceptado");
		Aceptado.setHorizontalAlignment(SwingConstants.LEFT);
		Aceptado.setFont(new Font("Tahoma", Font.PLAIN, 27));
		Aceptado.setBackground(Color.WHITE);
		Aceptado.setBounds(12, 275, 154, 45);
		getContentPane().add(Aceptado);
		
		txtId = new JTextField();
		txtId.setColumns(10);
		txtId.setBounds(50, 126, 164, 22);
		getContentPane().add(txtId);
		
		txtIdInvestigador = new JTextField();
		txtIdInvestigador.setColumns(10);
		txtIdInvestigador.setBounds(226, 179, 164, 22);
		getContentPane().add(txtIdInvestigador);
		
		txtIdRevista = new JTextField();
		txtIdRevista.setColumns(10);
		txtIdRevista.setBounds(226, 239, 164, 22);
		getContentPane().add(txtIdRevista);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(350, 126, 164, 22);
		getContentPane().add(txtNombre);
		
		JButton Alta = new JButton("Alta");
		Alta.setBounds(334, 295, 97, 25);
		getContentPane().add(Alta);
		
		JButton Baja = new JButton("Baja");
		Baja.setBounds(440, 295, 97, 25);
		getContentPane().add(Baja);
		
		JButton Modificar = new JButton("Modificar");
		Modificar.setBounds(549, 295, 97, 25);
		getContentPane().add(Modificar);

		setBounds(100, 100, 674, 369);
	}

}