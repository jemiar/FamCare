package com.project.hoangminh.famcare;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.MessageViewHolder> {

    private List<FamCareMessage> dataSet;

    public static class MessageViewHolder extends RecyclerView.ViewHolder {

        public TextView user;
        public TextView content;

        public MessageViewHolder(View v) {
            super(v);
            user = (TextView) v.findViewById(R.id.user);
            content = (TextView) v.findViewById(R.id.content);
        }

    }

    public MessageAdapter(List<FamCareMessage> ds) {
        dataSet = ds;
    }

    public MessageAdapter() {
        dataSet = new ArrayList<>();
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    public void addMessage(FamCareMessage m) {
        dataSet.add(m);
    }

    @NonNull
    @Override
    public MessageViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = (View) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.message_item, viewGroup, false);
        return new MessageViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MessageViewHolder messageViewHolder, int i) {
        FamCareMessage msgItem = dataSet.get(i);
        messageViewHolder.user.setText(msgItem.getUserName());
        messageViewHolder.content.setText(msgItem.getText());
    }
}
