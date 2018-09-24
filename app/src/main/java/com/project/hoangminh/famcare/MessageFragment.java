package com.project.hoangminh.famcare;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


/**
 * A simple {@link Fragment} subclass.
 */
public class MessageFragment extends Fragment {

    private FirebaseDatabase famCareDB;
    private DatabaseReference dbRef;
    private ChildEventListener newMsgListener;
    private Button sendBtn;
    private EditText msgEdit;
    private RecyclerView msgArea;
    private LinearLayoutManager msgLayoutManager;
    private MessageAdapter msgAdapter;

    public MessageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_message, container, false);

        famCareDB = FirebaseDatabase.getInstance();
        dbRef = famCareDB.getReference().child("messages");

        msgEdit = (EditText) view.findViewById(R.id.msgEditText);

        msgEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(charSequence.toString().trim().length() > 0)
                    sendBtn.setEnabled(true);
                else
                    sendBtn.setEnabled(false);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        msgArea = (RecyclerView) view.findViewById(R.id.messageArea);
        msgArea.setHasFixedSize(true);
        msgLayoutManager = new LinearLayoutManager(getContext());
        msgLayoutManager.setStackFromEnd(true);
        msgArea.setLayoutManager(msgLayoutManager);
        msgAdapter = new MessageAdapter();
        msgArea.setAdapter(msgAdapter);


        sendBtn = (Button) view.findViewById(R.id.sendButton);
        sendBtn.setEnabled(false);

        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FamCareMessage msg = new FamCareMessage("John Doe", msgEdit.getText().toString());
                dbRef.push().setValue(msg);
                msgEdit.setText("");
            }
        });

        newMsgListener = new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                FamCareMessage msg = dataSnapshot.getValue(FamCareMessage.class);
                msgAdapter.addMessage(msg);
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        };

        dbRef.addChildEventListener(newMsgListener);
        // Inflate the layout for this fragment
        return view;
    }

}
