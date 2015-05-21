package com.maicoin.api.entity;

/**
 * Created by yutelin on 1/12/15.
 */
public class CheckoutItem extends Entity {
    private String _description;
    private String _code;
    private String _price;
    private String _currency;
    private String _isPhysical;

    public String getDescription() {
        return _description;
    }

    public void setDescription(String _description) {
        this._description = _description;
    }

    public String getCode() {
        return _code;
    }

    public void setCode(String _code) {
        this._code = _code;
    }

    public String getPrice() {
        return _price;
    }

    public void setPrice(String _price) {
        this._price = _price;
    }

    public String getCurrency() {
        return _currency;
    }

    public void setCurrency(String _currency) {
        this._currency = _currency;
    }

    public String getIsPhysical() {
        return _isPhysical;
    }

    public void setIsPhysical(String _isPhysical) {
        this._isPhysical = _isPhysical;
    }
}
