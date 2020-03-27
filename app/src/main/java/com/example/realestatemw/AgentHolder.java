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
public void setCity (String city){
        TextView textCity = (TextView)mView.findViewById(R.id.city);
        textCity.setText(city);

}
public void setTown (String town){
        TextView textTown =(TextView)mView.findViewById(R.id.town);
        textTown.setText(town);
}



    public void setImage(Context context, String image) {
        ImageView imageView =(ImageView)mView.findViewById(R.id.image);
        Picasso.get().load(image).into(imageView);
    }
}
