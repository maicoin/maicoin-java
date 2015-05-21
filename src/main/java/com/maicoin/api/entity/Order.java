package com.maicoin.api.entity;


import org.apache.commons.lang3.builder.ToStringBuilder;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by yutelin on 9/26/14.
 */
public class Order extends Entity {

    public static final String TYPE_BUY = "buy";
    public static final String TYPE_SELL = "sell";

    public static final String STATUS_PENDING = "pending";
    public static final String STATUS_CANCELLED = "cancelled";
    public static final String STATUS_FAILURE = "failure";
    public static final String STATUS_FINAL = "final";
    public static final String STATUS_FRAUD = "fraud";
    public static final String STATUS_PAID = "paid";

    private String _type;
    private String _status;
    private String _txid;
    private Date _createdAt;
    private String _notes;
    private String _coinAmount;
    private String _coinCurrency;
    private String _coinPrice;
    private String _totalCost;
    private String _currency;
    private String _buyAmount;
    private String _buyCurrency;
    private String _sellAmount;
    private String _sellCurrency;
    private String _price;
    private MaicoinBankInformation _maicoinBankInformation;
    private List<String> _convenienceStoreBarcodes;

    public String getType() {
        return _type;
    }

    public void setType(String _type) {
        this._type = _type;
    }

    public String getStatus() {
        return _status;
    }

    public void setStatus(String _status) {
        this._status = _status;
    }

    public String getTxid() {
        return _txid;
    }

    public void setTxid(String _txid) {
        this._txid = _txid;
    }

    public Date getCreatedAt() {
        return _createdAt;
    }

    public void setCreatedAt(Date _createdAt) {
        this._createdAt = _createdAt;
    }

    public String getNotes() {
        return _notes;
    }

    public void setNotes(String _notes) {
        this._notes = _notes;
    }

    public String getCurrency() {
        return _currency;
    }

    public void setCurrency(String _currency) {
        this._currency = _currency;
    }

    public String getTotalCost() {
        return _totalCost;
    }

    public void setTotalCost(String _totalCost) {
        this._totalCost = _totalCost;
    }

    public String getCoinPrice() {
        return _coinPrice;
    }

    public void setCoinPrice(String _coinPrice) {
        this._coinPrice = _coinPrice;
    }

    public String getCoinCurrency() {
        return _coinCurrency;
    }

    public void setCoinCurrency(String _coinCurrency) {
        this._coinCurrency = _coinCurrency;
    }

    public String getCoinAmount() {
        return _coinAmount;
    }

    public void setCoinAmount(String _coinAmount) {
        this._coinAmount = _coinAmount;
    }

    public String getBuyAmount() {
        return _buyAmount;
    }

    public void setBuyAmount(String _buyAmount) {
        this._buyAmount = _buyAmount;
    }

    public String getBuyCurrency() {
        return _buyCurrency;
    }

    public void setBuyCurrency(String _buyCurrency) {
        this._buyCurrency = _buyCurrency;
    }

    public String getSellAmount() {
        return _sellAmount;
    }

    public void setSellAmount(String _sellAmount) {
        this._sellAmount = _sellAmount;
    }

    public String getSellCurrency() {
        return _sellCurrency;
    }

    public void setSellCurrency(String _sellCurrency) {
        this._sellCurrency = _sellCurrency;
    }

    public String getPrice() {
        return _price;
    }

    public void setPrice(String _price) {
        this._price = _price;
    }

    public MaicoinBankInformation getMaicoinBankInformation() {
        return _maicoinBankInformation;
    }

    public void setMaicoinBankInformation(MaicoinBankInformation _maicoinBankInformation) {
        this._maicoinBankInformation = _maicoinBankInformation;
    }

    public List<String> getConvenienceStoreBarcodes() {
        return _convenienceStoreBarcodes;
    }

    public void setConvenienceStoreBarcodes(List<String> _convenienceStoreBarcodes) {
        this._convenienceStoreBarcodes = _convenienceStoreBarcodes;
    }
}
