package com.bibek_clothingapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;
import java.io.PrintStream;

public class AddItemsActivity extends AppCompatActivity {
    EditText etItemName, etItemPrice, etItemImageName, etItemDescription;
    Button btnAdd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_add_items);

        etItemName = findViewById(R.id.et_ItemName);
        etItemPrice = findViewById(R.id.et_ItemPrice);
        etItemImageName = findViewById(R.id.et_ItemImageName);
        etItemDescription = findViewById(R.id.et_ItemDescription);
        btnAdd = findViewById(R.id.btn_Add);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Save();

            }
        });
    }

    private void Save(){
        try {
            PrintStream printStream = new PrintStream(openFileOutput("item.txt",MODE_PRIVATE|MODE_APPEND));
            printStream.println(etItemName.getText().toString()+"->"+etItemPrice.getText().toString()+"->"
                    +etItemImageName.getText().toString()+"->"+etItemDescription.getText().toString());
            etItemName.setText("");
            etItemPrice.setText("");
            etItemImageName.setText("");
            etItemDescription.setText("");

            Toast.makeText(AddItemsActivity.this, "Saved to" +getFilesDir(),Toast.LENGTH_LONG).show();

        } catch (IOException e) {
            Log.d("Item Add","Error"+e.toString());
            e.printStackTrace();
        }
    }
}
