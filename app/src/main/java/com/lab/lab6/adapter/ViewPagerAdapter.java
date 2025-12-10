package com.lab.lab6.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.lab.lab6.Dashboard;
import com.lab.lab6.HomeFragment;
import com.lab.lab6.Settings;

public class ViewPagerAdapter extends FragmentStateAdapter {

    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity){
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 1:
                return new Dashboard();
            case 2:
                return new Settings();
            default:
                return new HomeFragment();
        }
    }


    @Override
    public int getItemCount() {
        return 3;
    }
}
