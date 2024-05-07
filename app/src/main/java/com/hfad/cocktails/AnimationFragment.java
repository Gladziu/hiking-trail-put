package com.hfad.cocktails;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;

import androidx.fragment.app.Fragment;

public class AnimationFragment extends Fragment {
    private View mSceneView;
    private View mIconView;
    private View mBackgroundView;
    private int mStartColor;
    private int mEndColor;

    public static AnimationFragment newInstance() {
        return new AnimationFragment();
    }

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_animation, container, false);
        mSceneView = view;
        mIconView = view.findViewById(R.id.icon);
        mBackgroundView = view.findViewById(R.id.background);
        Resources resources = getResources();
        mStartColor = resources.getColor(R.color.black);
        mEndColor = resources.getColor(R.color.gray);
        startAnimation();
        return view;
    }
    private void startAnimation() {
        float iconXStart = mSceneView.getLeft()-400;
        float iconXEnd = mBackgroundView.getPivotX()+700;

        ObjectAnimator heightAnimator = ObjectAnimator
                .ofFloat(mIconView, "x", iconXStart, iconXEnd)
                .setDuration(4000);
        heightAnimator.setInterpolator(new DecelerateInterpolator());
        ObjectAnimator sunsetSkyAnimator = ObjectAnimator
                .ofInt(mBackgroundView, "backgroundColor", mStartColor, mEndColor)
                .setDuration(3000);
        sunsetSkyAnimator.setEvaluator(new ArgbEvaluator());
        heightAnimator.start();
        sunsetSkyAnimator.start();
    }
}
