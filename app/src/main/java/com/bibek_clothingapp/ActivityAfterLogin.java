package com.bibek_clothingapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class ActivityAfterLogin extends AppCompatActivity {

    private Button btnAddItems, btnDashboard;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_after_login);

        btnAddItems= findViewById(R.id.btnAddItems);
        btnDashboard = findViewById(R.id.btnDashboard);

        btnAddItems.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addIntent = new Intent(ActivityAfterLogin.this, ActivityAfterLogin.class);
                startActivity(addIntent);
            }
        });

        btnDashboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dashboardIntent= new Intent(ActivityAfterLogin.this, DashboardActivity.class );
                startActivity(dashboardIntent);
            }
        });
    }
}
