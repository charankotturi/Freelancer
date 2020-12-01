package com.example.minicompany.models;

import com.example.minicompany.data.Utils;

public class PopularFieldsModel {
    private int id;
    private String imgURL;
    private String fieldName;

    public PopularFieldsModel(String imgURL, String fieldName) {
        this.id = Utils.getPopular_ID();
        this.imgURL = imgURL;
        this.fieldName = fieldName;
    }

    public PopularFieldsModel(String fieldName) {
        this.id = Utils.getPopular_ID();
        this.fieldName = fieldName;
    }

    @Override
    public String toString() {
        return "PopularFieldsModel{" +
                "id=" + id +
                ", imgURL='" + imgURL + '\'' +
                ", fieldName='" + fieldName + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }
}
