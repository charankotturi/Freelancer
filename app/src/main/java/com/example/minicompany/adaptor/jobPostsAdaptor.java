package com.example.minicompany.adaptor;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.minicompany.JobActivity;
import com.example.minicompany.R;
import com.example.minicompany.models.jobModel;

import java.util.ArrayList;

public class jobPostsAdaptor extends RecyclerView.Adapter<jobPostsAdaptor.ViewHolder> {

    private Context mContext;
    private ArrayList<jobModel> jobModels = new ArrayList<>();

    private static final String TAG = "jobPostAdaptor";
    public static final String JOB_REVIEW = "reviewing the job";

    public jobPostsAdaptor(Context mContext) {
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.job_model, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.companyName.setText(jobModels.get(position).getCompanyTitle());
        holder.companyReq.setText(jobModels.get(position).getCategory());
        holder.durationOfJob.setText(jobModels.get(position).getDuration());
        holder.stipendMonth.setText(jobModels.get(position).getStipend());

        String workEnv = jobModels.get(position).getWorkEnv();

        holder.workEnv.setText(workEnv);

        if (workEnv.equalsIgnoreCase("work from office")) {
            Glide.with(mContext)
                    .asBitmap()
                    .load(R.drawable.ic_office)
                    .into(holder.imgWorkEnv);
        }

        if (workEnv.equalsIgnoreCase("work from home")) {
            Glide.with(mContext)
                    .asBitmap()
                    .load(R.drawable.ic_home)
                    .into(holder.imgWorkEnv);
        }

        Glide.with(mContext)
                .asBitmap()
                .load(jobModels.get(position).getCompanyLogo())
                .placeholder(R.drawable.placeholder)
                .into(holder.imgCompanyLogo);

        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, JobActivity.class);
                intent.putExtra(JOB_REVIEW, jobModels.get(position));
                mContext.startActivity(intent);
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

        private TextView companyReq, companyName, workEnv, stipendMonth, durationOfJob;
        private ImageView imgWorkEnv, imgCompanyLogo;
        private RelativeLayout parent;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            companyName = itemView.findViewById(R.id.txtCompanyTitle);
            companyReq = itemView.findViewById(R.id.txtCompanyReq);
            workEnv = itemView.findViewById(R.id.txtWorkEnv);
            imgWorkEnv = itemView.findViewById(R.id.imgWorkEnv);
            stipendMonth = itemView.findViewById(R.id.txtStipendPerMonth);
            durationOfJob = itemView.findViewById(R.id.txtTimeOfJob);
            imgCompanyLogo = itemView.findViewById(R.id.imgCompanyLogo);
            parent = itemView.findViewById(R.id.parent);

        }
    }
}
