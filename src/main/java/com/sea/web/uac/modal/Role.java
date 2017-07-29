package com.sea.web.uac.modal;

import java.io.Serializable;

/**
 * Created by lxg
 * on 2017/2/20.
 */
public class Role implements Serializable{
    private int id;
    private String roleName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
