package BaseDatos;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;

import com.sun.java.swing.plaf.windows.resources.windows;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Login {

	private JFrame frame;
	private JTextField txtUsuario;
	private JTextField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 102, 102));
		frame.setBounds(100, 100, 796, 541);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblBienvenido = new JLabel("BIENVENIDO");
		lblBienvenido.setForeground(Color.WHITE);
		lblBienvenido.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 69));
		lblBienvenido.setBounds(12, 13, 472, 84);
		frame.getContentPane().add(lblBienvenido);
		
		JLabel lblUsuario = new JLabel();
		lblUsuario.setText("USUARIO");
		lblUsuario.setForeground(Color.WHITE);
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUsuario.setBounds(37, 105, 67, 17);
		frame.getContentPane().add(lblUsuario);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(122, 103, 168, 22);
		frame.getContentPane().add(txtUsuario);
		
		txtPassword = new JTextField();
		txtPassword.setBounds(122, 143, 168, 22);
		frame.getContentPane().add(txtPassword);
		
		JLabel label_1 = new JLabel();
		label_1.setText("PASSWORD");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_1.setBounds(22, 145, 82, 17);
		frame.getContentPane().add(label_1);
		
		JButton btnIngresar = new JButton();
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Conexion.setcuenta(txtUsuario.getText(), txtPassword.getText());
				Conexion.getConection();
				
				if(Conexion.getstatus()) {
					CongresoBD obj =new CongresoBD();
					obj.setVisible(true);
					frame.setEnabled(false);
				}else {
					 JOptionPane.showMessageDialog(null, "Usuario y password incorrectos ","Error de conexion",
								JOptionPane.ERROR_MESSAGE);
					   txtUsuario.setText("");
					   txtPassword.setText("");
				}
				
			}
		});
		btnIngresar.setText("INGRESAR");
		btnIngresar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnIngresar.setBounds(42, 217, 89, 23);
		frame.getContentPane().add(btnIngresar);
		
		JButton btnSalir = new JButton();
		btnSalir.setText("SALIR");
		btnSalir.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSalir.setBounds(226, 217, 87, 23);
		frame.getContentPane().add(btnSalir);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Login.class.getResource("/Images/WhatsApp Image 2019-11-30 at 08.48.14.jpeg")));
		label.setBounds(0, 0, 917, 617);
		frame.getContentPane().add(label);
	}
}
