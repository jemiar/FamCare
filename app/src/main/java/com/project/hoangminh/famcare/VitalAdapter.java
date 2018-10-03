package com.project.hoangminh.famcare;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

//Inherit from RecyclerView Adapter
public class VitalAdapter extends RecyclerView.Adapter<VitalAdapter.VitalViewHolder> {
    private List<Vital_Item> dataSet;

    //Inherit from RecyclerView ViewHolder
    public static class VitalViewHolder extends RecyclerView.ViewHolder {
        public TextView iLabel;
        public TextView iValue;
        public TextView iDay;
        public TextView iTime;
        public ImageView iPic;

        //Get hold of item in a view
        public VitalViewHolder(View v) {
            super(v);
            iLabel = (TextView) v.findViewById(R.id.itemLabel);
            iValue = (TextView) v.findViewById(R.id.itemValue);
            iDay = (TextView) v.findViewById(R.id.day);
            iTime = (TextView) v.findViewById(R.id.time);
            iPic = (ImageView) v.findViewById(R.id.vitalIcon);
        }
    }

    public VitalAdapter(List<Vital_Item> ds) {
        dataSet = ds;
    }

    public VitalAdapter() {
        dataSet = new ArrayList<>();
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    public void addItem(Vital_Item vi) {
        dataSet.add(vi);
    }

    //Inflate the View Holder
    @NonNull
    @Override
    public VitalViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = (View) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.vital_item, viewGroup, false);
        return new VitalViewHolder(v);
    }

    //Set value for View Holder's items
    @Override
    public void onBindViewHolder(@NonNull VitalViewHolder vitalViewHolder, int i) {
        Vital_Item item = dataSet.get(i);
        vitalViewHolder.iLabel.setText(item.getLabel());
        vitalViewHolder.iValue.setText(item.getValue());
        vitalViewHolder.iDay.setText(item.getDay());
        vitalViewHolder.iTime.setText(item.getTime());
        vitalViewHolder.iPic.setImageResource(item.getIconId());
    }
}
