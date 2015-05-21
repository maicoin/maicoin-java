package com.maicoin.api.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.List;

/**
 * Created by yutelin on 9/26/14.
 */
public class ErrorResponse extends Entity{
    private int _code;
    private boolean _success;
    private List<String> _errors;
    private int _responseCode;

    public boolean isSuccess() {
        return _success;
    }

    public void setSuccess(boolean success) {
        this._success = success;
    }

    public List<String> getErrors() {
        return _errors;
    }

    public void setErrors(List<String> errors) {
        this._errors = errors;
    }

    public int getCode() {
        return _code;
    }

    public void setCode(int code) {
        this._code = code;
    }

    public int getResponseCode() {
        return _responseCode;
    }

    public void setResponseCode(int _responseCode) {
        this._responseCode = _responseCode;
    }
}
