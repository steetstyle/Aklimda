package me.geed.models;

public class Question {

     private String title;
     private String description;
     private int image;

    public Question(String question_title, String question_description){
        title = question_title;
        description = question_description;
    }

    public void setTitle(String title) {
        title = title;
    }

    public void setDescription(String description) {
        description = description;
    }

    public void setImage(int image) {
        image = image;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getImage() {
        return image;
    }
}
