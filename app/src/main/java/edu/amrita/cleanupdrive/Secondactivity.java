package edu.amrita.cleanupdrive;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;


public class Secondactivity extends AppCompatActivity {

    private Button showLocation;
    private Button addLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondactivity);//}


        showLocation = findViewById(R.id.button_show_location);
        addLocation = findViewById(R.id.button_add_location);
        onShowLocationPressed();
        onAddLocationPressed();
    }

    private void onAddLocationPressed() {
        addLocation.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: Show custom dialog here
            }
        });
    }

    private void onShowLocationPressed() {
        showLocation.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: maybe a new Activity to show locations?
            }

        });

    }

}

