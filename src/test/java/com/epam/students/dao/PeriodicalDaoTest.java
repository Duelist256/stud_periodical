package com.epam.students.dao;

import com.epam.students.model.Periodical;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

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
        int initialSize = periodicalDao.getAll().size();

        Periodical periodical = new Periodical();
        periodical.setTitle("Title1234");
        periodical.setDescription("Description1234");
        periodical.setPublisher("Publisher1234");
        periodical.setGenre("Genre1234");
        periodical.setPrice("1234");
        periodical.setImgPath("path1234");

        periodicalDao.create(periodical);

        int currentSize = periodicalDao.getAll().size();
        assertTrue(initialSize < currentSize);
    }

    @Test
    public void readPeriodical() throws Exception {
        PeriodicalDao periodicalDao = new PeriodicalDao();
        Periodical periodical = periodicalDao.read(10);

        assertNotNull(periodical);
    }

    @Test
    public void deletePeriodical() throws Exception {
        PeriodicalDao periodicalDao = new PeriodicalDao();
        List<Periodical> periodicals = periodicalDao.getAll();
        int initialSize = periodicals.size();

        Periodical periodical = periodicals.get(0);
        periodicalDao.delete(periodical);

        int currentSize = periodicalDao.getAll().size();

        assertTrue(currentSize < initialSize);

    }
}