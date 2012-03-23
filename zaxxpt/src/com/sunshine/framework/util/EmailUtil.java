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

	private String to;//收件人

	private String from;//发件人

	private String smtpServer;//SMTP服务器

	private String username;//用户名

	private String password;//密码

	private String subject;//主题

	private String content;//内容等

	private boolean ifAuth; // 服务器是否要身份认证

	private String filename = "";

	private Vector<String> file = new Vector<String>(); // 用于保存发送附件的文件名的集合

	/**
	 * 设置SMTP服务器地址
	 */
	public void setSmtpServer(String smtpServer) {
		this.smtpServer = smtpServer;
	}

	/**
	 * 设置发件人的地址
	 */
	public void setFrom(String from) {
		this.from = from;
	}

	/**
	 * 设置显示的名称
	 */
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	/**
	 * 设置服务器是否需要身份认证
	 */
	public void setIfAuth(boolean ifAuth) {
		this.ifAuth = ifAuth;
	}

	/**
	 * 设置E-mail用户名
	 */
	public void setUserName(String username) {
		this.username = username;
	}

	/**
	 * 设置E-mail密码
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * 设置接收者
	 */
	public void setTo(String to) {
		this.to = to;
	}

	/**
	 * 设置主题
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

	/**
	 * 设置主体内容
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * 该方法用于收集附件名
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
	 * 发送邮件
	 * @return
	 */
	public String send() {
		String result = null;
		Session session = null;
		Transport trans = null;
		Address from_address = null;
		Properties props = System.getProperties();
		props.put("mail.smtp.host", smtpServer);
		//下面if专门处理gmail服务 端口：465
		if(this.smtpServer.indexOf("smtp.gmail.com")>=0)
        {
			props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory"); 
			props.setProperty("mail.smtp.socketFactory.fallback", "false"); 
			props.setProperty("mail.smtp.port", "465"); 
			props.setProperty("mail.smtp.socketFactory.port", "465"); 
        }
		if (ifAuth) { // 服务器需要身份认证
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
			if (!file.isEmpty()) {// 有附件
				Enumeration efile = file.elements();
				while (efile.hasMoreElements()) {
					mbp = new MimeBodyPart();
					filename = efile.nextElement().toString(); // 选择出每一个附件名
					FileDataSource fds = new FileDataSource(filename); // 得到数据源
					mbp.setDataHandler(new DataHandler(fds)); // 得到附件本身并至入BodyPart
					mbp.setFileName(fds.getName()); // 得到文件名同样至入BodyPart
					mp.addBodyPart(mbp);
				}
				file.removeAllElements();
			}
			msg.setContent(mp); // Multipart加入到信件
			msg.setSentDate(new Date()); // 设置信件头的发送日期
			msg.saveChanges();
			trans = session.getTransport("smtp");
			trans.connect(smtpServer, username, password);
			trans.sendMessage(msg, msg.getAllRecipients()); // 发送信件  		
			trans.close();	
		} catch (AuthenticationFailedException e) {
			result = "邮件发送失败！错误原因：身份验证错误!";
		} catch (MessagingException e) {
			result = "邮件发送失败！错误原因：" + e.getMessage();
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