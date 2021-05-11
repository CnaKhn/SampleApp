package com.example.sample_app.EventBusExample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.sample_app.R;

import org.greenrobot.eventbus.EventBus;

public class ChildActivity extends AppCompatActivity {
    Button btnChild;
    EditText inputChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child);
        btnChild = findViewById(R.id.btn_child);
        inputChild = findViewById(R.id.input_child);

        btnChild.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }
}