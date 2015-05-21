package com.maicoin.api.entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.maicoin.api.converter.OrderConverter;

import java.util.List;

/**
 * Created by yutelin on 9/26/14.
 */
public class Orders extends Entity {
    private int _count;
    private int _currentPage;
    private int _numOfPages;
    private List<Order> _orders;

    public int getCount() {
        return _count;
    }

    public void setCount(int count) {
        this._count = count;
    }

    public int getCurrentPage() {
        return _currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this._currentPage = currentPage;
    }

    public int getNumOfPages() {
        return _numOfPages;
    }

    public void setNumOfPages(int numOfPages) {
        this._numOfPages = numOfPages;
    }

    public List<Order> getOrders() {
        return _orders;
    }

    @JsonDeserialize(converter=OrderConverter.class)
    public void setOrders(List<Order> orders) {
        this._orders = orders;
    }
}
