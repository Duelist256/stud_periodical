package com.epam.students.service;

import com.epam.students.dao.PeriodicalDao;
import com.epam.students.model.Periodical;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class PeriodicalServiceTest {

    @Mock
    private PeriodicalDao periodicalDao;

    @InjectMocks
    private PeriodicalService periodicalService;

    private static Periodical getTestPeriodicalObject() {
        return Periodical
                .newBuilder()
                .id(2)
                .title("TestTitle")
                .description("TestDesc")
                .publisher("TestPubl")
                .genre("TestGenre")
                .price(1.12F)
                .imgPath("path")
                .build();
    }

    @Test
    public void addPeriodical() throws Exception {
        doNothing().when(periodicalDao).create(any());
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
    public void getById() throws Exception {
        doReturn(Periodical.newBuilder().build()).when(periodicalDao).read(anyInt());
        int id = 1;
        periodicalService.getById(id);
        verify(periodicalDao, times(1)).read(id);
    }

    @Test
    public void updatePeriodical() throws Exception {
        doNothing().when(periodicalDao).create(any());
        Periodical periodical = getTestPeriodicalObject();
        periodicalService.updatePeriodical(periodical);
        verify(periodicalDao, times(1)).update(periodical);
    }

    @Test
    public void deletePeriodical() throws Exception {
        doNothing().when(periodicalDao).delete(any());
        Periodical periodical = getTestPeriodicalObject();
        periodicalService.deletePeriodical(periodical);
        verify(periodicalDao, times(1)).delete(periodical);
    }

    @Test
    public void getAll() throws Exception {
        doReturn(new ArrayList<Periodical>()).when(periodicalDao).getAll();
        periodicalService.getAll();
        verify(periodicalDao, times(1)).getAll();
    }

    @Test
    public void getPage() throws Exception {
        doReturn(new ArrayList<Periodical>()).when(periodicalDao).getPage(anyInt(), anyInt());
        int page = 3;
        int size = 5;
        periodicalService.getPage(page, size);
        verify(periodicalDao, times(1)).getPage(page, size);
    }
}