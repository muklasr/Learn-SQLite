package com.muklas.learnsqlite;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListVH> {
    private ArrayList<Contact> list;

    public ListAdapter(ArrayList<Contact> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ListAdapter.ListVH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_item, viewGroup, false);
        return new ListVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListAdapter.ListVH listVH, int i) {
        Contact contact = list.get(i);

        listVH.tvName.setText(contact.getName());
        listVH.tvPhone.setText(contact.getPhone());
        listVH.tvAddress.setText(contact.getAddress());

        listVH.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ListVH extends RecyclerView.ViewHolder{
        private TextView tvName, tvPhone, tvAddress;

        public ListVH(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_name);
            tvPhone = itemView.findViewById(R.id.tv_phone);
            tvAddress = itemView.findViewById(R.id.tv_address);
        }
    }
}
