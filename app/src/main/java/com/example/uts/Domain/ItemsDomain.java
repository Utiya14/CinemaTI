package com.example.uts.Domain;

import java.io.Serializable;

public class ItemsDomain implements Serializable {
    private String date;
    private String tittle;
    private String Description;
    private String bio;
    private String them;
    private String pic;
    private String duration;
    private int rate;

    public ItemsDomain(String them, String date, String tittle, String description, String pic, String duration, int rate) {
        this.them = them;
        this.date = date;
        this.tittle = tittle;
        Description = description;
        //this.bio = bio;
        this.pic = pic;
        this.duration = duration;
        this.rate = rate;
    }

    public void setThem(String them) {
        this.them = them;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public void setDescription(String description) {
        Description = description;
    }

    /*public void setBio(String bio) {
        this.bio = bio;
    }*/


    public void setPic(String pic) {
        this.pic = pic;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public String getThem() {
        return them;
    }
    public String getDate() {
        return date;
    }

    public String getTittle() {
        return tittle;
    }

    public String getDescription() {
        return Description;
    }

   /* public String getBio() {
        return bio;
    }*/


    public String getPic() {
        return pic;
    }

    public String getDuration() {
        return duration;
    }

    public int getRate() {
        return rate;
    }
}
