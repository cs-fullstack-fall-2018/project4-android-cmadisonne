package com.example.student.project4;

import android.widget.ImageButton;

class Recipe {
    private String title;
    private String subtitle;
    private String date;
    private String ingredients;
    private String instructions;
    private ImageButton image;

    Recipe(String s, String title, String subtitle, String ingredients, String instructions, String date){
        this.title = title;
        this.subtitle = subtitle;
        this.date = date;
        this.ingredients = ingredients;
        this.instructions = instructions;
        this.image = image;
    }

    public Recipe(ImageButton imageButton, String title, String subtitle, String s, String ingredient, String instruction) {
    }

    String getTitle () {return title;}

    ImageButton getImage () {return image;}

    String getSubtitle () {return subtitle;}



}
