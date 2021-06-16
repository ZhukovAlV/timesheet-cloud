package com.example.microservices.service_timedata.service;

import com.example.microservices.service_timedata.entity.TimeData;

import java.util.List;

public interface TimeDataService {
    List<TimeData> findAll();
    TimeData findById(Long theId);
    void save(TimeData theTimedata);
    void deleteById(Long theId);
}
