package com.example.rajesh.padhleintentservice;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;



public class JakeAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {

    ArrayList<JakeWhartonDataEntity> _dataArray;
    Context context;
    LayoutInflater inflater;


    public JakeAdapter(Context context,ArrayList<JakeWhartonDataEntity> _dataArray)
    {
        this.context=context;
        this._dataArray=_dataArray;
        inflater = LayoutInflater.from(context);
    }



    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.item_wharton_entity, parent, false);

        RecyclerViewHolder viewHolder = new RecyclerViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {

        JakeWhartonDataEntity _data=_dataArray.get(position);

        holder.text_title.setText(_data.getName());
        holder.text_description.setText(_data.getDescription());

        holder.text_language.setText(_data.getLanguage());
        holder.text_stargazer.setText(String.valueOf(_data.getStargazers_count()));

        holder.text_watcher.setText(String.valueOf(_data.getWatchers_count()));

    }

    @Override
    public int getItemCount() {
        return _dataArray.size();
    }
}
