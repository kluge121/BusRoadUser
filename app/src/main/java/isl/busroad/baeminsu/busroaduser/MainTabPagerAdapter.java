package isl.busroad.baeminsu.busroaduser;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

/**
 * Created by baeminsu on 2017. 10. 11..
 */

public class MainTabPagerAdapter extends FragmentStatePagerAdapter {

    private final ArrayList<Fragment> mainListFragment = new ArrayList<Fragment>();
    private String tabTitle[] = new String[]{"공지사항", "노선정보", "운행", "설정"};


    public MainTabPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return mainListFragment.get(position);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitle[position];
    }


    @Override
    public int getCount() {
        return mainListFragment.size();
    }

    public void addFragment(MainTab1 fragment1) {
        mainListFragment.add(fragment1);
    }

    public void addFragment(MainTab2 fragment2) {
        mainListFragment.add(fragment2);
    }

}