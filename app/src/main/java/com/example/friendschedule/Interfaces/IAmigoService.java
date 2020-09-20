package com.example.friendschedule.Interfaces;

import android.content.Context;

import com.example.friendschedule.Entities.Amigo;

import java.util.ArrayList;

public interface IAmigoService {
    ArrayList<Amigo> getAll(Context context, Integer favorito);
    Amigo getById(Context context, Integer id);
    Amigo changeFavorite(Context context, Integer id, Integer favorito);
    Boolean delete(Context context, Integer id);
}
