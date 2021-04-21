package com.example.sample_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.facebook.imagepipeline.core.ImageTranscoderType;
import com.facebook.imagepipeline.core.MemoryChunkType;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private RecyclerView recyclerView;
    private EditText inputContact;
    private Button btnSaveContact;
    private ContactsAdapter contactsAdapter;
    private int itemEditPosition = -1; //-1=not editing,

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
        initViews();
    }

    public void initViews() {
        contactsAdapter = new ContactsAdapter(new ContactsAdapter.ItemEventListener() {
            @Override
            public void onItemClick(String fullName, int position) {
                itemEditPosition = position;
                inputContact.setText(fullName);
            }
        });
        inputContact = findViewById(R.id.input_contact_name);
        btnSaveContact = findViewById(R.id.btn_save_contact);
        btnSaveContact.setOnClickListener(this);
        recyclerView = findViewById(R.id.rv_main);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        recyclerView.setAdapter(contactsAdapter);
    }

    @Override
    public void onClick(View v) {
        if (v.equals(btnSaveContact)) {
            if (inputContact.length() > 0) {
                if (itemEditPosition > -1) {
                    contactsAdapter.update(inputContact.getText().toString(), itemEditPosition);
                    itemEditPosition = -1;
                } else {
                    contactsAdapter.add(inputContact.getText().toString());
                    recyclerView.smoothScrollToPosition(0);
                    itemEditPosition = -1;
                }
                inputContact.setText("");
            }
        }
    }
}