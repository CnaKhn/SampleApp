package com.example.sample_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FragmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.frame_main_fragment_container, new MainFragment(), "Fragment");
        transaction.addToBackStack("MainFragment");
        transaction.commit();

        Button button = findViewById(R.id.btn_remove_fragment);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.frame_main_fragment_container);
                FragmentTransaction removeTransaction = getSupportFragmentManager().beginTransaction();
                removeTransaction.remove(fragment);
            }
        });
    }
}