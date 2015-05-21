package com.maicoin.api.converter;

import com.fasterxml.jackson.databind.util.StdConverter;
import com.maicoin.api.entity.Address;
import com.maicoin.api.entity.AddressNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yutelin on 9/27/14.
 */
public class AddressConverter extends StdConverter<List<AddressNode>, List<Address>> {

    public List<Address> convert(List<AddressNode> nodes) {
        List<Address> result = new ArrayList<Address>();

        for (AddressNode node : nodes) {
            result.add(node.getAddress());
        }

        return result;
    }
}
