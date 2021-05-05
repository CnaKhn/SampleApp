package com.example.sample_app.BroadcastReceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.widget.Toast;

public class ExampleBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        /*if (Intent.ACTION_BOOT_COMPLETED.equals(intent.getAction())) {

            Toast.makeText(context, "BOOT COMPLETED!", Toast.LENGTH_SHORT).show();

        }*/

        if (ConnectivityManager.CONNECTIVITY_ACTION.equals(intent.getAction())) {
            boolean noConnectivity = intent.getBooleanExtra(ConnectivityManager.EXTRA_NO_CONNECTIVITY, false);
            if (noConnectivity) {
                Toast.makeText(context, "No Connection.", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(context, "INTERNET CONNECTION FOUND!", Toast.LENGTH_SHORT).show();
            }

        }
    }
}
