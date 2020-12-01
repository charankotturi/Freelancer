package com.example.minicompany.adaptor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.minicompany.R;
import com.example.minicompany.models.PopularFieldsModel;

import java.util.ArrayList;

public class popularFieldsAdaptor extends RecyclerView.Adapter<popularFieldsAdaptor.ViewHolder> {

    ArrayList<PopularFieldsModel> popularFields = new ArrayList<>();
    private Context mContext;

    public popularFieldsAdaptor(Context mContext) {
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.popular_fields_model, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.activityName.setText(popularFields.get(position).getFieldName());
        Glide.with(mContext)
                .asBitmap()
                .load(popularFields.get(position).getImgURL())
                .placeholder(R.drawable.placeholder)
                .into(holder.imgUrl);

    }

    @Override
    public int getItemCount() {
        return popularFields.size();
    }

    public void setPopularFields(ArrayList<PopularFieldsModel> popularFields) {
        this.popularFields = popularFields;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgUrl;
        private TextView activityName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imgUrl = itemView.findViewById(R.id.imagePopularFieldsCard);
            activityName = itemView.findViewById(R.id.txtPopularFields);
        }
    }
}
