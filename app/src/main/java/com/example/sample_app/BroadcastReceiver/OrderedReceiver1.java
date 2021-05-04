package com.example.sample_app.BroadcastReceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.widget.Toast;

public class OrderedReceiver1 extends BroadcastReceiver {
    @Override // CUSTOM BROADCAST RECEIVER
    public void onReceive(Context context, Intent intent) {
        /*if ("com.example.sample_app.EXAMPLE_ACTION".equals(intent.getAction())) {
            String receivedText = intent.getStringExtra("com.example.sample_app.EXTRA_TEXT");
            Toast.makeText(context, receivedText, Toast.LENGTH_SHORT).show();
        }*/
        int resultCode = getResultCode();
        String resultData = getResultData();
        Bundle resultExtras = getResultExtras(true);
        String stringExtra = resultExtras.getString("stringExtra");
        resultCode++;
        stringExtra += "->OR1";
        String toastText = "OR1\n" + "resultCode: " + resultCode + "\n" + " resultData: " + resultData + "\n" + "stringExtra: " + stringExtra;
        Toast.makeText(context, toastText, Toast.LENGTH_LONG).show();
        resultData = "OR1";
        resultExtras.putString("stringExtra", stringExtra);
        setResult(resultCode, resultData, resultExtras);
    }
    /*@Override
    public void onReceive(Context context, Intent intent) {
        if (Intent.ACTION_BOOT_COMPLETED.equals(intent.getAction())) {
            Toast.makeText(context, "Boot Completed.", Toast.LENGTH_SHORT).show();
        }

        if (ConnectivityManager.CONNECTIVITY_ACTION.equals(intent.getAction())) {
            boolean noConnectivity = intent.getBooleanExtra(ConnectivityManager.EXTRA_NO_CONNECTIVITY, false);
            if (noConnectivity) {
                Toast.makeText(context, "Disconnected.", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(context, "Connected.", Toast.LENGTH_SHORT).show();
            }
        }
    }*/
}
