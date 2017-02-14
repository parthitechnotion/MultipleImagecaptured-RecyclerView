package com.multipleimagecapturedanddisplay;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cd on 13-02-2017.
 */
public class ProductImagesRecyclerAdapter extends RecyclerView.Adapter<ProductImagesRecyclerAdapter.ViewHolder> {

    private final Context context;
    private final ProductImagesRecyclerInterface productImagesRecyclerInterface;
    private List<Bitmap> productImagesUrls;
    private LayoutInflater layoutInflater;

    /**
     * Creates an adapter that handles a list of product images.
     *
     * @param context                        activity context.
     * @param productImagesRecyclerInterface listener indicating events that occurred.
     */
    public ProductImagesRecyclerAdapter(Context context, ProductImagesRecyclerInterface productImagesRecyclerInterface) {
        this.context = context;
        this.productImagesRecyclerInterface = productImagesRecyclerInterface;
        productImagesUrls = new ArrayList<>();
    }

    @Override
    public ProductImagesRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (layoutInflater == null)
            layoutInflater = LayoutInflater.from(parent.getContext());

        View view = layoutInflater.inflate(R.layout.list_item_product_image, parent, false);
        return new ViewHolder(view, productImagesRecyclerInterface);
    }

    @Override
    public void onBindViewHolder(ProductImagesRecyclerAdapter.ViewHolder holder, int position) {
//        Timber.d("ProductImage position: " + position);
        Bitmap productImageUrl = getItem(position);
        holder.setPosition(position);

        holder.IvListitem.setImageBitmap(productImageUrl);
       /* Picasso.with(context)
                .load(Constants.IMGURL+productImageUrl)
                .fit().centerInside()
                .placeholder(R.drawable.placeholder_loading)
                .error(R.drawable.placeholder_error)
                .into(holder.productImage);*/
    }

    private Bitmap getItem(int position) {
        return productImagesUrls.get(position);
    }

    @Override
    public int getItemCount() {
        return productImagesUrls.size();
    }

    /**
     * Add the product image url to the list.
     *
     * @param position        list position where item should be added.
     * @param productImageUrl image url to add.
     */
    public void add(int position, Bitmap productImageUrl) {
        productImagesUrls.add(position, productImageUrl);
        notifyItemInserted(position);
    }

    /**
     * Add the product image url at the end of the list.
     *
     * @param productImageUrl image url to add.
     */
    public void addLast(Bitmap productImageUrl) {
        productImagesUrls.add(productImagesUrls.size(), productImageUrl);
        notifyItemInserted(productImagesUrls.size());
    }

    /**
     * Clear list of product images.
     */
    public void clearAll() {
        int itemCount = productImagesUrls.size();

        if (itemCount > 0) {
            productImagesUrls.clear();
            notifyItemRangeRemoved(0, itemCount);
        }
    }

    public void setCurrentSelect(int position){
        if(productImagesUrls != null && productImagesUrls.size() >= position){
            for(int i =0 ; i < productImagesUrls.size(); i++){
               /* ModelTab info = data.get(i);
                if(i == position){
                    info.isSelect = true;
                }else {
                    info.isSelect = false;
                }*/
            }
            this.notifyDataSetChanged();
        }
    }


    // Provide a reference to the views for each data item
    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView IvListitem;
        int position;

        public ViewHolder(View v, final ProductImagesRecyclerInterface productImagesRecyclerInterface) {
            super(v);
            IvListitem = (ImageView) v.findViewById(R.id.IvListitem);

            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (productImagesRecyclerInterface != null)
                        productImagesRecyclerInterface.onImageSelected(v, position);
                }
            });
        }

        public void setPosition(int position) {
            this.position = position;
        }

    }
}
