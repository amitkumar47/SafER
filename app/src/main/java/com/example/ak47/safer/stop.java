package com.example.ak47.safer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class stop extends AppCompatActivity {

    public void Stop (View view){
        Intent amit = new Intent(".MainActivity");
        startActivity(amit);
    }
}
