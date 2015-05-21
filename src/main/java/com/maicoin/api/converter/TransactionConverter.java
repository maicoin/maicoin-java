package com.maicoin.api.converter;

import com.fasterxml.jackson.databind.util.StdConverter;
import com.maicoin.api.entity.Transaction;
import com.maicoin.api.entity.TransactionNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yutelin on 9/27/14.
 */
public class TransactionConverter extends StdConverter<List<TransactionNode>, List<Transaction>>{

    @Override
    public List<Transaction> convert(List<TransactionNode> nodes) {
        List<Transaction> result = new ArrayList<Transaction>();

        for (TransactionNode node : nodes) {
            result.add(node.getTransaction());
        }

        return result;
    }
}