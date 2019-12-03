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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class VerCongreso extends JInternalFrame {
	// Obtener el contexto del Frame principal Hospital
	public CongresoBD principal;
	public JPanel contentPanel;
	private JTextField buscar;
	Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
	private JTable table;

	public VerCongreso(String titulo, boolean tamaño, boolean cerrar, boolean maximizar, CongresoBD padre) {
		super(titulo, tamaño, cerrar, maximizar);
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

		buscar = new JTextField();
		buscar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent ke) {
				if ((ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') || (ke.getKeyCode() == KeyEvent.VK_BACK_SPACE)
						|| (ke.getKeyCode() == KeyEvent.VK_DELETE)) {
					buscar.setEditable(true);
				} else {
					buscar.setEditable(false);

				}
			}
		});
		buscar.setColumns(10);
		buscar.setBounds(70, 111, 354, 22);
		getContentPane().add(buscar);

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
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String Campo = buscar.getText();
				String where = "";

				if (!"".equals(Campo)) {
					where = "WHERE idCongreso= '" + Campo + "'";
				}

				try {
					DefaultTableModel modelo = new DefaultTableModel();
					table.setModel(modelo);
					PreparedStatement ps = null;
					ResultSet rs = null;
					@SuppressWarnings("unused")
					Conexion conn = new Conexion();
					Connection con = Conexion.getConection();

					String sql = "SELECT idCongreso,Nombre,lugar,costo,AreaInt,relevancia  FROM congreso " + where;
					System.out.println(sql);
					ps = (PreparedStatement) con.prepareStatement(sql);
					rs = ps.executeQuery();

					java.sql.ResultSetMetaData rsMd = rs.getMetaData();
					int cantidadColumnas = rsMd.getColumnCount();

					modelo.addColumn("ID Congreso");
					modelo.addColumn("Nombre");
					modelo.addColumn("Lugar ");
					modelo.addColumn("Costo");
					modelo.addColumn("Área de Interés ");
					modelo.addColumn("Relevancia ");

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
		btnBuscar.setBounds(436, 110, 97, 25);
		getContentPane().add(btnBuscar);

		setBounds(100, 100, 893, 531);
	}

}