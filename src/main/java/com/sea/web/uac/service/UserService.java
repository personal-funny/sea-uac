package com.sea.web.uac.service;

import com.sea.web.uac.dao.UserDAO;
import com.sea.web.uac.modal.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * UserService.
 *
 * Created by chris on 17-7-15.
 */
@Service
public class UserService {
  @Autowired
  private UserDAO userDAO;

  public void create(User user) {
    userDAO.create(user);
  }

  public void delete(User user) {
    userDAO.delete(user);
  }

  public void update(User user) {
    userDAO.update(user);
  }

  public User getById(long userId) {
    return userDAO.getById(userId);
  }

  public User getByLoginName(String loginName) {
    return userDAO.getByLoginName(loginName);
  }
}
