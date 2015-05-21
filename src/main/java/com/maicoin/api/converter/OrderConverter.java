package com.maicoin.api.converter;

import com.fasterxml.jackson.databind.util.StdConverter;
import com.maicoin.api.entity.Order;
import com.maicoin.api.entity.OrderNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yutelin on 9/26/14.
 */
public class OrderConverter extends StdConverter<List<OrderNode>, List<Order>> {

    public List<Order> convert(List<OrderNode> nodes) {
        List<Order> result = new ArrayList<Order>();

        for (OrderNode node : nodes) {
            result.add(node.getOrder());
        }

        return result;
    }
}
