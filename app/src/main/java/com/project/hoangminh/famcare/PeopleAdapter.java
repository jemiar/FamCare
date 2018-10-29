package com.project.hoangminh.famcare;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class PeopleAdapter extends RecyclerView.Adapter<PeopleAdapter.StaffViewHolder> {

    private List<Staff> dataSet;

    public static class StaffViewHolder extends RecyclerView.ViewHolder {

        public TextView staffName;
        public TextView staffPos;
        public ImageView staffPic;

        public StaffViewHolder(View v) {
            super(v);
            staffName = (TextView) v.findViewById(R.id.staffName);
            staffPos = (TextView) v.findViewById(R.id.staffPos);
            staffPic = (ImageView) v.findViewById(R.id.staffPic);
        }
    }

    public PeopleAdapter() {
        dataSet = new ArrayList<>();
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    public void addStaff(Staff s) {
        dataSet.add(s);
    }

    @NonNull
    @Override
    public StaffViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = (View) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.stafflayout, viewGroup, false);
        return new StaffViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull StaffViewHolder staffViewHolder, int i) {
        Staff staff = dataSet.get(i);
        staffViewHolder.staffName.setText(staff.getName());
        staffViewHolder.staffPos.setText(staff.getPos());
        staffViewHolder.staffPic.setImageResource(staff.getPhoto());
    }
}
