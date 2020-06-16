package com.example.fruit_store;

import java.io.Serializable;

public class Fruit implements Serializable {
    String name;
    String intro;
    int imageid;
    String price;

    public Fruit(String name, String intro, int imageid, String price) {
        this.name = name;
        this.intro = intro;
        this.imageid = imageid;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getIntro() {
        return intro;
    }

    public int getImageid() {
        return imageid;
    }

    public String getPrice() {
        return price;
    }
}
