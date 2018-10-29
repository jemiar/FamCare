package com.project.hoangminh.famcare;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
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

    //Inflate View for the fragment
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //Inflate the layout and assign it to a View
        View view = inflater.inflate(R.layout.fragment_message, container, false);

        //Get the instance of the database
        famCareDB = FirebaseDatabase.getInstance();
        //Only interest in the "messages" node -> Get the reference to it
        dbRef = famCareDB.getReference().child("messages");

        msgEdit = (EditText) view.findViewById(R.id.msgEditText);

        //Add event listener to the message input area
        msgEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            //When there is text changed, if there is text, set the [SEND] button to enabled state
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
        //For optimization, when you know your recyclerview size doesn't change
        //Allow OS to use the same layout without creating new one each time
        msgArea.setHasFixedSize(true);
        msgLayoutManager = new LinearLayoutManager(getContext());
        //New item is added from the the bottom of the recycler view
        msgLayoutManager.setStackFromEnd(true);
        msgArea.setLayoutManager(msgLayoutManager);
        msgAdapter = new MessageAdapter(getContext());
        msgArea.setAdapter(msgAdapter);


        sendBtn = (Button) view.findViewById(R.id.sendButton);
        //Initially, disable the [SEND] button
        sendBtn.setEnabled(false);

        //Set the click listener on [SEND] button
        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Create new message
                FamCareMessage msg = new FamCareMessage("Family", msgEdit.getText().toString());
                //Push to database
                dbRef.push().setValue(msg);
                //Reset the text input area
                msgEdit.setText("");
            }
        });

        //Create new event listener for database reference
        newMsgListener = new ChildEventListener() {
            //Invoke when there is new data added or when the 1st time the listener is attached to the database
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                //Get new messages from database's data snapshot
                FamCareMessage msg = dataSnapshot.getValue(FamCareMessage.class);
                //Add new messages to the adapter's message linkedlist
                msgAdapter.addMessage(msg);
                //notify the adapter that there are new messages
                msgAdapter.notifyDataSetChanged();
                //scroll to the latest message added to the recyclerview
                msgArea.smoothScrollToPosition(msgAdapter.getItemCount() - 1);
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

        //Add event listener to database reference
        dbRef.addChildEventListener(newMsgListener);
        // Inflate the layout for this fragment by return the view
        return view;
    }

    //Need to have onDestroyView to remove event listener from database reference
    //When the fragment is destroyed, the event listener for database still exists
    //When the fragment is recreated, new event listener is created in onCreateView,
    //resulted in multiple database event listeners -> duplication issue
    //By doing this, we are sure that there is only 1 event listener when the fragment is created
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        //Remove event listener from database reference when fragment is destroyed
        dbRef.removeEventListener(newMsgListener);
    }

}
