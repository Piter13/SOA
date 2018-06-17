package pl.marganski.soa.util;

import java.io.IOException;
import java.util.Objects;
import java.util.Optional;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import pl.marganski.soa.jpa.entities.User;
import pl.marganski.soa.jpa.entities.User.Role;

public class SecurityUtils {

	public static HttpSession getSession() {
		return getSession(getRequest());
	}

	public static Optional<User> getLoggedUser() {
		return getLoggedUser(getSession());
	}

	public static void redirect(String page) {
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect(page);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static boolean isAdmin() {
		return getLoggedUser().filter(SecurityUtils::isAdmin).isPresent();
	}

	public static boolean isAdmin(User u) {
		return u.getRole() == Role.Admin;
	}

	public static boolean isAdmin(HttpServletRequest req) {
		return getLoggedUser(getSession(req)).filter(SecurityUtils::isAdmin).isPresent();
	}

	public static boolean isAuthenticated(HttpServletRequest req) {
		return getLoggedUser(getSession(req)).isPresent();
	}

	private static HttpSession getSession(HttpServletRequest req) {
		return req.getSession(true);
	}

	private static HttpServletRequest getRequest() {
		return (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
	}

	private static Optional<User> getLoggedUser(HttpSession session) {
		Object u = session.getAttribute("user");
		return Objects.isNull(u) ? Optional.empty() : Optional.of((User) u);
	}

}
