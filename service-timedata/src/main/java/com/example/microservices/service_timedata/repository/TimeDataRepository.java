package com.example.microservices.service_timedata.repository;

import com.example.microservices.service_timedata.entity.TimeData;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface TimeDataRepository extends CrudRepository<TimeData, Long> {
    TimeData findByUserIdAndDate(Long userId, LocalDate date);
    Iterable<TimeData> findByUserId(Long userId);
    Iterable<TimeData> findByDate(LocalDate localDate);
}
