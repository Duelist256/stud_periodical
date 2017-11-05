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

    public void addPeriodical(Periodical periodical){
        periodicalDao.create(periodical);
    }

    public Periodical getById(int id){
        return periodicalDao.read(id);
    }

    public void updatePeriodical(Periodical periodical){
        periodicalDao.update(periodical);
    }

    public void deletePeriodical(Periodical periodical){
        periodicalDao.delete(periodical);
    }

    public List<Periodical> getAll() {
        return periodicalDao.getAll();
    }
}
