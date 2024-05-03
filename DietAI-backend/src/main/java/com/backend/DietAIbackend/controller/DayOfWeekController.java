package com.backend.DietAIbackend.controller;

import com.backend.DietAIbackend.model.DayWeek;
import com.backend.DietAIbackend.model.JobType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.DayOfWeek;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/dayOfWeek")
@CrossOrigin(origins = "${cors.allowed.origin}")
@Slf4j
public class DayOfWeekController {

    @GetMapping
    public List<DayWeek> getAllDayOfWeek() {
        return Arrays.asList(DayWeek.values());
    }
}
