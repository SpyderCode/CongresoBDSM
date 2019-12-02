package BaseDatos;

import java.awt.Color;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class VerUsuarios  extends JInternalFrame {
	// Obtener el contexto del Frame principal Hospital
	public CongresoBD principal;
	public JPanel contentPanel;
	private JTextField buscar;
	private JTable table;
	Border border = BorderFactory.createLineBorder(Color.BLACK, 1);

	public VerUsuarios(String titulo, boolean tamaño, boolean cerrar, boolean maximizar, CongresoBD padre) {
		super(titulo, tamaño, cerrar, maximizar);
		getContentPane().setBackground(Color.DARK_GRAY);
		setVisible(true);
		principal = padre;
		contentPanel = (JPanel) this.getContentPane();
		contentPanel.setLayout(null);
		
		JLabel lblVerUsuarios = new JLabel("Ver Investigadores");
		lblVerUsuarios.setForeground(Color.CYAN);
		lblVerUsuarios.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 69));
		lblVerUsuarios.setBounds(12, 13, 708, 84);
		getContentPane().add(lblVerUsuarios);
		
		JLabel label = new JLabel("ID");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Tahoma", Font.PLAIN, 29));
		label.setBounds(12, 110, 36, 45);
		getContentPane().add(label);
		
		buscar = new JTextField();
		buscar.setBounds(60, 128, 354, 22);
		getContentPane().add(buscar);
		buscar.setColumns(10);
		
		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Campo = buscar.getText();
				String where = "";

				if (!"".equals(Campo))
				{
				where = "WHERE idInvestigador = '" + Campo + "'";
				}
				
				try {
					DefaultTableModel modelo = new DefaultTableModel();
					table.setModel(modelo);
					PreparedStatement ps = null;
					ResultSet rs = null;
					@SuppressWarnings("unused")
					Conexion conn = new Conexion();
					Connection con = Conexion.getConection();
					
					
					
					String sql = "SELECT idInvestigador,nombre,apellido,especialidad  FROM investigador " + where;
					System.out.println(sql);
					ps = (PreparedStatement) con.prepareStatement(sql);
					rs = ps.executeQuery();
					
					java.sql.ResultSetMetaData rsMd =  rs.getMetaData();
					int cantidadColumnas = rsMd.getColumnCount();
					
					modelo.addColumn("ID Investigador");
					modelo.addColumn("Nombre");
			        modelo.addColumn("Apellido");
			        modelo.addColumn("Especialidad");
			        
			      
			                int[] anchos = {50, 100, 100, 120, 100, 100, 70};
			        for (int x = 0; x < cantidadColumnas; x++) {
			        table.getColumnModel().getColumn(x).setPreferredWidth(anchos[x]);
			        }
					while (rs.next()) {
						Object[] filas = new Object[cantidadColumnas];
						for (int i = 0; i< cantidadColumnas; i++)
						{
							filas[i] = rs.getObject(i + 1);
						}
						modelo.addRow(filas);
					}
						
				} catch (SQLException ex) {
					System.err.println(ex.toString());
				 }
			}
		});
		btnNewButton.setBounds(426, 127, 97, 25);
		getContentPane().add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(border);
		scrollPane.setBounds(12, 168, 836, 333);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 18));
		scrollPane.setViewportView(table);
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				try {
					DefaultTableModel modelo = new DefaultTableModel();
					table.setModel(modelo);
					PreparedStatement ps = null;
					ResultSet rs = null;
					@SuppressWarnings("unused")
					Conexion conn = new Conexion();
					Connection con = Conexion.getConection();
					
					
					
					String sql = "SELECT idInvestigador,nombre,apellido,especialidad  FROM investigador ";
					System.out.println(sql);
					ps = (PreparedStatement) con.prepareStatement(sql);
					rs = ps.executeQuery();
					
					java.sql.ResultSetMetaData rsMd =  rs.getMetaData();
					int cantidadColumnas = rsMd.getColumnCount();
					
					modelo.addColumn("ID Investigador");
					modelo.addColumn("Nombre");
			        modelo.addColumn("Apellido");
			        modelo.addColumn("Especialidad");
			        
			      
			                int[] anchos = {50, 100, 100, 120, 100, 100, 70};
			        for (int x = 0; x < cantidadColumnas; x++) {
			        table.getColumnModel().getColumn(x).setPreferredWidth(anchos[x]);
			        }
					while (rs.next()) {
						Object[] filas = new Object[cantidadColumnas];
						for (int i = 0; i< cantidadColumnas; i++)
						{
							filas[i] = rs.getObject(i + 1);
						}
						modelo.addRow(filas);
					}
						
				} catch (SQLException ex) {
					System.err.println(ex.toString());
				 }
			}
		});
		btnActualizar.setBounds(752, 127, 97, 25);
		getContentPane().add(btnActualizar);

		setBounds(100, 100, 877, 550);
	}
}