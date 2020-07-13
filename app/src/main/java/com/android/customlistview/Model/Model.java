package com.android.customlistview.Model;

public class Model {

    private String Image, Name;

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Model(String image, String name) {
        Image = image;
        Name = name;
    }
}
