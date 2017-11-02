package com.epam.students.model;

public class User {
    private int id;
    private String login;
    private String password;
    private String salt;
    private String name;
    private int isAdmin;

    private User(Builder builder){
        this.id = builder.id;
        this.login = builder.login;
        this.password = builder.password;
        this.salt = builder.salt;
        this.name = builder.salt;
        this.isAdmin = builder.isAdmin;
    }

    public int getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getSalt() {
        return salt;
    }

    public String getName() {
        return name;
    }

    public int getIsAdmin() {
        return isAdmin;
    }

    public static class Builder{

        private int id;
        private String login;
        private String password;
        private String salt;
        private String name;
        private int isAdmin;

        public Builder id(int id){
            this.id = id;
            return this;
        }

        public Builder login(String login){
            this.login = login;
            return this;
        }

        public Builder password(String password){
            this.password = password;
            return this;
        }

        public Builder salt(String salt){
            this.salt = salt;
            return this;
        }

        public Builder isAdmin(int isAdmin){
            this.isAdmin = isAdmin;
            return this;
        }

        public Builder name(String name){
           this.name = name;
           return this;
        }

        public User build(){
            return new User(this);
        }
    }

}
