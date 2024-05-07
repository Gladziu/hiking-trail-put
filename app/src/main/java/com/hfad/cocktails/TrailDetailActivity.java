package com.hfad.cocktails;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;


public class TrailDetailActivity extends AppCompatActivity {
    public static final String EXTRA_TRAIL_ID = "trailId";
    public static final String EXTRA_TRAIL_CATEGORY = "trailCategory";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trail_detail);

        int trailId = (Integer) getIntent().getExtras().get(EXTRA_TRAIL_ID);
        String trailCategory = (String) getIntent().getExtras().get(EXTRA_TRAIL_CATEGORY);
        Trail trail = receiveTrail(trailCategory, trailId);

        // Przekazywanie fragmentowi identyfikatora szlaku i kategorie
        TrailDetailFragment trailDetailFragment = (TrailDetailFragment) getSupportFragmentManager().findFragmentById(R.id.detail_fragment);
        trailDetailFragment.setTrailId(trailId, trailCategory);

        // Ustawiamy pasek narzedzi
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // nazwa szlaku i strzalka do cofania w pasku narzedzi
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(trail.getName());
        actionBar.setDisplayHomeAsUpEnabled(true);

        // Wyświetlamy zdjecia szlaku przy pasku narzedzi
        int trailImage = trail.getImageResourceId();
        ImageView imageView = (ImageView) findViewById(R.id.trail_image);
        imageView.setImageDrawable(ContextCompat.getDrawable(this, trailImage));
        imageView.setContentDescription(trail.getName());
    }

    private Trail receiveTrail(String recipeCategory, int trailId) {
        Trail[] trails = new Trail[0];
        if (recipeCategory != null) {
            if (recipeCategory.equals("winter")) {
                trails = Trail.winterTrails;
            } else {
                trails = Trail.summerTrails;
            }
        }
        return trails[trailId];
    }
}
