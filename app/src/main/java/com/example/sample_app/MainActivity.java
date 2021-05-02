package com.example.sample_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.sample_app.BroadcastReceiver.BroadcastReceiverActivity;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*ImageView picassoImageView = findViewById(R.id.picasso_image_view);
        Picasso
                .get()
                .load(R.drawable.wallpaper)
                .into(picassoImageView);

        ImageView glideImageView = findViewById(R.id.glide_image_view);
        Glide
                .with(this)
                .load(R.drawable.wallpaper)
                .into(glideImageView);

        ImageView frescoImageView = findViewById(R.id.fresco_image_view);
        Fresco.initialize(this,
                ImagePipelineConfig.newBuilder(this)
                        .setMemoryChunkType(MemoryChunkType.BUFFER_MEMORY)
                        .setImageTranscoderType(ImageTranscoderType.JAVA_TRANSCODER)
                        .experiment()
                        .setNativeCodeDisabled(true)
                        .build());

        */
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add("Contacts").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                startActivity(new Intent(MainActivity.this, ContactsActivity.class));
                return false;
            }
        });
        menu.add("Fragments").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                startActivity(new Intent(MainActivity.this, FragmentActivity.class));
                return false;
            }
        });
        menu.add("BroadcastReceiver").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                startActivity(new Intent(MainActivity.this, BroadcastReceiverActivity.class));
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
}