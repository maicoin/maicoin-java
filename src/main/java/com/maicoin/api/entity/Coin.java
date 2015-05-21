package com.maicoin.api.entity;

/**
 * Created by yutelin on 12/15/14.
 */
public class Coin extends Entity {
    private String _coinCurrency;
    private String _coinAmount;

    public String getCoinCurrency() {
        return _coinCurrency;
    }

    public void setCoinCurrency(String _coinCurrency) {
        this._coinCurrency = _coinCurrency;
    }

    public String getCoinAmount() {
        return _coinAmount;
    }

    public void setCoinAmount(String _coinAmount) {
        this._coinAmount = _coinAmount;
    }
}
