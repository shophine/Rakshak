package com.example.shophine.rakshak;

import com.android.volley.VolleyError;

import java.util.List;

/**
 * Created by shophine on 6/1/18.
 */

public class CommodityMiniEntity {
    private String message;
    private int statusCode;
    private List<Commodity> response;

    public CommodityMiniEntity(String message, int statusCode, List<Commodity> response) {
        this.message = message;
        this.statusCode = statusCode;
        this.response = response;
    }

    public CommodityMiniEntity() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public List<Commodity> getResponse() {
        return response;
    }

    public void setResponse(List<Commodity> response) {
        this.response = response;
    }
    public interface RestClientInterface {
        void onInitialize(CommodityMiniEntity centres, VolleyError error);
    }
}
