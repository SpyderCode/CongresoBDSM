package BaseDatos;

import java.awt.Color;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class VerPonencia  extends JInternalFrame {
	// Obtener el contexto del Frame principal Hospital
	public CongresoBD principal;
	public JPanel contentPanel;
	private JTextField txtId;
	private JTable tableDatos;
	Border border = BorderFactory.createLineBorder(Color.BLACK, 1);

	public VerPonencia(String titulo, boolean tamaño, boolean cerrar, boolean maximizar, CongresoBD padre) {
		super(titulo, tamaño, cerrar, maximizar);
		getContentPane().setBackground(Color.WHITE);
		setVisible(true);
		principal = padre;
		contentPanel = (JPanel) this.getContentPane();
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ver Ponencias");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 69));
		lblNewLabel.setBounds(12, 13, 528, 84);
		getContentPane().add(lblNewLabel);
		
		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 29));
		lblId.setBounds(12, 110, 36, 45);
		getContentPane().add(lblId);
		
		txtId = new JTextField();
		txtId.setBounds(60, 128, 354, 22);
		getContentPane().add(txtId);
		txtId.setColumns(10);
		
		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.setBounds(426, 127, 97, 25);
		getContentPane().add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(border);
		scrollPane.setBounds(12, 168, 528, 321);
		getContentPane().add(scrollPane);
		
		tableDatos = new JTable();
		tableDatos.setFont(new Font("Tahoma", Font.PLAIN, 18));
		scrollPane.setViewportView(tableDatos);

		setBounds(100, 100, 564, 535);
	}
}