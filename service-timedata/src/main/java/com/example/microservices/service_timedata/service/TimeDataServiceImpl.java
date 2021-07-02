package com.example.microservices.service_timedata.service;

import com.example.microservices.service_timedata.entity.TimeData;
import com.example.microservices.service_timedata.repository.TimeDataRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

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
    public Map<Integer,TimeData> findByYearAndMonth(Integer year, Integer month) {
        Map<Integer,TimeData> timeDataList = new HashMap();

        // сперва выбираем уже имеющиеся трудодни в базе
        timeDataRepository.findAll().forEach(timeData -> {
            if (timeData.getDate().getYear()==year &&
                    timeData.getDate().getMonthValue()==month)
            timeDataList.put(timeData.getDate().getDayOfMonth(),timeData);
        });

        //затем заполняем new TimeData для тех трудодней, которых нет в базе

        Calendar monthStart = new GregorianCalendar(year, month, 1);
        for (int i = 1; i <= monthStart.getActualMaximum(Calendar.DAY_OF_MONTH); i++) {
            if (!timeDataList.containsKey(i)) timeDataList.put(i,new TimeData());
        }

        return timeDataList;
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
