package com.example.sample_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class FragmentActivity extends AppCompatActivity implements MyDialogFragment.MyDialogListener {

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
                if (fragment != null) {
                    FragmentTransaction removeTransaction = getSupportFragmentManager().beginTransaction();
                    removeTransaction.remove(fragment);
                    removeTransaction.addToBackStack(null);
                    removeTransaction.commit();
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add("Show Dialog Fragment").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                MyDialogFragment dialogFragment = new MyDialogFragment();
                dialogFragment.show(getSupportFragmentManager(), null);
                return false;
            }
        });

        menu.add("View Pager 2").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                startActivity(new Intent(FragmentActivity.this, ViewPager2Activity.class));
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onOkButtonClicked(String data) {
        TextView textView = findViewById(R.id.txt_activity_fragment);
        textView.setText(data);

    }

    @Override
    public void onCancelButtonClicked() {
        Toast.makeText(this, "Cancel Button Clicked.", Toast.LENGTH_SHORT).show();
    }
}