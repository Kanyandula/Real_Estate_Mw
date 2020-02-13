package com.example.realestatemw;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

public class AgentHolder extends RecyclerView.ViewHolder {

    View mView;
    public  AgentHolder (View itemView){
        super(itemView);
        mView=itemView;
    }

    public void setCityName (String cityName){
        TextView textView_name = (TextView)mView.findViewById(R.id.city);
        textView_name.setText(cityName);
    }

    public void seTownName (String townName){
        TextView textView_name = (TextView)mView.findViewById(R.id.town);
        textView_name.setText(townName);
    }
    public void  setImageUrl (Context context,String imageUrl){
        ImageView imageView = (ImageView)mView.findViewById(R.id.image);
        Picasso.get().load(imageUrl).into(imageView);


    }



}
