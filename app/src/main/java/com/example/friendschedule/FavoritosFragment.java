package com.example.friendschedule;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;

import com.example.friendschedule.Adapters.AmigosAdapter;
import com.example.friendschedule.Entities.Amigo;
import com.example.friendschedule.Interfaces.IAmigoService;
import com.example.friendschedule.Services.AmigoService;

import java.util.ArrayList;

public class FavoritosFragment extends Fragment {

    private RecyclerView recyclerView;
    private AmigosAdapter amigosAdapter;
    private IAmigoService amigoService;
    private ArrayList<Amigo> amigos;
    private ScrollView scrollView;

    public FavoritosFragment() {
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
        View view = inflater.inflate(R.layout.fragment_favoritos, container, false);

        recyclerView = view.findViewById(R.id.rvAmigos);
        scrollView = view.findViewById(R.id.layoutVacio);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        amigoService = new AmigoService();
        amigos = amigoService.listOfAmigos(getContext(), 1);
        if(amigos == null)
            scrollView.setVisibility(View.VISIBLE);
        else{
            amigosAdapter = new AmigosAdapter();
            amigosAdapter.setData(amigos, amigoService);
            recyclerView.setAdapter(amigosAdapter);
        }

        return view;
    }
}