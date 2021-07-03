package com.example.microservices.service_timedata.service;

import com.example.microservices.service_timedata.entity.TimeData;
import com.example.microservices.service_timedata.repository.TimeDataRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;
import java.util.*;

@Service
@AllArgsConstructor
public class TimeDataServiceImpl implements TimeDataService {

    private TimeDataRepository timeDataRepository;

    @Override
    public Iterable<TimeData> findAll() {
        return timeDataRepository.findAll();
    }

    @Override
    public Map<Integer,TimeData> findByUserAndYearAndMonth(Long userId, Integer year, Integer month) {
        Map<Integer,TimeData> timeDataMap = new HashMap();

        // сперва выбираем уже имеющиеся трудодни в базе
        timeDataRepository.findByUserId(userId).forEach(timeData -> {
            if (timeData.getDate().getYear()==year &&
                    timeData.getDate().getMonthValue()==month)
                timeDataMap.put(timeData.getDate().getDayOfMonth(),timeData);
        });

        //затем заполняем new TimeData для тех трудодней, которых нет в базе
        Calendar monthStart = new GregorianCalendar(year, month, 1);
        for (int i = 1; i <= monthStart.getActualMaximum(Calendar.DAY_OF_MONTH); i++) {
            if (!timeDataMap.containsKey(i)) {
                TimeData timeData = new TimeData();
                timeData.setUserId(userId);
                timeData.setHour(8);
                timeData.setType("Я");
                timeData.setDate(LocalDate.of(year, month, i));
                timeDataMap.put(i,timeData);
            }
        }

        return timeDataMap;
    }

    @Override
    public Optional<TimeData> findById(Long id) {
        return timeDataRepository.findById(id);
    }

    @Override
    public Iterable<TimeData> findByUserId(Long userId) {
        return timeDataRepository.findByUserId(userId);
    }

    @Override
    public void save(TimeData timeData) {
        timeDataRepository.save(timeData);
    }

    @Override
    public void deleteById(Long theId) {
        timeDataRepository.deleteById(theId);
    }

}
