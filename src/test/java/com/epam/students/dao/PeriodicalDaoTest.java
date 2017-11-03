package com.epam.students.dao;

import com.epam.students.model.Periodical;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

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

        Periodical periodical = Periodical.newBuilder()
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
    public void readPeriodical() throws Exception {
        PeriodicalDao periodicalDao = new PeriodicalDao();
        Periodical periodical = periodicalDao.read(10);

        assertNotNull(periodical);
    }

    @Test
    public void readUpdateRead() throws Exception {
        String newTitle = "Za Rulem";
        String newDescription = "Know more about cars";
        String newPublisher = "Za Rulem publishing house";
        String newGenre = "cars";
        String newPrice = "145";
        String newImgPath = "newImgPath";


        PeriodicalDao periodicalDao = new PeriodicalDao();
        Periodical periodical = periodicalDao.read(5);

//        periodical.setTitle(newTitle);
//        periodical.setDescription(newDescription);
//        periodical.setPublisher(newPublisher);
//        periodical.setGenre(newGenre);
//        periodical.setPrice(newPrice);
//        periodical.setImgPath(newImgPath);

        periodicalDao.update(periodical);

        Periodical readPeriodical = periodicalDao.read(5);

        assertEquals(5, readPeriodical.getId());
        assertEquals(newTitle, readPeriodical.getTitle());
        assertEquals(newDescription, readPeriodical.getDescription());
        assertEquals(newPublisher, readPeriodical.getPublisher());
        assertEquals(newGenre, readPeriodical.getGenre());
        assertEquals(newPrice, readPeriodical.getPrice());
        assertEquals(newImgPath, readPeriodical.getImgPath());
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