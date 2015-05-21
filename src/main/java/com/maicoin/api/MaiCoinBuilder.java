package com.maicoin.api;

import java.net.URL;

/**
 * Created by yutelin on 9/25/14.
 */
public class MaiCoinBuilder {
    String apiKey;
    String apiSecret;
    URL baseUrl;
    String accessToken;

    public MaiCoin build(){
        return new MaiCoinImpl(this);
    }

    public MaiCoinBuilder setApiKey(String apiKey, String apiSecret){
        this.apiKey = apiKey;
        this.apiSecret = apiSecret;
        return this;
    }

    public MaiCoinBuilder setBaseUrl(URL baseUrl){
        this.baseUrl = baseUrl;
        return this;
    }

    public MaiCoinBuilder setAccessToken(String accessToken){
        this.accessToken = accessToken;
        return this;
    }


}
