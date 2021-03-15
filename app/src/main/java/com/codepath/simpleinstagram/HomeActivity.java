package com.codepath.simpleinstagram;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {
    private ImageView ivUser;
    private ImageView ivHome;
    private ImageView ivAdd;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ivUser = findViewById(R.id.ivUser);
        ivHome = findViewById(R.id.ivHome);
        ivAdd = findViewById(R.id.ivAdd);

        ivUser.setImageDrawable(getResources().getDrawable(R.drawable.instagram_user_outline_24));
        ivHome.setImageDrawable(getResources().getDrawable(R.drawable.instagram_home_filled_24));
        ivAdd.setImageDrawable(getResources().getDrawable(R.drawable.instagram_new_post_outline_24));
        ivUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ivUser.setImageDrawable(getResources().getDrawable(R.drawable.instagram_user_filled_24));
                ivHome.setImageDrawable(getResources().getDrawable(R.drawable.instagram_home_outline_24));
                ivAdd.setImageDrawable(getResources().getDrawable(R.drawable.instagram_new_post_outline_24));
                goUserActivity();
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

    private void goUserActivity() {
        Intent i = new Intent(this, UserActivity.class);
        startActivity(i);
        finish();
    }
    private void goMainActivity() {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        finish();
    }
}
