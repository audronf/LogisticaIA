package com.ia.controller;

import com.ia.negocio.Pedido;

import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailController {

	private static EmailController instance;
	
	private EmailController() {}
	
	public static EmailController getInstance() {
		if (instance==null)
			instance = new EmailController();
		return instance;
	}
	
	public void enviarCorreoNuevoPedido(Pedido p) {
		String remitente = "sara.sa.logistica";
		String destinatario = p.getCliente().getEmail();
		String asunto = "Datos de tu pedido";
		
		Properties props = System.getProperties();
		props.put("mail.smtp.host", "smtp.gmail.com");  //El servidor SMTP de Google
	    props.put("mail.smtp.user", remitente);
	    props.put("mail.smtp.clave", "ffmm2222");    //La clave de la cuenta
	    props.put("mail.smtp.auth", "true");    //Usar autenticación mediante usuario y clave
	    props.put("mail.smtp.starttls.enable", "true"); //Para conectar de manera segura al servidor SMTP
	    props.put("mail.smtp.port", "587"); //El puerto SMTP seguro de Google
	    
	    Session session = Session.getDefaultInstance(props);
	    MimeMessage message = new MimeMessage(session);
	    
	    try {
	        message.setFrom(new InternetAddress(remitente));
	        message.addRecipient(Message.RecipientType.TO, new InternetAddress(destinatario));   //Se podrían añadir varios de la misma manera
	        message.setSubject(asunto);
	        message.setText(
	        		"<a href=\"http://localhost:8080/Web/ingresoCodigo.html\"><img src=\"http://i64.tinypic.com/qywoyc.png\"></a><br><br>"
	        		+ "Hola <b>"+p.getCliente().getNombre() + "</b>,<br>El c�digo de tu nuevo pedido es: <b>"+ p.getCodPedido()+"</b><br><br>"
	        				+ "Pod�s usarlo para controlar su estado, ingres�ndolo en <a href=\"http://localhost:8080/Web/ingresoCodigo.html\">Sara S.A.</a>",
	        		"ISO-8859-1",
	        		"html");	        Transport transport = session.getTransport("smtp");
	        transport.connect("smtp.gmail.com", remitente, "ffmm2222");
	        transport.sendMessage(message, message.getAllRecipients());
	        transport.close();
	    }
	    catch (MessagingException me) {
	        me.printStackTrace();   //Si se produce un error
	    }
	}
}
