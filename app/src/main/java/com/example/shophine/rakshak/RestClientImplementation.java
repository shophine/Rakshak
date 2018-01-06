package com.example.shophine.rakshak;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by shophine on 6/1/18.
 */

public class RestClientImplementation  {

    public static RequestQueue queue;
    public static String url,predictedPrice;
    public static void getLocation(final CenterMiniEntity centre, final CenterMiniEntity.RestClientInterface restClientInterface, final Context context){
        queue = VolleySingleton.getInstance(context).getRequestQueue();
        url = "http://172.16.48.39:7777/api/web/location";
        JsonBaseRequest request = new JsonBaseRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                CenterMiniEntity centerMiniEntity = new CenterMiniEntity();
                Gson gson = new Gson();

                centerMiniEntity=gson.fromJson(response.toString(),CenterMiniEntity.class);
                centre.setMessage(centerMiniEntity.getMessage());
                centre.setResponse(centerMiniEntity.getResponse());
                centre.setStatusCode(centerMiniEntity.getStatusCode());
                restClientInterface.onInitialize(centre,null);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context,""+error.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
        queue.add(request);
    }

    public static void getPrediction(final PriceEntity priceEntity,final PriceEntity.PriceEntityInterface priceEntityInterface,final Context context){

        queue=VolleySingleton.getInstance(context).getRequestQueue();
        url = "http://172.16.48.39:7777/api/web/price";
        JSONObject param = priceEntity.getJsonObjectAsParams();
        JsonBaseRequest request=new JsonBaseRequest(Request.Method.POST, url, param, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    predictedPrice=response.getString("response");
                    priceEntityInterface.onPredicted(predictedPrice,null);
                    Log.v("predicted Price: ",predictedPrice);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });


        queue.add(request);

    }

}