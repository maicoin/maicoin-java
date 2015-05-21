package com.maicoin.api;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.joda.JodaModule;

import org.joda.money.CurrencyUnit;
import org.joda.money.Money;

/**
 * Created by yutelin on 9/26/14.
 */
public class ObjectMapperFactory {

    private static ObjectMapper _objectMapper = null ;

    public static ObjectMapper getObjectMapperInstance(){
        if(_objectMapper == null){
            synchronized (ObjectMapperFactory.class) {
                if(_objectMapper == null){
                    _objectMapper = new ObjectMapper();
                    _objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
                    _objectMapper.configure(SerializationFeature.INDENT_OUTPUT, false);
                    _objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                    _objectMapper.setPropertyNamingStrategy(PropertyNamingStrategy.CAMEL_CASE_TO_LOWER_CASE_WITH_UNDERSCORES);
                    _objectMapper.registerModule(new JodaModule());
                }
            }
        }
        return _objectMapper;
    }
    private ObjectMapperFactory(){
        //ignore
    }

}
