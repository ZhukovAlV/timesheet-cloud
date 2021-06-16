package com.example.microservices.service_timesheet.service;

import com.example.microservices.service_timesheet.entity.TimeData;
import com.example.microservices.service_timesheet.repository.TimeDataRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TimeDataServiceImpl implements TimeDataService {

    private TimeDataRepository timeDataRepository;

    @Override
    public List<TimeData> findAll() {
        return (List<TimeData>) timeDataRepository.findAll();
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
