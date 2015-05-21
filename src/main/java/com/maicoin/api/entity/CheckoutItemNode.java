package com.maicoin.api.entity;

/**
 * Created by yutelin on 1/12/15.
 */
public class CheckoutItemNode extends CheckoutItem {
    private CheckoutItem _item;

    public CheckoutItem getItem() {
        return _item;
    }

    public void setItem(CheckoutItem _item) {
        this._item = _item;
    }
}
