package edu.amrita.cleanupdrive;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import java.util.ArrayList;

import edu.amrita.cleanupdrive.roomdb.User;
import edu.amrita.cleanupdrive.roomdb.UserDao;
import edu.amrita.cleanupdrive.utility.MockData;


public class Secondactivity extends AppCompatActivity {

    private Button showloc;
    private Button addloc;


    private UserDao userDao;
    private ArrayList<User> locations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondactivity);//}


        showloc = findViewById(R.id.button_show_location);
        addloc = findViewById(R.id.button_add_location);
        onshowloc();
        onaddloc();

    }

   private void onshowloc(){
        showloc.setOnClickListener(new OnClickListener() {
       @Override
       public void onClick(View v) {

            }

        });

    }
    private void onaddloc(){
        addloc.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View v) {

            }


                                  }


        );
    }

    private class InsertAndFetchAsyncTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            if (userDao.getAllUsers().size() <= 0) {
                userDao.addUsers(MockData.getUsers());
            }
            locations = new ArrayList<>(userDao.getAllLocations());
            Log.i("FETCHED USERS", locations.toStringForLoc());
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

        }
    }



}

