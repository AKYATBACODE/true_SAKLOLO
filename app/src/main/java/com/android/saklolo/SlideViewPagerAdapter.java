package com.android.saklolo;


import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class SlideViewPagerAdapter extends PagerAdapter {

    Context ctx;

    public SlideViewPagerAdapter(Context ctx){
        this.ctx = ctx;

    }


    public int getCount() {
        return 3;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater layoutInflater = (LayoutInflater) ctx.getSystemService(ctx.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_screen, container, false);

        ImageView logo = view.findViewById(R.id.logo);
        ImageView next = view.findViewById(R.id.back);
        ImageView back = view.findViewById(R.id.next);
        Button button = view.findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ctx, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                ctx.startActivity(intent);


            }
        });
        next.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                SlideActivity.viewPager.setCurrentItem(position + 1);

            }
        });
        back.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                SlideActivity.viewPager.setCurrentItem(position - 1);

            }

        });


        switch (position) {
            case 0:
                logo.setImageResource(R.drawable.intro_1);
                back.setVisibility(View.GONE);
                break;
            case 1:
                logo.setImageResource(R.drawable.intro_2);
                back.setVisibility(View.GONE);
                break;
            case 2:
                logo.setImageResource(R.drawable.intro_3);
                back.setVisibility(View.VISIBLE);
                next.setVisibility(View.GONE);


                container.addView(view);
                return view;


        }
    }



