package com.example.shophine.rakshak;

import com.android.volley.VolleyError;
import com.google.android.gms.maps.model.LatLng;

/**
 * Created by shophine on 6/1/18.
 */

public class Centres {
    private int id;
    private String name;
    private String latitude;
    private String longitude;

    public Centres() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public Centres(int id, String name, String latitude, String longitude) {
        this.id = id;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }

}
