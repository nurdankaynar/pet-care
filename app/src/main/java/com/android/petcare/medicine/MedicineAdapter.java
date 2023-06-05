package com.android.petcare.medicine;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.android.petcare.R;
import com.android.petcare.database.entities.labtest.LabTest;
import com.android.petcare.database.entities.medicine.Medicine;
import com.bumptech.glide.Glide;

import java.util.List;

public class MedicineAdapter extends RecyclerView.Adapter<MedicineAdapter.ViewHolder> {
    private List<Medicine> listdata;

    public MedicineAdapter(List<Medicine> listdata) {
        this.listdata = listdata;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.item_medcine, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Medicine myListData = listdata.get(position);
        holder.title.setText(myListData.getName());
        holder.shortDesc.setText(myListData.getDesc());
        holder.shortDesc.setText(myListData.getDesc());
        holder.price.setText(myListData.getPrice() + "₺");
        Glide.with(holder.itemView.getContext()).load(myListData.getImage()).into(holder.image);
    }


    @Override
    public int getItemCount() {
        return listdata.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView image;
        public TextView title;
        public TextView shortDesc;
        public TextView price;

        public ViewHolder(View itemView) {
            super(itemView);
            this.title = (TextView) itemView.findViewById(R.id.txtTitle);
            this.shortDesc = (TextView) itemView.findViewById(R.id.txtShortDesc);
            this.image = (ImageView) itemView.findViewById(R.id.ivImage);
            this.price = (TextView) itemView.findViewById(R.id.txtPrice);
        }
    }
}