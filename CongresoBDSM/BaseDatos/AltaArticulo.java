package BaseDatos;

import java.awt.Color;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
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
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JRadioButton;

public class AltaArticulo  extends JInternalFrame {
	// Obtener el contexto del Frame principal Hospital
	public CongresoBD principal;
	public JPanel contentPanel;
	private JTextField txtId;
	private JTextField txtIdInvestigador;
	private JTextField txtNombre;
    private int vered;
    private JTextField txtIdRevista;
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
		
		txtId = new JTextField();
		txtId.setColumns(10);
		txtId.setBounds(50, 126, 164, 22);
		getContentPane().add(txtId);
		
		txtIdInvestigador = new JTextField();
		txtIdInvestigador.setColumns(10);
		txtIdInvestigador.setBounds(226, 179, 164, 22);
		getContentPane().add(txtIdInvestigador);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(350, 126, 164, 22);
		getContentPane().add(txtNombre);
		
		ButtonGroup veredicto = new ButtonGroup();
		
		JRadioButton rdbtnAceptado = new JRadioButton("Aceptado");
		rdbtnAceptado.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rdbtnAceptado.setBackground(Color.WHITE);
		rdbtnAceptado.setForeground(Color.BLACK);
		rdbtnAceptado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				vered=1;
			}
		});
		rdbtnAceptado.setBounds(66, 252, 109, 23);
		getContentPane().add(rdbtnAceptado);
		veredicto.add(rdbtnAceptado);
		
		JRadioButton rdbtnRechazado = new JRadioButton("Rechazado");
		rdbtnRechazado.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rdbtnRechazado.setBackground(Color.WHITE);
		rdbtnRechazado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vered=0;
			}
		});
		rdbtnRechazado.setBounds(66, 296, 109, 23);
		getContentPane().add(rdbtnRechazado);
		veredicto.add(rdbtnRechazado);
		
		JLabel lblIdRevista = new JLabel("ID Revista");
		lblIdRevista.setFont(new Font("Tahoma", Font.PLAIN, 29));
		lblIdRevista.setBounds(12, 205, 220, 45);
		getContentPane().add(lblIdRevista);
		
		txtIdRevista = new JTextField();
		txtIdRevista.setColumns(10);
		txtIdRevista.setBounds(226, 219, 164, 22);
		getContentPane().add(txtIdRevista);
		
		JButton Modificar = new JButton("Modificar");
		Modificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CallableStatement cs =null;
				try {
					Connection con = Conexion.getConection();
				    cs=con.prepareCall("{call updateArticulo(?,?,?,?)}");
				    cs.setString("idart",txtId.getText());
				    cs.setString("nomart",txtNombre.getText());
				    cs.setString("idinv",txtIdInvestigador.getText());
				    cs.setString("vere",""+vered);
				    cs.setString("idrev", txtIdRevista.getText());
				    
		
				    cs.execute();
				    JOptionPane.showMessageDialog(null,"Datos Mofidicados Correctamente ");
				    
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		Modificar.setBounds(549, 295, 97, 25);
		getContentPane().add(Modificar);
		
		JButton Alta = new JButton("Alta");
		Alta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				CallableStatement cs =null;
				try {
					Connection con = Conexion.getConection();
				    cs=con.prepareCall("{call altaArticulo(?,?,?,?,?)}");
				    cs.setString("idart",txtId.getText());
				    cs.setString("nomart",txtNombre.getText());
				    cs.setString("idinv",txtIdInvestigador.getText());
				    cs.setLong("vere",vered);
				    cs.setString("idrev", txtIdRevista.getText());
				    
		
				    cs.execute();
				    JOptionPane.showMessageDialog(null,"Datos Guardados Correctamente ");
				    
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
			}
		});
		Alta.setBounds(334, 295, 97, 25);
		getContentPane().add(Alta);
		
		JButton Baja = new JButton("Baja");
		Baja.addActionListener(new ActionListener() {
			CallableStatement cs =null;
			public void actionPerformed(ActionEvent e) {
				
				try {
					Connection con = Conexion.getConection();
				    cs=con.prepareCall("{call deletearticulo(?)}");
				    cs.setString("id",txtId.getText());
				
				    cs.execute();
				    JOptionPane.showMessageDialog(null,"Articulo Borrado Correctamente ");
				    
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		Baja.setBounds(440, 295, 97, 25);
		getContentPane().add(Baja);

		setBounds(100, 100, 674, 369);
	}
}