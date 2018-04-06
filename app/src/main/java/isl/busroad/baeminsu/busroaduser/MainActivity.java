package isl.busroad.baeminsu.busroaduser;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private TextView affiliation;
    private ViewPager viewPager;
    private Toolbar toolbar;
    private MainTabPagerAdapter mainTabPagerAdapter;


    private MainTab1 mTabFragment1;
    private MainTab2 mTabFragment2;
    int type;
    PropertyManager propertyManager = PropertyManager.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        final String getAff = intent.getStringExtra("affiliation");


        affiliation = (TextView) findViewById(R.id.affiliation);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        affiliation.setText(getAff);





        tabLayout.setupWithViewPager(viewPager);
        setTabViewPager(viewPager);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });


    }


    private void setTabViewPager(ViewPager viewPager) {
        mainTabPagerAdapter = new MainTabPagerAdapter(getSupportFragmentManager());
        mTabFragment1 = MainTab1.newInstance();
        mTabFragment2 = MainTab2.newInstance();
        mainTabPagerAdapter.addFragment(mTabFragment1);
        mainTabPagerAdapter.addFragment(mTabFragment2);
        viewPager.setAdapter(mainTabPagerAdapter);

    }
}
