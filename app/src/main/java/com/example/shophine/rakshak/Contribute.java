package com.example.shophine.rakshak;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.VolleyError;

import java.util.ArrayList;
import java.util.List;

public class Contribute extends Fragment {

    RecyclerView rvNews;
    NewsMiniEntity entity;
    List<NewsEntity> newsList;
    NewsAdapter adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.contribute, container, false);
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        newsList = new ArrayList<>();
        /*RestClientImplementation.getNews(entity, new NewsMiniEntity.restInterface() {
            @Override
            public void onRecieve(NewsMiniEntity entity, VolleyError error) {
                if(error == null){
                    newsList = entity.getResponse();
                }
            }
        },getContext());
        adapter = new NewsAdapter(newsList);
        rvNews = (RecyclerView) v.findViewById(R.id.rvNews);
        rvNews.setLayoutManager(manager);
        rvNews.setAdapter(adapter);*/
        return v;
    }
}
