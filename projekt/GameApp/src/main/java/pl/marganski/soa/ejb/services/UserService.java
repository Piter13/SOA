package pl.marganski.soa.ejb.services;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.transaction.Transactional;

import org.apache.commons.codec.digest.DigestUtils;

import pl.marganski.soa.jpa.entities.User;
import pl.marganski.soa.repositories.UserRepository;

@Singleton
@Startup
@Transactional
public class UserService {

	@EJB
	private UserRepository userRepository;
	
	@Resource
	SessionContext sessionContext;

	public User getUser(String username) {
		return userRepository.findOneByUsername(username).orElse(new User());

	}

	public void changePassword(String username, String newPassword) {
		User user = getUser(username);
		user.setPassword(DigestUtils.sha256Hex(newPassword));
		userRepository.update(user);
	}
	
	public User findCurrentUser() {
        String login = sessionContext.getCallerPrincipal().getName();
        return userRepository.findOneByUsername(login).orElse(null);
    }
}