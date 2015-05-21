package com.maicoin.api.entity;

import java.math.BigDecimal;

/**
 * Created by yutelin on 9/26/14.
 */
public class Price extends Entity {
    public enum Currency{
        TWD("TWD"), USD("USD"), CNY("CNY");
        private final String currency;
        private Currency(String currency){
            this.currency = currency;
        }

        public String getValue(){
            return currency;
        }
    }

    private BigDecimal _sellPrice;
    private BigDecimal _buyPrice;
    private BigDecimal _price;
    private String _currency;

    public BigDecimal getSellPrice() {
        return _sellPrice;
    }

    public void setSellPrice(BigDecimal sellPrice) {
        this._sellPrice = sellPrice;
    }

    public BigDecimal getBuyPrice() {
        return _buyPrice;
    }

    public void setBuyPrice(BigDecimal buyPrice) {
        this._buyPrice = buyPrice;
    }

    public BigDecimal getPrice() {
        return _price;
    }

    public void setPrice(BigDecimal price) {
        this._price = price;
    }

    public String getCurrency() {
        return _currency;
    }

    public void setCurrency(String currency) {
        this._currency = currency;
    }

}
