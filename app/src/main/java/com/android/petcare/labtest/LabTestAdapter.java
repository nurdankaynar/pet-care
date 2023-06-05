package com.android.petcare.labtest;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.android.petcare.R;
import com.android.petcare.database.entities.labtest.LabTest;

import java.util.List;

public class LabTestAdapter extends RecyclerView.Adapter<LabTestAdapter.ViewHolder> {
    private List<LabTest> listdata;
    private LabTestItemListener listener;

    public LabTestAdapter(List<LabTest> listdata, LabTestItemListener listener) {
        this.listdata = listdata;
        this.listener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.item_lab_test, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final LabTest myListData = listdata.get(position);
        holder.title.setText(myListData.getTitle());
        holder.shortDesc.setText(myListData.getShortDesc());
        holder.date.setText(myListData.getDate());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onItemClick(myListData.getFie_id());
            }
        });
    }


    @Override
    public int getItemCount() {
        return listdata.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public TextView shortDesc;
        public TextView date;
        public CardView cardView;

        public ViewHolder(View itemView) {
            super(itemView);
            this.cardView = (CardView) itemView.findViewById(R.id.cwLabCard);
            this.title = (TextView) itemView.findViewById(R.id.txtTitle);
            this.date = (TextView) itemView.findViewById(R.id.txtDate);
            this.shortDesc = (TextView) itemView.findViewById(R.id.txtShortDesc);
        }
    }

    interface LabTestItemListener {
        void onItemClick(int articleId);
    }
}