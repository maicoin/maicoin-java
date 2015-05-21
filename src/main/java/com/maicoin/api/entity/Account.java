package com.maicoin.api.entity;

/**
 * Created by yutelin on 2/25/15.
 */
public class Account extends Entity  {
    String _currencyType;
    String _totalBalance;
    String _availableBalance;
    String _btcAddress;

    public String getCurrencyType() {
        return _currencyType;
    }

    public void setCurrencyType(String _currencyType) {
        this._currencyType = _currencyType;
    }

    public String getTotalBalance() {
        return _totalBalance;
    }

    public void setTotalBalance(String _totalBalance) {
        this._totalBalance = _totalBalance;
    }

    public String getAvailableBalance() {
        return _availableBalance;
    }

    public void setAvailableBalance(String _availableBalance) {
        this._availableBalance = _availableBalance;
    }

    public String getBtcAddress() {
        return _btcAddress;
    }

    public void setBtcAddress(String _btcAddress) {
        this._btcAddress = _btcAddress;
    }
}
