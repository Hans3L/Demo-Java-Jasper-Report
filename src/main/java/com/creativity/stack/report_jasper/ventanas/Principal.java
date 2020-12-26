package com.creativity.stack.report_jasper.ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.creativity.stack.report_jasper.conexion.Conexion;

import lombok.extern.slf4j.Slf4j;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JInternalFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.awt.event.MouseEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

//@Slf4j
public class Principal extends JFrame implements ActionListener, MouseListener, KeyListener {

	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblNewLabel;
	private JInternalFrame internalFrame;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JTextField txtId;
	private JTextField txtNombre;
	private JTextField txtApellidos;
	private JTextField txtDir;
	private JTextField txtFono;
	private JButton btnGuardar;
	private JButton btnActualizar;
	private JButton btnCancelar;
	private JScrollPane scrollPane;
	private JTable tabla;
	private JButton btnImprimir;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principal() {
		setResizable(false);
		setTitle("EMPLEADOS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 827, 383);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		// centrado de la ventana
		this.setLocationRelativeTo(null);

		panel = new JPanel();
		panel.setBounds(0, 0, 801, 333);
		contentPane.add(panel);
		panel.setLayout(null);

		lblNewLabel = new JLabel("Registro Empleado");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(233, 11, 148, 21);
		panel.add(lblNewLabel);

		internalFrame = new JInternalFrame("Registrar");
		internalFrame.setBounds(29, 44, 267, 278);
		panel.add(internalFrame);
		internalFrame.getContentPane().setLayout(null);

		lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setBounds(10, 29, 46, 14);
		internalFrame.getContentPane().add(lblNewLabel_1);

		lblNewLabel_2 = new JLabel("Nombre");
		lblNewLabel_2.setBounds(10, 54, 61, 14);
		internalFrame.getContentPane().add(lblNewLabel_2);

		lblNewLabel_3 = new JLabel("Apellidos");
		lblNewLabel_3.setBounds(10, 82, 61, 14);
		internalFrame.getContentPane().add(lblNewLabel_3);

		lblNewLabel_4 = new JLabel("Dirección");
		lblNewLabel_4.setBounds(10, 107, 61, 14);
		internalFrame.getContentPane().add(lblNewLabel_4);

		lblNewLabel_5 = new JLabel("Teléfono");
		lblNewLabel_5.setBounds(10, 132, 61, 14);
		internalFrame.getContentPane().add(lblNewLabel_5);

		txtId = new JTextField();
		txtId.setEditable(false);
		txtId.setBounds(66, 26, 142, 20);
		internalFrame.getContentPane().add(txtId);
		txtId.setColumns(10);

		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(66, 51, 142, 20);
		internalFrame.getContentPane().add(txtNombre);

		txtApellidos = new JTextField();
		txtApellidos.setColumns(10);
		txtApellidos.setBounds(66, 79, 142, 20);
		internalFrame.getContentPane().add(txtApellidos);

		txtDir = new JTextField();
		txtDir.setColumns(10);
		txtDir.setBounds(66, 104, 142, 20);
		internalFrame.getContentPane().add(txtDir);

		txtFono = new JTextField();
		txtFono.setColumns(10);
		txtFono.setBounds(66, 129, 142, 20);
		internalFrame.getContentPane().add(txtFono);

		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(this);
		btnGuardar.setBounds(10, 179, 89, 23);
		internalFrame.getContentPane().add(btnGuardar);

		btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(this);
		btnActualizar.setBounds(136, 179, 105, 23);
		internalFrame.getContentPane().add(btnActualizar);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(80, 214, 89, 23);
		internalFrame.getContentPane().add(btnCancelar);

		scrollPane = new JScrollPane();
		scrollPane.addMouseListener(this);
		scrollPane.setBounds(324, 43, 467, 249);
		panel.add(scrollPane);

		tabla = new JTable();
		tabla.addMouseListener(this);
		scrollPane.setViewportView(tabla);

		btnImprimir = new JButton("Imprimir");
		btnImprimir.addActionListener(this);
		btnImprimir.setBounds(324, 299, 89, 23);
		panel.add(btnImprimir);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(702, 303, 89, 23);
		panel.add(btnEliminar);
		
		txtBuscar = new JTextField();
		txtBuscar.addKeyListener(this);
		txtBuscar.setBounds(624, 13, 167, 20);
		panel.add(txtBuscar);
		txtBuscar.setColumns(10);
		
		lblBuscar = new JLabel("Buscar:");
		lblBuscar.setBounds(568, 16, 46, 14);
		panel.add(lblBuscar);
		internalFrame.setVisible(true);
		mostrarTabla("");
		// clean init field
		limpiar();
	}

	// Instancia Global
	Conexion conn = new Conexion();
	Connection cn = conn.getConexion();
	private JButton btnEliminar;
	private JTextField txtBuscar;
	private JLabel lblBuscar;

	public void limpiar() {
		txtId.setText("");
		txtNombre.setText("");
		txtApellidos.setText("");
		txtDir.setText("");
		txtFono.setText("");
	}

	public void mostrarTabla(String valor) {
		DefaultTableModel modelo = new DefaultTableModel();
		modelo.addColumn("ID");
		modelo.addColumn("NOMBRE");
		modelo.addColumn("APELLIDO");
		modelo.addColumn("DIRECCION");
		modelo.addColumn("TELEFONO");
		tabla.setModel(modelo);

		String sql = "SELECT id, name_employee, last_name, address, phone FROM employee WHERE CONCAT (name_employee,'',last_name) LIKE '%"
				+ valor + "%'";

		String datos[] = new String[5];

		Statement st;

		try {
			st = cn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				datos[0] = rs.getString(1);
				datos[1] = rs.getString(2);
				datos[2] = rs.getString(3);
				datos[3] = rs.getString(4);
				datos[4] = rs.getString(5);
				modelo.addRow(datos);
			}
			tabla.setModel(modelo);
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error al llenar la tabla");
		}
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnImprimir) {
			actionPerformedBtnImprimir(arg0);
		}
		if (arg0.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(arg0);
		}
		if (arg0.getSource() == btnCancelar) {
			actionPerformedBtnCancelar(arg0);
		}
		if (arg0.getSource() == btnActualizar) {
			actionPerformedBtnActualizar(arg0);
		}
		if (arg0.getSource() == btnGuardar) {
			actionPerformedBtnGuardar(arg0);
		}
	}
	protected void actionPerformedBtnGuardar(ActionEvent arg0) {
		try {
			PreparedStatement ps = cn.prepareStatement("INSERT INTO employee (name_employee, last_name, address, phone) VALUES (?,?,?,?)");
			ps.setString(1,txtNombre.getText());
			ps.setString(2,txtApellidos.getText());
			ps.setString(3,txtDir.getText());
			ps.setString(4,txtFono.getText());
			ps.executeUpdate();
			limpiar();
			mostrarTabla("");
			JOptionPane.showMessageDialog(null, "Datos guardados correctamente");
		} catch(SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error al guardar Empleado");
		}
	}
	protected void actionPerformedBtnActualizar(ActionEvent arg0) {
		try {
			String query = "UPDATE employee SET name_employee='"+txtNombre.getText()+"',last_name='"+txtApellidos.getText()+"',address='"+txtDir.getText()+"',phone='"+txtFono.getText()+"' WHERE id='"+txtId.getText()+"'";
			PreparedStatement ps = cn.prepareStatement(query);
			int respuesta = ps.executeUpdate();
			if(respuesta>0) {
				JOptionPane.showConfirmDialog(null, "Datos Actualizados");
				limpiar();
				mostrarTabla("");
			} else {
				JOptionPane.showMessageDialog(null, "No cargo los datos a los campos!");

			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == tabla) {
			mouseClickedTabla(e);
		}
		if (e.getSource() == scrollPane) {
			mouseClickedScrollPane(e);
		}
	}
	public void mouseEntered(MouseEvent e) {
	}
	public void mouseExited(MouseEvent e) {
	}
	public void mousePressed(MouseEvent e) {
	}
	public void mouseReleased(MouseEvent e) {
	}
	protected void mouseClickedScrollPane(MouseEvent e) {
	}
	protected void mouseClickedTabla(MouseEvent e) {
		int fila = this.tabla.getSelectedRow();
		this.txtId.setText(this.tabla.getValueAt(fila,0).toString());
		this.txtNombre.setText(this.tabla.getValueAt(fila,1).toString());
		this.txtApellidos.setText(this.tabla.getValueAt(fila,2).toString());
		this.txtDir.setText(this.tabla.getValueAt(fila,3).toString());
		this.txtFono.setText(this.tabla.getValueAt(fila,4).toString());
		
	}
	protected void actionPerformedBtnCancelar(ActionEvent arg0) {
		limpiar();
	}
	protected void actionPerformedBtnEliminar(ActionEvent arg0) {
		try {
			String query = "DELETE FROM employee WHERE id ='"+txtId.getText()+"'";
			
			PreparedStatement ps = cn.prepareStatement(query);
			
			int respuesta = ps.executeUpdate();
			
			if (respuesta>0) {
				JOptionPane.showConfirmDialog(null, "¿Quieres eliminar a este empleado?");
				limpiar();
				mostrarTabla("");
			}else {
				JOptionPane.showMessageDialog(null, "No se cargo ningun valor");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
		if (e.getSource() == txtBuscar) {
			keyReleasedTxtBuscar(e);
		}
	}
	public void keyTyped(KeyEvent e) {
	}
	protected void keyReleasedTxtBuscar(KeyEvent e) {
		
			mostrarTabla(txtBuscar.getText());
	}
	protected void actionPerformedBtnImprimir(ActionEvent arg0) {
		try {
			String path = new File("src\\main\\java\\com\\creativity\\stack\\report_jasper\\reporte\\Empleados.jasper").getAbsolutePath();
			JasperPrint informe = JasperFillManager.fillReport(path, null,cn);
			JasperViewer ventanavisor = new JasperViewer(informe,false);
			ventanavisor.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
