package com.example.szilvi.tour_guide_bp;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class RestaurantsFragment extends Fragment {

    public RestaurantsFragment() {
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
        items.add(new Items(getResources().getString(R.string.onix), getResources().getString(R.string.onix_address), getResources().getString(R.string.onix_info),
                getResources().getString(R.string.onix_phone), getResources().getString(R.string.onix_web), R.drawable.onyx));
        items.add(new Items(getResources().getString(R.string.trofea), getResources().getString(R.string.trofea_address), getResources().getString(R.string.trofea_info),
                getResources().getString(R.string.trofea_phone), getResources().getString(R.string.trofea_web), R.drawable.trofea));
        items.add(new Items(getResources().getString(R.string.costes), getResources().getString(R.string.costes_adress), getResources().getString(R.string.costes_info),
                getResources().getString(R.string.costes_phone), getResources().getString(R.string.costes_web), R.drawable.costes));

        ItemsAdapter itemsAdapter = new ItemsAdapter(getActivity(), items);
        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);

        return rootView;
    }
}