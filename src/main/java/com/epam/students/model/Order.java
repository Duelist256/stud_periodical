package com.epam.students.model;

public class Order {

    private int id;
    private int idUser;
    private int idPeriodical;
    private String status;

    private Order(Builder builder){
        this.id = builder.id;
        this.idUser = builder.idUser;
        this.idPeriodical = builder.idPeriodical;
        this.status = builder.status;
    }

    public int getId() {
        return id;
    }

    public int getIdUser() {
        return idUser;
    }

    public int getIdPeriodical() {
        return idPeriodical;
    }

    public String getStatus() {
        return status;
    }

    public static class Builder{

        private int id;
        private int idUser;
        private int idPeriodical;
        private String status;

        public Builder id(int id){
            this.id = id;
            return this;
        }

        public Builder idUser(int idUser){
           this.idUser = idUser;
           return this;
        }

        public Builder status(String status){
            this.status = status;
            return this;
        }

        public Builder idPeriodical(int idPeriodical){
            this.idPeriodical = idPeriodical;
            return this;
        }

        public Order build(){
            return new Order(this);
        }

    }
}
