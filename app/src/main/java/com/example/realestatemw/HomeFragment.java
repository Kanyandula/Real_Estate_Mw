package com.example.realestatemw;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerAdapter_LifecycleAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.EventListener;

public class HomeFragment extends Fragment   {

    private RecyclerView recyclerView;
    private DatabaseReference mDatabase;
    private FirebaseDatabase database;




    FirebaseRecyclerAdapter<Agent,AgentHolder> firebaseRecyclerAdapter;

    public View onCreateView (@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.home_fragment, container, false);
        //1. get a reference to recyclerView
        recyclerView = (RecyclerView)view.findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        // 2. set layoutManger
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));





        FirebaseRecyclerOptions<Agent> options = new FirebaseRecyclerOptions.Builder<Agent>()
                .setQuery(FirebaseDatabase.getInstance().getReference().child("Buy"),Agent.class)
                .build();

        firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<Agent, AgentHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull AgentHolder holder, int position, @NonNull Agent model) {
                holder.setCityName(model.getCityName());
                holder.seTownName(model.getTownMame());
                holder.setImageUrl(holder.mView.getContext(), model.getImageUrl());

            }

            @NonNull
            @Override
            public AgentHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

                View view1 = LayoutInflater.from(parent.getContext()).inflate(R.layout.individual_row,parent,
                        false);

                return new AgentHolder(view1);
            }
        };


recyclerView.setAdapter(firebaseRecyclerAdapter);

        return view;

    }
    protected void  onResune(){
        super.onResume();
        // Start listening to get recipes from firebase
        firebaseRecyclerAdapter.startListening();
    }

    public void onDestroy(){
        super.onDestroy();
        // Stop listening when the user gets out of the app.
        firebaseRecyclerAdapter.stopListening();
    }

}
