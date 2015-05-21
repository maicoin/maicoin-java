package com.maicoin.api.entity;

import java.util.Date;

/**
 * Created by yutelin on 9/27/14.
 */
public class Address extends Entity {
    private String _address;
    private Date _createdAt;
    private String _currencyType;

    public String getAddress() {
        return _address;
    }

    public void setAddress(String _address) {
        this._address = _address;
    }

    public Date getCreatedAt() {
        return _createdAt;
    }

    public void setCreatedAt(Date _createdAt) {
        this._createdAt = _createdAt;
    }

    public String getCurrencyType() {
        return _currencyType;
    }

    public void setCurrencyType(String _currencyType) {
        this._currencyType = _currencyType;
    }
}
