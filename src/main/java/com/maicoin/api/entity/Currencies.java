package com.maicoin.api.entity;

import java.util.List;

/**
 * Created by yutelin on 9/26/14.
 */
public class Currencies extends Entity {
    List<String> _currencies;

    public List<String> getCurrencies() {
        return _currencies;
    }

    public void setCurrencies(List<String> currencies) {
        this._currencies = currencies;
    }
}
