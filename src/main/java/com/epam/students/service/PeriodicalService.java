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

    public void addPeriodical(){

    }


    public List<Periodical> getAll() {
       return periodicalDao.getAll();
    }
}
