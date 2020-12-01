package com.example.minicompany.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.bumptech.glide.util.Util;
import com.example.minicompany.data.Utils;

import java.util.ArrayList;

public class jobModel implements Parcelable {
    private int id;
    private String CompanyTitle;
    private String Category;
    private String CompanyLogo;
    private String Stipend;
    private String Duration;
    private String WorkEnv;
    private String JobType;
    private String CompanyDes;
    private String AboutJob;
    private ArrayList<String> Skills;
    private int NumberOfOpenings;
    private ArrayList<String> perks;
    private String status;
    private boolean saved;

    public jobModel(String companyTitle, String category, String companyLogo, String stipend, String duration, String workEnv, String jobType, String companyDes, String aboutJob, ArrayList<String> skills, int numberOfOpenings, ArrayList<String> perks) {
        this.id = Utils.getId();
        CompanyTitle = companyTitle;
        Category = category;
        CompanyLogo = companyLogo;
        Stipend = stipend;
        Duration = duration;
        WorkEnv = workEnv;
        JobType = jobType;
        CompanyDes = companyDes;
        AboutJob = aboutJob;
        Skills = skills;
        NumberOfOpenings = numberOfOpenings;
        this.perks = perks;
        this.status = "open";
        this.saved = false;
    }

    public jobModel() {
    }

    protected jobModel(Parcel in) {
        id = in.readInt();
        CompanyTitle = in.readString();
        Category = in.readString();
        CompanyLogo = in.readString();
        Stipend = in.readString();
        Duration = in.readString();
        WorkEnv = in.readString();
        JobType = in.readString();
        CompanyDes = in.readString();
        AboutJob = in.readString();
        Skills = in.createStringArrayList();
        NumberOfOpenings = in.readInt();
        perks = in.createStringArrayList();
        status = in.readString();
        saved = in.readByte() != 0;
    }

    public static final Creator<jobModel> CREATOR = new Creator<jobModel>() {
        @Override
        public jobModel createFromParcel(Parcel in) {
            return new jobModel(in);
        }

        @Override
        public jobModel[] newArray(int size) {
            return new jobModel[size];
        }
    };

    @Override
    public String toString() {
        return "jobModel{" +
                "id=" + id +
                ", CompanyTitle='" + CompanyTitle + '\'' +
                ", Category='" + Category + '\'' +
                ", CompanyLogo='" + CompanyLogo + '\'' +
                ", Stipend='" + Stipend + '\'' +
                ", Duration='" + Duration + '\'' +
                ", WorkEnv='" + WorkEnv + '\'' +
                ", JobType='" + JobType + '\'' +
                ", CompanyDes='" + CompanyDes + '\'' +
                ", AboutJob='" + AboutJob + '\'' +
                ", Skills=" + Skills +
                ", NumberOfOpenings=" + NumberOfOpenings +
                ", perks=" + perks +
                ", status='" + status + '\'' +
                ", saved=" + saved +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompanyTitle() {
        return CompanyTitle;
    }

    public void setCompanyTitle(String companyTitle) {
        CompanyTitle = companyTitle;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public String getCompanyLogo() {
        return CompanyLogo;
    }

    public void setCompanyLogo(String companyLogo) {
        CompanyLogo = companyLogo;
    }

    public String getStipend() {
        return Stipend;
    }

    public void setStipend(String stipend) {
        Stipend = stipend;
    }

    public String getDuration() {
        return Duration;
    }

    public void setDuration(String duration) {
        Duration = duration;
    }

    public String getWorkEnv() {
        return WorkEnv;
    }

    public void setWorkEnv(String workEnv) {
        WorkEnv = workEnv;
    }

    public String getJobType() {
        return JobType;
    }

    public void setJobType(String jobType) {
        JobType = jobType;
    }

    public String getCompanyDes() {
        return CompanyDes;
    }

    public void setCompanyDes(String companyDes) {
        CompanyDes = companyDes;
    }

    public String getAboutJob() {
        return AboutJob;
    }

    public void setAboutJob(String aboutJob) {
        AboutJob = aboutJob;
    }

    public ArrayList<String> getSkills() {
        return Skills;
    }

    public void setSkills(ArrayList<String> skills) {
        Skills = skills;
    }

    public int getNumberOfOpenings() {
        return NumberOfOpenings;
    }

    public void setNumberOfOpenings(int numberOfOpenings) {
        NumberOfOpenings = numberOfOpenings;
    }

    public ArrayList<String> getPerks() {
        return perks;
    }

    public void setPerks(ArrayList<String> perks) {
        this.perks = perks;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isSaved() {
        return saved;
    }

    public void setSaved(boolean saved) {
        this.saved = saved;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(CompanyTitle);
        parcel.writeString(Category);
        parcel.writeString(CompanyLogo);
        parcel.writeString(Stipend);
        parcel.writeString(Duration);
        parcel.writeString(WorkEnv);
        parcel.writeString(JobType);
        parcel.writeString(CompanyDes);
        parcel.writeString(AboutJob);
        parcel.writeStringList(Skills);
        parcel.writeInt(NumberOfOpenings);
        parcel.writeStringList(perks);
        parcel.writeString(status);
        parcel.writeByte((byte) (saved ? 1 : 0));
    }
}
