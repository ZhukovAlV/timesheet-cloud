package com.example.microservices.service_timedata.controller;

import com.example.microservices.service_timedata.entity.TimeData;
import com.example.microservices.service_timedata.service.TimeDataService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
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
    public List<TimeData> findAll() {
        return timeDataService.findAll();
    }

    @GetMapping("/{id}")
    public TimeData findById(@PathVariable Long id) {
        TimeData timeData = timeDataService.findById(id);
        if (timeData == null) {
            throw new RuntimeException("TimeData ID not found - " + id);
        }
        return timeData;
    }

    @PostMapping("/add")
    public TimeData addTimeData(@RequestBody TimeData timeData) {
        timeDataService.save(timeData);
        return timeData;
    }

    @PutMapping("/update")
    public TimeData updateTimeData(@RequestBody TimeData timeData) {
        timeDataService.save(timeData);
        return timeData;
    }

    @DeleteMapping("/delete/{id}")
    public String deleteTimeData(@PathVariable Long id) {
        TimeData tempTimeData = timeDataService.findById(id);
        if (tempTimeData == null) {
            throw new RuntimeException("TimeData ID not found - " + id);
        }
        timeDataService.deleteById(id);
        return  "Deleted TimeData ID - " + id;
    }
}
