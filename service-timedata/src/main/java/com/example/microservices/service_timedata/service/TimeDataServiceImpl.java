package com.example.microservices.service_timedata.service;

import com.example.microservices.service_timedata.entity.TimeData;
import com.example.microservices.service_timedata.repository.TimeDataRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TimeDataServiceImpl implements TimeDataService {

    private TimeDataRepository timeDataRepository;

    @Override
    public List<TimeData> findAll() {
        List<TimeData> list = new ArrayList<>();
        timeDataRepository.findAll().forEach(list::add);
        return list;
    }

    @Override
    public TimeData findById(Long id) {
        Optional<TimeData> result = timeDataRepository.findById(id);
        if (result.isPresent()) {
            return result.get();
        } else {
            throw new RuntimeException("Did not find timedata id - " + id);
        }
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
