package com.maicoin.api.entity;

/**
 * Created by yutelin on 2/25/15.
 */
public class AccountNode extends Entity {
    private Account _account;

    public Account getAccount() {
        return _account;
    }

    public void setAccount(Account _account) {
        this._account = _account;
    }
}
