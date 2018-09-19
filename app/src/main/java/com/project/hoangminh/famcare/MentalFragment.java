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
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class MentalFragment extends Fragment {

    Button sendButton;
    SeekBar moodBar, anxietyBar, helpBar;
    TextView moodValue, anxietyValue, helpValue;

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

        moodValue = (TextView) view.findViewById(R.id.moodvalue);
        anxietyValue = (TextView) view.findViewById(R.id.anxietyvalue);
        helpValue = (TextView) view.findViewById(R.id.helpvalue);

        moodBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                String value = String.format("%.1f", ((float)i + 1) / 2);
                moodValue.setText(value);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        anxietyBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                String value = String.format("%.1f", ((float)i + 1) / 2);
                anxietyValue.setText(value);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        helpBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                String value = String.format("%.1f", ((float)i + 1) / 2);
                helpValue.setText(value);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String message = "Mood: " + moodValue.getText() + "\nAnxiety: " + anxietyValue.getText() + "\nHelp: " + helpValue.getText() + "\n\n";

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
