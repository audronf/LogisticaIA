package com.ia.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.ia.controller.Controller;
import com.ia.dto.DistribuidorDTO;
import com.ia.dto.HojaDeRutaDTO;

import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AsignacionPedidos extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AsignacionPedidos frame = new AsignacionPedidos();
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
	public AsignacionPedidos() {
		setTitle("SARA S.A. - Asignar hojas de ruta");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 488);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(51, 147, 197, 238);
		contentPane.add(scrollPane);
		
		DefaultListModel<String> listModel = new DefaultListModel<String>();
		List<HojaDeRutaDTO> hojasDeRutaDTO = Controller.getInstance().verHojasDeRuta();
		for (HojaDeRutaDTO h : hojasDeRutaDTO)
			listModel.addElement(h.toString());
		JList<String> hdr = new JList<String>(listModel);	
		scrollPane.setViewportView(hdr);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(370, 147, 197, 238);
		contentPane.add(scrollPane_1);
		scrollPane_1.setVisible(false);
		
		JLabel lblHojasDeRuta = new JLabel("Hojas de ruta");
		lblHojasDeRuta.setBounds(51, 116, 82, 14);
		contentPane.add(lblHojasDeRuta);
		
		JLabel lblDistribuidores = new JLabel("Distribuidores");
		lblDistribuidores.setBounds(371, 116, 102, 14);
		contentPane.add(lblDistribuidores);
		lblDistribuidores.setVisible(false);
		
		JButton btnNewButton = new JButton("Asignar");
		btnNewButton.setBounds(450, 397, 117, 33);
		contentPane.add(btnNewButton);
		btnNewButton.setVisible(false);
		
		JButton btnSeleccionar = new JButton("Seleccionar");
		btnSeleccionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String seleccion = hdr.getSelectedValue();
				String parts[] = seleccion.split("-");
				String localidad = parts[1].trim();
				List<DistribuidorDTO> dist = Controller.getInstance().verDistribuidoresLocalidad(localidad);
				DefaultListModel<String> modelDist = new DefaultListModel<String>();
				for (DistribuidorDTO d : dist)
					modelDist.addElement(d.getDni() +" - "+ d.getNombre());
				JList<String> distrs = new JList<String>(modelDist);
				scrollPane_1.setViewportView(distrs);
				scrollPane_1.setVisible(true);
				lblDistribuidores.setVisible(true);
				btnNewButton.setVisible(true);
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						String hojaDeRuta = parts[0].trim();
						String seleccionDist = distrs.getSelectedValue();
						String partsD[] = seleccionDist.split("-");
						String dniDistribuidor = partsD[0].trim();
						Controller.getInstance().asignarHojaDeRuta(Integer.parseInt(hojaDeRuta), dniDistribuidor);
					}
				});
			}
		});
		btnSeleccionar.setBounds(132, 397, 117, 33);
		contentPane.add(btnSeleccionar);
		

		
		ImageIcon logo = new ImageIcon("src/resources/SaraSA.png");
		JLabel logotipo = new JLabel(logo);
		logotipo.setBounds(-18, 11, 463, 86);
		contentPane.add(logotipo);
		btnNewButton.setVisible(false);
	}
}
