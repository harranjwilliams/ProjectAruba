package com.aruba.android.projectaruba;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseAnalytics;
import com.parse.ParseException;
import com.parse.ParseUser;

public class MainActivity extends AppCompatActivity {

    protected EditText usernameEditText;
    protected EditText passwordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameEditText = findViewById(R.id.usernameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);

        if (ParseUser.getCurrentUser() != null) {
            //TODO Go to logged in INTENT
        }

        ParseAnalytics.trackAppOpenedInBackground(getIntent());
    }

    public void onLoginButtonListener(View view) {
        String username = usernameEditText.getText().toString();
        String password = passwordEditText.getText().toString();
        if (username.matches("") || password.matches("")) {
            Toast.makeText(this, "A username and a password are required.", Toast.LENGTH_LONG).show();
        }
        else {
            ParseUser.logInInBackground(username, password, new LogInCallback() {
                @Override
                public void done(ParseUser user, ParseException e) {
                    if (e == null) {
                        Log.i("LogInCallback", "OK!");
                        //TODO Go to logged in INTENT
                    } else {
                        Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }

                }
            });
        }
        Log.i("MainActivity", "Login button clicked");
    }
}
