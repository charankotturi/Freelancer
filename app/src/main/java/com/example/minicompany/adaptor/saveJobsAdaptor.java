package com.example.minicompany.adaptor;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.minicompany.JobActivity;
import com.example.minicompany.MyApplicationActivity;
import com.example.minicompany.R;
import com.example.minicompany.data.Utils;
import com.example.minicompany.models.jobModel;

import java.util.ArrayList;

public class saveJobsAdaptor extends RecyclerView.Adapter<saveJobsAdaptor.ViewHolder> {

    private Context mContext;
    private ArrayList<jobModel> jobModels = new ArrayList<>();

    public saveJobsAdaptor(Context mContext) {
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.save_item_model, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.companyName.setText(jobModels.get(position).getCompanyTitle());
        holder.companyReq.setText(jobModels.get(position).getCategory());
        holder.stipendMonth.setText(jobModels.get(position).getStipend());


        Glide.with(mContext)
                .asBitmap()
                .load(jobModels.get(position).getCompanyLogo())
                .placeholder(R.drawable.placeholder)
                .into(holder.imgCompanyLogo);

        holder.btnApplyNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean exits = false;
                ArrayList<jobModel> allApplicationJobs = Utils.getAllApplications(mContext);

                if (allApplicationJobs != null) {
                    for (jobModel j: allApplicationJobs) {
                        if (j.getId() == jobModels.get(position).getId()) {
                            exits = true;
                        }
                    }
                }else {
                    Utils.addApplications(mContext, jobModels.get(position));
                    mContext.startActivity(new Intent(mContext, MyApplicationActivity.class));
                }

                if (!exits) {
                    Utils.addApplications(mContext, jobModels.get(position));
                    mContext.startActivity(new Intent(mContext, MyApplicationActivity.class));
                }else {
                    holder.btnApplyNow.setClickable(false);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return jobModels.size();
    }

    public void setJobModels(ArrayList<jobModel> jobModels) {
        this.jobModels = jobModels;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView companyReq, companyName, stipendMonth, btnApplyNow;
        private ImageView imgCompanyLogo;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            companyName = itemView.findViewById(R.id.txtCompanyTitle);
            companyReq = itemView.findViewById(R.id.txtCompanyReq);


            stipendMonth = itemView.findViewById(R.id.txtStipendPerMonth);
            imgCompanyLogo = itemView.findViewById(R.id.imgCompanyLogo);
            btnApplyNow = itemView.findViewById(R.id.btnApplyNow);

        }
    }
}
