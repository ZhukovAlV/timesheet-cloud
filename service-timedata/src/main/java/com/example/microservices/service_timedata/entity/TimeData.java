package com.example.microservices.service_timedata.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@NoArgsConstructor
@Data
@Entity
@Table(name = "TIMEDATA")
public class TimeData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "USERID")
    private Long userId;
    @Column(name = "HOUR")
    private Integer hour;
    @Column(name = "TYPE_D")
    private String type;
    @Column(name = "DATE")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
}
