package com.codepath.simpleinstagram;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class LoginActivity extends AppCompatActivity {
    public static final String TAG = "LoginActivity";
    private EditText etUsername;
    private EditText etPassword;
    private Button btnSignup;
    private Button btnLogin;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // If there is a User signed in..
        if (ParseUser.getCurrentUser() != null) {
            goHomeActivity();
        }

        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnSignup = findViewById(R.id.btnSignup);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG,"onClick login button");
                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();
                loginUser(username,password);
            }
        });
        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();
                if(username.isEmpty()){
                    Toast.makeText(LoginActivity.this, "Username cannot be empty!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(password.isEmpty()){
                    Toast.makeText(LoginActivity.this, "Password cannot be empty!", Toast.LENGTH_SHORT).show();
                    return;
                }
                signupUser(username,password);
            }
        });
    }

    private void signupUser(String username, String password) {
        ParseUser user = new ParseUser();
        //set parameters
        user.setUsername(username);
        user.setPassword(password);

        // Invoke signUpInBackground
        user.signUpInBackground(new SignUpCallback() {
            @Override
            public void done(ParseException e) {
                if(e != null) {
                    Log.e(TAG, "Issue with signing up new user!", e);
                    Toast.makeText(LoginActivity.this, "Error while signup",Toast.LENGTH_SHORT).show();
                    return;
                }
                Log.i(TAG,"Signed up successfully!");
                Toast.makeText(LoginActivity.this, "You have successfully signed up!", Toast.LENGTH_SHORT).show();
                etUsername.setText("");
                etPassword.setText("");
            }
        });
    }

    private void loginUser(String username, String password) {
        Log.i(TAG,"Attempting to login user "+ username);
        ParseUser.logInInBackground(username, password, new LogInCallback() {
            @Override
            public void done(ParseUser user, ParseException e) {
                if (e != null) {
                    Log.e(TAG, "Issue with login", e);
                    Toast.makeText(LoginActivity.this,"Issue with login!",Toast.LENGTH_SHORT).show();
                    return;
                }
                //navigate to the home activity if the user has signed in properly.
                goHomeActivity();
                Toast.makeText(LoginActivity.this,"Success!",Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void goHomeActivity() {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        finish();
    }
}
