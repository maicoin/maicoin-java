package com.maicoin.api.entity;

/**
 * Created by yutelin on 12/23/14.
 */
public class MaicoinBankInformation extends Entity {
    private String _maicoinBankCode;
    private String _maicoinBankAccountName;
    private String _maicoinBankAccountNumber;

    public String getMaicoinBankCode() {
        return _maicoinBankCode;
    }

    public void setMaicoinBankCode(String _maicoinBankCode) {
        this._maicoinBankCode = _maicoinBankCode;
    }

    public String getMaicoinBankAccountName() {
        return _maicoinBankAccountName;
    }

    public void setMaicoinBankAccountName(String _maicoinBankAccountName) {
        this._maicoinBankAccountName = _maicoinBankAccountName;
    }

    public String getMaicoinBankAccountNumber() {
        return _maicoinBankAccountNumber;
    }

    public void setMaicoinBankAccountNumber(String _maicoinBankAccountNumber) {
        this._maicoinBankAccountNumber = _maicoinBankAccountNumber;
    }
}
