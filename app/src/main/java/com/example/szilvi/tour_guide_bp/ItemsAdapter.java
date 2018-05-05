package com.example.szilvi.tour_guide_bp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class ItemsAdapter extends ArrayAdapter<Items> {
    private Context context = getContext();

    public ItemsAdapter(Activity context, ArrayList<Items> places) {
        super(context, 0, places);
    }

    @NonNull
    @Override
    public View getView(int position, @NonNull View convertView, @NonNull ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view.
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.items_details, parent, false);
        }

        // Get the {@link Place} object located at this position in the list
        Items currentPlace = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID name_text_view.
        TextView name = (TextView) listItemView.findViewById(R.id.name_text_view);
        assert currentPlace != null;
        // Get the name of the place from the currentPlace object and set this text on name.
        name.setText(currentPlace.getPlaceName());

        // Find the TextView in the list_item.xml layout with the ID address_text_view.
        TextView address = (TextView) listItemView.findViewById(R.id.address_text_view);
        // Get the address of the place from the currentPlace object and set this text on address.
        address.setText(currentPlace.getPlaceAddress());

        // Find the ImageView in the list_item.xml layout with the ID image.
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image_view);
        // Check if an image is provided for that place or not
        if (currentPlace.hasImage()) {
            // If an image is available, display the provided image based on the resource ID
            imageView.setImageResource(currentPlace.getImageResourceId());
            // Make sure the view is visible
            imageView.setVisibility(View.VISIBLE);
        } else {
            // Otherwise hide the ImageView
            imageView.setVisibility(View.GONE);
        }


        String namePlaceDetail = currentPlace.getPlaceName();
        String addressPlaceDetail = currentPlace.getPlaceAddress();
        String infoPlaceDetail = currentPlace.getInfo();
        String phonePlaceDetail = currentPlace.getPhone();
        String webPlaceDetail = currentPlace.getWeb();
        int imagePlaceDetail = currentPlace.getImageResourceId();

        final Intent itemIntent = new Intent(context, DetailsInNewPage.class);
        itemIntent.putExtra(context.getString(R.string.place), namePlaceDetail);
        itemIntent.putExtra(context.getString(R.string.address), addressPlaceDetail);
        itemIntent.putExtra(context.getString(R.string.web), webPlaceDetail);
        itemIntent.putExtra(context.getString(R.string.phone), phonePlaceDetail);
        itemIntent.putExtra(context.getString(R.string.info), infoPlaceDetail);
        itemIntent.putExtra(context.getString(R.string.picture), imagePlaceDetail);

        listItemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(itemIntent);
            }
        });

        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;

    }
}

