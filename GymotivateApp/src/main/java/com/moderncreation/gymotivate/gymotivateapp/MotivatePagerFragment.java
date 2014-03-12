package com.moderncreation.gymotivate.gymotivateapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.moderncreation.gymotivate.models.MotivateImage;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by xsun on 3/11/14.
 */
public class MotivatePagerFragment extends Fragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_TITLE = "title";

    protected List<MotivateImage> mMotivateImages;

    @InjectView(R.id.pager)
    protected ViewPager mViewPager;

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static MotivatePagerFragment newInstance(String title) {
        MotivatePagerFragment fragment = new MotivatePagerFragment();
        Bundle args = new Bundle();
        args.putString(ARG_TITLE, title);
        fragment.setArguments(args);
        return fragment;
    }

    public MotivatePagerFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.inject(this, rootView);

        Bundle args = getArguments();
        String title = args.getString(ARG_TITLE);
        mMotivateImages = new ArrayList<MotivateImage>();
        if(title.equals("positive")) {
            mMotivateImages.add(new MotivateImage("positive1", "http://1.bp.blogspot.com/_VmZpep1KUeg/TT-WoNET6uI/AAAAAAAAAHE/AXzw5HpqQUY/s1600/cute-dog2.jpg"));
            mMotivateImages.add(new MotivateImage("positive2", "http://images2.fanpop.com/image/photos/13900000/Cute-Dog-Wallpaper-dogs-13936376-1024-768.jpg"));
            mMotivateImages.add(new MotivateImage("positive3", "http://www.myawesomepic.com/wp-content/uploads/2013/01/dog1.jpg"));
        } else {
            mMotivateImages.add(new MotivateImage("negative1", "http://4.bp.blogspot.com/-MzZCzWI_6Xc/UIUQp1qPfzI/AAAAAAAAHpA/OTwHCJSWFAY/s1600/cats_animals_kittens_cat_kitten_cute_desktop_1680x1050_hd-wallpaper-753974.jpeg"));
            mMotivateImages.add(new MotivateImage("negative2", "http://jasonlefkowitz.net/wp-content/uploads/2013/07/Cute-Cats-cats-33440930-1280-800.jpg"));
            mMotivateImages.add(new MotivateImage("negative3", "http://cdn.cutestpaw.com/wp-content/uploads/2011/11/Halloween-l.jpg"));
        }

        FragmentManager fm = getChildFragmentManager();
        mViewPager.setAdapter(new FragmentStatePagerAdapter(fm) {
            @Override
            public Fragment getItem(int position) {
                MotivateImage motivateImage = mMotivateImages.get(position);
                return MotivatePageFragment.newInstance(motivateImage);
            }

            @Override
            public int getCount() {
                return mMotivateImages.size();
            }
        });

        return rootView;
    }
}
