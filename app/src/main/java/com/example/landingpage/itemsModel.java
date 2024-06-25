package com.example.landingpage;

import android.net.Uri;

public class itemsModel {
    private String id;
    private String name;
    private String Description;
    private double price;
    private Uri image;
    private boolean purchased;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Uri getImage() {
        return image;
    }

    public void setImage(Uri image) {
        this.image = image;
    }

    public boolean isPurchased() {
        return purchased;
    }

    public void setPurchased(boolean purchased) {
        this.purchased = purchased;
    }
    public String toString(){
        return "Item{" +
                "id=" + id +
                ",name='" + name + '\'' +
                "description='" + Description + '\'' +
                "image=" + image +
                "price=" + price +
                "purchased=" + purchased +
                "}";
    }
}
