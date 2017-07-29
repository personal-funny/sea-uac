package com.sea.web.uac.service;

import com.sea.web.uac.dao.UserRoleDAO;
import com.sea.web.uac.modal.UserRole;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * UserRoleService.
 *
 * Created by chris on 17-7-15.
 */
@Service
public class UserRoleService {

  @Autowired
  private UserRoleDAO userRoleDAO;

  public void create(UserRole ur) {
    userRoleDAO.create(ur);
  }

  public void delete(UserRole ur) {
    userRoleDAO.delete(ur);
  }

  public List<UserRole> getByUid(long userId) {
    return userRoleDAO.getByUid(userId);
  }

  public List<UserRole> getByRid(long roleId) {
    return userRoleDAO.getByRid(roleId);
  }
}
