package mx.org.infonavit.solicitud.oferente.utils;
//package mx.org.infonavit.reporteuvs.utils;
//
//import java.util.Properties;
//
//import javax.mail.Message;
//import javax.mail.Session;
//import javax.mail.Transport;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeMessage;
//
//public class SimpleSSLMail {
//	
//	 private static final String SMTP_HOST_NAME = "smtp.gmail.com";
//	    private static final int SMTP_HOST_PORT = 465;
//	    private static final String SMTP_AUTH_USER = "acasaslopez10@gmail.com";
//	    private static final String SMTP_AUTH_PWD  = "4driaN83";
//
//	    public static void main(String[] args) throws Exception{
//	       new SimpleSSLMail().test();
//	    }
//
//	    public void test() throws Exception{
//	        Properties props = new Properties();
//
//	        props.put("mail.transport.protocol", "smtps");
//	        props.put("mail.smtps.host", SMTP_HOST_NAME);
//	        props.put("mail.smtps.auth", "true");
//	        // props.put("mail.smtps.quitwait", "false");
//
//	        Session mailSession = Session.getDefaultInstance(props);
//	        mailSession.setDebug(true);
//	        Transport transport = mailSession.getTransport();
//
//	        MimeMessage message = new MimeMessage(mailSession);
//	        message.setSubject("Testing SMTP-SSL");
//	        message.setContent("This is a test", "text/plain");
//
//	        message.addRecipient(Message.RecipientType.TO,
//	             new InternetAddress("acasaslopez10@gmail.com"));
//
//	        transport.connect
//	          (SMTP_HOST_NAME, SMTP_HOST_PORT, SMTP_AUTH_USER, SMTP_AUTH_PWD);
//
//	        transport.sendMessage(message,
//	            message.getRecipients(Message.RecipientType.TO));
//	        transport.close();
//	        System.out.println("El mail fe enviado....");
//	    }
//
//}
