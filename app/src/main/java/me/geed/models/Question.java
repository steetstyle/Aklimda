package me.geed.models;

public class Question {

     private String title;
     private String short_description;
     private String description;
     private int image;

    public Question(String question_title, String short_description, String question_description){
        this.title = question_title;
        this.short_description = short_description;
        this.description = question_description;
    }

    public void setTitle(String title) {
        title = title;
    }

    public void setDescription(String description) {
        description = description;
    }

    public void setShortDescription(String short_description) { short_description = short_description; }

    public void setImage(int image) {
        image = image;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getShortDescription() {
        return short_description;
    }

    public int getImage() {
        return image;
    }
}
