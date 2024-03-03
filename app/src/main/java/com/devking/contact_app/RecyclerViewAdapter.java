package com.devking.contact_app;

import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.View_Holder> {

    ArrayList<Model_class> data;
    ClickLIstner clickLIstner;

    public RecyclerViewAdapter(ArrayList<Model_class> data , ClickLIstner clickLIstner) {
        this.data = data;
        this.clickLIstner = clickLIstner;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.View_Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_model,parent,false);
        return new View_Holder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull View_Holder holder, int position) {
        Model_class currentitem = data.get(position);
        if (currentitem != null) {
            holder.name.append("Name :" + currentitem.getName());
            holder.phn_number.append("PhoneNumber :" +currentitem.getPhn_number().toString());
        }

    }

    @Override
    public int getItemCount() {
        return (data != null) ? data.size() : 0;
    }


    public class  View_Holder extends RecyclerView.ViewHolder {

        TextView name , phn_number;
        public View_Holder(@NonNull View itemView) {
            super(itemView);

                name = itemView.findViewById(R.id.name);
                phn_number = itemView.findViewById(R.id.phn_number);

                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        clickLIstner.onItemClick(getAdapterPosition());
                    }
                });
        }

    }

    public void updateData(ArrayList<Model_class> newData) {
        data = newData;
        notifyDataSetChanged();
    }
}
