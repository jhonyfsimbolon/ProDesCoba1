package com.unri.mobile.prodescoba1;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class ImageAdapterBanner extends PagerAdapter {
    private Context mContext;
    private int[] mImageId = new int[]{R.drawable.air, R.drawable.pantai, R.drawable.rumah};

    ImageAdapterBanner(Context context){
        mContext = context;
    }

    @Override
    public int getCount() {
        return mImageId.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        ImageView imageView = new ImageView(mContext);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setImageResource(mImageId[position]);
        container.addView(imageView, 0);
        return imageView;
    }



    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ImageView) object);
    }

}