package com.code4rox.calculatorfox;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.zip.Inflater;

public class MenuAdapter extends RecyclerView.Adapter {
    @NonNull
    @Override
    public MenuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.gridview,parent,false);
        MenuViewHolder vh=new MenuViewHolder(v);

        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public  class MenuViewHolder extends RecyclerView.ViewHolder{

        Button btn,btn1;
        public MenuViewHolder(@NonNull View itemView) {
            super(itemView);
             btn=(Button) itemView.findViewById(R.id.btn_pagerview);
             btn1=(Button) itemView.findViewById(R.id.btn_counter);
        }
    }
}
