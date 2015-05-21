package com.maicoin.api.exception;

import com.maicoin.api.entity.ErrorResponse;

import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * Created by yutelin on 9/26/14.
 */
public class MaiCoinException extends Exception {

    private ErrorResponse _response;

    private MaiCoinException(){}

    public MaiCoinException(ErrorResponse response) {
        super(StringUtils.join(response.getErrors()));
        this._response = response;
    }

    public int getCode(){
        return _response.getCode();
    }

    public List<String> getErrors(){
        return _response.getErrors();
    }

}
