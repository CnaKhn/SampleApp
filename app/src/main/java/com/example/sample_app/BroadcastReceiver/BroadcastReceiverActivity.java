package com.example.sample_app.BroadcastReceiver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;

import com.example.sample_app.R;

public class BroadcastReceiverActivity extends AppCompatActivity {
    //ExampleBroadcastReceiver broadcastReceiver = new ExampleBroadcastReceiver();
    OrderedReceiver1 orderedReceiver1 = new OrderedReceiver1();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast_receiver);
        /*IntentFilter filter = new IntentFilter("com.example.sample_app.EXAMPLE_ACTION");
        registerReceiver(broadcastReceiver, filter);*/
        IntentFilter filter = new IntentFilter("com.example.sample_app.EXAMPLE_ACTION");
        registerReceiver(orderedReceiver1, filter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(orderedReceiver1);
    }

    /*@Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(broadcastReceiver);
    }*/
}