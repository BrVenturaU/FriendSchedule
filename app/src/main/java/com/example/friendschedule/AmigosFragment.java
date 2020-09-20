package com.example.friendschedule;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.Toast;

import com.example.friendschedule.Adapters.AmigosAdapter;
import com.example.friendschedule.Entities.Amigo;
import com.example.friendschedule.Interfaces.IAmigoService;
import com.example.friendschedule.Services.AmigoService;

import java.util.ArrayList;

public class AmigosFragment extends Fragment implements View.OnClickListener{

    private RecyclerView recyclerView;
    private AmigosAdapter amigosAdapter;
    private IAmigoService amigoService;
    private ArrayList<Amigo> amigos;
    private ScrollView scrollView;
    private Context context;
    public AmigosFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_amigos, container, false);
        context = getContext();
        recyclerView = view.findViewById(R.id.rvAmigos);
        scrollView = view.findViewById(R.id.layoutVacio);

        recyclerView.setLayoutManager(new LinearLayoutManager(context));

        amigoService = new AmigoService();
        amigos = amigoService.getAll(context);
        if(amigos == null)
            scrollView.setVisibility(View.VISIBLE);
        else{
            amigosAdapter = new AmigosAdapter();
            amigosAdapter.setData(amigos, amigoService);
            recyclerView.setAdapter(amigosAdapter);

            amigosAdapter.setOnclicListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int idAmigo = amigos.get(recyclerView.getChildAdapterPosition(view)).getId();
                    Intent intent = new Intent(context, InformacionAmigoActivity.class);
                    intent.putExtra("idAmigo", idAmigo);
                    startActivity(intent);
                    ((Activity)context).finish();
                }
            });
        }

        return view;
    }

    @Override
    public void onClick(View view) {

    }
}