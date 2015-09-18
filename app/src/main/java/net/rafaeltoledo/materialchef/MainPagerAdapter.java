package net.rafaeltoledo.materialchef;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class MainPagerAdapter extends FragmentPagerAdapter {

    public MainPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) return new RecyclerViewFragment();
        return new StuffFragment();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) return "List";
        return "Stuff";
    }

    @Override
    public int getCount() {
        return 2;
    }
}
