package com.example.sample_app;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class MyDialogFragment extends DialogFragment {
    private MyDialogListener dialogListener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        dialogListener = (MyDialogListener) context;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        View view = LayoutInflater.from(getContext()).inflate(R.layout.dialog_fragment, null, false);
        builder.setView(view);

        EditText inputText = view.findViewById(R.id.input_dialog);
        Button btnOK = view.findViewById(R.id.btn_dialog_ok);
        Button btnCancel = view.findViewById(R.id.btn_dialog_cancel);

        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (inputText.length() > 0) {
                    dialogListener.onOkButtonClicked(inputText.getText().toString());
                    dismiss();
                }
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogListener.onCancelButtonClicked();
                dismiss();
            }
        });
        return builder.create();
    }

    interface MyDialogListener {
        void onOkButtonClicked(String data);
        void onCancelButtonClicked();
    }

}
