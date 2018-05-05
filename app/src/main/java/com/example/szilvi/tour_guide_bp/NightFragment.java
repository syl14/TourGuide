package com.example.szilvi.tour_guide_bp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class NightFragment extends Fragment {

    public NightFragment() {
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.items_list, container, false);

        final ArrayList<Items> items = new ArrayList<>();

        items.add(new Items(getResources().getString(R.string.parlament), getResources().getString(R.string.parlament_address), getResources().getString(R.string.parlament_info), getResources().getString(R.string.parlament_phone),
                getResources().getString(R.string.parlament_web), R.drawable.parlament_night));
        items.add(new Items(getResources().getString(R.string.andrasy), getResources().getString(R.string.andrasy_address), getResources().getString(R.string.andrasy_info), getResources().getString(R.string.andrassy_phone),
                getResources().getString(R.string.andrassy_web), R.drawable.andrassy));
        items.add(new Items(getResources().getString(R.string.buda), getResources().getString(R.string.buda_address), getResources().getString(R.string.buda_info), getResources().getString(R.string.buda_phone),
                getResources().getString(R.string.buda_web), R.drawable.buda_castle_night));
        items.add(new Items(getResources().getString(R.string.heroes), getResources().getString(R.string.house_address), getResources().getString(R.string.heroes_info), getResources().getString(R.string.heroes_phone),
                getResources().getString(R.string.heroes_web), R.drawable.hetvezer));
        items.add(new Items(getResources().getString(R.string.chain), getResources().getString(R.string.chain_address), getResources().getString(R.string.chain_info), getResources().getString(R.string.chain_phone),
                getResources().getString(R.string.chain_web), R.drawable.bridge_szechenyi));
        items.add(new Items(getResources().getString(R.string.liberty), getResources().getString(R.string.liberty_address), getResources().getString(R.string.liberty_info), getResources().getString(R.string.liberty_phone),
                getResources().getString(R.string.liberty_web), R.drawable.liberty_of));
        ItemsAdapter itemsAdapter = new ItemsAdapter(getActivity(), items);
        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);

        return rootView;
    }
}
