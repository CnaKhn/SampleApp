package com.example.sample_app.EventBusExample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.sample_app.R;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class EventBusActivity extends AppCompatActivity {
    private static final String TAG = "EventBusActivity";
    EditText inputChild;
    Button btnChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_bus);

        EventBus.getDefault().register(this);

        inputChild = findViewById(R.id.input_event_bus);
        btnChild = findViewById(R.id.btn_event_bus);
        btnChild.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(EventBusActivity.this, ChildActivity.class));
            }
        });
    }

    @Subscribe
    public void onEvent(CustomMessageEvent messageEvent) {
        Log.d(TAG, "onEvent: Event Fired : " + messageEvent.getMessage());
        inputChild.setText(messageEvent.getMessage());
    }


}