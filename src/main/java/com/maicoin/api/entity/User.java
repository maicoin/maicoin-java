package com.maicoin.api.entity;

/**
 * Created by yutelin on 9/27/14.
 */
public class User extends Entity {
    private String _id;
    private String _name;
    private String _email;
    private String _firstName;
    private String _lastName;
    private Boolean _accountPinSet;
    private Boolean _phoneSet;
    private String _address;
    private String _locale;

    public String getId() {
        return _id;
    }

    public void setId(String _id) {
        this._id = _id;
    }

    public String getName() {
        return _name;
    }

    public void setName(String _name) {
        this._name = _name;
    }

    public String getEmail() {
        return _email;
    }

    public void setEmail(String _email) {
        this._email = _email;
    }

    public String getFirstName() {
        return _firstName;
    }

    public void setFirstName(String _firstName) {
        this._firstName = _firstName;
    }

    public String getLastName() {
        return _lastName;
    }

    public void setLastName(String _lastName) {
        this._lastName = _lastName;
    }

    public Boolean getAccountPinSet() {
        return _accountPinSet;
    }

    public void setAccountPinSet(Boolean _accountPinSet) {
        this._accountPinSet = _accountPinSet;
    }

    public Boolean getPhoneSet() {
        return _phoneSet;
    }

    public void setPhoneSet(Boolean _phoneSet) {
        this._phoneSet = _phoneSet;
    }

    public String getAddress() {
        return _address;
    }

    public void setAddress(String _address) {
        this._address = _address;
    }

    public String getLocale() {
        return _locale;
    }

    public void setLocale(String _locale) {
        this._locale = _locale;
    }
}
