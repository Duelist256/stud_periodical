package com.epam.students.service;

import com.epam.students.dao.PeriodicalDao;
import com.epam.students.model.Periodical;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class PeriodicalServiceTest {

    @Spy
    private PeriodicalDao periodicalDao;

    @InjectMocks
    private PeriodicalService periodicalService;

    @Test
    public void addPeriodicalTest() throws Exception {
        Periodical periodical = Periodical
                .newBuilder()
                .title("TestTitle")
                .description("TestDesc")
                .publisher("TestPubl")
                .genre("TestGenre")
                .price(1.12F)
                .imgPath("path")
                .build();
        periodicalService.addPeriodical(periodical);

        verify(periodicalDao, times(1)).create(periodical);
    }

    @Test
    public void getByIdTest() throws Exception {
        int id = 1;
        periodicalService.getById(id);
        verify(periodicalDao, times(1)).read(id);
    }

    @Test
    public void updatePeriodicalTest() throws Exception {
        Periodical periodical = Periodical
                .newBuilder()
                .id(2)
                .title("TestTitle")
                .description("TestDesc")
                .publisher("TestPubl")
                .genre("TestGenre")
                .price(1.12F)
                .imgPath("path")
                .build();

        periodicalService.updatePeriodical(periodical);
        verify(periodicalDao, times(1)).update(periodical);
    }

    @Test
    public void deletePeriodical() throws Exception {
        Periodical periodical = Periodical
                .newBuilder()
                .id(3)
                .build();
        periodicalService.deletePeriodical(periodical);
        verify(periodicalDao, times(1)).delete(periodical);
    }

    @Test
    public void getAllTest() throws Exception {
        periodicalService.getAll();
        verify(periodicalDao, times(1)).getAll();
    }

    @Test
    public void getPageTest() throws Exception {
        int page = 3;
        int size = 5;
        periodicalService.getPage(page, size);
        verify(periodicalDao, times(1)).getPage(page, size);
    }
}