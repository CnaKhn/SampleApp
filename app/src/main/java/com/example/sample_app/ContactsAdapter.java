package com.example.sample_app;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ContactViewHolder> {
    private ArrayList<String> contacts;
    private ItemEventListener itemEventListener;

    public ContactsAdapter(ItemEventListener itemEventListener) {
        contacts = new ArrayList<>();
        this.itemEventListener = itemEventListener;
        contacts.add("Sina Khanbabaei");
        contacts.add("asd asd");
        contacts.add("dsa dsa");
        contacts.add("dsa asd");
        contacts.add("akjgh ljg");
        contacts.add("alk g asf");
        contacts.add("k ajfa ");
        contacts.add("klauweghruih");
        contacts.add("ytrb");
        contacts.add("hjhd");
        contacts.add("awegfg");
        contacts.add("kjghs");
        contacts.add("yertg");
        contacts.add("jhgfsa");
        contacts.add("jhfgsdfg");
        contacts.add("jhsrt");
        contacts.add("fghwef");
        contacts.add("jiyre");
        contacts.add("dfgq");
        contacts.add("qtre");
    }

    public void add(String fullName) {
        contacts.add(0, fullName);
        notifyItemInserted(0);

    }

    public void update(String fullName, int position) {
        contacts.set(position, fullName + " EDITED");
        notifyItemChanged(position);
    }

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ContactViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_contact, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {
        holder.bind(contacts.get(position));
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    public class ContactViewHolder extends RecyclerView.ViewHolder {
        private TextView tvFirstChar;
        private TextView tvFullName;

        public ContactViewHolder(@NonNull View itemView) {
            super(itemView);
            tvFirstChar = itemView.findViewById(R.id.tv_first_char);
            tvFullName = itemView.findViewById(R.id.tv_full_name);
        }

        public void bind(String fullName) {
            tvFullName.setText(fullName);
            tvFirstChar.setText(fullName.substring(0, 1).toUpperCase());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    itemEventListener.onItemClick(fullName, getAdapterPosition());
                }
            });
            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    contacts.remove(getAdapterPosition());
                    notifyItemRemoved(getAdapterPosition());
                    return false;
                }
            });
        }
    }

    public interface ItemEventListener {
        void onItemClick(String fullName, int position);
    }

}
