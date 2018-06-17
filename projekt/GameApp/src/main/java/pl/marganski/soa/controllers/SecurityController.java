package pl.marganski.soa.controllers;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import pl.marganski.soa.ejb.services.SecurityService;
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
    	if(SecurityUtils.getLoggedUser().get().getRole().equals(Role.Admin)) {
    		return false;
    	} else {
    		 Long count = SecurityUtils.getLoggedUser()
    						.get()
    						.getCastles()
    						.stream()
    						.filter(f -> f.getId() == Integer.parseInt(castleId))
    						.count();
    		 if(count > 0) {
    			 return false;
    		 }
    		 return true;
    		 
    	}
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

