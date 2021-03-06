package com.example.microservices.service_timedata.controller;

import com.example.microservices.service_timedata.entity.TimeData;
import com.example.microservices.service_timedata.service.TimeDataService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/timedata")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@AllArgsConstructor
@Log4j2
public class TimeDataController {

    TimeDataService timeDataService;

    @GetMapping("")
    public Iterable<TimeData> findAll() {
        log.info("Get all timedata");
        return timeDataService.findAll();
    }

    @GetMapping("/{userId}/{year}/{month}")
    public Map<Integer,TimeData> findByYearAndMonth(@PathVariable Long userId, @PathVariable Integer year, @PathVariable Integer month) {
        log.info("Get timedata by year and month");
        return timeDataService.findByUserAndYearAndMonth(userId, year,month);
    }

    @GetMapping("/{userId}")
    public Iterable<TimeData> findByUserId(@PathVariable Long userId) {
        log.info("Get timedata by " + userId);
        return timeDataService.findByUserId(userId);
    }

    @PostMapping("")
    public TimeData addTimeData(@RequestBody TimeData timeData) {
        log.info("Add new timedata");
        timeDataService.save(timeData);
        return timeData;
    }

    @PutMapping("")
    public TimeData updateTimeData(@RequestBody TimeData timeData) {
        log.info("Update timedata by " + timeData.getId());
        timeDataService.save(timeData);
        return timeData;
    }

/*    @PutMapping("")
    public List<TimeData> updateListTimeData(@RequestBody List<TimeData> listTimeData) {
        log.info("Update List<TimeData>");
        for (TimeData timeData : listTimeData) {
            timeDataService.save(timeData);
        }
        return listTimeData;
    }*/

    @DeleteMapping("/{timeDataId}")
    public ResponseEntity<?> deleteTimeData(@PathVariable Long timeDataId) {
        log.info("Delete timedata by " + timeDataId);
        if (timeDataService.findById(timeDataId).isPresent()) {
            timeDataService.deleteById(timeDataId);
            return ResponseEntity.ok().build();
        } else {
            return new ResponseEntity<>("", HttpStatus.NOT_FOUND);
        }
    }
}
