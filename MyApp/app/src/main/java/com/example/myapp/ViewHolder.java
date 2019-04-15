package com.example.myapp;


import android.animation.ValueAnimator;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.TextView;

public class ViewHolder extends RecyclerView.ViewHolder{


    public TextView Title;
    public TextView subTitle;
    Context context;
    CardView cardView;
    int minHeight;


    public ViewHolder(@NonNull View itemView){
        super(itemView);
            Title = itemView.findViewById(R.id.title);
            subTitle= itemView.findViewById(R.id.sub_title);



        WindowManager windowmanager = (WindowManager)context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dimension = new DisplayMetrics();
        windowmanager.getDefaultDisplay().getMetrics(dimension);
        final int height = dimension.heightPixels;


        cardView.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {

            @Override
            public boolean onPreDraw() {
                cardView.getViewTreeObserver().removeOnPreDrawListener(this);
                minHeight = cardView.getHeight();
                ViewGroup.LayoutParams layoutParams = cardView.getLayoutParams();
                layoutParams.height = minHeight;
                cardView.setLayoutParams(layoutParams);

                return true;
            }
        });

       /* ImageButton btn = (itemView).findViewById(R.id.expandable_arrow);

        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                toggleHeight(height);

            }
        });*/
    }

    private void toggleHeight(int height) {

        if (cardView.getHeight() == minHeight) {
            // expand

            expandView(minHeight); //'height' is the height of screen which we have measured already.

        } else {
            // collapse
            collapseView();

        }
    }

    public void collapseView() {

        ValueAnimator anim = ValueAnimator.ofInt(cardView.getMeasuredHeightAndState(),
                minHeight);
        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int val = (Integer) valueAnimator.getAnimatedValue();
                ViewGroup.LayoutParams layoutParams = cardView.getLayoutParams();
                layoutParams.height = val;
                cardView.setLayoutParams(layoutParams);

            }
        });
        anim.start();
    }
    public void expandView(int height) {

        ValueAnimator anim = ValueAnimator.ofInt(cardView.getMeasuredHeightAndState(),
                height);
        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int val = (Integer) valueAnimator.getAnimatedValue();
                ViewGroup.LayoutParams layoutParams = cardView.getLayoutParams();
                layoutParams.height = val;
                cardView.setLayoutParams(layoutParams);
            }
        });
        anim.start();

    }
}
