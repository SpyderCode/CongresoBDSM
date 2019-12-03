package BaseDatos;
//Credo por Pedro,Ricardo,Magaly
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
import javax.swing.SwingConstants;
import java.awt.Window.Type;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

public class Login {

	private JFrame frmCongresosYRevistas;
	private JTextField txtUsuario;
	private JPasswordField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frmCongresosYRevistas.setVisible(true);
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
		frmCongresosYRevistas = new JFrame();
		frmCongresosYRevistas.setForeground(Color.BLACK);
		frmCongresosYRevistas.setBackground(Color.BLACK);
		frmCongresosYRevistas.setTitle("Congresos Y Revistas");
		frmCongresosYRevistas.getContentPane().setBackground(new Color(0, 102, 102));
		frmCongresosYRevistas.setBounds(100, 100, 735, 506);
		frmCongresosYRevistas.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmCongresosYRevistas.getContentPane().setLayout(null);

		JLabel lblBienvenido = new JLabel("BIENVENIDO");
		lblBienvenido.setForeground(Color.WHITE);
		lblBienvenido.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 69));
		lblBienvenido.setBounds(12, 13, 472, 84);
		frmCongresosYRevistas.getContentPane().add(lblBienvenido);

		JLabel lblUsuario = new JLabel();
		lblUsuario.setText("USUARIO");
		lblUsuario.setForeground(Color.WHITE);
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUsuario.setBounds(37, 105, 67, 17);
		frmCongresosYRevistas.getContentPane().add(lblUsuario);

		txtUsuario = new JTextField();
		txtUsuario.setBounds(122, 103, 168, 22);
		frmCongresosYRevistas.getContentPane().add(txtUsuario);

		txtPassword = new JPasswordField();
		txtPassword.setBounds(122, 143, 168, 22);
		frmCongresosYRevistas.getContentPane().add(txtPassword);

		JLabel label_1 = new JLabel();
		label_1.setText("PASSWORD");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_1.setBounds(22, 145, 82, 17);
		frmCongresosYRevistas.getContentPane().add(label_1);

		JButton btnIngresar = new JButton();
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				Conexion.setcuenta(txtUsuario.getText(), txtPassword.getText());
				Conexion.getConection();

				if (Conexion.getstatus()) {
					CongresoBD obj = new CongresoBD();
					obj.setVisible(true);
					frmCongresosYRevistas.setEnabled(false);
				} else {
					JOptionPane.showMessageDialog(null, "Usuario y password incorrectos ", "Error de conexion",
							JOptionPane.ERROR_MESSAGE);
					txtUsuario.setText("");
					txtPassword.setText("");
				}

			}
		});
		btnIngresar.setText("INGRESAR");
		btnIngresar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnIngresar.setBounds(42, 217, 105, 23);
		frmCongresosYRevistas.getContentPane().add(btnIngresar);

		JButton btnSalir = new JButton();
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.err.println("Yeet");
				System.exit(0);
			}
		});
		btnSalir.setText("SALIR");
		btnSalir.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSalir.setBounds(226, 217, 87, 23);
		frmCongresosYRevistas.getContentPane().add(btnSalir);

		JLabel lblBienvenidoACongresos = new JLabel("");
		lblBienvenidoACongresos.setForeground(Color.BLACK);
		lblBienvenidoACongresos.setBackground(Color.WHITE);
		lblBienvenidoACongresos.setIcon(new ImageIcon(Login.class.getResource("/Images/mapaches.png")));
		lblBienvenidoACongresos.setBounds(347, -22, 917, 617);
		frmCongresosYRevistas.getContentPane().add(lblBienvenidoACongresos);
	}
}
