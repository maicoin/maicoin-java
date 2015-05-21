package com.maicoin.api;

import com.maicoin.api.entity.Address;
import com.maicoin.api.entity.Addresses;
import com.maicoin.api.entity.Checkout;
import com.maicoin.api.entity.CheckoutParamBuilder;
import com.maicoin.api.entity.Checkouts;
import com.maicoin.api.entity.Coin;
import com.maicoin.api.entity.Currencies;
import com.maicoin.api.entity.Entity;
import com.maicoin.api.entity.Order;
import com.maicoin.api.entity.Orders;
import com.maicoin.api.entity.Price;
import com.maicoin.api.entity.Transaction;
import com.maicoin.api.entity.Transactions;
import com.maicoin.api.entity.User;
import com.maicoin.api.exception.MaiCoinException;

import java.io.IOException;


/**
 * Created by yutelin on 9/25/14.
 */
public interface MaiCoin {

    public static final int CODE_SUCCESS                              = 0;
    public static final int CODE_MISSING_HEADER                       = 100;
    public static final int CODE_UNAUTHORIZED                         = 101;
    public static final int CODE_INVALID_NONCE                        = 102;
    public static final int CODE_DB_UNABLE_TO_CREATE                  = 103;
    public static final int CODE_DB_EXCEPTION                         = 104;
    public static final int CODE_INVALID_PARAM                        = 105;
    public static final int CODE_CURRENCY_NOT_SUPPORTED               = 106;
    public static final int CODE_USER_NOT_FOUND                       = 107;
    public static final int CODE_MISSING_PARAMETERS                   = 108;
    public static final int CODE_ORDER_OUT_OF_RANGE                   = 109;
    public static final int CODE_ORDER_OVER_MAX_DAILY_BUY             = 110;
    public static final int CODE_ORDER_HAS_OUTSTANDING_BUY            = 111;
    public static final int CODE_ORDER_OVER_MAX_DAILY_SELL            = 112;
    public static final int CODE_BTC_NOT_ENOUGH                       = 113;
    public static final int CODE_TRANSACTION_NOT_FOUND                = 114;
    public static final int CODE_TRANSACTION_INVALID_AMOUNT           = 115;
    public static final int CODE_TRANSACTION_CANNOT_REQUEST_FROM_SELF = 116;
    public static final int CODE_INVALID_EMAIL_ADDRESS                = 117;
    public static final int CODE_TRANSACTION_NOT_CANCELLABLE          = 118;
    public static final int CODE_CHECKOUT_NOT_FOUND                   = 119;
    public static final int CODE_ABOVE_DAILY_LIMIT                    = 120;
    public static final int CODE_NOT_SUPPORTED                        = 121;
    public static final int CODE_INVALID_ADDRESS                      = 122;
    public static final int CODE_ORDER_NOT_FOUND                      = 126;
    public static final int CODE_ACCOUNT_PIN_INCORRECT                = 127;
    public static final int CODE_OAUTH_INVALID_TOKEN                  = 132;
    public static final int CODE_OAUTH_FORBIDDEN_TOKEN                = 133;
    public static final int CODE_ACCOUNT_PIN_EXISTS                   = 134;
    public static final int CODE_UNABLE_TO_APPROVE_REQUEST            = 149;
    public static final int CODE_INVALID_AMOUNT_CURRENCY              = 150;
    
    public User getUser() throws IOException, MaiCoinException;
    public Entity createAccountPin(String pin) throws IOException, MaiCoinException;
    public Entity updateAccountPin(String oldPin, String newPin) throws IOException, MaiCoinException;
    public Coin getBalance() throws IOException, MaiCoinException;
    public Address getReceiveAddress() throws IOException, MaiCoinException;
    public Addresses getAddresses() throws IOException, MaiCoinException;
    public Address generateReceiveAddress() throws IOException, MaiCoinException;
    public Price getPrice() throws IOException, MaiCoinException;
    public Price getPrice(Price.Currency currency) throws IOException, MaiCoinException;
    public Currencies getCurrencies() throws IOException, MaiCoinException;
    public Orders getOrders() throws IOException, MaiCoinException;
    public Orders getOrders(int page, int limit) throws IOException, MaiCoinException;
    public Order getOrder(String txid) throws IOException, MaiCoinException;
    public Order buyBtc(double amount) throws IOException, MaiCoinException;
    public Order buyOrder(double amount, String currency) throws IOException, MaiCoinException;
    public Order sellBtc(double amount) throws IOException, MaiCoinException;
    public Transactions getTransactions() throws IOException, MaiCoinException;
    public Transactions getTransactions(int page, int limit) throws IOException, MaiCoinException;
    public Transaction getTransaction(String txid) throws IOException, MaiCoinException;
    public Transaction sendTransaction(String address, double amount, String currency, String notes, String accountPin) throws IOException, MaiCoinException;
    public Transaction requestTransaction(String address, double amount, String currency, String notes) throws IOException, MaiCoinException;
    public Transaction cancelRequestTransaction(String txid) throws IOException, MaiCoinException;
    public Transaction approveRequestTransaction(String txid, String pin) throws IOException, MaiCoinException;
    public Checkout createCheckout(CheckoutParamBuilder builder) throws IOException, MaiCoinException;
    public Checkout getCheckout(String uid)  throws IOException, MaiCoinException;
    public Checkouts getCheckouts(int page, int limit) throws IOException, MaiCoinException;
}
