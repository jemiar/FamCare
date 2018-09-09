package com.project.hoangminh.famcare;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class MentalFragment extends Fragment {

    Button sendButton;
    SeekBar moodBar, anxietyBar, helpBar;

    public MentalFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_mental, container, false);

        sendButton = (Button) view.findViewById(R.id.sendButton);
        moodBar = (SeekBar) view.findViewById(R.id.moodbar);
        anxietyBar = (SeekBar) view.findViewById(R.id.anxietybar);
        helpBar = (SeekBar) view.findViewById(R.id.helpbar);

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int moodValue = moodBar.getProgress() + 1;
                int anxietyValue = anxietyBar.getProgress() + 1;
                int helpValue = helpBar.getProgress() + 1;
                String message = "Mood: " + moodValue + "\nAnxiety: " + anxietyValue + "\nHelp: " + helpValue + "\n";

                String[] address = {"hhuynh20@uic.edu"};

                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                emailIntent.setData(Uri.parse("mailto:"));
                emailIntent.setType("text/plain");
                emailIntent.putExtra(Intent.EXTRA_EMAIL, address);
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Mood Assessment");
                emailIntent.putExtra(Intent.EXTRA_TEXT, message);

                try {
                    startActivity(Intent.createChooser(emailIntent, "Send email..."));
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(getContext(),"There is no email client", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }

}
