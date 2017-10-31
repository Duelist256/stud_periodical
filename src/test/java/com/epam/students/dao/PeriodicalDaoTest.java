package com.epam.students.dao;

import com.epam.students.model.Periodical;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class PeriodicalDaoTest {

    @Test
    public void checkSize() {
        PeriodicalDao periodicalDao = new PeriodicalDao();
        List<Periodical> periodicals = periodicalDao.getAll();
        assertFalse(periodicals.isEmpty());
    }

    @Test
    public void checkCreate() throws Exception {
        PeriodicalDao periodicalDao = new PeriodicalDao();

        Periodical periodical = new Periodical();
        periodical.setTitle("Title1234");
        periodical.setDescription("Description1234");
        periodical.setPublisher("Publisher1234");
        periodical.setGenre("Genre1234");
        periodical.setPrice("1234");
        periodical.setImgPath("path1234");

        periodicalDao.create(periodical);

        List<Periodical> periodicals = periodicalDao.getAll();
        assertEquals(21, periodicals.size());
    }
}