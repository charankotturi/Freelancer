package com.example.minicompany.adaptor;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.minicompany.R;

import java.util.ArrayList;

public class tagAdaptor extends RecyclerView.Adapter<tagAdaptor.ViewHolder> {

    ArrayList<String> tags = new ArrayList<>();

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tag_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtSkillTags.setText(tags.get(position).toString());
    }

    @Override
    public int getItemCount() {
        return tags.size();
    }

    public void setTags(ArrayList<String> tags) {
        this.tags = tags;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView txtSkillTags;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtSkillTags = itemView.findViewById(R.id.txtSkillTag);

        }
    }

}
