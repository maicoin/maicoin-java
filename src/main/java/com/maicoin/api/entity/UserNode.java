package com.maicoin.api.entity;

/**
 * Created by yutelin on 3/3/15.
 */
public class UserNode extends Entity{
    private User _user;

    public User getUser() {
        return _user;
    }

    public void setUser(User _user) {
        this._user = _user;
    }
}
