package com.sea.web.uac.modal;

import java.io.Serializable;

/**
 * Created by lxg
 * on 2017/2/20.
 */
public class    UserRole implements Serializable{
    private int id;
    private int uid;
    private int rid;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }
}
