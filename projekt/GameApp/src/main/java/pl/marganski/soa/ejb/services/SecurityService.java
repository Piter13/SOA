package pl.marganski.soa.ejb.services;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.digest.DigestUtils;

import pl.marganski.soa.ejb.services.UserService;
import pl.marganski.soa.jpa.entities.User;
import pl.marganski.soa.util.CredentialsException;
import pl.marganski.soa.util.SecurityUtils;
import pl.marganski.soa.util.SessionAlreadyExistsException;;

@Singleton
@Startup
public class SecurityService {

	@EJB
	private UserService userService;

	private Map<User, HttpSession> sessions = new HashMap<>();

	public void login(String userName, String password) throws CredentialsException, SessionAlreadyExistsException {
		User user = userService.getUser(userName);

		if (!DigestUtils.sha256Hex(password).equals(user.getPassword())) {
			throw new CredentialsException();
		}

		HttpSession session = SecurityUtils.getSession();
		session.setAttribute("user", user);

		if (Objects.nonNull(sessions.get(user))) {
			throw new SessionAlreadyExistsException();
		}
		sessions.put(user, session);
	}

	public void logout() {
		HttpSession session = SecurityUtils.getSession();
		User user = (User) session.getAttribute("user");
		sessions.remove(user);
		session.invalidate();
	}

}
