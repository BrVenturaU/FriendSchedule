package com.example.friendschedule.Interfaces;

import android.content.Context;

import com.example.friendschedule.Entities.Amigo;

import java.util.ArrayList;

public interface IAmigoService {
    ArrayList<Amigo> listOfAmigos(Context context);
}
