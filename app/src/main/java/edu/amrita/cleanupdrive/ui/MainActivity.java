package edu.amrita.cleanupdrive.ui;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

import edu.amrita.cleanupdrive.R;
import edu.amrita.cleanupdrive.roomdb.User;
import edu.amrita.cleanupdrive.roomdb.UserDao;
import edu.amrita.cleanupdrive.roomdb.UserRoomDatabase;
import edu.amrita.cleanupdrive.utility.MockData;

public class MainActivity extends AppCompatActivity {

    private Button loginOrRegister;
    private EditText username;
    private EditText password;
    private ProgressBar progressBar;

    private UserDao userDao;
    private ArrayList<User> users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginOrRegister = findViewById(R.id.button_login);
        username = findViewById(R.id.edit_username);
        password = findViewById(R.id.edit_password);
        progressBar = findViewById(R.id.progress_loading);

        UserRoomDatabase database = UserRoomDatabase.getDatabase(this);
        userDao = database.userDao();

        new InsertAndFetchAsyncTask().execute();
        onLoginOrRegisterButtonClicked();
    }


    private void onLoginOrRegisterButtonClicked() {
        loginOrRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isUserPresent = false;
                User enteredUser = new User(username.getText().toString(),
                        password.getText().toString());
                for (User user : users) {
                    if (user.getUsername().equals(enteredUser.getUsername()) &&
                            user.getPassword().equals(enteredUser.getPassword())) {
                        isUserPresent = true;
                        Snackbar.make(findViewById(android.R.id.content), "Login successful",
                                Snackbar.LENGTH_LONG)
                                .show();

                        Intent intent = new Intent(getBaseContext(), Dashboard.class);
                        startActivity(intent);

                        break;
                    }
                }

                if (!isUserPresent) {
                    Snackbar.make(findViewById(android.R.id.content), "Invalid Credentials",
                            Snackbar.LENGTH_LONG)
                            .show();
                }

                View view = getCurrentFocus();
                if (view != null) {
                    InputMethodManager inputMethodManager =
                            (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
                }
            }
        });
    }

    private class InsertAndFetchAsyncTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected Void doInBackground(Void... voids) {
            if (userDao.getAllUsers().size() <= 0) {
                userDao.addUsers(MockData.getUsers());
            }
            users = new ArrayList<>(userDao.getAllUsers());
            Log.i("FETCHED USERS", users.toString());
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            progressBar.setVisibility(View.INVISIBLE);
        }
    }

}
