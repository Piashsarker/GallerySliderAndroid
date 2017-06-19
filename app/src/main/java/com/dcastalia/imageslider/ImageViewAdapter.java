package com.dcastalia.imageslider;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by piashsarker on 6/6/17.
 */

public class ImageViewAdapter extends RecyclerView.Adapter<ImageViewAdapter.ViewHolder> {

    private Context context ;
    private int [] sliderImagesId ;
    private ViewPager viewPager ;
    private int selectedPosition;

    public ImageViewAdapter(Context context, int [] sliderImagesId , ViewPager mViewPager){
        this.context = context ;
        this.sliderImagesId = sliderImagesId ;
        viewPager = mViewPager;
        selectedPosition = viewPager.getCurrentItem() ;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_image, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        holder.imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        holder.imageView.setImageResource(sliderImagesId[position]);


        if(selectedPosition  == position){
            holder.imageView.setBackgroundColor(Color.parseColor("#FFFFFF"));
            holder.imageView.setPadding(2,2,2,2);
        }
        else{
            holder.imageView.setBackgroundColor(0);
            holder.imageView.setPadding(0,0,0,0);
        }

        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(position);
                changeBorderColor(holder);
            }
        });

    }

    public void setSelectedPosition(int position){
        selectedPosition = position;
        notifyDataSetChanged();
    }


    private void changeBorderColor(ViewHolder holder) {
        int currentPosition = holder.getLayoutPosition() ;
        if(selectedPosition!=currentPosition){
            int lastSelectionPosition = selectedPosition ;
            selectedPosition = currentPosition ;
            notifyItemChanged(lastSelectionPosition);
            holder.imageView.setBackgroundColor(Color.parseColor("#FFFFFF"));
            holder.imageView.setPadding(2,2,2,2);
        }
    }

    @Override
    public int getItemCount() {
        return  sliderImagesId.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView ;

        public ViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.imageView);

        }
    }
}
