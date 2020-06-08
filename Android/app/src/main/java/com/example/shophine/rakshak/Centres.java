package com.example.shophine.rakshak;

import com.android.volley.VolleyError;
import com.google.android.gms.maps.model.LatLng;

/**
 * Created by shophine on 6/1/18.
 */

public class Centres {
    private int id;
    private String name;

    public Centres() {
    }

    public Centres(int id, String name) {
        this.id = id;
        this.name = name;
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
}
