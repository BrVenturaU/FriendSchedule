package com.example.friendschedule.Utils;

import androidx.recyclerview.widget.DiffUtil;

import com.example.friendschedule.Entities.Amigo;

import java.util.ArrayList;

public class DiffData extends DiffUtil.Callback {

    private ArrayList<Amigo> oldList;
    private ArrayList<Amigo> newList;

    public DiffData(ArrayList<Amigo> oldList, ArrayList<Amigo> newList) {
        this.oldList = oldList;
        this.newList = newList;
    }

    @Override
    public int getOldListSize() {
        return oldList.size();
    }

    @Override
    public int getNewListSize() {
        return newList.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return oldItemPosition == newItemPosition;
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        return oldList.get(oldItemPosition) == newList.get(newItemPosition);
    }
}
