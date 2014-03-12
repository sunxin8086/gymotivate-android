package com.moderncreation.gymotivate.gymotivateapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.toolbox.NetworkImageView;
import com.moderncreation.gymotivate.com.moderncreation.gymotivate.network.VolleySingleton;
import com.moderncreation.gymotivate.models.MotivateImage;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by xsun on 3/11/14.
 */
public class MotivatePageFragment extends Fragment {

    /**
     * The fragment argument representing the text for this
     * fragment.
     */
    private static final String ARG_TEXT= "text";

    /**
     * The fragment argument representing the image url for this
     * fragment.
     */
    private static final String ARG_IMAGE_URL= "image_url";


    @InjectView(R.id.motivation_image)
    protected NetworkImageView mImageView;

    @InjectView(R.id.motivation_text_view)
    protected TextView mTextView;

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static MotivatePageFragment newInstance(MotivateImage motivateImage) {
        MotivatePageFragment fragment = new MotivatePageFragment();
        Bundle args = new Bundle();
        args.putString(ARG_TEXT, motivateImage.getText());
        args.putString(ARG_IMAGE_URL, motivateImage.getImageUrl());
        fragment.setArguments(args);
        return fragment;
    }

    public MotivatePageFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.motivation_page, container, false);
        ButterKnife.inject(this, rootView);

        Bundle args = getArguments();
        String text = args.getString(ARG_TEXT);
        String imageUrl = args.getString(ARG_IMAGE_URL);

        mTextView.setText(text);
        mImageView.setImageUrl(imageUrl, VolleySingleton.getInstance().getImageLoader());
        return rootView;
    }
}
