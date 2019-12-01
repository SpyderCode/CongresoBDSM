package BaseDatos;

import java.awt.Color;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JTextField;

public class AltaPonencia  extends JInternalFrame {
	// Obtener el contexto del Frame principal Hospital
	public CongresoBD principal;
	public JPanel contentPanel;
	private JTextField txtID;
	private JTextField txtIdInvestigador;
	private JTextField txtNombre;
	private String vered;
	private JTextField txtIdCongreso;

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
		lblNombre.setBounds(12, 182, 112, 45);
		getContentPane().add(lblNombre);
		
		JLabel lblIdInvestigador = new JLabel("ID Investigador");
		lblIdInvestigador.setFont(new Font("Tahoma", Font.PLAIN, 29));
		lblIdInvestigador.setBounds(236, 106, 220, 45);
		getContentPane().add(lblIdInvestigador);
		
		txtID = new JTextField();
		txtID.setBounds(50, 124, 164, 22);
		getContentPane().add(txtID);
		txtID.setColumns(10);
		
		txtIdInvestigador = new JTextField();
		txtIdInvestigador.setColumns(10);
		txtIdInvestigador.setBounds(450, 125, 164, 22);
		getContentPane().add(txtIdInvestigador);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(137, 201, 164, 22);
		getContentPane().add(txtNombre);

		setBounds(100, 100, 674, 369);
		
ButtonGroup veredicto = new ButtonGroup();
		
		JRadioButton rdbtnAceptado = new JRadioButton("Aceptado");
		rdbtnAceptado.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rdbtnAceptado.setBackground(Color.WHITE);
		rdbtnAceptado.setForeground(Color.BLACK);
		rdbtnAceptado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				vered="Aceptado";
			}
		});
		rdbtnAceptado.setBounds(66, 265, 109, 23);
		getContentPane().add(rdbtnAceptado);
		veredicto.add(rdbtnAceptado);
		
		JRadioButton rdbtnRechazado = new JRadioButton("Rechazado");
		rdbtnRechazado.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rdbtnRechazado.setBackground(Color.WHITE);
		rdbtnRechazado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vered="Rechazado";
			}
		});
		rdbtnRechazado.setBounds(66, 291, 109, 23);
		getContentPane().add(rdbtnRechazado);
		veredicto.add(rdbtnRechazado);
		
		JLabel lblIdCongreso = new JLabel("ID Congreso");
		lblIdCongreso.setFont(new Font("Tahoma", Font.PLAIN, 29));
		lblIdCongreso.setBounds(12, 143, 220, 45);
		getContentPane().add(lblIdCongreso);
		
		txtIdCongreso = new JTextField();
		txtIdCongreso.setColumns(10);
		txtIdCongreso.setBounds(185, 159, 164, 22);
		getContentPane().add(txtIdCongreso);
		
		JButton btnAlta = new JButton("Alta");
		btnAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CallableStatement cs =null;
				try {
					Connection con = Conexion.getConection();
				    cs=con.prepareCall("{call altaponencia(?,?,?,?,?)}");
				    cs.setString("idpon",txtID.getText());
				    cs.setString("nom",txtNombre.getText());
				    cs.setString("idinves",txtIdInvestigador.getText());
				    cs.setString("vere",vered);
				    cs.setString("idCon", txtIdCongreso.getText());
				    
		
				    cs.execute();
				    JOptionPane.showMessageDialog(null,"Datos Guardados Correctamente ");
				    
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnAlta.setBounds(334, 293, 97, 25);
		getContentPane().add(btnAlta);
		
		JButton btnBaja = new JButton("Baja");
		btnBaja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CallableStatement cs =null;
				try {
					Connection con = Conexion.getConection();
				    cs=con.prepareCall("{call deleteponencia(?)}");
				    cs.setString("id",txtID.getText());
				   
				    
		
				    cs.execute();
				    JOptionPane.showMessageDialog(null,"Ponencia borrada correctamente ");
				    
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnBaja.setBounds(440, 293, 97, 25);
		getContentPane().add(btnBaja);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CallableStatement cs =null;
				try {
					Connection con = Conexion.getConection();
				    cs=con.prepareCall("{call updatePonencia(?,?,?,?)}");
				    cs.setString("idpon",txtID.getText());
				    cs.setString("nom",txtNombre.getText());
				    cs.setString("idinves",txtIdInvestigador.getText());
				    cs.setString("vere",vered);
				    
		
				    cs.execute();
				    JOptionPane.showMessageDialog(null,"Datos Guardados Correctamente ");
				    
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnModificar.setBounds(549, 293, 97, 25);
		getContentPane().add(btnModificar);

		setBounds(100, 100, 674, 369);
	}
}