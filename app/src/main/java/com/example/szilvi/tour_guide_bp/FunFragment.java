package com.example.szilvi.tour_guide_bp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class FunFragment extends Fragment {

    public FunFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.items_list, container, false);

        final ArrayList<Items> items = new ArrayList<>();

        items.add(new Items(getResources().getString(R.string.andrasy), getResources().getString(R.string.andrasy_address), getResources().getString(R.string.andrasy_info), getResources().getString(R.string.andrassy_phone),
                getResources().getString(R.string.andrassy_web), R.drawable.andrassy_ave));
        items.add(new Items(getResources().getString(R.string.matthias), getResources().getString(R.string.matthias_address), getResources().getString(R.string.matthias_info), getResources().getString(R.string.matthias_phone),
                getResources().getString(R.string.market_web), R.drawable.matthias_church));
        items.add(new Items(getResources().getString(R.string.fisherman), getResources().getString(R.string.fisherman_address), getResources().getString(R.string.fisherman_info), getResources().getString(R.string.fisherman_phone),
                getResources().getString(R.string.fisherman_web), R.drawable.fishermans_bastia));
        items.add(new Items(getResources().getString(R.string.house), getResources().getString(R.string.house_address), getResources().getString(R.string.house_info), getResources().getString(R.string.house_phone),
                getResources().getString(R.string.house_web), R.drawable.house_of_terror));
        items.add(new Items(getResources().getString(R.string.liberty), getResources().getString(R.string.liberty_address), getResources().getString(R.string.liberty_info), getResources().getString(R.string.liberty_phone),
                getResources().getString(R.string.liberty_web), R.drawable.liberty_bridge));
        items.add(new Items(getResources().getString(R.string.market), getResources().getString(R.string.market_address), getResources().getString(R.string.market_info), getResources().getString(R.string.matthias_phone),
                getResources().getString(R.string.market_web), R.drawable.great_market_hall));
        items.add(new Items(getResources().getString(R.string.bath), getResources().getString(R.string.bath_address), getResources().getString(R.string.bath_info), getResources().getString(R.string.bath_phone),
                getResources().getString(R.string.bath_web), R.drawable.szechenyi_thermal_bath));

        ItemsAdapter itemsAdapter = new ItemsAdapter(getActivity(), items);
        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);

        return rootView;
    }
}

