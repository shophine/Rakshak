package com.example.shophine.rakshak;

import com.android.volley.VolleyError;

import java.util.List;

/**
 * Created by shophine on 7/1/18.
 */

public class RegionMiniEntity {
    private String message;
    private int statusCode;
    private List<Region> response;

    public RegionMiniEntity(String message, int statusCode, List<Region> response) {
        this.message = message;
        this.statusCode = statusCode;
        this.response = response;
    }

    public RegionMiniEntity() {
    }

    public RegionMiniEntity(int statusCode) {
        this.statusCode = statusCode;
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

    public List<Region> getResponse() {
        return response;
    }

    public void setResponse(List<Region> response) {
        this.response = response;
    }
    public interface RestClientInterface {
        void onInitialize(RegionMiniEntity centres, VolleyError error);
    }
}
