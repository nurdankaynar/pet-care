package com.android.petcare.doctor;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.android.petcare.R;
import com.android.petcare.database.entities.medicine.Medicine;
import com.android.petcare.database.entities.vet.Veteriner;
import com.bumptech.glide.Glide;

import java.util.List;

public class VetAdapter extends RecyclerView.Adapter<VetAdapter.ViewHolder> {
    private List<Veteriner> listdata;

    public VetAdapter(List<Veteriner> listdata) {
        this.listdata = listdata;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.item_doctor, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Veteriner myListData = listdata.get(position);
        holder.nameSurname.setText(myListData.getFirstName() + " " + myListData.getLastName());
        holder.clinic.setText(myListData.getClinic());
        holder.rating.setRating(new Float(myListData.getRating()));
        Glide.with(holder.itemView.getContext()).load(myListData.getImage()).into(holder.image);
    }


    @Override
    public int getItemCount() {
        return listdata.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView image;
        public TextView nameSurname;
        public TextView clinic;
        public RatingBar rating;

        public ViewHolder(View itemView) {
            super(itemView);
            this.nameSurname = (TextView) itemView.findViewById(R.id.doctorName);
            this.clinic = (TextView) itemView.findViewById(R.id.doctorClinic);
            this.image = (ImageView) itemView.findViewById(R.id.doctorImage);
            this.rating = (RatingBar) itemView.findViewById(R.id.doctorRating);
        }
    }
}