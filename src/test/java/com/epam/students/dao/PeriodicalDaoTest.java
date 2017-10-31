package com.epam.students.dao;

import com.epam.students.model.Periodical;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertFalse;

public class PeriodicalDaoTest {

    @Test
    public void checkSize() {
        PeriodicalDao periodicalDao = new PeriodicalDao();
        List<Periodical> periodicals = periodicalDao.getAll();
        assertFalse(periodicals.isEmpty());
    }
}