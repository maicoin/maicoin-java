package com.maicoin.api.entity;

/**
 * Created by yutelin on 9/27/14.
 */
public class AddressNode extends Entity {
    private Address _address;

    public Address getAddress() {
        return _address;
    }

    public void setAddress(Address _address) {
        this._address = _address;
    }
}
