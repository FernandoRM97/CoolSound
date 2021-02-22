package com.java.coolsound.service;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Service;

@Service
public class CorreoServiceImpl implements CorreoService{

	public void enviarMail(String nombre, String email, String mensaje) {
		
		String emisor = "coolsoundemail@gmail.com";
		
	    Properties props = System.getProperties();
	    props.put("mail.smtp.host", "smtp.gmail.com");
	    
	    props.put("mail.smtp.user", emisor);
	    
	    props.put("mail.smtp.clave", "coolsound123!");
	    
	    props.put("mail.smtp.auth", "true");
	    
	    props.put("mail.smtp.starttls.enable", "true");
	    
	    props.put("mail.smtp.port", "587");

	    Session session = Session.getDefaultInstance(props);
	    MimeMessage message = new MimeMessage(session);
	    
	    try {
	        message.setFrom(new InternetAddress(emisor));
	        message.addRecipients(Message.RecipientType.TO, "coolsoundemail@gmail.com");					
	        message.setSubject("MENSAJE DESDE FORMULARIO DE CONTACTO");
	        message.setText("El usuario " + nombre + " con email: " + email + ", ha enviado un mensaje con el siguiente contenido " + "\n" + mensaje);
	        Transport transport = session.getTransport("smtp");
	        transport.connect("smtp.gmail.com", emisor, "coolsound123!");
	        transport.sendMessage(message, message.getAllRecipients());
	        transport.close();
	    }
	    catch (MessagingException me) {
	        me.printStackTrace();
	    }
		
	}
	

}
