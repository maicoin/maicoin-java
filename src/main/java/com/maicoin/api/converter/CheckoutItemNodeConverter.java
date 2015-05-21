package com.maicoin.api.converter;

import com.fasterxml.jackson.databind.util.StdConverter;
import com.maicoin.api.entity.CheckoutItem;
import com.maicoin.api.entity.CheckoutItemNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yutelin on 1/12/15.
 */
public class CheckoutItemNodeConverter extends StdConverter<List<CheckoutItem>, List<CheckoutItemNode>> {

    @Override
    public List<CheckoutItemNode> convert(List<CheckoutItem> items) {
        List<CheckoutItemNode> result = new ArrayList<CheckoutItemNode>();

        for (CheckoutItem item : items) {
            CheckoutItemNode node = new CheckoutItemNode();
            node.setItem(item);
            result.add(node);
        }

        return result;
    }
}
