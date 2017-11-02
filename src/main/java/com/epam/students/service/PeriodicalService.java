package com.epam.students.service;

import com.epam.students.model.Periodical;

import java.util.ArrayList;
import java.util.List;

public class PeriodicalService {

    public List<Periodical> getAll() {
        //к PeriodacalDAO
        //заглушка

        List<Periodical> all = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Periodical periodical = new Periodical.Builder()
                    .title(String.valueOf(i))
                    .genre("жанр")
                    .description("desc" + String.valueOf(i))
                    .build();
                    

            // метод по получить i-й элемент из бд

            all.add(periodical);
        }
        return all;
    }
}
