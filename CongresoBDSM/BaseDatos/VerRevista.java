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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class VerRevista extends JInternalFrame {
	// Obtener el contexto del Frame principal Hospital
	public CongresoBD principal;
	public JPanel contentPanel;
	private JTextField txtID;
	private JTable table;
	Border border = BorderFactory.createLineBorder(Color.BLACK, 1);

	public VerRevista(String titulo, boolean tamaño, boolean cerrar, boolean maximizar, CongresoBD padre) {
		super(titulo, tamaño, cerrar, maximizar);
		getContentPane().setBackground(Color.DARK_GRAY);
		setVisible(true);
		principal = padre;
		contentPanel = (JPanel) this.getContentPane();
		contentPanel.setLayout(null);

		JLabel lblVerRevista = new JLabel("Ver Revista");
		lblVerRevista.setForeground(Color.CYAN);
		lblVerRevista.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 69));
		lblVerRevista.setBounds(12, 13, 708, 84);
		getContentPane().add(lblVerRevista);

		JLabel lblID = new JLabel("ID");
		lblID.setForeground(Color.WHITE);
		lblID.setFont(new Font("Tahoma", Font.PLAIN, 29));
		lblID.setBounds(22, 87, 36, 45);
		getContentPane().add(lblID);

		txtID = new JTextField();
		txtID.setColumns(10);
		txtID.setBounds(70, 105, 354, 22);
		getContentPane().add(txtID);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(border);
		scrollPane.setBounds(22, 145, 836, 333);
		getContentPane().add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.setBackground(Color.WHITE);
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

					String sql = "SELECT idRevista,costo,relevancia,numRevista,Nombre,fecha,tipoPub  FROM revista";
					System.out.println(sql);
					ps = (PreparedStatement) con.prepareStatement(sql);
					rs = ps.executeQuery();

					java.sql.ResultSetMetaData rsMd = rs.getMetaData();
					int cantidadColumnas = rsMd.getColumnCount();

					modelo.addColumn("ID Revista");
					modelo.addColumn("Costo");
					modelo.addColumn("Relevancia");
					modelo.addColumn("numRevista");
					modelo.addColumn("Nombre");
					modelo.addColumn("fecha");
					modelo.addColumn("tipoPub");

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
		btnActualizar.setBounds(762, 104, 97, 25);
		getContentPane().add(btnActualizar);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBackground(Color.WHITE);
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnBuscar.setBounds(436, 104, 97, 25);
		getContentPane().add(btnBuscar);

		setBounds(100, 100, 889, 537);
	}
}