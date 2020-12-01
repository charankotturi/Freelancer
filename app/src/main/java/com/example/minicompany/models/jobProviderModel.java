package com.example.minicompany.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.example.minicompany.data.Utils;

import java.util.ArrayList;

public class jobProviderModel implements Parcelable {
    private int provider_id;
    private String providerName;
    private String rating;
    private String GitHubLink;
    private String description;
    private ArrayList<String> pSkills;

    public jobProviderModel(String providerName, String rating, String gitHubLink, String description) {
        this.provider_id = Utils.getProvider_ID();
        this.providerName = providerName;
        this.rating = rating;
        GitHubLink = gitHubLink;
        this.description = description;
    }

    protected jobProviderModel(Parcel in) {
        provider_id = in.readInt();
        providerName = in.readString();
        rating = in.readString();
        GitHubLink = in.readString();
        description = in.readString();
        pSkills = in.createStringArrayList();
    }

    public static final Creator<jobProviderModel> CREATOR = new Creator<jobProviderModel>() {
        @Override
        public jobProviderModel createFromParcel(Parcel in) {
            return new jobProviderModel(in);
        }

        @Override
        public jobProviderModel[] newArray(int size) {
            return new jobProviderModel[size];
        }
    };

    @Override
    public String toString() {
        return "jobProviderModel{" +
                "provider_id=" + provider_id +
                ", providerName='" + providerName + '\'' +
                ", rating='" + rating + '\'' +
                ", GitHubLink='" + GitHubLink + '\'' +
                ", description='" + description + '\'' +
                ", pSkills=" + pSkills +
                '}';
    }

    public int getProvider_id() {
        return provider_id;
    }

    public void setProvider_id(int provider_id) {
        this.provider_id = provider_id;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getGitHubLink() {
        return GitHubLink;
    }

    public void setGitHubLink(String gitHubLink) {
        GitHubLink = gitHubLink;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<String> getpSkills() {
        return pSkills;
    }

    public void setpSkills(ArrayList<String> pSkills) {
        this.pSkills = pSkills;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(provider_id);
        parcel.writeString(providerName);
        parcel.writeString(rating);
        parcel.writeString(GitHubLink);
        parcel.writeString(description);
        parcel.writeStringList(pSkills);
    }
}
