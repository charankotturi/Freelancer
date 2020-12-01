package com.example.minicompany.adaptor;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.minicompany.R;
import com.example.minicompany.fragment.searchFragment;

import java.util.ArrayList;

public class resTagAdaptor extends RecyclerView.Adapter<resTagAdaptor.ViewHolder> {

    ArrayList<String> tags = new ArrayList<>();
    private Context mContext;

    public resTagAdaptor(Context mContext) {
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.res_tag_layout, parent, false);
        return new resTagAdaptor.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtSkillTags.setText(tags.get(position).toString());
        holder.tagCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Utils.setCategory(tags.get(position));
                searchFragment fragment= new searchFragment();
                Bundle bundle = new Bundle();
                bundle.putString("lol" ,tags.get(position));
                fragment.setArguments(bundle);
                Navigation.findNavController((Activity) mContext, R.id.fragment).navigate(R.id.itmSearch, bundle);
            }
        });
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
        private CardView tagCard;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtSkillTags = itemView.findViewById(R.id.txtSkillTag);
            tagCard = itemView.findViewById(R.id.tagCard);

        }
    }
}
