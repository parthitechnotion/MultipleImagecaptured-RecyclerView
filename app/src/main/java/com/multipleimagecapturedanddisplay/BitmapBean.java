package com.multipleimagecapturedanddisplay;

import android.graphics.Bitmap;

/**
 * Created by cd on 14-02-2017.
 */
public class BitmapBean {
    Bitmap imagebitmap;
    boolean IsSelected;

    public Bitmap getImagebitmap() {
        return imagebitmap;
    }

    public void setImagebitmap(Bitmap imagebitmap) {
        this.imagebitmap = imagebitmap;
    }

    public boolean isSelected() {
        return IsSelected;
    }

    public void setSelected(boolean selected) {
        IsSelected = selected;
    }
}
