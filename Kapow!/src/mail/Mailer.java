package mail;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * Api mailer for send emails and recover password
 * 
 * @author Kitsu.
 */


public class Mailer{
	

	/**
	 * This class make the function for send emails in java
	 * 
	 * @param
	 */
	
public static void sendMail(String destinatario, String asunto, String cuerpo) {
    // This is for the pre-email text before the @gmail for exameple. Is the sender too.
     String remitente = "suppkapow";  //For the email
     String clave = "roottoor"; //password of the email
    Properties props = System.getProperties();
    props.put("mail.smtp.host", "smtp.gmail.com");  //The SMTP Server of google
    props.put("mail.smtp.user", remitente);
    props.put("mail.smtp.clave", clave);    //Password
    props.put("mail.smtp.auth", "true");    //Use authentication by password and user
    props.put("mail.smtp.starttls.enable", "true"); //Safe mode connection
    props.put("mail.smtp.port", "587"); //SMTP PORT 

    Session session = Session.getDefaultInstance(props);
    MimeMessage message = new MimeMessage(session);

    try {
    	//Here go the sender "remitente" is the string we use at the start
        message.setFrom(new InternetAddress(remitente));
        //Here go the email of the user we recover in "destinatario"
        message.addRecipients(Message.RecipientType.TO, destinatario);
        //Subjet
        message.setSubject(asunto);
        //Message
        message.setText(cuerpo);
        Transport transport = session.getTransport("smtp");
        transport.connect("smtp.gmail.com", remitente, clave);
        transport.sendMessage(message, message.getAllRecipients());
        transport.close();
    }
    catch (MessagingException me) {
        me.printStackTrace();   //Si se produce un error
    }
  }
}

