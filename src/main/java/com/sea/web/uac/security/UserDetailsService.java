package com.sea.web.uac.security;

import com.sea.web.uac.modal.User;
import com.sea.web.uac.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author lx48475
 * @version Id: UserDetailsService.java, v 0.1 2017年08月09 10:43 lx48475 Exp $
 */
@Component
public class UserDetailsService {

    @Autowired
    private UserService userService;

    public User loadUserVOByUserName(String loginName) {
        User user = userService.getByLoginName(loginName);
        if (user == null) {
            throw new RuntimeException(String.format("No user found with username '%s'.", loginName));
        } else {
            return user;
        }
    }
}
