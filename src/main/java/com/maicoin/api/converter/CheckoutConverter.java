package com.maicoin.api.converter;

import com.fasterxml.jackson.databind.util.StdConverter;
import com.maicoin.api.entity.Checkout;
import com.maicoin.api.entity.CheckoutNode;
import com.maicoin.api.entity.Transaction;
import com.maicoin.api.entity.TransactionNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yutelin on 1/12/15.
 */
public class CheckoutConverter extends StdConverter<List<CheckoutNode>, List<Checkout>>{

    @Override
    public List<Checkout> convert(List<CheckoutNode> nodes) {
        List<Checkout> result = new ArrayList<Checkout>();

        for (CheckoutNode node : nodes) {
            result.add(node.getCheckout());
        }

        return result;
    }
}
