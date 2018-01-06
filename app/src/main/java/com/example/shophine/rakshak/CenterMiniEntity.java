package com.example.shophine.rakshak;

import com.android.volley.VolleyError;

import java.util.List;

/**
 * Created by shophine on 6/1/18.
 */

public class CenterMiniEntity {
    private String message;
    private int statusCode;
    private List<Centres> response;

    public CenterMiniEntity(String message, int statusCode, List<Centres> response) {
        this.message = message;
        this.statusCode = statusCode;
        this.response = response;
    }

    public CenterMiniEntity() {
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

    public List<Centres> getResponse() {
        return response;
    }

    public void setResponse(List<Centres> response) {
        this.response = response;
    }

    public interface RestClientInterface {
        void onInitialize(CenterMiniEntity centres, VolleyError error);
    }
}
