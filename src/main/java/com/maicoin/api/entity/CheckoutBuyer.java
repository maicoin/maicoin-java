package com.maicoin.api.entity;

/**
 * Created by yutelin on 1/12/15.
 */
public class CheckoutBuyer extends Entity {
    private String _buyerName;
    private String _buyerAddress1;
    private String _buyerAddress2;
    private String _buyerCity;
    private String _buyerState;
    private String _buyerZip;
    private String _buyerEmail;
    private String _buyerPhone;
    private String _buyerCountry;

    public String getBuyerName() {
        return _buyerName;
    }

    public void setBuyerName(String _buyerName) {
        this._buyerName = _buyerName;
    }

    public String getBuyerAddress1() {
        return _buyerAddress1;
    }

    public void setBuyerAddress1(String _buyerAddress1) {
        this._buyerAddress1 = _buyerAddress1;
    }

    public String getBuyerAddress2() {
        return _buyerAddress2;
    }

    public void setBuyerAddress2(String _buyerAddress2) {
        this._buyerAddress2 = _buyerAddress2;
    }

    public String getBuyerCity() {
        return _buyerCity;
    }

    public void setBuyerCity(String _buyerCity) {
        this._buyerCity = _buyerCity;
    }

    public String getBuyerState() {
        return _buyerState;
    }

    public void setBuyerState(String _buyerState) {
        this._buyerState = _buyerState;
    }

    public String getBuyerZip() {
        return _buyerZip;
    }

    public void setBuyerZip(String _buyerZip) {
        this._buyerZip = _buyerZip;
    }

    public String getBuyerEmail() {
        return _buyerEmail;
    }

    public void setBuyerEmail(String _buyerEmail) {
        this._buyerEmail = _buyerEmail;
    }

    public String getBuyerPhone() {
        return _buyerPhone;
    }

    public void setBuyerPhone(String _buyerPhone) {
        this._buyerPhone = _buyerPhone;
    }

    public String getBuyerCountry() {
        return _buyerCountry;
    }

    public void setBuyerCountry(String _buyerCountry) {
        this._buyerCountry = _buyerCountry;
    }
}
