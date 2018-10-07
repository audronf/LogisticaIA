package com.ia.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.ia.controller.Controller;
import com.ia.dto.DistribuidorDTO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginDistribuidor extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginDistribuidor frame = new LoginDistribuidor();
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
	public LoginDistribuidor() {
		setResizable(false);
		setTitle("SARA S.A.");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 329, 294);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(74, 122, 69, 14);
		contentPane.add(lblUsuario);
		
		textField = new JTextField();
		textField.setBounds(74, 138, 156, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setBounds(74, 169, 90, 14);
		contentPane.add(lblContrasea);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(74, 185, 156, 20);
		contentPane.add(passwordField);
		
		JButton btnLogin = new JButton("Ingresar");
		btnLogin.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				if (Controller.getInstance().verificarCredencialesProveedor(textField.getText(),
						passwordField.getText())) {
					ConfirmarPedidosRealizados cpr = new ConfirmarPedidosRealizados(textField.getText());
					cpr.setVisible(true);
					dispose();
				}
				else {
					JOptionPane.showMessageDialog(null, "El usuario o la contraseña ingresados son incorrectos", "Error de identificación", JOptionPane.ERROR_MESSAGE);
					passwordField.setText("");
				}
			}
		});
		btnLogin.setBounds(171, 218, 89, 29);
		contentPane.add(btnLogin);
		
		ImageIcon img = new ImageIcon("src/resources/SaraSA.png");
		JLabel header = new JLabel(img);
		header.setBounds(0, 11, 323, 96);
		contentPane.add(header);
	}
}
