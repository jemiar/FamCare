package com.project.hoangminh.famcare;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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
        public View wholeView; //store the whole item row view, to attach onClick listener

        //Get hold of item in a view
        public VitalViewHolder(View v) {
            super(v);
            iLabel = (TextView) v.findViewById(R.id.itemLabel);
            iValue = (TextView) v.findViewById(R.id.itemValue);
            iDay = (TextView) v.findViewById(R.id.day);
            iTime = (TextView) v.findViewById(R.id.time);
            iPic = (ImageView) v.findViewById(R.id.vitalIcon);
            wholeView = v;
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
        //Set onClick listener on the whole row
        vitalViewHolder.wholeView.setOnClickListener(new VitalItemClickListener(i));
    }

    //Inner class implement onclick listener on the whole view
    //Tailoring with index variable to get the position of the item
    private class VitalItemClickListener implements View.OnClickListener {
        private int index;

        public VitalItemClickListener(int i) {
            index = i;
        }
        @Override
        public void onClick(View view) {
            Toast.makeText(view.getContext(), dataSet.get(index).getLabel(), Toast.LENGTH_SHORT).show();
        }
    }
}
