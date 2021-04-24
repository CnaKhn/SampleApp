package com.example.sample_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ContactsActivity extends AppCompatActivity implements View.OnClickListener {
    private RecyclerView recyclerView;
    private EditText inputContact;
    private Button btnSaveContact;
    private ContactsAdapter contactsAdapter;
    private int itemEditPosition = -1; //-1=not editing

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);
        initViews();
    }

    public void initViews() {
        contactsAdapter = new ContactsAdapter((fullName, position) -> {
            itemEditPosition = position;
            inputContact.setText(fullName);
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