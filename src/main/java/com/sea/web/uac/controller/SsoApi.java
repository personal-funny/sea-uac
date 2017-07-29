package com.sea.web.uac.controller;

import com.sea.web.uac.modal.User;
import com.sea.web.uac.service.RoleService;
import com.sea.web.uac.service.UserRoleService;
import com.sea.web.uac.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Controller impl
 *
 * Created by chris on 17-2-25.
 */
@RestController
@RequestMapping("/check")
public class SsoApi {

  @Autowired
  private RoleService roleService;

  @Autowired
  private UserRoleService userRoleService;

  @Autowired
  private UserService userService;

  @RequestMapping(value="/login")
  public void login(HttpServletRequest request, HttpServletResponse response) {

  }

  @RequestMapping(value = "/logout")
  public void logout(HttpServletRequest request, HttpServletResponse response) {

  }

  @RequestMapping(value = "/user")
  public Map<String, String> user(Principal principal) {
    Map<String, String> map = new LinkedHashMap<>();
    map.put("name", principal.getName());
    return map;
  }

  @RequestMapping(value = "/hello", method = RequestMethod.GET)
  public String hello(HttpServletRequest request) {
    User user = userService.getById(1);
    roleService.get(1);
    userRoleService.getByRid(1);
    return "name : " + user.getUserName() + " pass : " + user.getPassword();
  }
}
