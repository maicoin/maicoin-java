package com.maicoin.api.converter;

import com.fasterxml.jackson.databind.util.StdConverter;
import com.maicoin.api.entity.CheckoutItem;
import com.maicoin.api.entity.CheckoutItemNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yutelin on 1/12/15.
 */
public class CheckoutItemConverter extends StdConverter<List<CheckoutItemNode>, List<CheckoutItem>> {

    @Override
    public List<CheckoutItem> convert(List<CheckoutItemNode> nodes) {
        List<CheckoutItem> result = new ArrayList<CheckoutItem>();

        for (CheckoutItemNode node : nodes) {
            result.add(node.getItem());
        }

        return result;
    }
}
