package com.project.hoangminh.famcare;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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
    private VitalRecyclerListener adapterRecyclerListener;

    //Inherit from RecyclerView ViewHolder
    //Method 2. Step 2: Implement View.OnClickListener for the ViewHolder
    public static class VitalViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView iLabel;
        public TextView iValue;
//        public TextView iDay;
//        public TextView iTime;
        public ImageView iPic;

        //Method 2. Step 3: Have a instance variable for the listener
        public VitalRecyclerListener rListener;


        //NOTE: This one does the work, but it creates too many listener if there are so many items
        //public View wholeView; //store the whole item row view, to attach onClick listener

        //Get hold of item in a view
        public VitalViewHolder(View v, VitalRecyclerListener l) {
            super(v);
            iLabel = (TextView) v.findViewById(R.id.itemLabel);
            iValue = (TextView) v.findViewById(R.id.itemValue);
//            iDay = (TextView) v.findViewById(R.id.day);
//            iTime = (TextView) v.findViewById(R.id.time);
            iPic = (ImageView) v.findViewById(R.id.vitalIcon);

            //2nd method: Set the listener variable
            //Set the listener on the View
            rListener = l;
            v.setOnClickListener(this);


            //NOTE: This one does the work, but it creates too many listener if there are so many items
            //wholeView = v;
        }

        //2nd method: Implement the onClick method
        @Override
        public void onClick(View view) {
            rListener.onClick(view, getAdapterPosition());
        }
    }

    public VitalAdapter(List<Vital_Item> ds, VitalRecyclerListener listener) {
        dataSet = ds;
        adapterRecyclerListener = listener;
    }

    public VitalAdapter(VitalRecyclerListener listener) {
        dataSet = new ArrayList<>();
        adapterRecyclerListener = listener;
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    public Vital_Item getIemAt(int i) {
        return dataSet.get(i);
    }

    public void addItem(Vital_Item vi) {
        dataSet.add(vi);
        notifyDataSetChanged();
    }


    //Inflate the View Holder
    @NonNull
    @Override
    public VitalViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = (View) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.vital_item, viewGroup, false);
        return new VitalViewHolder(v, adapterRecyclerListener);
    }

    //Set value for View Holder's items
    @Override
    public void onBindViewHolder(@NonNull VitalViewHolder vitalViewHolder, int i) {
        Vital_Item item = dataSet.get(i);
        vitalViewHolder.iLabel.setText(item.getLabel());
        vitalViewHolder.iValue.setText(item.getValue());
//        vitalViewHolder.iDay.setText(item.getDay());
//        vitalViewHolder.iTime.setText(item.getTime());
        vitalViewHolder.iPic.setImageResource(item.getIconId());


        //Set onClick listener on the whole row
        //NOTE: This one does the work, but it creates too many listener if there are so many items
        //vitalViewHolder.wholeView.setOnClickListener(new VitalItemClickListener(i));
    }


    //Inner class implement onclick listener on the whole view
    //Tailoring with index variable to get the position of the item

    //NOTE: This one does the work, but it creates too many listener if there are so many items
    /*
    private class VitalItemClickListener implements View.OnClickListener {
        private int index;

        public VitalItemClickListener(int i) {
            index = i;
        }
        @Override
        public void onClick(View view) {
            Toast.makeText(view.getContext(), dataSet.get(index).getLabel(), Toast.LENGTH_SHORT).show();
            Log.i("Listener", this.toString());
        }
    }
    */

}

//1st method to attach listener to item:
//Have a instance variable wholeView in the the ViewHolder class
//In the ViewHolder constructor: set the wholeView variable
//Define a ItemClickListener implements View.OnClickListener
//This class has an index variable to store the position of the item
//Implement onClick method
//Attach the listener to wholeView variable inside the onBindViewHolder method

//2nd method: Refer: https://android.jlelse.eu/click-listener-for-recyclerview-adapter-2d17a6f6f6c9