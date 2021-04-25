package com.example.sample_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.transition.Slide;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class ViewPager2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager2);
        ViewPager2 viewPager2 = findViewById(R.id.view_pager2);
        SlideAdapter adapter = new SlideAdapter(this);
        viewPager2.setOrientation(ViewPager2.ORIENTATION_VERTICAL);
        viewPager2.setCurrentItem(2);
        viewPager2.setAdapter(adapter);

        TabLayout tabLayout = findViewById(R.id.tab_layout);
        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(tabLayout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch (position) {
                    case 0:
                        tab.setText("A");
                        break;
                    case 1:
                        tab.setText("B");
                        break;
                    case 2:
                        tab.setText("C");
                        break;
                    case 3:
                        tab.setText("D");
                        break;
                    case 4:
                        tab.setText("E");
                        break;
                }
            }
        });
        tabLayoutMediator.attach();
    }
}