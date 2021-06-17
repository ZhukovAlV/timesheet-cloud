package com.example.microservices.service_timedata.controller;

import com.example.microservices.service_timedata.entity.TimeData;
import com.example.microservices.service_timedata.service.TimeDataService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/timedata")
@CrossOrigin(origins = "http://localhost:4200")
@AllArgsConstructor
@Log4j2
public class TimeDataController {

    TimeDataService timeDataService;

    @GetMapping("/all")
    public Iterable<TimeData> findAll() {
        log.info("Get all timedata");
        return timeDataService.findAll();
    }

    @GetMapping("/{userId}")
    public Iterable<TimeData> findByUserId(@PathVariable Long userId) {
        log.info("Get timedata by " + userId);
        return timeDataService.findByUserId(userId);
    }


    @PostMapping("/add")
    public TimeData addTimeData(@RequestBody TimeData timeData) {
        log.info("Add new timedata");
        timeDataService.save(timeData);
        return timeData;
    }

    @PutMapping("/update")
    public TimeData updateTimeData(@RequestBody TimeData timeData) {
        log.info("Update timedata by " + timeData.getId());
        timeDataService.save(timeData);
        return timeData;
    }

    @DeleteMapping("/delete/{timeDataId}")
    public ResponseEntity deleteTimeData(@PathVariable Long timeDataId) {
        log.info("Delete timedata by " + timeDataId);
        timeDataService.deleteById(timeDataId);
        return ResponseEntity.ok().build();
    }
}
