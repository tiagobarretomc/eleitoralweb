package br.com.eleitoralweb.entity;

import javax.mail.MessagingException;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class Email {
	private String[] para;
	private String assunto;
	private String mensagem;
	private String de;
	private String deAlias;

	public String[] getPara() {
		return para;
	}

	public void setPara(String[] para) {
		this.para = para;
	}

	public String getAssunto() {
		return assunto;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public String getDe() {
		return de;
	}

	public void setDe(String de) {
		this.de = de;
	}

	public String getDeAlias() {
		return deAlias;
	}

	public void setDeAlias(String deAlias) {
		this.deAlias = deAlias;
	}

	public void enviar() throws EmailException {
		SimpleEmail email = new SimpleEmail();
		// Utilize o hostname do seu provedor de email
		System.out.println("alterando hostname...");
		email.setHostName("smtp.gmail.com");
		// Quando a porta utilizada não é a padrão (gmail = 465)
		email.setSmtpPort(465);
		// Adicione os destinatários
		email.addTo("manudominique@gmail.com", "Jose");
		// Configure o seu email do qual enviará
		email.setFrom("manudominique@gmail.com", "Seu nome");
		// Adicione um assunto
		email.setSubject("Test message");
		// Adicione a mensagem do email
		email.setMsg("This is a simple test of commons-email");
		// Para autenticar no servidor é necessário chamar os dois métodos
		// abaixo
		System.out.println("autenticando...");
		email.setSSL(true);
		email.setAuthentication("manudominique@gmail.com", "12qw09po");
		System.out.println("enviando...");
		email.send();
		System.out.println("Email enviado!");
	}
	public static void main(String[] args) {
		Email e  = new Email();
		try {
			e.enviar();
		} catch (EmailException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
