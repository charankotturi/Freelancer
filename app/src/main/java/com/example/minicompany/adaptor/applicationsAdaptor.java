package com.example.minicompany.adaptor;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.minicompany.R;
import com.example.minicompany.models.jobModel;

import java.util.ArrayList;

public class applicationsAdaptor extends RecyclerView.Adapter<applicationsAdaptor.ViewHolder> {

    private Context mContext;
    private ArrayList<jobModel> jobModels = new ArrayList<>();

    public applicationsAdaptor(Context mContext) {
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_applications_model, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.companyName.setText(jobModels.get(position).getCompanyTitle());
        holder.companyReq.setText(jobModels.get(position).getCategory());
        holder.stipendMonth.setText(jobModels.get(position).getStipend());

        String workEnv = jobModels.get(position).getWorkEnv();

        Glide.with(mContext)
                .asBitmap()
                .load(jobModels.get(position).getCompanyLogo())
                .placeholder(R.drawable.placeholder)
                .into(holder.imgCompanyLogo);

        if (jobModels.get(position).getStatus() != null) {
            holder.txtStatus.setText(jobModels.get(position).getStatus());
        }

        holder.btnChatWithCompany.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext, "you will be directed to "+jobModels.get(position).getCompanyTitle()+ " chat!", Toast.LENGTH_SHORT).show();
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

        private TextView companyReq, companyName, stipendMonth, txtStatus;
        private ImageView imgCompanyLogo, btnChatWithCompany;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            companyName = itemView.findViewById(R.id.txtCompanyTitle);
            companyReq = itemView.findViewById(R.id.txtCompanyReq);


            stipendMonth = itemView.findViewById(R.id.txtStipendPerMonth);
            imgCompanyLogo = itemView.findViewById(R.id.imgCompanyLogo);
            txtStatus = itemView.findViewById(R.id.txtStatus);
            btnChatWithCompany = itemView.findViewById(R.id.imgChatApplication);

        }
    }
}
