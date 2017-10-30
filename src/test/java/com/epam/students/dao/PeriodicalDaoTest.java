package com.epam.students.dao;

import com.epam.students.model.Periodical;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class PeriodicalDaoTest {

    private PeriodicalDao periodicalDao;
    private List<Periodical> periodicals;

    @Before
    public void setPeriodicalDaoAndGetAllPeriodicals() {
        periodicalDao = new PeriodicalDao();
        periodicals = periodicalDao.getAll();
        assertNotNull(periodicals);
    }

    @Test
    public void checkSize() {
        assertEquals(periodicals.size(), 20);
    }

    @Test
    public void checkIfNotNull() {
        for (Periodical periodical : periodicals) {
            assertNotNull(periodical);
        }
    }
}