package com.example.microservices.service_timesheet.repository;

import com.example.microservices.service_timesheet.entity.TimeData;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface TimeDataRepository extends CrudRepository<TimeData, Long> {
    TimeData findByUserIdAndDate(Long userId, LocalDate date);
}
