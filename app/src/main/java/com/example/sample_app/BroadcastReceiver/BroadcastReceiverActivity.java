package com.example.sample_app.BroadcastReceiver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.IntentFilter;
import android.os.Bundle;

import com.example.sample_app.R;

import static com.example.sample_app.BroadcastReceiver.ExampleBroadcastReceiver.MY_CUSTOM_ACTION;

public class BroadcastReceiverActivity extends AppCompatActivity {
    ExampleBroadcastReceiver receiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast_receiver);
        receiver = new ExampleBroadcastReceiver();

        IntentFilter filter = new IntentFilter();
        filter.addAction(MY_CUSTOM_ACTION);
        registerReceiver(receiver, filter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(receiver);
    }
}