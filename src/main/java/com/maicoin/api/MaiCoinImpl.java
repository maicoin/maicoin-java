package com.maicoin.api;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.maicoin.api.entity.Address;
import com.maicoin.api.entity.Addresses;
import com.maicoin.api.entity.Checkout;
import com.maicoin.api.entity.CheckoutNode;
import com.maicoin.api.entity.CheckoutParamBuilder;
import com.maicoin.api.entity.Checkouts;
import com.maicoin.api.entity.Coin;
import com.maicoin.api.entity.Currencies;
import com.maicoin.api.entity.Entity;
import com.maicoin.api.entity.ErrorResponse;
import com.maicoin.api.entity.Order;
import com.maicoin.api.entity.OrderNode;
import com.maicoin.api.entity.Orders;
import com.maicoin.api.entity.Price;
import com.maicoin.api.entity.Request;
import com.maicoin.api.entity.Transaction;
import com.maicoin.api.entity.TransactionNode;
import com.maicoin.api.entity.Transactions;
import com.maicoin.api.entity.User;
import com.maicoin.api.entity.UserNode;
import com.maicoin.api.exception.MaiCoinException;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/**
 * Created by yutelin on 9/25/14.
 */
public class MaiCoinImpl implements MaiCoin {
    private String _apiKey;
    private String _apiSecret;
    private URL _baseUrl;
    private String _accessToken;

    private static final ObjectMapper objectMapper = ObjectMapperFactory.getObjectMapperInstance();


    MaiCoinImpl(MaiCoinBuilder builder){
        _apiKey = builder.apiKey;
        _apiSecret = builder.apiSecret;
        _baseUrl = builder.baseUrl;
        _accessToken = builder.accessToken;
    }

    public String toString() {
        //@TODO: change this
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

    /***********************************************************************************************
     * API
     ***********************************************************************************************/
    @Override
    public User getUser() throws IOException, MaiCoinException {
        URL url = new URL(_baseUrl, "user");
        UserNode result = deserialize(doHttp(url, "GET", null), UserNode.class);
        return result != null ? result.getUser() : null;
    }

    @Override
    public Entity createAccountPin(String pin) throws IOException, MaiCoinException {
        URL url = new URL(_baseUrl, "user/account_pin");
        Request request = new Request();
        request.setPin(pin);
        Entity result = deserialize(doHttp(url, "POST", request), Entity.class);
        return result;
    }

    @Override
    public Entity updateAccountPin(String oldPin, String newPin) throws IOException, MaiCoinException {
        URL url = new URL(_baseUrl, "user/account_pin");
        Request request = new Request();
        request.setOldPin(oldPin);
        request.setNewPin(newPin);
        Entity result = deserialize(doHttp(url, "PUT", request), Entity.class);
        return result;
    }

    @Override
    public Coin getBalance() throws IOException, MaiCoinException {
        URL url = new URL(_baseUrl, "account/balance");
        Coin result = deserialize(doHttp(url, "GET", null), Coin.class);
        return result;
    }

    @Override
    public Address getReceiveAddress() throws IOException, MaiCoinException {
        return getReceiveAddress("btc");
    }

    private Address getReceiveAddress(String currency) throws IOException, MaiCoinException {
        URL url = new URL(_baseUrl, "account/receive_address/"+currency);
        Address result = deserialize(doHttp(url, "GET", null), Address.class);
        return result;
    }

    @Override
    public Addresses getAddresses() throws IOException, MaiCoinException {
        return getAddresses("btc");
    }

    private Addresses getAddresses(String currency) throws IOException, MaiCoinException {
        URL url = new URL(_baseUrl, "account/addresses/"+currency);
        Addresses result = deserialize(doHttp(url, "GET", null), Addresses.class);
        return result;
    }

    @Override
    public Address generateReceiveAddress() throws IOException, MaiCoinException {
        return generateReceiveAddress("btc");
    }

    private Address generateReceiveAddress(String currency) throws IOException, MaiCoinException {
        URL url = new URL(_baseUrl, "account/receive_address");
        Request request = new Request();
        request.setCurrency(currency);
        Address result = deserialize(doHttp(url, "POST", request), Address.class);
        return result;
    }

    @Override
    public Price getPrice() throws IOException, MaiCoinException {
        return getPrice(Price.Currency.TWD);
    }

    @Override
    public Price getPrice(Price.Currency currency) throws IOException, MaiCoinException {
        URL url = new URL(_baseUrl, "prices/" + currency.getValue());
        Price result = deserialize(doHttp(url, "GET", null), Price.class);
        return result;
    }

    @Override
    public Currencies getCurrencies() throws IOException, MaiCoinException {
        URL url = new URL(_baseUrl, "currencies");
        Currencies result = deserialize(doHttp(url, "GET", null), Currencies.class);
        return result;
    }

    @Override
    public Orders getOrders() throws IOException, MaiCoinException {
        return getOrders(1, 25);
    }

    @Override
    public Orders getOrders(int page, int limit) throws IOException, MaiCoinException {
        URL url = new URL(_baseUrl, "orders?page="+page+"&limit="+limit);
        Orders result = deserialize(doHttp(url, "GET", null), Orders.class);
        return result;
    }

    @Override
    public Order getOrder(String txid) throws IOException, MaiCoinException {
        URL url = new URL(_baseUrl, "orders/" + txid);
        OrderNode result = deserialize(doHttp(url, "GET", null), OrderNode.class);
        return result!=null? result.getOrder() : null;
    }

    @Override
    public Order buyBtc(double amount) throws IOException, MaiCoinException {
        return buyOrder(amount, "btc");
    }

    @Override
    public Order buyOrder(double amount, String currency) throws IOException, MaiCoinException{
        URL url = new URL(_baseUrl, "orders");
        Request request = new Request();
        request.setAmount(amount);
        request.setType("buy");
        request.setCurrency(currency);
        OrderNode result = deserialize(doHttp(url, "POST", request), OrderNode.class);
        return result != null ? result.getOrder() : null;
    }

    @Override
    public Order sellBtc(double amount) throws IOException, MaiCoinException {
        URL url = new URL(_baseUrl, "orders");
        Request request = new Request();
        request.setAmount(amount);
        request.setType("sell");
        OrderNode result = deserialize(doHttp(url, "POST", request), OrderNode.class);
        return result != null ? result.getOrder() : null;
    }

    @Override
    public Transactions getTransactions() throws IOException, MaiCoinException {
        return getTransactions(1, 25);
    }

    @Override
    public Transactions getTransactions(int page, int limit) throws IOException, MaiCoinException {
        URL url = new URL(_baseUrl, "transactions?page="+page+"&limit="+limit);
        Transactions result = deserialize(doHttp(url, "GET", null), Transactions.class);
        return result;
    }

    @Override
    public Transaction getTransaction(String txid) throws IOException, MaiCoinException {
        URL url = new URL(_baseUrl, "transactions/" + txid);
        TransactionNode result = deserialize(doHttp(url, "GET", null), TransactionNode.class);
        return result!=null? result.getTransaction() : null;
    }

    @Override
    public Transaction sendTransaction(String address, double amount, String currency, String notes, String pin) throws IOException, MaiCoinException {
        URL url = new URL(_baseUrl, "transactions");
        Request request = new Request();
        request.setType("send");
        request.setAmount(amount);
        request.setCurrency(currency);
        request.setAddress(address);
        request.setNotes(notes);
        request.setAccountPin(pin);
        TransactionNode result = deserialize(doHttp(url, "POST", request), TransactionNode.class);
        return result!=null? result.getTransaction() : null;
    }

    @Override
    public Transaction requestTransaction(String address, double amount, String currency, String notes) throws IOException, MaiCoinException {
        URL url = new URL(_baseUrl, "transactions");
        Request request = new Request();
        request.setType("request");
        request.setAmount(amount);
        request.setAddress(address);
        request.setCurrency(currency);
        request.setNotes(notes);
        TransactionNode result = deserialize(doHttp(url, "POST", request), TransactionNode.class);
        return result!=null? result.getTransaction() : null;
    }

    @Override
    public Transaction cancelRequestTransaction(String txid) throws IOException, MaiCoinException {
        URL url = new URL(_baseUrl, "transactions/" + txid );
        TransactionNode result = deserialize(doHttp(url, "DELETE", null), TransactionNode.class);
        return result!=null? result.getTransaction() : null;
    }

    @Override
    public Transaction approveRequestTransaction(String txid, String pin) throws IOException, MaiCoinException {
        URL url = new URL(_baseUrl, "transactions/" + txid + "/approve");
        Request request = new Request();
        request.setAccountPin(pin);
        TransactionNode result = deserialize(doHttp(url, "PUT", request), TransactionNode.class);
        return result!=null? result.getTransaction() : null;
    }

    @Override
    public Checkout createCheckout(CheckoutParamBuilder builder) throws IOException, MaiCoinException {
        URL url = new URL(_baseUrl, "checkouts");
        CheckoutNode result = deserialize(doHttp(url, "POST", builder.build()), CheckoutNode.class);
        return result!=null? result.getCheckout() : null;
    }

    @Override
    public Checkout getCheckout(String uid) throws IOException, MaiCoinException {
        URL url = new URL(_baseUrl, "checkouts/" + uid);
        CheckoutNode result = deserialize(doHttp(url, "GET", null), CheckoutNode.class);
        return result!=null? result.getCheckout() : null;
    }

    @Override
    public Checkouts getCheckouts(int page, int limit) throws IOException, MaiCoinException {
        URL url = new URL(_baseUrl, "checkouts?page="+page+"&limit="+limit);
        Checkouts result = deserialize(doHttp(url, "GET", null), Checkouts.class);
        return result;
    }

    /***********************************************************************************************
     * Http
     ***********************************************************************************************/
    private String doHttp(URL url, String method, Object requestBody) throws IOException, MaiCoinException {
        URLConnection urlConnection = url.openConnection();
        HttpURLConnection conn = (HttpURLConnection)urlConnection;
        conn.setRequestMethod(method);

        String body = null;
        if (requestBody != null) {
            body = objectMapper.writeValueAsString(requestBody);
            //System.out.println("body = " + body);
            conn.setRequestProperty("Content-Type", "application/json");
        }

        if (_apiKey != null && _apiSecret != null) {
            doHmacAuthentication(url, body, conn);
        }
        else if (_accessToken != null) {
            doAccessTokenAuthentication(conn);
        }

        if (body != null) {
            conn.setDoOutput(true);
            OutputStream outputStream = conn.getOutputStream();
            try {
                outputStream.write(body.getBytes(Charset.forName("UTF-8")));
            } finally {
                outputStream.close();
            }
        }

        InputStream is = null;
        InputStream es = null;
        try {
            is = conn.getInputStream();
            String result = IOUtils.toString(is, "UTF-8");
            return result;
        } catch (IOException e) {
            es = conn.getErrorStream();
            ErrorResponse response = null;
            String errorMessage = null;
            if (es != null) {
                errorMessage = IOUtils.toString(es, "UTF-8");
                response = deserialize(errorMessage, ErrorResponse.class);
                response.setResponseCode(conn.getResponseCode());
            }
            //Handling errors
            if (response != null){
                throw new MaiCoinException(response);
            } else {
                throw e;
            }
        } finally {
            if (is != null) {
                is.close();
            }
            if (es != null) {
                es.close();
            }
        }
    }

    /***********************************************************************************************
     * Authentication
     ***********************************************************************************************/
    private void doHmacAuthentication (URL url, String body, HttpURLConnection conn) throws IOException {
        String nonce = String.valueOf(System.currentTimeMillis()*1000);
        String message = nonce + url.toString() + (body != null ? body : "");
        Mac mac = null;
        try {
            mac = Mac.getInstance("HmacSHA256");
            mac.init(new SecretKeySpec(_apiSecret.getBytes(), "HmacSHA256"));
        } catch (Throwable t) {
            throw new IOException(t);
        }
        String signature = new String(Hex.encodeHex(mac.doFinal(message.getBytes())));
        conn.setRequestProperty("ACCESS_KEY", _apiKey);
        conn.setRequestProperty("ACCESS_SIGNATURE", signature);
        conn.setRequestProperty("ACCESS_NONCE", nonce);
    }

    private void doAccessTokenAuthentication(HttpURLConnection conn) {
        conn.setRequestProperty("AUTHORIZATION", "Bearer " + _accessToken);
    }

    /***********************************************************************************************
     * Serialization
     ***********************************************************************************************/
    private static <T> T deserialize(String json, Class<T> clazz) throws IOException {
        return objectMapper.readValue(json, clazz);
    }
    private static <T> T deserialize(String json, TypeReference typeReference) throws IOException {
        return objectMapper.readValue(json, typeReference);
    }
}
