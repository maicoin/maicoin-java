package com.maicoin.api.entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.maicoin.api.converter.TransactionConverter;

import java.util.List;

/**
 * Created by yutelin on 9/27/14.
 */
public class Transactions extends Entity {
    private int _count;
    private int _currentPage;
    private int _numOfPages;
    private Coin _balance;
    private Money _nativeBalance;
    private User _currentUser;
    private List<Transaction> _transactions;

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

    public Coin getBalance() {
        return _balance;
    }

    public void setBalance(Coin _balance) {
        this._balance = _balance;
    }

    public Money getNativeBalance() {
        return _nativeBalance;
    }

    public void setNativeBalance(Money _nativeBalance) {
        this._nativeBalance = _nativeBalance;
    }

    public User getCurrentUser() {
        return _currentUser;
    }

    public void setCurrentUser(User _user) {
        this._currentUser = _user;
    }

    public List<Transaction> getTransactions() {
        return _transactions;
    }

    @JsonDeserialize(converter=TransactionConverter.class)
    public void setTransactions(List<Transaction> transactions) {
        this._transactions = transactions;
    }
}
