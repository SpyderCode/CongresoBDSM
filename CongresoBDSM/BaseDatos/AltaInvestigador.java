package BaseDatos;

import java.awt.Color;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

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
		btnRegistra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CallableStatement cs =null;
				try {
					Connection con = Conexion.getConection();
				    cs=con.prepareCall("{call altaInvestigador(?,?,?,?)}");
				    cs.setString("idinv",txtId.getText());
				     cs.setString("nom",txtNombre.getText());
				    cs.setString("apell",txtApellido.getText());
				    cs.setString("espe",txtEspecialidad.getText());
				   
				    
				   
				    cs.execute();
				    JOptionPane.showMessageDialog(null,"Investigador Registrado Correctamente ");
				  
			
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
			
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null,"Error al registrar Investigador ");
				}
			}
		});
		btnRegistra.setBounds(245, 346, 97, 25);
		getContentPane().add(btnRegistra);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CallableStatement cs =null;
				try {
					Connection con = Conexion.getConection();
				    cs=con.prepareCall("{call deletinvestigador(?)}");
				    cs.setString("id",txtId.getText());
				 
				   
				    
				   
				    cs.execute();
				    JOptionPane.showMessageDialog(null,"Investigador Borrado Correctamente ");
				  
			
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null,"Error al eliminar Investigador ");
					e1.printStackTrace();
				}
				
			}
		});
		btnEliminar.setBounds(350, 347, 97, 25);
		getContentPane().add(btnEliminar);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CallableStatement cs =null;
				try {
					Connection con = Conexion.getConection();
				    cs=con.prepareCall("{call updateInvestigador(?,?,?,?)}");
				    cs.setString("idinv",txtId.getText());
				     cs.setString("nom",txtNombre.getText());
				    cs.setString("apell",txtApellido.getText());
				    cs.setString("espe",txtEspecialidad.getText());
				   
				    
				   
				    cs.execute();
				    JOptionPane.showMessageDialog(null,"Investigador Modificado Correctamente ");
				  
			
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null,"Error al Modificar Investigador");
					e1.printStackTrace();
				}
				
			}
		});
		btnModificar.setBounds(457, 347, 97, 25);
		getContentPane().add(btnModificar);

		setBounds(100, 100, 578, 412);
	}
}