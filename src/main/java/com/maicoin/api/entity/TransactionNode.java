package com.maicoin.api.entity;

/**
 * Created by yutelin on 9/27/14.
 */
public class TransactionNode extends Entity {
    private Transaction _transaction;

    public Transaction getTransaction() {
        return _transaction;
    }

    public void setTransaction(Transaction _transaction) {
        this._transaction = _transaction;
    }
}
