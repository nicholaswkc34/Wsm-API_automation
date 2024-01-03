package com.rev.manager;

import com.mailersend.sdk.MailerSend;
import com.mailersend.sdk.MailerSendResponse;
import com.mailersend.sdk.emails.Email;
import com.mailersend.sdk.exceptions.MailerSendException;

import java.io.File;

 public class EmailManager {

    public EmailManager() {
    }

	public void sendEmail() {
		try {
			Email email = new Email();
			email.setFrom("Nicholas", "kachon.wong@revmedia.my");
			email.addRecipient("Nicholas", "kachon.wong@revmedia.my");
			email.addRecipient("Aafrin", "aafrin.fareeth@revmedia.my");
			email.addRecipient("Nabilah", "nabilah@revmedia.my");
			email.addRecipient("Poobalan", "poobalan@revmedia.my");

			email.setSubject("Berita Harian Automation Testing Report");
			email.setPlain("Dear Stakeholders, Please find the test automation report from attachment");
			File reportFile = new File(System.getProperty("user.dir") + "/report/testreport.zip");
			email.attachFile(reportFile);

			MailerSend ms = new MailerSend();
			ms.setToken("mlsn.be9d580f062f6a477ad1a2e9bba1de4a20a2579394109d3cc13f94b7d64841ad");

			MailerSendResponse response = ms.emails().send(email);
			System.out.println(response.messageId);

		} catch(MailerSendException ex) {
			ex.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}






	/*
	Email from = new Email("qa-automation@revmedia.my");
			String subject = "Free Malaysia Today Test Automation Report";
			Email to = new Email("aafrin.fareeth@revmedia.my");
			Content content = new Content("text/plain", "Dear Stakeholders, please find the test automation report in the report folder.");
			Mail mail = new Mail(from, subject, to, content);

			SendGrid sg = new SendGrid("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");
			Request request = new Request();

			request.setMethod(Method.POST);
			request.setEndpoint("mail/send");
			request.setBody(mail.build());
			Response response = sg.api(request);

			System.out.println(response.getStatusCode());
			System.out.println(response.getBody());
			System.out.println(response.getHeaders());





	public synchronized void sendEmail() {
		try {
			Email from = new Email("qa-automation@revmedia.my");
			String subject = "Buletin TV3 Test Automation Report";
			Email to = new Email("nicholaswkc34@gmail.com");
			Content content = new Content("text/plain", "Dear Stakeholders, please find the test automation report from attachment");
			Mail mail = new Mail(from, subject, to, content);

			Path file = Paths.get(".//report//TestReport-Spark.xml");
			byte[] attachmentContentBytes = Files.readAllBytes(file);
			Attachments attachment = new Attachments();
			Base64 base64 = new Base64();
			String encodedStr = base64.encodeAsString(attachmentContentBytes);
			attachment.setContent(encodedStr);
			attachment.setType("text/html");
			attachment.setFilename("TestReport.html");
			attachment.setFilename("attachment");
			mail.addAttachments(attachment);

			SendGrid sg = new SendGrid("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");
			Request request = new Request();

			request.setMethod(Method.POST);
			request.setEndpoint("mail/send");
			request.setBody(mail.build());
			Response response = sg.api(request);

			System.out.println(response.getStatusCode());
			System.out.println(response.getBody());
			System.out.println(response.getHeaders());
		} catch (IOException ex) {
			System.out.println("Error sending email" + ex.getMessage());

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}*/


	/*

try (final InputStream inputStream = Files.newInputStream(Paths.get(".//report//TestReport-Spark.xml"))) {
				final Attachments attachments = new Attachments
						.Builder("TestReport.html", inputStream)
						.withType("text/html")
						.build();
				mail.addAttachments(attachments);
			} catch (IOException ex) {
				System.out.println("Error added attachment " + ex.getMessage());
			}




 */





    /*public synchronized void sendEmail() {
		try {

			MailMessage message = new MailMessage();

			message.setSubject("Buletin TV3 Automation Testing Report");
			message.setBody("Dear Stakeholders, This is the Buletin TV3 automation testing report for your reference.");

			// Set Sender
			message.setFrom(new MailAddress("peterapiit@gmail.com", "Nicholas Wong", true));
			message.getTo().addItem(new MailAddress("nicholaswkc34@gmail.com", "Recipient 1", false));
			//message.getTo().addItem(new MailAddress("to1@outlook.com", "Recipient 1", false));

			// Add attachments
			message.getAttachments().addItem(new Attachment(".//report//TestReport-Spark.xml"));

			message.save("EmailMessage.msg", SaveOptions.getDefaultMsgUnicode());

			// Create an instance of SmtpClient Class
			SmtpClient client = new SmtpClient();

			// Specify your mailing host server, Username, Password, Port
			client.setHost("smtp.gmail.com");
			client.setUsername("peterapiit@gmail.com");
			client.setPassword("[wlx_+279295@wkc#]");
			client.setPort(587);

			client.send(message);

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}*/

}
