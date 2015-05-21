package com.maicoin.api.entity;

/**
 * Created by yutelin on 1/12/15.
 */
public class CheckoutNode extends Entity {
    private Checkout _checkout;

    public Checkout getCheckout() {
        return _checkout;
    }

    public void setCheckout(Checkout _checkout) {
        this._checkout = _checkout;
    }
}
