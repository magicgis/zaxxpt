package com.sunshine.framework.util;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Enumeration;
import java.util.Properties;
import java.util.Vector;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Address;
import javax.mail.AuthenticationFailedException;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class EmailUtil {
	
	private String displayName;

	private String to;//�ռ���

	private String from;//������

	private String smtpServer;//SMTP������

	private String username;//�û���

	private String password;//����

	private String subject;//����

	private String content;//���ݵ�

	private boolean ifAuth; // �������Ƿ�Ҫ�����֤

	private String filename = "";

	private Vector<String> file = new Vector<String>(); // ���ڱ��淢�͸������ļ����ļ���

	/**
	 * ����SMTP��������ַ
	 */
	public void setSmtpServer(String smtpServer) {
		this.smtpServer = smtpServer;
	}

	/**
	 * ���÷����˵ĵ�ַ
	 */
	public void setFrom(String from) {
		this.from = from;
	}

	/**
	 * ������ʾ������
	 */
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	/**
	 * ���÷������Ƿ���Ҫ�����֤
	 */
	public void setIfAuth(boolean ifAuth) {
		this.ifAuth = ifAuth;
	}

	/**
	 * ����E-mail�û���
	 */
	public void setUserName(String username) {
		this.username = username;
	}

	/**
	 * ����E-mail����
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * ���ý�����
	 */
	public void setTo(String to) {
		this.to = to;
	}

	/**
	 * ��������
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

	/**
	 * ������������
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * �÷��������ռ�������
	 */
	public void addAttachfile(String fname) {
		file.addElement(fname);
	}
	
	public EmailUtil(String smtpServer, String from, String displayName,String username, String password) {
		this.smtpServer = smtpServer;
		this.from = from;
		this.displayName = displayName;
		this.ifAuth = true;
		this.username = username;
		this.password = password;
	}
	
	public String send(String to, String subject,String content) {
		this.to = to;
		this.subject = subject;
		this.content = content;
		return send();
	}
	
	/**
	 * �����ʼ�
	 * @return
	 */
	public String send() {
		String result = null;
		Session session = null;
		Transport trans = null;
		Address from_address = null;
		Properties props = System.getProperties();
		props.put("mail.smtp.host", smtpServer);
		//����ifר�Ŵ���gmail���� �˿ڣ�465
		if(this.smtpServer.indexOf("smtp.gmail.com")>=0)
        {
			props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory"); 
			props.setProperty("mail.smtp.socketFactory.fallback", "false"); 
			props.setProperty("mail.smtp.port", "465"); 
			props.setProperty("mail.smtp.socketFactory.port", "465"); 
        }
		if (ifAuth) { // ��������Ҫ�����֤
			props.put("mail.smtp.auth", "true");
			SmtpAuth smtpAuth = new SmtpAuth(username, password);
			session = Session.getDefaultInstance(props, smtpAuth);
		} else {
			props.put("mail.smtp.auth", "false");
			session = Session.getDefaultInstance(props, null);
		}
		
		session.setDebug(false);
		
		try {
			Message msg = new MimeMessage(session);
			try {
				from_address = new InternetAddress(from, displayName);
				msg.setFrom(from_address);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
				
			msg.setSubject(subject);
			Multipart mp = new MimeMultipart();
			MimeBodyPart mbp = new MimeBodyPart();
			mbp.setContent(content.toString(), "text/html;charset=gb2312");
			mp.addBodyPart(mbp);
			msg.setRecipient(Message.RecipientType.TO,new InternetAddress(to));
			if (!file.isEmpty()) {// �и���
				Enumeration efile = file.elements();
				while (efile.hasMoreElements()) {
					mbp = new MimeBodyPart();
					filename = efile.nextElement().toString(); // ѡ���ÿһ��������
					FileDataSource fds = new FileDataSource(filename); // �õ�����Դ
					mbp.setDataHandler(new DataHandler(fds)); // �õ�������������BodyPart
					mbp.setFileName(fds.getName()); // �õ��ļ���ͬ������BodyPart
					mp.addBodyPart(mbp);
				}
				file.removeAllElements();
			}
			msg.setContent(mp); // Multipart���뵽�ż�
			msg.setSentDate(new Date()); // �����ż�ͷ�ķ�������
			msg.saveChanges();
			trans = session.getTransport("smtp");
			trans.connect(smtpServer, username, password);
			trans.sendMessage(msg, msg.getAllRecipients()); // �����ż�  		
			trans.close();	
		} catch (AuthenticationFailedException e) {
			result = "�ʼ�����ʧ�ܣ�����ԭ�������֤����!";
		} catch (MessagingException e) {
			result = "�ʼ�����ʧ�ܣ�����ԭ��" + e.getMessage();
		}
		return result;
	}
	
}

class SmtpAuth extends javax.mail.Authenticator {
	
	private String username, password;

	public SmtpAuth(String username, String password) {
		this.username = username;
		this.password = password;
	}

	protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
		return new javax.mail.PasswordAuthentication(username, password);
	}
	
}