package com.moderncreation.gymotivate.gymotivateapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends ActionBarActivity implements ActionBar.TabListener {

    MotivatePagerFragment mPositiveMotivationFragment;
    MotivatePagerFragment mNegativeMotivationFragment;
    Fragment currentFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPositiveMotivationFragment = MotivatePagerFragment.newInstance("positive");
        mNegativeMotivationFragment = MotivatePagerFragment.newInstance("negative");

        // Set up the action bar.
        final ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        actionBar.addTab(
                actionBar.newTab()
                        .setText(R.string.positive_motivation)
                        .setTabListener(this)
        );
        actionBar.addTab(
                actionBar.newTab()
                        .setText(R.string.negative_motivation)
                        .setTabListener(this)
        );
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
        // When the given tab is selected, switch to the corresponding page in
        // the ViewPager.
        Fragment fragment = mPositiveMotivationFragment;

        if (tab.getPosition() == 1) {
            fragment = mNegativeMotivationFragment;
        }

        if (currentFragment != null)
            fragmentTransaction.detach(currentFragment);
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.attach(fragment);
        currentFragment = fragment;
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
    }
}
