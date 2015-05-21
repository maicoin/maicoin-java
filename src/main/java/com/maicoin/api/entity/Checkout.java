package com.maicoin.api.entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.maicoin.api.converter.CheckoutItemConverter;
import com.maicoin.api.converter.CheckoutItemNodeConverter;

import java.util.Date;
import java.util.List;

/**
 * Created by yutelin on 1/12/15.
 */

public class Checkout extends Entity{
    private String _amount;
    private String _currency;
    private String _returnUrl;
    private String _cancelUrl;
    private String _callbackUrl;
    private String _merchantRefId;
    private String _posData;
    private String _locale;
    private CheckoutBuyer _buyer;
    private List<CheckoutItem> _items;

    private String _uid;
    private Date _createdAt;
    private String _status;
    private String _checkoutUrl;

    public String getAmount() {
        return _amount;
    }

    public void setAmount(String _amount) {
        this._amount = _amount;
    }

    public String getCurrency() {
        return _currency;
    }

    public void setCurrency(String _currency) {
        this._currency = _currency;
    }

    public String getReturnUrl() {
        return _returnUrl;
    }

    public void setReturnUrl(String _returnUrl) {
        this._returnUrl = _returnUrl;
    }

    public String getCancelUrl() {
        return _cancelUrl;
    }

    public void setCancelUrl(String _cancelUrl) {
        this._cancelUrl = _cancelUrl;
    }

    public String getCallbackUrl() {
        return _callbackUrl;
    }

    public void setCallbackUrl(String _callbackUrl) {
        this._callbackUrl = _callbackUrl;
    }

    public String getMerchantRefId() {
        return _merchantRefId;
    }

    public void setMerchantRefId(String _merchantRefId) {
        this._merchantRefId = _merchantRefId;
    }

    public String getPosData() {
        return _posData;
    }

    public void setPosData(String _posData) {
        this._posData = _posData;
    }

    public String getLocale() {
        return _locale;
    }

    public void setLocale(String _locale) {
        this._locale = _locale;
    }

    public CheckoutBuyer getBuyer() {
        return _buyer;
    }

    public void setBuyer(CheckoutBuyer _buyer) {
        this._buyer = _buyer;
    }

    @JsonSerialize(converter = CheckoutItemNodeConverter.class)
    public List<CheckoutItem> getItems() {
        return _items;
    }

    @JsonDeserialize(converter=CheckoutItemConverter.class)
    public void setItems(List<CheckoutItem> _items) {
        this._items = _items;
    }

    public String getCheckoutUrl() {
        return _checkoutUrl;
    }

    public void setCheckoutUrl(String _checkoutUrl) {
        this._checkoutUrl = _checkoutUrl;
    }

    public String getStatus() {
        return _status;
    }

    public void setStatus(String _status) {
        this._status = _status;
    }

    public Date getCreatedAt() {
        return _createdAt;
    }

    public void setCreatedAt(Date _createdAt) {
        this._createdAt = _createdAt;
    }

    public String getUid() {
        return _uid;
    }

    public void setUid(String _uid) {
        this._uid = _uid;
    }
}
