package com.ia.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.ia.controller.Controller;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class RegistrarIncidencia extends JFrame {

	private JPanel contentPane;
	String codPedido;
	private JTextField textField;
	/**
	 * Create the frame.
	 */
	public RegistrarIncidencia(String codPedido) {
		this.codPedido = codPedido;
		setTitle("SARA S.A. - Registrar incidencia");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 270);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRegistrarIncidencia = new JLabel("Registrar incidencia");
		lblRegistrarIncidencia.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblRegistrarIncidencia.setBounds(85, 11, 322, 43);
		contentPane.add(lblRegistrarIncidencia);
		
		JLabel lblIngresarBreveDescripcin = new JLabel("Ingresar breve descripci\u00F3n de la incidencia:");
		lblIngresarBreveDescripcin.setBounds(10, 77, 306, 14);
		contentPane.add(lblIngresarBreveDescripcin);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(20, 102, 388, 76);
		contentPane.add(textPane);
		
		JButton btnNewButton = new JButton("Registrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (textPane.getText().length()>200)
					JOptionPane.showMessageDialog(null, "Cantidad de caracteres: "+textPane.getText().length()+". La cantidad máxima permitida es 200", "Error", JOptionPane.WARNING_MESSAGE);		
				else {
					Controller.getInstance().registrarIncidencia(codPedido, textPane.getText());
					JOptionPane.showMessageDialog(null, "La incidencia fue registrada correctamente");
				}
				dispose();
			}
		});
		btnNewButton.setBounds(318, 189, 89, 31);
		contentPane.add(btnNewButton);
		
		
	}
}
