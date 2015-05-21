package com.maicoin.api.entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.maicoin.api.converter.AddressConverter;

import java.util.List;

/**
 * Created by yutelin on 9/27/14.
 */
public class Addresses extends Entity {
    private List<Address> _addresses;
    private String _currencyType;

    public List<Address> getAddresses() {
        return _addresses;
    }

    @JsonDeserialize(converter=AddressConverter.class)
    public void setAddresses(List<Address> _addresses) {
        this._addresses = _addresses;
    }

    public String getCurrencyType() {
        return _currencyType;
    }

    public void setCurrencyType(String _currencyType) {
        this._currencyType = _currencyType;
    }
}
