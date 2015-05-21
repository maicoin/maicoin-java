package com.maicoin.api.entity;

/**
 * Created by yutelin on 9/26/14.
 */
public class OrderNode extends Entity{
    private Order _order;

    public Order getOrder() {
        return _order;
    }

    public void setOrder(Order _order) {
        this._order = _order;
    }
}
