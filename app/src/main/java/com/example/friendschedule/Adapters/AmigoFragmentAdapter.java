package com.example.friendschedule.Adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.friendschedule.AmigosFragment;
import com.example.friendschedule.FavoritosFragment;

public class AmigoFragmentAdapter extends FragmentStateAdapter {
    private static final int NUM_PAGES = 2;
    public AmigoFragmentAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:{
                return new AmigosFragment();
            }
            default:{
                return new FavoritosFragment();
            }
        }
    }

    @Override
    public int getItemCount() {
        return NUM_PAGES;
    }
}
