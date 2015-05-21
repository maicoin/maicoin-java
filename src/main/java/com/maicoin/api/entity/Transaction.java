package com.maicoin.api.entity;

import java.util.Date;

/**
 * Created by yutelin on 9/27/14.
 */
public class Transaction extends Entity {

    public static final String TYPE_EXTERNAL_RECEIVE = "external_receive";
    public static final String TYPE_EXTERNAL_SEND = "external_send";
    public static final String TYPE_INTERNAL_SEND = "internal_send";
    public static final String TYPE_EMAIL_REQUEST = "email_request";
    public static final String TYPE_EMAIL_SEND = "email_send";
    public static final String TYPE_PAYMENT_NAME_SEND = "payment_name_send";
    public static final String TYPE_MERCHANT_SEND = "merchant_send";

    public static final String STAUS_PENDING = "pending";
    public static final String STATUS_CANCELLED_BY_TO_USER = "cancelled_by_to_user";
    public static final String STATUS_CANCELLED_BY_FROM_USER = "cancelled_by_from_user";
    public static final String STATUS_FINAL = "final";
    public static final String STATUS_FAILURE = "failure";
    public static final String STATUS_UNCLAIMED = "unclaimed";
    
    private String _id;
    private Date _createdAt;
    private String _amount;
    private String _currency;
    private String _status;
    private String _transactionType;
    private String _notes;
    private User _sender;
    private User _recipient;

    public String getId() {
        return _id;
    }

    public void setId(String _id) {
        this._id = _id;
    }

    public Date getCreatedAt() {
        return _createdAt;
    }

    public void setCreatedAt(Date _createdAt) {
        this._createdAt = _createdAt;
    }

    public String getStatus() {
        return _status;
    }

    public void setStatus(String _status) {
        this._status = _status;
    }

    public String getTransactionType() {
        return _transactionType;
    }

    public void setTransactionType(String _transactionType) {
        this._transactionType = _transactionType;
    }

    public String getNotes() {
        return _notes;
    }

    public void setNotes(String _notes) {
        this._notes = _notes;
    }

    public User getSender() {
        return _sender;
    }

    public void setSender(User _sender) {
        this._sender = _sender;
    }

    public User getRecipient() {
        return _recipient;
    }

    public void setRecipient(User _recipient) {
        this._recipient = _recipient;
    }

    public String getAmount() {
        return _amount;
    }

    public void setAmount(String _coinAmount) {
        this._amount = _coinAmount;
    }

    public String getCurrency() {
        return _currency;
    }

    public void setCurrency(String _coinCurrency) {
        this._currency = _coinCurrency;
    }
}
