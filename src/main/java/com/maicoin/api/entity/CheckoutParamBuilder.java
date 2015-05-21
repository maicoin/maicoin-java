package com.maicoin.api.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yutelin on 1/12/15.
 */
public class CheckoutParamBuilder {

    private Checkout _checkout;
    private List<CheckoutItem> _items;

    public CheckoutParamBuilder() {
        _checkout = new Checkout();
        _items = new ArrayList<CheckoutItem>();
    }

    public CheckoutNode build(){
        _checkout.setItems(_items);
        CheckoutNode result = new CheckoutNode();
        result.setCheckout(_checkout);
        return result;
    }

    /**
     * Checkout Data
     */
    public void setCheckoutData(String amount, String currency, String returnUrl, String cancelUrl,
                                String callbackUrl, String refId, String posData, String locale){
        _checkout.setAmount(amount);
        _checkout.setCurrency(currency);
        _checkout.setReturnUrl(returnUrl);
        _checkout.setCancelUrl(cancelUrl);
        _checkout.setCallbackUrl(callbackUrl);
        _checkout.setMerchantRefId(refId);
        _checkout.setPosData(posData);
        _checkout.setLocale(locale);
    }

    /**
     * Checkout Buyer Data
     */
    public void setBuyerData(String name, String address1, String address2, String city,
                             String state, String zip, String email, String phone, String country){
        CheckoutBuyer buyer = new CheckoutBuyer();
        buyer.setBuyerName(name);
        buyer.setBuyerAddress1(address1);
        buyer.setBuyerAddress2(address2);
        buyer.setBuyerCity(city);
        buyer.setBuyerState(state);
        buyer.setBuyerZip(zip);
        buyer.setBuyerEmail(email);
        buyer.setBuyerPhone(phone);
        buyer.setBuyerCountry(country);
        _checkout.setBuyer(buyer);
    }

    /**
     * Checkout items
     */
    public void addItem(String description, String code, String price, String currency, boolean isPhysical){
        CheckoutItem item = new CheckoutItem();
        item.setDescription(description);
        item.setCode(code);
        item.setPrice(price);
        item.setCurrency(currency);
        item.setIsPhysical(Boolean.toString(isPhysical));
        _items.add(item);
    }
}
