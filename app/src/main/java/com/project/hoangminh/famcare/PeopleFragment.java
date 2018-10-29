package com.project.hoangminh.famcare;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;


/**
 * A simple {@link Fragment} subclass.
 */
public class PeopleFragment extends Fragment {

    private RecyclerView peopleList;
    private PeopleAdapter pAdapter;

    public PeopleFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_people, container, false);
        peopleList = (RecyclerView) view.findViewById(R.id.peopleList);
        peopleList.setHasFixedSize(true);
        peopleList.setLayoutManager(new LinearLayoutManager(getContext()));
        pAdapter = new PeopleAdapter();
        peopleList.setAdapter(pAdapter);

        Staff staff1 = new Staff("Dr. Jackson", "primary physician", R.drawable.doctor);
        pAdapter.addStaff(staff1);
        Staff staff2 = new Staff("Dr. Espinoza", "cardiologist", R.drawable.doctor1);
        pAdapter.addStaff(staff2);
        Staff staff3 = new Staff("John Smith", "nurse", R.drawable.nurse);
        pAdapter.addStaff(staff3);
        pAdapter.notifyDataSetChanged();

        LinearLayout callStation = (LinearLayout) view.findViewById(R.id.callStation);
        callStation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + "7089833607"));
                startActivity(intent);
            }
        });

        return view;
    }

}
