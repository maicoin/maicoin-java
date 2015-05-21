package com.maicoin.api.entity;

/**
 * Created by yutelin on 9/26/14.
 */
public class Money extends Entity {
    private String _currency;
    private String _amount;

    public String getCurrency() {
        return _currency;
    }

    public void setCurrency(String currency) {
        this._currency = currency;
    }

    public String getAmount() {
        return _amount;
    }

    public void setAmount(String amount) {
        this._amount = amount;
    }
}
