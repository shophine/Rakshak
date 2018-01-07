package com.example.shophine.rakshak;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shophine on 7/1/18.
 */


public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {
    List<NewsEntity> newsList = new ArrayList<>();
    NewsEntity news;
    public NewsAdapter(List<NewsEntity> list){
        newsList = list;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cards,parent,false);
        ViewHolder h = new ViewHolder(v);
        return h;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        news = newsList.get(position);
        holder.headline.setText(news.getHeadline());
        holder.headline.setText(news.getContent());
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView headline;
        TextView content;
        public ViewHolder(View itemView) {
            super(itemView);
            headline = (TextView) itemView.findViewById(R.id.headline);
            content = (TextView) itemView.findViewById(R.id.content);
        }
    }
}
