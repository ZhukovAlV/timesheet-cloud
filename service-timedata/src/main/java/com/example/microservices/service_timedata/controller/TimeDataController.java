package com.example.microservices.service_timedata.controller;

import com.example.microservices.service_timedata.entity.TimeData;
import com.example.microservices.service_timedata.service.TimeDataService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/timedata")
@Controller
@AllArgsConstructor
public class TimeDataController {

    TimeDataService timeDataService;

    @GetMapping("all")
    public List<TimeData> findAll() {
        return timeDataService.findAll();
    }

    @GetMapping("get/{id}")
    public TimeData getTimeData(@PathVariable Long id) {
        TimeData timeData = timeDataService.findById(id);
        if (timeData == null) {
            throw new RuntimeException("TimeData ID not found - " + id);
        }
        return timeData;
    }

    @PostMapping("add")
    public TimeData addTimeData(@RequestBody TimeData timeData) {
        timeDataService.save(timeData);
        return timeData;
    }

    @PutMapping("update/{id}")
    public TimeData updateTimeData(@PathVariable Long id, @RequestBody TimeData timeData) {
        timeData.setId(id);
        timeDataService.save(timeData);
        return timeData;
    }

    @DeleteMapping("delete/{id}")
    public String deleteTimeData(@PathVariable Long id) {
        TimeData tempTimeData = timeDataService.findById(id);
        if (tempTimeData == null) {
            throw new RuntimeException("TimeData ID not found - " + id);
        }
        timeDataService.deleteById(id);
        return  "Deleted TimeData ID - " + id;
    }
}
