package com.epam.students.model;

public class Order {
    private int id;
    private int id_user;
    private int id_periodical;
    private String status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getId_periodical() {
        return id_periodical;
    }

    public void setId_periodical(int id_periodical) {
        this.id_periodical = id_periodical;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
