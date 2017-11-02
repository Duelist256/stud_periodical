package com.epam.students.dao;

import com.epam.students.model.Periodical;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertFalse;
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

        Periodical periodical = new Periodical.Builder()
        .title("Title1234")
        .description("Description1234")
        .publisher("Publisher1234")
        .genre("Genre1234")
        .price("1234")
        .imgPath("path1234")
                .build();

        periodicalDao.create(periodical);

        int currentSize = periodicalDao.getAll().size();
        assertTrue(initialSize < currentSize);
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