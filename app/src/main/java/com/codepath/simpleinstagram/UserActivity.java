package com.codepath.simpleinstagram;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.parse.ParseUser;

public class UserActivity extends AppCompatActivity {

    private ImageView ivUser;
    private ImageView ivHome;
    private ImageView ivAdd;
    private Button btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        ivUser = findViewById(R.id.ivUser);
        ivHome = findViewById(R.id.ivHome);
        ivAdd = findViewById(R.id.ivAdd);
        btnLogout = findViewById(R.id.btnLogout);

        //Layout templates
        ivUser.setImageDrawable(getResources().getDrawable(R.drawable.instagram_user_filled_24));
        ivHome.setImageDrawable(getResources().getDrawable(R.drawable.instagram_home_outline_24));
        ivAdd.setImageDrawable(getResources().getDrawable(R.drawable.instagram_new_post_outline_24));

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ParseUser.logOut();
                ParseUser currentUser = ParseUser.getCurrentUser();
                if (currentUser == null) {
                    Intent i = new Intent(UserActivity.this, LoginActivity.class);
                    Toast.makeText(UserActivity.this,"You have Successfully logged out!",Toast.LENGTH_SHORT).show();
                    startActivity(i);
                }
            }
        });
        ivHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ivUser.setImageDrawable(getResources().getDrawable(R.drawable.instagram_user_outline_24));
                ivHome.setImageDrawable(getResources().getDrawable(R.drawable.instagram_home_filled_24));
                ivAdd.setImageDrawable(getResources().getDrawable(R.drawable.instagram_new_post_outline_24));
                goHomeActivity();
            }
        });
        ivAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ivUser.setImageDrawable(getResources().getDrawable(R.drawable.instagram_user_outline_24));
                ivHome.setImageDrawable(getResources().getDrawable(R.drawable.instagram_home_outline_24));
                ivAdd.setImageDrawable(getResources().getDrawable(R.drawable.instagram_new_post_filled_24));
                goMainActivity();
            }
        });
    }

    private void goHomeActivity() {
        Intent i = new Intent(this, HomeActivity.class);
        startActivity(i);
        finish();
    }
    private void goMainActivity() {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        finish();
    }
}
