package com.epam.students.model;

/**
 * POJO class for OrderPeriodical table data access with Builder,
 * not much to comment here.
 */
public class OrderPeriodical {

    private int id_order;
    private int id_periodical;

    private OrderPeriodical() {
    }

    public int getIdOrder() {
        return id_order;
    }

    public void setIdOrder(int id_order) {
        this.id_order = id_order;
    }

    public int getIdPeriodical() {
        return id_periodical;
    }

    public void setIdPeriodical(int id_periodical) {
        this.id_periodical = id_periodical;
    }

    public static Builder newBuilder() {
        return new OrderPeriodical().new Builder();
    }

     public class Builder {

        private Builder() {

        }

        public  Builder idOrder(int id_order) {
            OrderPeriodical.this.id_order = id_order;
            return this;
        }

        public Builder idPeriodical(int id_periodical) {
            OrderPeriodical.this.id_periodical = id_periodical;
            return this;
        }

        public OrderPeriodical build() {
            return OrderPeriodical.this;
        }


    }
}
