package com.project.hoangminh.famcare;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import static android.support.v7.widget.DividerItemDecoration.HORIZONTAL;


/**
 * A simple {@link Fragment} subclass.
 */
public class VitalFragment extends Fragment {

    private RecyclerView vitalArea;
    private LinearLayoutManager vitalLayoutMan;
    private VitalAdapter vAdapter;

    public VitalFragment() {
        // Required empty public constructor
    }

    //Inflate view for the fragment
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //Inflate the layout and assign it to a View
        View view = inflater.inflate(R.layout.fragment_vital, container, false);

        vitalArea = (RecyclerView) view.findViewById(R.id.vitalArea);
        //For optimization, when you know your recyclerview size doesn't change
        //Allow OS to use the same layout without creating new one each time
        vitalArea.setHasFixedSize(true);
        vitalLayoutMan = new LinearLayoutManager(getContext());
        vitalArea.setLayoutManager(vitalLayoutMan);
        vAdapter = new VitalAdapter();
        vitalArea.setAdapter(vAdapter);

        //Add divider between item
        DividerItemDecoration itemDecor = new DividerItemDecoration(getContext(), HORIZONTAL);
        vitalArea.addItemDecoration(itemDecor);

        //Add new items to vital area
        Vital_Item heartRate = new Vital_Item("Heart Rate", "Normal", "1/2", "8:30 AM", R.drawable.cardiogram);
        vAdapter.addItem(heartRate);
        Vital_Item respRate = new Vital_Item("Respiratory Rate", "Normal", "1/2", "9:30 AM", R.drawable.lungs);
        vAdapter.addItem(respRate);
        Vital_Item bloodPressure = new Vital_Item("Blood Pressure", "Normal", "1/2", "9:30 AM", R.drawable.pressure);
        vAdapter.addItem(bloodPressure);
        Vital_Item bodyTemp = new Vital_Item("Body Temperature", "Normal", "1/2", "9:30 AM", R.drawable.temp);
        vAdapter.addItem(bodyTemp);
        Vital_Item bloodOxygen = new Vital_Item("Blood Oxygen", "Normal", "1/2", "9:30 AM", R.drawable.oxygen);
        vAdapter.addItem(bloodOxygen);
        Vital_Item pain = new Vital_Item("Pain", "Normal", "1/2", "9:30 AM", R.drawable.bandage);
        vAdapter.addItem(pain);
        Vital_Item medication = new Vital_Item("Medication", "Normal", "1/2", "9:30 AM", R.drawable.pills);
        vAdapter.addItem(medication);
        vAdapter.notifyDataSetChanged();

        // Return the view for inflation
        return view;
    }

}
