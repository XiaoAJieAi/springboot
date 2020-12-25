package com.n22.springboot.controller;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailMessage;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@RestController
@RequestMapping("/email")
public class EmailController {

	@Autowired
	private JavaMailSender jms;
	
	@Autowired
	private TemplateEngine templateEngine;
	
	@Value("${spring.mail.username}")
	private String from;
	
	@RequestMapping("/sendSimpleEmail")
	public String sendSimpleEmail() {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(from);
		message.setTo("guoshijievip@126.com"); //接收地址
		message.setSubject("一封简单的邮件"); // 标题
		message.setText("使用springBoot发送简单邮件。");
		jms.send(message);
		return "发送成功";
	}
	
	/**
	 * helper.setText(sb.toString(), true);中的true表示发送HTML格式邮件。
	 * @return
	 */
	@RequestMapping("/sendHTMLEmail")
	public String sendHTMLEmail() {
		MimeMessage message = null;
		try {
			message = jms.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, true);
			helper.setFrom(from);
			helper.setTo("guoshijievip@126.com"); //接收地址
			helper.setSubject("一封HTML的邮件"); // 标题
			StringBuffer sb = new StringBuffer();
			sb.append("<p style='color:#6db33f'>使用Spring Boot发送HTML格式邮件。</p>");
			helper.setText(sb.toString(),true);
			jms.send(message);
			return "发送成功";
		} catch (MessagingException e) {
			e.printStackTrace();
			return e.getMessage();
		}
	}
	
	@RequestMapping("/sendAttachMentsEmail")
	public String sendAttachMentsEmail() {
		MimeMessage message = null;
		try {
			message = jms.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, true);
			helper.setFrom(from);
			helper.setTo("guoshijievip@126.com"); //接收地址
			helper.setSubject("一封带附件的邮件"); // 标题
			helper.setText("详情参见附件内容！"); //内容
			// 传入附件
			FileSystemResource resource = new FileSystemResource("E:\\dubbo-admin-2.6.0.war");
			helper.addAttachment("dubbo-admin.war", resource);
			jms.send(message);
			return "发送成功";
		} catch (MessagingException e) {
			e.printStackTrace();
			return e.getMessage();
		}
	}
	
	/**
	 * helper.addInline("img", file);中的img和图片标签里cid后的名称相对应。
	 * @return
	 */
	@RequestMapping("/sendInlineEmail")
	public String sendInlineEmail() {
		MimeMessage message = null;
		try {
			message = jms.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, true);
			helper.setFrom(from);
			helper.setTo("guoshijievip@126.com"); //接收地址
			helper.setSubject("一封带静态资源的邮件"); // 标题
			helper.setText("<html><body>博客图：<img src='cid:img'/></body></html>", true); //内容
			// 传入附件
			FileSystemResource resource = new FileSystemResource("C:\\Users\\Public\\Pictures\\Sample Pictures\\u=3147399228,691223223&fm=26&gp=0.png");
			helper.addInline("img", resource);
			jms.send(message);
			return "发送成功";
		} catch (MessagingException e) {
			e.printStackTrace();
			return e.getMessage();
		}
	}
	
	/**
	 * 发送模板邮件
	 * @return
	 */
	@RequestMapping("/sendTemplateEmail")
	public String sendTemplateEmail(String code) {
		MimeMessage message = null;
		try {
			message = jms.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, true);
			helper.setFrom(from);
			helper.setTo("guoshijievip@126.com"); //接收地址
			helper.setSubject("邮件摸板测试"); // 标题
			// 处理邮件模板
			Context context = new Context();
			context.setVariable("code", code);
			String template = templateEngine.process("emailTemplate", context);
			helper.setText(template,true);
			jms.send(message);
			return "发送成功";
		} catch (MessagingException e) {
			e.printStackTrace();
			return e.getMessage();
		}
	}
}
