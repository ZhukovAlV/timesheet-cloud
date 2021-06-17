package com.example.microservices.service_timedata.service;

import com.example.microservices.service_timedata.entity.TimeData;

import java.util.List;
import java.util.Optional;

public interface TimeDataService {
    Iterable<TimeData> findAll();
    Optional<TimeData> findById(Long theId);
    Iterable<TimeData> findByUserId(Long userId);
    void save(TimeData theTimedata);
    void deleteById(Long theId);
}
