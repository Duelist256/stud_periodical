package com.epam.students.model;

public class Order {

    private int id;
    private int idUser;
    private int idPeriodical;
    private String status;

    private Order(){

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

    public static Builder newBuilder() {
        return new Order().new Builder();
    }

    public class Builder{

        private Builder(){

        }

        public Builder id(int id){
            Order.this.id = id;
            return this;
        }

        public Builder idUser(int idUser){
           Order.this.idUser = idUser;
           return this;
        }

        public Builder status(String status){
            Order.this.status = status;
            return this;
        }

        public Builder idPeriodical(int idPeriodical){
            Order.this.idPeriodical = idPeriodical;
            return this;
        }

        public Order build(){
          return Order.this;
        }

    }
}
