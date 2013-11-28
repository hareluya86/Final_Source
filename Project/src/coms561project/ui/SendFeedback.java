package coms561project.ui;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * @author Tim
 *
 */
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
		
	/**
	 * @return the result
	 */
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
	            InternetAddress.parse("lmiller@cs.iastate.edu"));
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

	/**
	 * @return the feedbackSent
	 */
	public boolean isFeedbackSent() {
		return feedbackSent;
	}

	/**
	 * @return the feedbackSentSuccessful
	 */
	public boolean isFeedbackSentSuccessful() {
		return feedbackSentSuccessful;
	}

	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @param subject the subject to set
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

	/**
	 * @param message the message to set
	 */
	public void setBody(String body) {
		this.body = body;
	}

	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * @return the body
	 */
	public String getBody() {
		return body;
	}
	
}
