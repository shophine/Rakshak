package com.example.shophine.rakshak;

import com.android.volley.VolleyError;

import java.util.List;

/**
 * Created by shophine on 7/1/18.
 */

public class NewsMiniEntity {
    int statusCode;
    String message;
    List<NewsEntity> response;

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<NewsEntity> getResponse() {
        return response;
    }

    public void setResponse(List<NewsEntity> response) {
        this.response = response;
    }

    public NewsMiniEntity() {

    }

    public NewsMiniEntity(int statusCode, String message, List<NewsEntity> response) {

        this.statusCode = statusCode;
        this.message = message;
        this.response = response;
    }

    public interface restInterface{
        void onRecieve(NewsMiniEntity entity, VolleyError error);
    }
}
