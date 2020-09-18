package com.example.friendschedule.Adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.friendschedule.Entities.Amigo;
import com.example.friendschedule.Interfaces.IAmigoService;

import java.util.ArrayList;

public class AmigosAdapter extends RecyclerView.Adapter<AmigosAdapter.ViewHolder> implements View.OnClickListener {

    private Context context;
    private ArrayList<Amigo> amigos;
    private IAmigoService amigoService;
    private View.OnClickListener listener;

    public AmigosAdapter() {
    }

    public void setData(ArrayList<Amigo> list, IAmigoService service){
        amigos = list;
        amigoService = service;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    @Override
    public void onClick(View view) {

    }
}
