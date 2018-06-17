package pl.marganski.soa.util;

public class CredentialsException extends Exception {
	private static final long serialVersionUID = 1L;

	public CredentialsException() {
		super("Incorrect username or password");
	}

}