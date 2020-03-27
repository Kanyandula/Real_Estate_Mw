package com.example.realestatemw;

public class Agent {

    private String city,town, image;

    //Constractor
    public Agent (){ }

    public Agent (String city, String town, String image){
        this.city=city;
        this.town=town;
        this.image=image;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
