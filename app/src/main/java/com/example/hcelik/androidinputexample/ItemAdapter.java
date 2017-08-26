package com.example.hcelik.androidinputexample;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hcelik on 26.08.17
 */

class ItemAdapter extends ArrayAdapter<Item> {
    @NonNull
    private final Context context;
    private final int resource;
    @NonNull
    private final List<Item> objects;

    public ItemAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<Item> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.objects = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;

        if (view == null) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.row, null);
        }

        Item item = objects.get(position);

        TextView title = view.findViewById(R.id.listtitle);
        TextView firstname = view.findViewById(R.id.firstname);
        TextView lastname = view.findViewById(R.id.lastname);

        title.setText(item.getTitle());
        firstname.setText(item.getFirstname());
        lastname.setText(item.getLastname());

        return view;
    }
}
