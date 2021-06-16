package com.example.microservices.service_timesheet.service;

import com.example.microservices.service_timesheet.entity.TimeData;

import java.util.List;

public interface TimeDataService {
    List<TimeData> findAll();
    TimeData findById(Long theId);
    void save(TimeData theTimedata);
    void deleteById(Long theId);
}
