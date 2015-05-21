package com.maicoin.api.entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.maicoin.api.converter.CheckoutConverter;

import java.util.List;

/**
 * Created by yutelin on 1/12/15.
 */
public class Checkouts extends Entity {
    private int _count;
    private int _currentPage;
    private int _numOfPages;
    private List<Checkout> _checkouts;

    public int getCount() {
        return _count;
    }

    public void setCount(int _count) {
        this._count = _count;
    }

    public int getCurrentPage() {
        return _currentPage;
    }

    public void setCurrentPage(int _currentPage) {
        this._currentPage = _currentPage;
    }

    public int getNumOfPages() {
        return _numOfPages;
    }

    public void setNumOfPages(int _numOfPages) {
        this._numOfPages = _numOfPages;
    }

    public List<Checkout> getCheckouts() {
        return _checkouts;
    }

    @JsonDeserialize(converter=CheckoutConverter.class)
    public void setCheckouts(List<Checkout> _checkouts) {
        this._checkouts = _checkouts;
    }
}
