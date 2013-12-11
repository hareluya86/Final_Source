package coms561project.ui;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.opensymphony.xwork2.ActionSupport;


public class SendFeedback extends ActionSupport {
	
	private static final long serialVersionUID = 1L;

	private boolean feedbackSent = false;
	private boolean feedbackSentSuccessful = false;
	
	private String author;
	private String email;
	private String subject;
	private String body;
	
	static Properties properties = new Properties();
	static
	{
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.socketFactory.port", "465");
		properties.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.port", "465");
	}
		

	public String execute() throws Exception {
		feedbackSent = true;
		
	     String ret = SUCCESS;
	     try
	      {
	         Session session = Session.getDefaultInstance(properties,  
	            new javax.mail.Authenticator() {
	            protected PasswordAuthentication 
	            getPasswordAuthentication() {
	            return new 
	            PasswordAuthentication("coms561project@gmail.com", "solX+#.y@&6&D~A");
	            }});

	         Message message = new MimeMessage(session);
	         message.setFrom(new InternetAddress(email));
	         message.setRecipients(Message.RecipientType.TO, 
	            InternetAddress.parse("alduaiji@iastate.edu"));
	         message.setSubject(subject);
	         message.setText(body + "\n\n" + author + "\n" + email);
	         Transport.send(message);
	         
	         feedbackSentSuccessful = true;
	      }
	      catch(Exception e)
	      {
	    	  feedbackSentSuccessful = false;
	         ret = SUCCESS;
	         e.printStackTrace();
	      } 
	      return ret;

	}


	public boolean isFeedbackSent() {
		return feedbackSent;
	}


	public boolean isFeedbackSentSuccessful() {
		return feedbackSentSuccessful;
	}

	
	public void setAuthor(String author) {
		this.author = author;
	}


	public void setEmail(String email) {
		this.email = email;
	}

	
	public void setSubject(String subject) {
		this.subject = subject;
	}

	
	public void setBody(String body) {
		this.body = body;
	}

	
	public String getAuthor() {
		return author;
	}


	public String getEmail() {
		return email;
	}

	
	public String getSubject() {
		return subject;
	}


	public String getBody() {
		return body;
	}
	
}
