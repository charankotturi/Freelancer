package com.example.minicompany.models;

public class resumeModel {
    private String resName;
    private String resEdu;
    private String resDes;
    private String resSkills;
    private String resProjectDes;
    private String resGitLink;

    public resumeModel(String resName, String resEdu, String resDes, String resSkills) {
        this.resName = resName;
        this.resEdu = resEdu;
        this.resDes = resDes;
        this.resSkills = resSkills;
        this.resProjectDes = "none";
        this.resGitLink = "none";
    }

    public resumeModel() {
    }

    @Override
    public String toString() {
        return "resumeModel{" +
                "resName='" + resName + '\'' +
                ", resEdu='" + resEdu + '\'' +
                ", resDes='" + resDes + '\'' +
                ", resSkills='" + resSkills + '\'' +
                ", resProjectDes='" + resProjectDes + '\'' +
                ", resGitLink='" + resGitLink + '\'' +
                '}';
    }

    public String getResName() {
        return resName;
    }

    public void setResName(String resName) {
        this.resName = resName;
    }

    public String getResEdu() {
        return resEdu;
    }

    public void setResEdu(String resEdu) {
        this.resEdu = resEdu;
    }

    public String getResDes() {
        return resDes;
    }

    public void setResDes(String resDes) {
        this.resDes = resDes;
    }

    public String getResSkills() {
        return resSkills;
    }

    public void setResSkills(String resSkills) {
        this.resSkills = resSkills;
    }

    public String getResProjectDes() {
        return resProjectDes;
    }

    public void setResProjectDes(String resProjectDes) {
        this.resProjectDes = resProjectDes;
    }

    public String getResGitLink() {
        return resGitLink;
    }

    public void setResGitLink(String resGitLink) {
        this.resGitLink = resGitLink;
    }
}


