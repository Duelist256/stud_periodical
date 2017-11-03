package com.epam.students.model;

public class OrderPeriodical {

    private int id_order;
    private int id_periodical;

    private OrderPeriodical() {
    }

    public int getId_order() {
        return id_order;
    }

    public void setId_order(int id_order) {
        this.id_order = id_order;
    }

    public int getId_periodical() {
        return id_periodical;
    }

    public void setId_periodical(int id_periodical) {
        this.id_periodical = id_periodical;
    }

    public static Builder newBuilder() {
        return new OrderPeriodical().new Builder();
    }

     public class Builder {

        private Builder() {

        }

        public  Builder id_order(int id_order) {
            OrderPeriodical.this.id_order = id_order;
            return this;
        }

        public Builder id_periodical(int id_periodical) {
            OrderPeriodical.this.id_periodical = id_periodical;
            return this;
        }

        public OrderPeriodical build() {
            return OrderPeriodical.this;
        }


    }
}
