package com.sea.web.uac.security;

import com.sea.web.uac.modal.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author lx48475
 * @version Id: LoginChecker.java, v 0.1 2017年08月09 10:34 lx48475 Exp $
 */
public class LoginChecker extends HandlerInterceptorAdapter {

    @Autowired
    private TokenHelper tokenHelper;
    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String authToken = tokenHelper.getToken(request);
        if (authToken != null) {
            String username = tokenHelper.getUsernameFromToken(authToken);
            try {
                User user = userDetailsService.loadUserVOByUserName(username);
                return true;
            } catch (Exception e) {
                response.setStatus(HttpStatus.UNAUTHORIZED.value());
                return false;
            }
        } else {
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            return false;
        }
    }

}
