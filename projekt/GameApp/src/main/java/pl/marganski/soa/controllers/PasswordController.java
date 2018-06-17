package pl.marganski.soa.controllers;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import pl.marganski.soa.ejb.services.UserService;
import pl.marganski.soa.util.SecurityUtils;

@SuppressWarnings("deprecation")
@ManagedBean
public class PasswordController {
    @EJB
    private UserService userService;

    private String username = SecurityUtils.getLoggedUser()
            								.orElseThrow(IllegalStateException::new)
            								.getUsername();
    private String newPassword;
    private String message;

    public void changePassword() {
        try {
            userService.changePassword(username, newPassword);
            SecurityUtils.redirect("home.xhtml");
        } catch (Exception e) {
            message = "Something went wrong";
        }
    }

    public boolean isNotEmpty(String s) {
        return s != null && s.length() != 0;
    }

    public boolean isAdmin() {
        return SecurityUtils.isAdmin();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}