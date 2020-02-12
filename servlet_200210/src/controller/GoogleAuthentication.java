package controller;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class GoogleAuthentication extends Authenticator {
	PasswordAuthentication passAuth;
	
	public GoogleAuthentication() {
		passAuth = 
			new PasswordAuthentication("dldyddlek123","bomfadfcjnstntvt");
	}
	
	public PasswordAuthentication getPasswordAuthentication() {
		return passAuth;
	}
}
