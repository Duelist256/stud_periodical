package com.epam.students.model;

public class Order {
    private int id;
    private int idUser;
    private int idPeriodical;
    private String status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdPeriodical() {
        return idPeriodical;
    }

    public void setIdPeriodical(int idPeriodical) {
        this.idPeriodical = idPeriodical;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
