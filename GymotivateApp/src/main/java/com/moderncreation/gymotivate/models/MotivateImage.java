package com.moderncreation.gymotivate.models;

/**
 * Created by xsun on 3/11/14.
 */
public class MotivateImage {
    protected String mText;
    protected String mImageUrl;

    public MotivateImage(String text, String imageUrl) {
        mText = text;
        mImageUrl = imageUrl;
    }

    public String getText() {
        return mText;
    }

    public String getImageUrl() {
        return mImageUrl;
    }
}
