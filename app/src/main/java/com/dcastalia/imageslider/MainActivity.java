package com.dcastalia.imageslider;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    LinearLayout layoutGallery ;
    ImageView  collapse , expand ;


    private int[] sliderImagesId = new int[]{
            R.drawable.photo1, R.drawable.photo2, R.drawable.dinner_1,
            R.drawable.dinner_2, R.drawable.dinner_3, R.drawable.dinner_4,R.drawable.photo1, R.drawable.photo2, R.drawable.dinner_1,
            R.drawable.dinner_2, R.drawable.dinner_3, R.drawable.dinner_4,R.drawable.photo1, R.drawable.photo2, R.drawable.dinner_1,
            R.drawable.dinner_2, R.drawable.dinner_3, R.drawable.dinner_4,R.drawable.photo1, R.drawable.photo2, R.drawable.dinner_1,
            R.drawable.dinner_2, R.drawable.dinner_3, R.drawable.dinner_4};

    RecyclerView recyclerView ;
    private ImageViewAdapter mAdapter;
    private StaggeredGridLayoutManager gridLayoutManager ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewPager mViewPager = (ViewPager) findViewById(R.id.viewPageAndroid);
        layoutGallery = (LinearLayout) findViewById(R.id.layout_image_gallery);
        collapse = (ImageView) findViewById(R.id.img_collapse);
        expand = (ImageView) findViewById(R.id.img_expand);


        AndroidImageAdapter adapterView = new AndroidImageAdapter(this, sliderImagesId);
        mViewPager.setAdapter(adapterView);

        recyclerView = (RecyclerView) findViewById(R.id.bottomGalleryRecyclerView);
        gridLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(gridLayoutManager);

        // specify an adapter (see also next example)
        mAdapter = new ImageViewAdapter(MainActivity.this, sliderImagesId, mViewPager);
        recyclerView.setAdapter(mAdapter);

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                recyclerView.getLayoutManager().scrollToPosition(position);
                mAdapter.setSelectedPosition(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        collapse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layoutGallery.setVisibility(View.GONE);
                expand.setVisibility(View.VISIBLE);

            }
        });

        expand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layoutGallery.setVisibility(View.VISIBLE);
                expand.setVisibility(View.GONE);

            }
        });

    }


}
