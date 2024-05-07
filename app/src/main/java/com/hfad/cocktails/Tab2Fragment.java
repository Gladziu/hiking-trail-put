package com.hfad.cocktails;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class Tab2Fragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        RecyclerView trailRecycler = (RecyclerView) inflater.inflate(R.layout.fragment_tab1, container, false);
        String[] trailNames = new String[Trail.winterTrails.length];
        for (int i = 0; i < trailNames.length; i++) {
            trailNames[i] = Trail.winterTrails[i].getName();
        }
        int[] trailImages = new int[Trail.winterTrails.length];
        for (int i = 0; i < trailImages.length; i++) {
            trailImages[i] = Trail.winterTrails[i].getImageResourceId();
        }
        CaptionedImagesAdapter adapter = new CaptionedImagesAdapter(trailNames, trailImages);
        trailRecycler.setAdapter(adapter);
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
        trailRecycler.setLayoutManager(layoutManager);

        adapter.setListener(new CaptionedImagesAdapter.Listener() {
            public void onClick(int position) {
                Intent intent = new Intent(getActivity(), TrailDetailActivity.class);
                intent.putExtra(TrailDetailActivity.EXTRA_TRAIL_ID, position);
                intent.putExtra(TrailDetailActivity.EXTRA_TRAIL_CATEGORY, "winter");
                getActivity().startActivity(intent);
            }
        });

        return trailRecycler;
    }
}