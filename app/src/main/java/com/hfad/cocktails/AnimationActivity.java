package com.hfad.cocktails;

import android.content.Intent;
import android.os.Handler;

import androidx.fragment.app.Fragment;

public class AnimationActivity extends SingleFragmentActivity {
    Handler handler = new Handler();

    @Override
    protected Fragment createFragment() {
        handler.postDelayed(mLaunchTask, 3000);
        return AnimationFragment.newInstance();
    }

    private final Runnable mLaunchTask = new Runnable() {
        public void run() {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
        }
    };
}