package com.example.szilvi.tour_guide_bp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ViewFragment extends Fragment {

    public ViewFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.items_list, container, false);

        final ArrayList<Items> items = new ArrayList<>();

        items.add(new Items(getResources().getString(R.string.parlament), getResources().getString(R.string.parlament_address), getResources().getString(R.string.parlament_info), getResources().getString(R.string.parlament_phone),
                getResources().getString(R.string.parlament_web), R.drawable.parlament));
        items.add(new Items(getResources().getString(R.string.buda), getResources().getString(R.string.buda_address), getResources().getString(R.string.buda_info), getResources().getString(R.string.buda_phone),
                getResources().getString(R.string.buda_web), R.drawable.buda_castle));
        items.add(new Items(getResources().getString(R.string.stephen), getResources().getString(R.string.stephen_address), getResources().getString(R.string.stephen_info), getResources().getString(R.string.stephen_phone),
                getResources().getString(R.string.stephen_web), R.drawable.st_stephen));
        items.add(new Items(getResources().getString(R.string.fisherman), getResources().getString(R.string.fisherman_address), getResources().getString(R.string.fisherman_info), getResources().getString(R.string.fisherman_phone),
                getResources().getString(R.string.fisherman_web), R.drawable.fishermans_bastia));
        items.add(new Items(getResources().getString(R.string.gellert), getResources().getString(R.string.gellert), getResources().getString(R.string.gellert_info), getResources().getString(R.string.gellert_phone),
                getResources().getString(R.string.gellert_web), R.drawable.gellerhill));
        items.add(new Items(getResources().getString(R.string.heroes), getResources().getString(R.string.heroes), getResources().getString(R.string.heroes_info), getResources().getString(R.string.heroes_phone),
                getResources().getString(R.string.heroes_web), R.drawable.osvezer));
        items.add(new Items(getResources().getString(R.string.shoes), getResources().getString(R.string.shoes_address), getResources().getString(R.string.shoes_info), getResources().getString(R.string.shoes_phone),
                getResources().getString(R.string.shoes_web), R.drawable.shoes_of_danubia));

        ItemsAdapter itemsAdapter = new ItemsAdapter(getActivity(), items);
        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);

        return rootView;

    }
}