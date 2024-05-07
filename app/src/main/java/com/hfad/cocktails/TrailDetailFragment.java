package com.hfad.cocktails;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class TrailDetailFragment extends Fragment {
    private long trailId;
    private String trailCategory;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            StoperFragment stoper = new StoperFragment();
            FragmentTransaction ft = getChildFragmentManager().beginTransaction();
            ft.add(R.id.stoper_container, stoper);
            ft.addToBackStack(null);
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.commit();
        }
        else{
            trailId = savedInstanceState.getLong("trailId");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_trail_detail, container, false);
    }

    public void setTrailId(long id, String trailCategory) {
        this.trailId = id;
        this.trailCategory = trailCategory;
    }


    @Override
    public void onStart() {
        super.onStart();
        View view = getView();
        if (view != null) {
            Trail trail = receiveTrail(trailCategory, (int) trailId);
            TextView description = (TextView) view.findViewById(R.id.textDescription);
            description.setText(trail.getDescription());
        }
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putLong("trailId", trailId);
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

