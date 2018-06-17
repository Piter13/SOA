package pl.marganski.soa.util;

public class SessionAlreadyExistsException extends Exception {
	private static final long serialVersionUID = 1L;

	public SessionAlreadyExistsException() {
		super("Session is already started");
	}

}