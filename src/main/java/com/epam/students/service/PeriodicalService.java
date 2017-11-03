package com.epam.students.service;

import com.epam.students.dao.PeriodicalDao;
import com.epam.students.model.Periodical;

import java.util.ArrayList;
import java.util.List;

public class PeriodicalService {

    private PeriodicalDao periodicalDao;

    public PeriodicalService(){
        periodicalDao = new PeriodicalDao();
    }

    public void addPeriodical(String title,String description,String publisher,String genre,String price,String img_path){
        Periodical periodical = Periodical.newBuilder()
                .title(title)
                .description(description)
                .publisher(publisher)
                .genre(genre)
                .price(price)
                .imgPath(img_path)
                .build();

        periodicalDao.create(periodical);
    }


    public List<Periodical> getAll() {
       return periodicalDao.getAll();
    }
}
