package com.epam.students.model;

public class Periodical {

    private int id;
    private String title;
    private String description;
    private String publisher;
    private String genre;
    private String price;
    private String imgPath;

    private Periodical(){

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

    public static Builder newBuilder(){
        return new Periodical().new Builder();
    }

    public class Builder{

        private Builder(){

        }

        public Builder id(int id){
            Periodical.this.id = id;
            return this;
        }

        public Builder title(String title){
            Periodical.this.title = title;
            return this;
        }

        public Builder description(String description){
            Periodical.this.description = description;
            return this;
        }

        public Builder publisher(String publisher){
            Periodical.this.publisher = publisher;
            return this;
        }

        public Builder genre(String genre){
            Periodical.this.genre = genre;
            return this;
        }

        public Builder price(String price){
            Periodical.this.price = price;
            return this;
        }

        public Builder imgPath(String imgPath){
            Periodical.this.imgPath = imgPath;
            return this;
        }

        public Periodical build(){
            return Periodical.this;
        }

    }

}
