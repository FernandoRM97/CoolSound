package com.java.coolsound.service;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailServiceImpl implements EmailService{

	static final String FROM = "remitente@correo.es";
	static final String FROMNAME = "NombreRemitente";
	static final String TO = "coolsoundemail@gmail.com";
	static final String SMTP_USERNAME = "coolsoundemail@gmail.com";
	static final String SMTP_PASSWORD = "coolsound123!";
	//static final String CONFIGSET = "ConfigSet";
	static final String HOST = "smtp.gmail.com";
	static final int PORT = 587;
	static final String SUBJECT = "MENSAJE DESDE COOLSOUND";
	static final String BODY = String.join(System.getProperty("line.separator"), "Prueba de envio de correo desde JavaMail");
	
	@Override
	public void enviarMail() {
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
	        message.setSubject("Comentario de usuario.");
	        message.setText("Nombre del usuario: " + "nombre" + "\n" + "Correo: " + "correo" + "\n" + "Comentario: " + "\n" + "comentario");
	        Transport transport = session.getTransport("smtp");
	        transport.connect("smtp.gmail.com", emisor, "coolsound123!");
	        transport.sendMessage(message, message.getAllRecipients());
	        transport.close();
	    }
	    catch (MessagingException me) {
	        me.printStackTrace();
	    }

	}
	
//	@Override
//	public void eviarMail() throws Exception {
//		String remitente = "frabanal14@gmail.com";
//		String clave = "clave";
//		String destinatario = "coolsoundemail@gmail.com";
//		
//		Properties props = new Properties();
//		props.put("mail.smtp.host", "smtp.gmail.com");
//		props.put("mail.smtp.port", "587");
//		props.put("mail.smtp.auth", "true");
//		props.put("mail.smtp.starttls.enable", "true");
//		props.put("mail.smtp.user", remitente);
//		
//		Session session = Session.getDefaultInstance(props);
//		MimeMessage mensaje = new MimeMessage(session);
//		
//		try {
//			mensaje.addRecipient(Message.RecipientType.TO, new InternetAddress(destinatario));
//			mensaje.setSubject("Prueba");
//			mensaje.setText("DEJFGUIWOHBORGIUWERB GWEGUNW EG");
//			
//			Transport transport = session.getTransport("smtp");
//			transport.connect("smtp.gmail.com", remitente, clave);
//			transport.sendMessage(mensaje, mensaje.getAllRecipients());
//			transport.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		
//	}
//	

	
	
//	@Override
//	public void eviarMail() throws Exception{
//		Properties props = System.getProperties();
//		props.put("mail.transport.protocol", "smtp");
//		props.put("mail.smtp.port", "PORT");
//		props.put("mail.smtp.starttls.enable", "true");
//		props.put("mail.smtp.auth", "true");
//		Session session = Session.getDefaultInstance(props);
//		MimeMessage msg = new MimeMessage(session);
//		msg.setFrom(new InternetAddress(FROM, FROMNAME));
//		msg.setRecipient(Message.RecipientType.TO, new InternetAddress(TO));
//		msg.setSubject(SUBJECT);
//		msg.setContent(BODY, "text/html");
//		//msg.setHeader("X-SES-CONFIGURATION-SET", CONFIGSET);
//		Transport transport = session.getTransport();
//		
//		try {
//			transport.connect(HOST, SMTP_USERNAME, SMTP_PASSWORD);
//			transport.sendMessage(msg, msg.getAllRecipients());
//			System.out.println("Mensaje enviado con éxito");
//		} catch (Exception ex) {
//			System.out.println("Mensaje no enviado");
//		} finally {
//			transport.close();
//		}
//	}

}
