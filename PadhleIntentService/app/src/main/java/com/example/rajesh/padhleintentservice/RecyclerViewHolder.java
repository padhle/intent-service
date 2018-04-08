package com.example.rajesh.padhleintentservice;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class RecyclerViewHolder extends RecyclerView.ViewHolder {
    CardView card;
    TextView text_title;
    TextView text_description;
    TextView text_language;
    TextView text_stargazer;
    TextView text_watcher;
    ImageView image_background;

    public RecyclerViewHolder(View itemView) {
        super(itemView);

        card=itemView.findViewById(R.id.card);
        text_title=itemView.findViewById(R.id.text_title);
        text_description=itemView.findViewById(R.id.text_description);
        text_language=itemView.findViewById(R.id.text_language);
        text_stargazer=itemView.findViewById(R.id.text_stargazer);
        text_watcher=itemView.findViewById(R.id.text_watcher);
        image_background=itemView.findViewById(R.id.image_background);

    }
}