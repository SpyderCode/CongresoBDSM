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
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

public class VerCongreso  extends JInternalFrame {
	// Obtener el contexto del Frame principal Hospital
	public CongresoBD principal;
	public JPanel contentPanel;
	private JTextField txtID;
	Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
	private JTable table;

	public VerCongreso(String titulo, boolean tama�o, boolean cerrar, boolean maximizar, CongresoBD padre) {
		super(titulo, tama�o, cerrar, maximizar);
		getContentPane().setForeground(Color.DARK_GRAY);
		getContentPane().setBackground(Color.DARK_GRAY);
		setVisible(true);
		principal = padre;
		contentPanel = (JPanel) this.getContentPane();
		contentPanel.setLayout(null);
		
		JLabel lblVerCongreso = new JLabel("Ver Congreso");
		lblVerCongreso.setForeground(Color.CYAN);
		lblVerCongreso.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 69));
		lblVerCongreso.setBounds(12, 13, 708, 84);
		getContentPane().add(lblVerCongreso);
		
		JLabel lblId = new JLabel("ID");
		lblId.setForeground(Color.WHITE);
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 29));
		lblId.setBounds(22, 93, 36, 45);
		getContentPane().add(lblId);
		
		txtID = new JTextField();
		txtID.setColumns(10);
		txtID.setBounds(70, 111, 354, 22);
		getContentPane().add(txtID);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(border);
		scrollPane.setBounds(22, 151, 836, 333);
		getContentPane().add(scrollPane);
		
		table = new JTable();
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

					String sql = "SELECT * FROM congreso";
					System.out.println(sql);
					ps = (PreparedStatement) con.prepareStatement(sql);
					rs = ps.executeQuery();

					java.sql.ResultSetMetaData rsMd = rs.getMetaData();
					int cantidadColumnas = rsMd.getColumnCount();

					modelo.addColumn("ID Congreso");
					modelo.addColumn("Nombre");
					modelo.addColumn("lugar");
					modelo.addColumn("costo");
					modelo.addColumn("Area Interes");
					modelo.addColumn("relevancia");

					int[] anchos = { 50, 100, 100, 120, 100, 100, 70 };
					for (int x = 0; x < cantidadColumnas; x++) {
						table.getColumnModel().getColumn(x).setPreferredWidth(anchos[x]);
					}
					while (rs.next()) {
						Object[] filas = new Object[cantidadColumnas];
						for (int i = 0; i < cantidadColumnas; i++) {
							filas[i] = rs.getObject(i + 1);
						}
						modelo.addRow(filas);
					}

				} catch (SQLException ex) {
					System.err.println(ex.toString());
				}
			}
		});
		btnActualizar.setBounds(762, 110, 97, 25);
		getContentPane().add(btnActualizar);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(436, 110, 97, 25);
		getContentPane().add(btnBuscar);

		setBounds(100, 100, 893, 531);
	}

}