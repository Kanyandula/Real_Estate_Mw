package com.example.realestatemw;

public class Agent {

    private String cityName,townMame, imageUrl;

    public Agent (){ }

    public Agent(String cityName,String townMame, String  imageUrl){
        this.cityName=cityName;
        this.townMame=townMame;
        this. imageUrl= imageUrl;

    }

    public String getCityName() {
        return cityName;
    }

    public String getTownMame() {
        return townMame;
    }

    public String getImageUrl() {
        return  imageUrl;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public void setTownMame(String townMame) {
        this.townMame = townMame;
    }

    public void setImageUrl(String  imageUrl) {
        this. imageUrl =  imageUrl;
    }
}
