package com.ia.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.ia.controller.Controller;
import com.ia.dto.PedidoDTO;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JEditorPane;
import javax.swing.JTextPane;
import javax.swing.JCheckBox;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class ConfirmarPedidosRealizados extends JFrame {

	private JPanel contentPane;
	private String username;
	
	/**
	 * Create the frame.
	 */
	public ConfirmarPedidosRealizados(String username) {
		this.username = username;
		setResizable(false);
		setTitle("SARA S.A. - Confirmar pedidos realizados");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 429);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(57, 158, 406, 221);
		contentPane.add(scrollPane);
		
		DefaultListModel<String> model = new DefaultListModel<String>();
		List<PedidoDTO> pendientes = Controller.getInstance().verPedidosPendientes(username);
		if (pendientes.isEmpty()) 
			model.addElement("No hay pedidos pendientes");
		else
			for (PedidoDTO p : pendientes)
				model.addElement(p.toString());
		JList<String> list = new JList<String>(model);
		if (pendientes.isEmpty())
			list.disable();
		scrollPane.setViewportView(list);
		
		JButton btnNewButton = new JButton("Entregado");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String seleccion = list.getSelectedValue();
				String parts[] = seleccion.split("-");
				String codPedido = parts[0].trim();
				try {
					Controller.getInstance().pedidoEntregado(codPedido);
					model.removeElement(list.getSelectedValue());
					list.setModel(model);
				}catch(Exception e) {
					JOptionPane.showMessageDialog(null, "Error al actualizar el pedido", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton.setBounds(473, 158, 106, 23);
		if (pendientes.isEmpty())
			btnNewButton.setEnabled(false);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Incidencia");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String seleccion = list.getSelectedValue();
				String parts[] = seleccion.split("-");
				String codPedido = parts[0].trim();
				RegistrarIncidencia ri = new RegistrarIncidencia(codPedido);
				ri.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(473, 183, 106, 23);
		if (pendientes.isEmpty())
			btnNewButton_1.setEnabled(false);
		contentPane.add(btnNewButton_1);
		
		JLabel lblPedidos = new JLabel("Pedidos pendientes:");
		lblPedidos.setBounds(57, 133, 122, 14);
		contentPane.add(lblPedidos);
		
		JLabel lblAcciones = new JLabel("Acciones:");
		lblAcciones.setBounds(473, 133, 85, 14);
		contentPane.add(lblAcciones);
		
		ImageIcon img = new ImageIcon("src/resources/SaraSA.png");
		JLabel header = new JLabel(img);
		header.setBounds(87, 32, 366, 83);
		contentPane.add(header);
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model.clear();
				List<PedidoDTO> pendientes = Controller.getInstance().verPedidosPendientes(username);	
				if (pendientes.isEmpty()) {
					model.addElement("No hay pedidos pendientes");
					list.disable();
				}
				else
					for (PedidoDTO p : pendientes)
						model.addElement(p.toString());
				list.setModel(model);
			}
		});
		btnActualizar.setBounds(338, 129, 115, 23);
		contentPane.add(btnActualizar);
	}
}
