package com.example.parking;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class ParkingAdapter extends ArrayAdapter<ParkingClass> {

    Context context;
    List<ParkingClass> ArrList;

    public ParkingAdapter(@NonNull Context context, List<ParkingClass> arrList) {
        super(context, R.layout.custom_parking_item_list,arrList);

        this.ArrList = arrList;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_parking_item_list,null,true);

        TextView txtZone = view.findViewById(R.id.custom_parking_list_id);
        TextView txtName = view.findViewById(R.id.custom_parking_list_name);

        txtZone.setText(ArrList.get(position).getZone());
        txtName.setText(ArrList.get(position).getName());

        return view;
    }
}
