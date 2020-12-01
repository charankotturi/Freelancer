package com.example.minicompany.adaptor;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.minicompany.ProviderActivity;
import com.example.minicompany.R;
import com.example.minicompany.data.Utils;
import com.example.minicompany.models.jobProviderModel;

import java.util.ArrayList;


public class jobProviderModelAdaptor extends RecyclerView.Adapter<jobProviderModelAdaptor.ViewHolder> {

    ArrayList<jobProviderModel> modelAdaptors = new ArrayList<>();
    private Context context;

    public static String PROVIDER_JOB_MAN = "lol i will never get employed";

    public jobProviderModelAdaptor(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.job_provider_model, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtUserName.setText(modelAdaptors.get(position).getProviderName());
        holder.txtProviderRating.setText(modelAdaptors.get(position).getRating());

        if (modelAdaptors.get(position).getpSkills() != null){
            tagAdaptor adaptor = new tagAdaptor();
            holder.recViewSkills.setAdapter(adaptor);
            holder.recViewSkills.setLayoutManager(new LinearLayoutManager(context, RecyclerView.HORIZONTAL, false));
            adaptor.setTags(modelAdaptors.get(position).getpSkills());
        }

        holder.provider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ProviderActivity.class);
                intent.putExtra(PROVIDER_JOB_MAN, modelAdaptors.get(position));
                context.startActivity(intent);
                //TODO: direct em to another activity. that's it check and sell.
            }
        });
    }

    @Override
    public int getItemCount() {
        return modelAdaptors.size();
    }

    public void setModelAdaptors(ArrayList<jobProviderModel> modelAdaptors) {
        this.modelAdaptors = modelAdaptors;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView txtUserName;
        private TextView txtProviderRating;
        private CardView provider;
        private RecyclerView recViewSkills;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtProviderRating = itemView.findViewById(R.id.providerRating);
            txtUserName = itemView.findViewById(R.id.txtUserName);
            provider = itemView.findViewById(R.id.providerCard);
            recViewSkills = itemView.findViewById(R.id.recViewPSkills);

        }
    }
}
