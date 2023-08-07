package com.example.asmphp.adapters;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.asmphp.HomeActivity;
import com.example.asmphp.HomeFragment;
import com.example.asmphp.PhongTroFragment;
import com.example.asmphp.TintucFragment;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    private int mBehavior;
    private Context mContext;

    public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior, Context context) {
        super(fm, behavior);
        mBehavior = behavior;
        mContext = context;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new HomeFragment();
            case 1:
                return new TintucFragment();
            case 2:
                return new PhongTroFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}
