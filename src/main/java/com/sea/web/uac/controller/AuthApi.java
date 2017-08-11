package com.sea.web.uac.controller;

import com.sea.web.uac.modal.User;
import com.sea.web.uac.security.TokenHelper;
import com.sea.web.uac.security.UserDetailsService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author lx48475
 * @version Id: AuthApi.java, v 0.1 2017年08月11 17:29 lx48475 Exp $
 */
@RestController
@RequestMapping(value = "/auth")
public class AuthApi {

    @Value("${jwt.expires_in}")
    private int EXPIRES_IN;

    @Value("${jwt.cookie}")
    private String TOKEN_COOKIE;

    @Value("${app.user_cookie}")
    private String USER_COOKIE;

    @Autowired
    private TokenHelper tokenHelper;

    @Autowired
    private UserDetailsService userDetailsService;

    /**
     * 根据用户名和密码获取token
     *
     * @param userName
     * @param password
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<String> auth(@RequestParam String userName, @RequestParam String password) throws IOException {
        ResponseEntity<String> responseEntity = null;
        User user = userDetailsService.loadUserVOByUserName(userName);
        if (StringUtils.equals(password, user.getPassword())) {
            String result = tokenHelper.generateToken(userName);
            responseEntity = new ResponseEntity<>(result, HttpStatus.OK);
        } else {
            responseEntity = new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        return responseEntity;
    }

    /**
     * 刷新token。当token过期时。
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/refresh", method = RequestMethod.POST)
    public ResponseEntity<String> refresh(HttpServletRequest request) {
        String authToken = tokenHelper.getToken(request);
        ResponseEntity<String> responseEntity = null;
        if (authToken != null && tokenHelper.canTokenBeRefreshed(authToken)) {
            String refreshToken = tokenHelper.refreshToken(authToken);
            responseEntity = new ResponseEntity<>(refreshToken, HttpStatus.OK);
        } else {
            responseEntity = new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        return responseEntity;
    }
}
