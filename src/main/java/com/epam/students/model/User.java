package com.epam.students.model;

/**
 * POJO class for User table data access with Builder,
 * not much to comment here.
 */
public class User {

    private int id;
    private String login;
    private String password;
    private String salt;
    private String name;
    private int isAdmin;

    private User(){

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

    public int isAdmin() {
        return isAdmin;
    }

    public static Builder newBuilder(){
        return new User().new Builder();
    }

    public class Builder{

        private Builder(){

        }

        public Builder id(int id){
            User.this.id = id;
            return this;
        }

        public Builder login(String login){
            User.this.login = login;
            return this;
        }

        public Builder password(String password){
            User.this.password = password;
            return this;
        }

        public Builder salt(String salt){
            User.this.salt = salt;
            return this;
        }

        public Builder isAdmin(int isAdmin){
            User.this.isAdmin = isAdmin;
            return this;
        }

        public Builder name(String name){
           User.this.name = name;
           return this;
        }

        public User build(){
            return User.this;
        }
    }

}
