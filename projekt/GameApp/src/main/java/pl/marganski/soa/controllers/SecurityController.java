package pl.marganski.soa.controllers;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import pl.marganski.soa.ejb.services.CastleService;
import pl.marganski.soa.ejb.services.SecurityService;
import pl.marganski.soa.jpa.entities.User;
import pl.marganski.soa.jpa.entities.User.Role;
import pl.marganski.soa.util.CredentialsException;
import pl.marganski.soa.util.SecurityUtils;
import pl.marganski.soa.util.SessionAlreadyExistsException;;

@SuppressWarnings("deprecation")
@ManagedBean
@SessionScoped
public class SecurityController {
	@EJB
	private SecurityService securityService;

	@EJB
	private CastleService castleService;

	private String username;
	private String password;
	private String message;

	public void login() {
		try {
			securityService.login(username, password);
			SecurityUtils.redirect("home.xhtml");
		} catch (CredentialsException e) {
			message = e.getMessage();
		} catch (SessionAlreadyExistsException e) {
			message = e.getMessage();
		}
	}

	public void logout() {
		SecurityUtils.redirect("login.xhtml");
		securityService.logout();
	}

	public boolean isAuthorizedToEditCategory(String castleId) {
		int attemptingUser = castleService.getCastleDTO(Integer.parseInt(castleId)).getUser();
		int currentUser = SecurityUtils.getLoggedUser().get().getId();

		if (SecurityUtils.getLoggedUser().get().getRole().equals(Role.Admin)) {
			return false;
		} else if (attemptingUser == currentUser) {
			return false;
		}
		return true;
	}

	public boolean isAuthenticated() {
		return SecurityUtils.getLoggedUser().isPresent();
	}

	public boolean isAdmin() {
		return SecurityUtils.isAdmin();
	}

	public boolean isNotEmpty(String s) {
		return s != null && s.length() != 0;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String userName) {
		this.username = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
