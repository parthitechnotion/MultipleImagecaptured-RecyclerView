package com.multipleimagecapturedanddisplay;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.util.List;

/**
 * Created by cd on 13-02-2017.
 */
public class ProductImagesPagerAdapter extends PagerAdapter {
    private Context context;
    private List<Bitmap> images;

    /**
     * Creates an adapter for viewing product images.
     *
     * @param context activity context.
     * @param images  list of product images.
     */
    public ProductImagesPagerAdapter(Context context, List<Bitmap> images) {
        this.context = context;
        this.images = images;
    }

    @Override
    public int getCount() {
        return images.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView imgDisplay;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View viewLayout = inflater.inflate(R.layout.layout_fullscreen_image, container, false);
        imgDisplay = (ImageView) viewLayout.findViewById(R.id.fullscreen_image);

        imgDisplay.setImageBitmap(images.get(position));
       /* Picasso.with(context).load(Constants.IMGURL+images.get(position))
                .fit().centerInside()
                .placeholder(R.drawable.placeholder_loading)
                .error(R.drawable.placeholder_error)
                .into(imgDisplay);*/

        container.addView(viewLayout);
        return viewLayout;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((RelativeLayout) object);
    }


}
