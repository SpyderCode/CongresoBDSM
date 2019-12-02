package BaseDatos;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Color;

public class BajaCongreso   extends JInternalFrame {

	public CongresoBD principal;
	public JPanel contentPanel;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	public BajaCongreso(String titulo, boolean tamaño, boolean cerrar, boolean maximizar, CongresoBD padre) {
		super(titulo, tamaño, cerrar, maximizar);
		getContentPane().setBackground(Color.WHITE);
		setVisible(true);
		principal = padre;
		contentPanel = (JPanel) this.getContentPane();
		contentPanel.setLayout(null);
		
		JLabel label = new JLabel();
		label.setText("Area de invitado");
		label.setBounds(242, 65, 93, 16);
		getContentPane().add(label);
		
		JLabel label_1 = new JLabel();
		label_1.setText("Apellido");
		label_1.setBounds(12, 120, 45, 16);
		getContentPane().add(label_1);
		
		textField = new JTextField();
		textField.setBounds(69, 117, 171, 22);
		getContentPane().add(textField);
		
		JLabel label_2 = new JLabel();
		label_2.setText("Nombre");
		label_2.setBounds(12, 67, 45, 16);
		 getContentPane().add(label_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(73, 64, 152, 22);
		 getContentPane().add(textField_1);
		
		JLabel label_3 = new JLabel();
		label_3.setText("ID");
		label_3.setBackground(Color.WHITE);
		label_3.setBounds(24, 16, 12, 16);
		 getContentPane().add(label_3);
		
		textField_2 = new JTextField();
		textField_2.setBounds(54, 13, 171, 22);
		 getContentPane().add(textField_2);
		
		JLabel label_4 = new JLabel();
		label_4.setText("Costo");
		label_4.setBounds(264, 16, 32, 16);
		 getContentPane().add(label_4);
		
		textField_3 = new JTextField();
		textField_3.setBounds(308, 13, 86, 22);
		 getContentPane().add(textField_3);
		
		JLabel label_5 = new JLabel();
		label_5.setText("Relevancia");
		label_5.setBounds(264, 120, 61, 16);
		 getContentPane().add(label_5);
		
		textField_4 = new JTextField();
		textField_4.setBounds(343, 64, 140, 22);
		 getContentPane().add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setBounds(343, 117, 140, 22);
		 getContentPane().add(textField_5);
		
		JButton button = new JButton();
		button.setText("Dar de Baja");
		button.setBounds(380, 196, 99, 25);
		 getContentPane().add(button);
		
		setBounds(100, 100, 513, 369);
	}

}
