package com.sea.web.uac.service;

import com.sea.web.uac.dao.RoleDAO;
import com.sea.web.uac.modal.Role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * RoleService.
 *
 * Created by chris on 17-7-15.
 */
@Service
public class RoleService {

  @Autowired
  private RoleDAO roleDAO;

  public void create(Role role) {
    roleDAO.create(role);
  }

  public void delete(Role role) {
    roleDAO.delete(role);
  }

  public void update(Role role) {
    roleDAO.update(role);
  }

  public Role get(long rid) {
    return roleDAO.get(rid);
  }
}
