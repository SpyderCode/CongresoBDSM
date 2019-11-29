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

public class VerArticulos  extends JInternalFrame {
	// Obtener el contexto del Frame principal Hospital
	public CongresoBD principal;
	public JPanel contentPanel;
	private JTextField textField;
	private JTable tableDatos;
	Border border = BorderFactory.createLineBorder(Color.BLACK, 1);

	public VerArticulos(String titulo, boolean tama�o, boolean cerrar, boolean maximizar, CongresoBD padre) {
		super(titulo, tama�o, cerrar, maximizar);
		getContentPane().setBackground(Color.WHITE);
		setVisible(true);
		principal = padre;
		contentPanel = (JPanel) this.getContentPane();
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ver Articulos");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 69));
		lblNewLabel.setBounds(12, 13, 528, 84);
		getContentPane().add(lblNewLabel);
		
		JLabel label = new JLabel("ID");
		label.setFont(new Font("Tahoma", Font.PLAIN, 29));
		label.setBounds(12, 110, 36, 45);
		getContentPane().add(label);
		
		textField = new JTextField();
		textField.setBounds(60, 128, 354, 22);
		getContentPane().add(textField);
		textField.setColumns(10);
		
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