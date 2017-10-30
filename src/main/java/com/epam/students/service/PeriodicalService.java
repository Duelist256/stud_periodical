package com.epam.students.service;

import com.epam.students.model.Periodical;

import java.util.ArrayList;
import java.util.List;

public class PeriodicalService {

    public List<Periodical> getAll(){
        //к PeriodacalDAO
        //заглушка
        List<Periodical> all = new ArrayList<>();
        System.out.println("++++++");
        for (int i = 0; i < 10; i++) {
            Periodical periodical = new Periodical();
            periodical.setTitle(String.valueOf(i));
            periodical.setGenre("жанр");
            periodical.setDescription("desc" + String.valueOf(i));
            all.add(periodical);
        }
        return all;
    }
}
