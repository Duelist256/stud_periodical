package com.epam.students.model;

public class Language {
    /*
    Default language is english
     */
   private static String language = "ru";
   private static String country = "US";
   private Language(){

   }

   public static String getLanguage(){
       return language;
   }
   public static void setLanguage(String lang){
       language = lang;
   }

    public static String getCountry() {
       if(language.equals("ru"))
        return "RU";
       else return "US";
    }
}
