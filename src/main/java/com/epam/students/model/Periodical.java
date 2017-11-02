package com.epam.students.model;

public class Periodical {

    private int id;
    private String title;
    private String description;
    private String publisher;
    private String genre;
    private String price;
    private String imgPath;

    private Periodical(Builder builder){
        this.id = builder.id;
        this.title = builder.title;
        this.description = builder.description;
        this.publisher = builder.publisher;
        this.genre = builder.genre;
        this.price = builder.price;
        this.imgPath = builder.imgPath;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getGenre() {
        return genre;
    }

    public String getPrice() {
        return price;
    }

    public String getImgPath() {
        return imgPath;
    }

    public static class Builder{

        private int id;
        private String title;
        private String description;
        private String publisher;
        private String genre;
        private String price;
        private String imgPath;

        public Builder id(int id){
            this.id = id;
            return this;
        }

        public Builder title(String title){
            this.title = title;
            return this;
        }

        public Builder description(String description){
            this.description = description;
            return this;
        }

        public Builder publisher(String publisher){
            this.publisher = publisher;
            return this;
        }

        public Builder genre(String genre){
            this.genre = genre;
            return this;
        }

        public Builder price(String price){
            this.price = price;
            return this;
        }

        public Builder imgPath(String imgPath){
            this.imgPath = imgPath;
            return this;
        }

        public Periodical build(){
            return new Periodical(this);
        }

    }

}
