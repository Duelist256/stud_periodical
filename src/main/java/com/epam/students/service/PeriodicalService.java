package com.epam.students.service;

import com.epam.students.dao.PeriodicalDao;
import com.epam.students.model.Periodical;

import java.util.List;

public class PeriodicalService {

    public List<Periodical> getAll() {
        PeriodicalDao periodicalDao = new PeriodicalDao();
        List<Periodical> all = periodicalDao.getAll();
        return all;
    }
}
