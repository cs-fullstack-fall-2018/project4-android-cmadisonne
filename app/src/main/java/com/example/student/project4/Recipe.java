package com.example.student.project4;

class Recipe {
    private String title;
    private String subtitle;
    private String date;
    private String ingredients;
    private String instructions;

    Recipe(String title, String subtitle, String ingredients, String instructions, String date){
        this.title = title;
        this.subtitle = subtitle;
        this.date = date;
        this.ingredients = ingredients;
        this.instructions = instructions;
    }
    String getTitle () {return title;}

    String getSubtitle () {return subtitle;}

    String getDate () {return date;}


}
